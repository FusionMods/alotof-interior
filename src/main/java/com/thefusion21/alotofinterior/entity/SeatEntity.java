package com.thefusion21.alotofinterior.entity;

import com.thefusion21.alotofinterior.block.Seat;
import com.thefusion21.alotofinterior.registry.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
//? if < 1.21.6 {
import net.minecraft.nbt.CompoundTag;
//?} else {
/*
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
*/
//?}

import java.util.List;

/**
 * Invisible, non-colliding vehicle a player rides while sitting on a {@link Seat} block -
 * see {@link #sit} for the shared interaction every such block calls into. Ephemeral by
 * design: never summonable, and self-discards the instant it has no passenger or its
 * anchor block stops being the block that spawned it (covers both a normal dismount and
 * the block being broken/replaced while occupied). Deliberately NOT built with
 * {@code .noSave()} in {@link ModEntities} despite that - see the comment there.
 * {@link #tick()} treats a reloaded instance with no {@link #anchorPos} (never persisted,
 * since {@link #readAdditionalSaveData} is a no-op) as invalid and discards it immediately.
 *
 * Deliberately does NOT override any of the passenger-attachment-point APIs (which differ
 * incompatibly across 1.20.1/1.20.2/1.21+ - {@code getPassengersRidingOffset()} vs
 * {@code getMyRidingOffset(Entity)}+{@code Vector3f} vs {@code Vec3}-returning
 * {@code getPassengerAttachmentPoint(Entity, EntityDimensions, float)}). Instead {@link #sit}
 * spawns this entity directly at the exact world-space seat height, so the default
 * (unconfigured) offset vanilla adds on top of a plain, near-zero-size {@link Entity} is
 * negligible on every version.
 */
public class SeatEntity extends Entity {
    // onPassengerTurned() (below) fires on whichever side is driving the passenger's own
    // rotation - for the riding player specifically, that's the CLIENT, in response to
    // local mouse input (confirmed by decompiling Entity#turn(), which calls
    // vehicle.onPassengerTurned(this) right after applying the raw mouse delta). configure()
    // below only ever runs server-side (from sit(), which returns before reaching it on the
    // client), so these two values MUST go through SynchedEntityData rather than being plain
    // fields - a plain field would leave the client's own copy of this entity stuck on
    // maxYawDeviation's Java default (0f/infinite-if-uninitialized), silently disabling the
    // clamp for the one side that actually needs it.
    private static final EntityDataAccessor<Float> SEAT_YAW = SynchedEntityData.defineId(SeatEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> MAX_YAW_DEVIATION = SynchedEntityData.defineId(SeatEntity.class, EntityDataSerializers.FLOAT);

    private BlockPos anchorPos;
    private Block anchorBlock;

    public SeatEntity(EntityType<? extends SeatEntity> entityType, Level level) {
        super(entityType, level);
        this.setInvulnerable(true);
    }

    private void configure(BlockPos anchorPos, Block anchorBlock, float seatYaw, float maxYawDeviation) {
        this.anchorPos = anchorPos.immutable();
        this.anchorBlock = anchorBlock;
        this.entityData.set(SEAT_YAW, seatYaw);
        this.entityData.set(MAX_YAW_DEVIATION, maxYawDeviation);
    }

    /**
     * Shared "sit down" interaction for every {@link Seat} block - called from their
     * {@code use}/{@code useWithoutItem} override. Reuses an unoccupied seat entity already
     * anchored to {@code pos} if one exists, otherwise spawns a fresh one.
     */
    public static InteractionResult sit(Seat seat, BlockState state, Level level, BlockPos pos, Player player) {
        if (player.isShiftKeyDown() || player.isPassenger()) {
            return InteractionResult.PASS;
        }
        if (level.isClientSide()) {
            return InteractionResult.SUCCESS;
        }

        BlockPos anchor = pos.immutable();
        List<SeatEntity> existing = level.getEntitiesOfClass(SeatEntity.class, new AABB(anchor), e -> anchor.equals(e.anchorPos));
        SeatEntity seatEntity;
        if (!existing.isEmpty()) {
            seatEntity = existing.get(0);
            if (!seatEntity.getPassengers().isEmpty()) {
                return InteractionResult.PASS;
            }
        } else {
            seatEntity = new SeatEntity(ModEntities.SEAT.get(), level);
            seatEntity.configure(anchor, state.getBlock(), seat.getSeatYaw(state), seat.getMaxYawDeviation(state));
            seatEntity.setPos(anchor.getX() + 0.5, anchor.getY() + seat.getSeatHeight(state), anchor.getZ() + 0.5);
            level.addFreshEntity(seatEntity);
        }

        player.startRiding(seatEntity);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void tick() {
        if (this.level().isClientSide()) {
            return;
        }
        if (this.anchorPos == null || this.getPassengers().isEmpty() || this.level().getBlockState(this.anchorPos).getBlock() != this.anchorBlock) {
            this.ejectPassengers();
            this.discard();
        }
    }

    @Override
    public void onPassengerTurned(Entity passenger) {
        float maxYawDeviation = this.entityData.get(MAX_YAW_DEVIATION);
        if (Float.isInfinite(maxYawDeviation)) {
            return;
        }
        // Same technique vanilla's Boat#clampRotation uses: express the passenger's yaw as a
        // deviation from center, clamp that, then re-apply only the correction (rather than
        // stomping getYRot() outright) so yRotO moves with it and the camera doesn't visibly
        // snap/interpolate from the wrong place.
        float seatYaw = this.entityData.get(SEAT_YAW);
        float relative = Mth.wrapDegrees(passenger.getYRot() - seatYaw);
        float clampedRelative = Mth.clamp(relative, -maxYawDeviation, maxYawDeviation);
        float correction = clampedRelative - relative;
        passenger.yRotO += correction;
        passenger.setYRot(passenger.getYRot() + correction);
        passenger.setYHeadRot(passenger.getYRot());
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    //? if < 1.20.5 {
    /*
    @Override
    protected void defineSynchedData() {
        this.entityData.define(SEAT_YAW, 0f);
        this.entityData.define(MAX_YAW_DEVIATION, Float.POSITIVE_INFINITY);
    }
    */
    //?} else {
    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        builder.define(SEAT_YAW, 0f);
        builder.define(MAX_YAW_DEVIATION, Float.POSITIVE_INFINITY);
    }
    //?}

    //? if < 1.21.6 {
    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {
    }

    @Override
    public boolean hurt(DamageSource damageSource, float amount) {
        return false;
    }
    //?} else {
    /*
    @Override
    protected void readAdditionalSaveData(ValueInput valueInput) {
    }

    @Override
    protected void addAdditionalSaveData(ValueOutput valueOutput) {
    }

    @Override
    public boolean hurtServer(ServerLevel serverLevel, DamageSource damageSource, float amount) {
        return false;
    }
    */
    //?}
}

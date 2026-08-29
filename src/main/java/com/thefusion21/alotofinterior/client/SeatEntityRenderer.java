package com.thefusion21.alotofinterior.client;

import com.thefusion21.alotofinterior.entity.SeatEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlas;
//? if >= 1.21.6 {
/*
import net.minecraft.client.renderer.entity.state.EntityRenderState;
*/
//?}

/**
 * {@link SeatEntity} is fully invisible, but every {@code EntityType} still needs a
 * renderer registered or the client crashes trying to draw it. Neither branch below
 * overrides {@code render}/{@code submit} - that method has always had a default,
 * no-op-for-us implementation (draws a name tag/leash/shadow only if one is actually
 * set, none of which this entity ever does), so only the two genuinely abstract members
 * need bodies: {@code getTextureLocation} pre-1.21.6, {@code createRenderState} from
 * 1.21.6 on. That also sidesteps a real rename in the render method itself: 26.1 replaced
 * {@code render(..., MultiBufferSource, int)} with
 * {@code submit(..., SubmitNodeCollector, CameraRenderState)} entirely (confirmed by
 * decompiling both sides) - not overriding it means this class doesn't need to care which
 * shape is active. The 1.21.6 boundary itself matches the one this project already uses
 * elsewhere (see {@link ALotOfInteriorClient}'s render-type registration).
 */
@Environment(EnvType.CLIENT)
//? if < 1.21.6 {
public class SeatEntityRenderer extends EntityRenderer<SeatEntity> {
    public SeatEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public net.minecraft.resources.ResourceLocation getTextureLocation(SeatEntity entity) {
        return TextureAtlas.LOCATION_BLOCKS;
    }
}
//?} else {
/*
public class SeatEntityRenderer extends EntityRenderer<SeatEntity, EntityRenderState> {
    public SeatEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public EntityRenderState createRenderState() {
        return new EntityRenderState();
    }
}
*/
//?}

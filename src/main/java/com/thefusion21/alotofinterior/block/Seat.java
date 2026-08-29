package com.thefusion21.alotofinterior.block;

import net.minecraft.world.level.block.state.BlockState;

/**
 * Implemented by any {@link net.minecraft.world.level.block.Block} that a player can sit
 * on - see {@link com.thefusion21.alotofinterior.entity.SeatEntity#sit} for the shared
 * interaction logic every such block calls into, and {@link StoolBlock} for the simplest
 * (unrestricted-rotation) implementation. A future chair block reuses the exact same
 * entity/interaction plumbing by implementing this with a finite
 * {@link #getMaxYawDeviation} derived from its own facing property.
 */
public interface Seat {
    /** World-Y offset, in blocks, above this block's origin where the rider sits. */
    double getSeatHeight(BlockState state);

    /**
     * The seat's "forward" direction in degrees (same convention as {@code Entity#getYRot()}).
     * Only meaningful when {@link #getMaxYawDeviation} is finite.
     */
    float getSeatYaw(BlockState state);

    /**
     * How far, in degrees, the rider may turn away from {@link #getSeatYaw} before being
     * clamped back. {@code Float.POSITIVE_INFINITY} means unrestricted free look (stools);
     * a chair supplies a narrower arc instead.
     */
    float getMaxYawDeviation(BlockState state);
}

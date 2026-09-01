package com.thefusion21.alotofinterior.block.state;

import net.minecraft.util.StringRepresentable;

public enum DrawerType implements StringRepresentable {
    SINGLE("single"),
    LEFT("left"),
    RIGHT("right"),
    MIDDLE("middle");

    private final String name;

    private DrawerType(String name) {
        this.name = name;
    }

    public String getSerializedName() {
        return this.name;
    }

    public DrawerType getOpposite() {
        switch (this) {
            case LEFT:
                return RIGHT;
            case RIGHT:
                return LEFT;
            default:
                return this;
        }
    }
}

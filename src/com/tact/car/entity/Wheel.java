package com.tact.car.entity;

/**
 * Wheel of car.
 */
public class Wheel {

    private final float size;

    private int color;

    public Wheel(int color, float size) {
        super();
        this.size = size;
        this.color = color;

        System.out.println("Create a new wheel with size : " + this.size + " and color : " + this.color);
    }

    /**
     * @return the size
     */
    public final float getSize() {
        return size;
    }

    /**
     * @return the color
     */
    public final int getColor() {
        return color;
    }

}

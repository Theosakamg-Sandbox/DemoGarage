package com.tact.car.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Car Entity
 */
public class Car {

    /** Name of Customer/Car. */
    private final String name;

    /** Color code. */
    private int color;

    /** Installed wheels. */
    private List<Wheel> wheels = new ArrayList<Wheel>();

    public Car(String name, int colorCar) {
         super();
         this.name = name;
         this.color = colorCar;
    }

    public Car(String name, int colorCar, float wheelSize) {
        this(name, colorCar);

        System.out.println("Create a new car : " + this.name);

        for (int i = 0; i < 4; i++) {
            Wheel wheel = new Wheel(this.color, wheelSize);
            this.wheels.add(wheel);
//            this.localizedWheels.put("RL",	wheel);
        }
    }

    public final float getWheelSize() {
        Wheel wheel = this.wheels.get(0);
        return wheel.getSize();
    }

    /**
     * @return the wheels
     */
    public final List<Wheel> getWheels() {
        return wheels;
    }

    /**
     * @param wheels the wheels to set
     */
    public final Car setWheels(List<Wheel> wheels) {
        this.wheels = wheels;

        return this;
    }

    /**
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * @return the color
     */
    public final int getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public final void setColor(int color) {
        this.color = color;
    }

}

package com.tact.car.entity;

import java.util.List;

import com.tact.car.exception.GarageException;
import com.tact.car.exception.StockException;

/**
 * Technician of Car-Repair.
 */
public class Technician {

    private final String name;

    private final Garage garage;

    private boolean isWork = false;

    public Technician(String name, Garage garage) {
        super();
        this.name = name;
        this.garage = garage;
    }

    @Override
    public String toString() {
        return String.format("%s", this.name);
    }

    public void changeWheels(Car car) throws GarageException {
        this.isWork = true;

        List<Wheel> oldWheels = car.getWheels();
        List<Wheel> newWheels;
        try {
            newWheels = this.garage.getNewWheelsOnStock(car.getWheelSize());
        } catch (StockException e) {
            throw new GarageException(e);
        }

        System.out.println("Replace old wheels by new wheels...");
        car.getWheels().removeAll(oldWheels);
        car.getWheels().addAll(newWheels);

        this.garage.addWheelsToTrash(oldWheels);

        this.isWork = false;
    }

    /**
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * @return the isWork
     */
    public final boolean isWork() {
        return isWork;
    }
}

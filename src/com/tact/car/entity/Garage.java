package com.tact.car.entity;

import java.util.ArrayList;
import java.util.List;

import com.tact.car.exception.GarageException;
import com.tact.car.exception.StockException;

/**
 * Car-Repair Entity.
 */
public class Garage {

    /** Name of compagny */
    private final String name;

    /** Adress of compagny */
    private final String address;

    /** List of Employes. */
    private final List<Technician> employes = new ArrayList<Technician>();

    /** New Wheel stock. */
    private final List<Wheel> stocks = new ArrayList<Wheel>();

    /** Trash of Wheel. */
    private final List<Wheel> trashs = new ArrayList<Wheel>();

    /** Car in park */
    private final List<Car> parkingCars = new ArrayList<Car>();

    public Garage(String name, String address) {
        super();
        this.name = name;
        this.address = address;

//        this.employes = new ArrayList<Technician>();

        // Employ Jojo
        Technician tech = new Technician("Jojo", this);
        this.employes.add(tech);

        // Employ Mick
        tech = new Technician("Mick", this);
        this.employes.add(tech);

        System.out.println("Create new Gararge " + this.name + " with " + this.employes.size() + " employes.");
    }

    public void addNewWheels(List<Wheel> wheels) {
        this.stocks.addAll(wheels);
        System.out.println("Add wheels to stock... actual stock : " + this.stocks.size());
    }

    public List<Wheel> getNewWheelsOnStock(float size) throws StockException {
        List<Wheel> result = new ArrayList<Wheel>();

        System.out.println("Find new wheels from stock... size : " + size);

        for (Wheel wheel : this.stocks) {
            if (wheel.getSize() == size) {
                result.add(wheel);
            }
            if (result.size() == 4) {
                break;
            }
        }

        if (result.size() == 4) {
            this.stocks.removeAll(result);
            System.out.println("Finded 4 wheels of size " + size);
        } else {
            result.clear();
            throw new StockException("No new wheel available ! Please call provider...");
        }

        return result;
    }

    public void addWheelsToTrash(List<Wheel> wheels) {
        this.trashs.addAll(wheels);
        System.out.println("Add old wheels to trash... actual stock : " + this.trashs.size());
    }

    public void recieve(Car car) throws GarageException {
        this.parkingCars.add(car);

        System.out.println("A customer delivery a car " + car.getName() + " for change the wheels of size : " + car.getWheelSize());

        // Take a technician
        Technician tech = null;

        for (Technician technician : employes) {
            if (!technician.isWork()) {
                tech = technician;
                break;
            }
        }

        if (tech != null) {
            System.out.println("Find Technician available (" + tech +")...");
            tech.changeWheels(car);
        } else {
            throw new GarageException("No technician available !!");
        }

    }

    public Car delivery(String name) {
        Car result = null;

        for (Car car : this.parkingCars) {
            if (car.getName().equals(name)) {
                result = car;
                break;
            }
        }
        this.parkingCars.remove(result);

        return result;
    }

    /**
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * @return the address
     */
    public final String getAddress() {
        return address;
    }

}

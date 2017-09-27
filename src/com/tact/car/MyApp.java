package com.tact.car;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.tact.car.entity.Car;
import com.tact.car.entity.Garage;
import com.tact.car.entity.Wheel;
import com.tact.car.exception.GarageException;
import com.tact.car.exception.StockException;

public class MyApp {

    public static final int COLOR_BLACK = 0;

    /**
     * Starting endpoint
     * @param args
     */
    public static void main(String[] args) {

        Random rand = new Random(new Date().getTime());

        Garage myGarage = null;
        if (myGarage == null) {
            myGarage = new Garage("MonSuperGarage", "13 rue du champion, 35000 RENNES");

            // Provider make new wheels...
            List<Wheel> wheels = new ArrayList<Wheel>();
            for (int i = 0; i < 4; i++) {
                Wheel wheel = new Wheel(COLOR_BLACK, 24.0f);
                wheels.add(wheel);
            }

            for (int i = 0; i < 8; i++) {
                Wheel wheel = new Wheel(COLOR_BLACK, 32.0f);
                wheels.add(wheel);
            }
            // Delivery to Garage.
            myGarage.addNewWheels(wheels);
//            grepo.save(myGarage);
        }
        System.out.println("");

        // New Customer deliver her car.
        Car car = new Car("Titi", COLOR_BLACK, 24.0f);
        try {
            myGarage.recieve(car);
        } catch (GarageException e) {
            displayWhy(e);
        }
        System.out.println("");

        car = new Car("Toto", COLOR_BLACK, 32.0f);
        try {
            myGarage.recieve(car);
        } catch (GarageException e) {
            displayWhy(e);
        }
        System.out.println("");

        car = new Car("Tutu", COLOR_BLACK, 24.0f);
        try {
            myGarage.recieve(car);
        } catch (GarageException e) {
            displayWhy(e);
        }

    }

    private static void displayWhy(GarageException e) {
        if (e.getCause() instanceof StockException) {
            System.out.println("Please order wheels.");
        }
        System.out.println("Pb on gararge : " + e.getMessage());

    }

}

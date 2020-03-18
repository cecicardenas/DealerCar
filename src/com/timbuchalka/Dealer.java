package com.timbuchalka;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Dealer {

    private String model;
    private int year;
    private String color;
    private ArrayList<Car> car;

    public Dealer(String model, int year, String color) {
        this.model = model;
        this.year = year;
        this.color = color;
        this.car = new ArrayList<Car>();
    }

    public boolean addNewCar(Car newCar) {
        if (findCar(newCar.getSerialNumber()) >= 0) {
            System.out.println("Car is already on file");
            return false;
        }
        this.car.add(newCar);
        return true;
    }

    public int findCar(Car serialNumber) {
        return this.car.indexOf(serialNumber);
    }

    public int findCar(String serialNumber) {
        for (int i=0; i<this.car.size(); i++) {
            Car car = this.car.get(i);
            if (car.getSerialNumber().equals(serialNumber)) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeCar(Car serialNumber) {
        int foundPosition = findCar(serialNumber);
        if (foundPosition<0) {
            System.out.println(serialNumber.getSerialNumber() + ", was not found");
            return false;
        }
        this.car.remove(foundPosition);
        System.out.println(serialNumber.getSerialNumber() + ", was deleted");
        return true;
    }

    public boolean updateCar(Car oldCar, Car newCar) {
        int foundPosition = findCar(oldCar);
        if (foundPosition < 0) {
            System.out.println(oldCar.getSerialNumber() + ", was not found");
            return false;
        }
        this.car.set(foundPosition, newCar);
        System.out.println(oldCar.getSerialNumber() + ", was replaced with " + newCar.getSerialNumber());
        return true;
    }

    public String queryCar(Car serialNumber) {
        if (findCar(serialNumber)>=0) {
            return serialNumber.getSerialNumber();
        }
        return null;
    }

    public void printCar() {
        System.out.println("Car List");
        for (int i=0; i < this.car.size(); i++) {
            System.out.println((i+1) + "." +
                    this.car.get(i).getSerialNumber() + "--" +
                    this.car.get(i).getModel() + "--" +
                    this.car.get(i).getYear() + "--" +
                    this.car.get(i).getColor());
        }
    }

    public Car queryCar(String serialNumber) {
        int position = findCar(serialNumber);
        if (position >= 0) {
            return  this.car.get(position);
        }
        return null;
    }

    public ArrayList<Car> getCar() {
        return car;
    }
}

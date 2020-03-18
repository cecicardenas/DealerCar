package com.timbuchalka;

public class Car {
    private String serialNumber;
    private String model;
    private int year;
    private String color;

    public Car(String serialNumber, String model, int year, String color) {
        this.serialNumber = serialNumber;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public static Car createCar(String serialNumber, String model, int year, String color) {
        return new Car(serialNumber, model, year, color);

    }

}

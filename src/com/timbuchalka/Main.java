package com.timbuchalka;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Dealer dealer = new Dealer("Honda", 2020, "Black");

    public static void main(String[] args) {
        boolean quit = false;
        printActions();
        while (!quit) {
            System.out.println("\n Enter actions");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nShutting down");
                    quit = true;
                    break;
                case 1:
                    dealer.printCar();
                    break;
                case 2:
                    addNewCar();
                    break;
                case 3:
                    updateCar();
                    break;
                case 4:
                    removeCar();
                    break;
                case 5:
                    queryCar();
                    break;
                case 6:
                    printActions();
                    break;
                default:
            }
        }
    }

    private static void printActions() {
        System.out.println("\t 0 - Exit");
        System.out.println("\t 1 - Inventory");
        System.out.println("\t 2 - Add Car");
        System.out.println("\t 3 - Update Car");
        System.out.println("\t 4 - Remove Car");
        System.out.println("\t 5 - Search Car");
        System.out.println("\t 6 - Actions");
    }

    private static void addNewCar() {
        System.out.println("Enter new serial number: ");
        String serialNumber = scanner.nextLine();
        System.out.println("Enter model: ");
        String model = scanner.nextLine();
        System.out.println("Enter color: ");
        String color = scanner.nextLine();
        System.out.println("Enter year: ");
        int year = scanner.nextInt();

        Car newCar = Car.createCar(serialNumber, model, year, color);
        if (dealer.addNewCar(newCar)) {
            System.out.println("New car added: \nSerial Number= " + serialNumber + "\nmodel= " + model + "\nyear= " + year + "\ncolor= " + color);
        } else {
            System.out.println("Cannot add, " + serialNumber + " already on file");
        }
    }

    private static void updateCar() {
        System.out.println("Enter existing car");
        String numberSerial =scanner.nextLine();
        Car existingCarRecord = dealer.queryCar(numberSerial);
        if (existingCarRecord == null) {
            System.out.println("Car not found");
            return;
        }
        System.out.println("Enter new Number Serial: ");
        String newSerial = scanner.nextLine();
        System.out.println("Enter new model: ");
        String newModel = scanner.nextLine();
        System.out.println("Enter new color: ");
        String newColor = scanner.nextLine();
        System.out.println("Enter new year: ");
        int newYear= scanner.nextInt();
        Car newCar = Car.createCar(newSerial, newModel, newYear, newColor);
        if (dealer.updateCar(existingCarRecord, newCar)) {
            System.out.println("Successfully updated record");
        } else {
            System.out.println("Enter updating record");
        }
    }

    private static void removeCar() {
        System.out.println("Enter existing number serial");
        String numberSerial = scanner.nextLine();
        Car existingCarRecord = dealer.queryCar(numberSerial);
        if (existingCarRecord == null) {
            System.out.println("Car not found");
            return;
        }
        if (dealer.removeCar(existingCarRecord)) {
            System.out.println("Successfully deleted record");
        } else {
            System.out.println("Error deleting  contact");
        }
    }

    private static void queryCar() {
        System.out.println("Enter existing Number Serial");
        String serialNumber = scanner.nextLine();
        Car existingCarRecord = dealer.queryCar(serialNumber);
        if (existingCarRecord == null) {
            System.out.println("Contact not found");
            return;
        }
        System.out.println("Serial Number: " + existingCarRecord.getSerialNumber() + "\nModel: " + existingCarRecord.getModel() + "\nYear: " + existingCarRecord.getYear() + "\nColor: " + existingCarRecord.getColor());
    }

    private static void printCar() {
        dealer.getCar();
    }
}

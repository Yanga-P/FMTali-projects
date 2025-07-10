package com.cars;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Car> cars = new ArrayList<>();
        int menuOption;

        System.out.println("Good day. Welcome to the Vehicle Registration App!");

        do {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Register a new vehicle");
            System.out.println("2. View vehicle report");
            System.out.println("3. Exit the application");
            System.out.print("Enter your choice: ");
            while (!input.hasNextInt()) {
                System.out.print("Please enter a valid number (1-3): ");
                input.next();
            }
            menuOption = input.nextInt();
            input.nextLine();

            if (menuOption == 1) {
                Car car = new Car();

                System.out.print("Enter vehicle make (e.g., BMW): ");
                car.setMake(input.nextLine());

                System.out.print("Enter vehicle model (e.g., M4): ");
                car.setModel(input.nextLine());

                String vin;
                while (true) {
                    System.out.print("Enter VIN (17 characters): ");
                    vin = input.nextLine();
                    if (vin.length() == 17) {
                        car.setVin(vin);
                        break;
                    } else {
                        System.out.println("VIN must be exactly 17 characters long.");
                    }
                }

                System.out.println("Select license plate format:");
                System.out.println("1. Old format (e.g., ABC123GP)");
                System.out.println("2. New format (e.g., AB12CDGP)");
                System.out.print("Enter your choice: ");
                int plateChoice = input.nextInt();
                input.nextLine();

                if (plateChoice == 1) {
                    System.out.print("Enter old format plate number: ");
                } else if (plateChoice == 2) {
                    System.out.print("Enter new format plate number: ");
                } else {
                    System.out.println("Invalid choice. Skipping plate input.");
                }
                car.setPlateNumber(input.nextLine());

                System.out.print("Enter vehicle mileage: ");
                while (!input.hasNextInt()) {
                    System.out.print("Please enter a number for mileage: ");
                    input.next();
                }
                car.setMileage(input.nextInt());

                System.out.print("Enter year of manufacture (e.g., 2020): ");
                while (!input.hasNextInt()) {
                    System.out.print("Please enter a valid year: ");
                    input.next();
                }
                car.setYear(input.nextInt());
                input.nextLine();

                cars.add(car);
                System.out.println("Vehicle registered successfully!");

            } else if (menuOption == 2) {
                System.out.println("\n******** VEHICLE REPORT ********");
                if (cars.isEmpty()) {
                    System.out.println("No vehicles have been registered yet.");
                } else {
                    cars.sort(Comparator.comparingInt(Car::getYear).reversed());
                    for (Car c : cars) {
                        System.out.println("-------------------------------");
                        System.out.println("Make: " + c.getMake());
                        System.out.println("Model: " + c.getModel());
                        System.out.println("VIN: " + c.getVin());
                        System.out.println("Plate Number: " + c.getPlateNumber());
                        System.out.println("Mileage: " + c.getMileage());
                        System.out.println("Year: " + c.getYear());
                    }
                }
            } else if (menuOption == 3) {
                System.out.println("Thank you for using the Vehicle Registration App. Goodbye!");
            } else {
                System.out.println("Invalid option. Please select 1, 2, or 3.");
            }

        } while (menuOption != 3);

        input.close();
    }
}

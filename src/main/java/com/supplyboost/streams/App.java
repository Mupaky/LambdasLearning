package com.supplyboost.lambdabuildin;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class App {
    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(
                new Car("Honda", "Accord", "Red", 22300),
                new Car("Honda", "Civic", "Blue", 17700),
                new Car("Toyota", "Land Cruiser", "White", 48500),
                new Car("Toyota", "Corolla", "Black", 16200),
                new Car("Toyota", "Camry", "Blue", 24000),
                new Car("Nissan", "Sentra", "White", 17300),
                new Car("Mitsubishi", "Lancer", "White", 20000),
                new Car("Jeep", "Wrangler", "Red", 24500)
        );

// We don't have need of methods here
//        printCarsPriceRange(cars, 18000, 22000);
//        printCarByColor(cars, "Red");

//        System.out.println("Printing cars in range:");
//        printCars(cars, new CarCondition() {
//            @Override
//            public boolean test(Car car) {
//                return car.getPrice() >= 18000 && car.getPrice() <= 22000;
//            }
//        });
//
//        System.out.println("\nPrinting cars with color:");
//        printCars(cars, new CarCondition() {
//            @Override
//            public boolean test(Car car) {
//                return car.getColor().equals("Blue");
//            }
//        });

        System.out.println("\nPrinting cars in range simplified:");
        printCars(cars, (car) -> car.getPrice() >= 18000 && car.getPrice() <= 22000);
        printCars(cars, (car) -> car.getColor().equals("Blue"));

        System.out.println("\nPrinting cars with Predicate:");
        printCarsWithPredicate(cars, (car) -> car.getPrice() >= 18000 && car.getPrice() <= 22000);
        printCarsWithPredicate(cars, (car) -> car.getColor().equals("Blue"));


        //Start with function package
        Function<Car, String> priceAndColor = (c) -> "Price = " + c.getPrice() + " Color = " + c.getColor();
        System.out.println("\nPrinting cars with Function interface:");
        String stringColor = priceAndColor.apply(cars.getFirst());
        System.out.println(stringColor);


    }


    public static void printCars(List<Car> cars, CarCondition condition) {
        for(Car c: cars) {
            if(condition.test(c)) {
                c.printCar();
            }
        }
    }

    public static void printCarsWithPredicate(List<Car> cars, Predicate<Car> condition) {
        for(Car c: cars) {
            if(condition.test(c)) {
                c.printCar();
            }
        }
    }


    // We don't need those anymore after Lambda implementation and polymorphism
    public static void printCarsPriceRange(List<Car> cars, int low, int high) {
        for(Car c: cars) {
            if(low <= c.getPrice() && c.getPrice() <= high) {
                c.printCar();
            }
        }
    }

    // We don't need those anymore after Lambda implementation and polymorphism
    public static void printCarByColor(List<Car> cars, String color) {
        for(Car c: cars) {
            if(c.getColor().equals(color)) {
                c.printCar();
            }
        }
    }


}
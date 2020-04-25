package com.jai.overriding;

public class TestOverride {

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        Vehicle vehicle1 = new Bus();
        Vehicle vehicle2 = new Car();

        vehicle.maxSpeed();
        vehicle1.maxSpeed();
        vehicle2.maxSpeed();
        Car car = new Car();

        System.out.println(vehicle.add(1,5));
        System.out.println(car.add(1,5));
    }
}

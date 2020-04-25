package com.jai.overriding;

public class Car extends Vehicle {

    void maxSpeed() {
        System.out.println("Vehicle max speed 70mph");
    }

    public long add(long x, long y) {
        System.out.println("Car add..");
        return x+y;
    }
}

package com.jai.ca.overriding;

public class BClass extends AClass {

    public void sayHello(AClass aClass) {
        System.out.println("AClass's child says hello world");
    }

    public void sayHello(BClass aClass) {
        System.out.println("BClass says hello world");
    }
}



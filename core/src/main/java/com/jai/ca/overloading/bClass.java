package com.jai.ca.overloading;

public class bClass {

    public void Initialise(String test) {
        test = "This is a test";
    }

    public void HelloWorld() {
        String boo = null;
        Initialise(boo);
        System.out.println(boo);
    }

    /**
     * we can implement method overloading in two different ways:
     *
     * implementing two or more methods that have the same name but take different numbers of arguments
     * implementing two or more methods that have the same name but take arguments of different types
     *
     *
     * Here's a summary of the type promotion rules that apply for method overloading:
     *
     * byte can be promoted to short, int, long, float, or double
     * short can be promoted to int, long, float, or double
     * char can be promoted to int, long, float, or double
     * int can be promoted to long, float, or double
     * long can be promoted to float or double
     * float can be promoted to double
     */
    // Not a valid overload.
    //    protected String HelloWorld() {
//        String boo = null;
//        Initialise(boo);
//        System.out.println(boo);
//        return boo;
//    }
}

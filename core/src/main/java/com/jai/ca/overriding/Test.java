package com.jai.ca.overriding;

public class  Test {

    public static void main(String[] args) {
        AClass aclass = new BClass();
        aclass.sayHello(aclass);

//        BClass bclass = new BClass();
//        bclass.sayHello(aclass);
    }
}

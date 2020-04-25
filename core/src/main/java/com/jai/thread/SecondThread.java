package com.jai.thread;

public class SecondThread implements Runnable{

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().toString());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread is running.." +i);
        }
    }


    public static void main(String[] args) {
        System.out.println("Main started");
        SecondThread s = new SecondThread();
        System.out.println(Thread.currentThread().toString());
        new Thread(s).start();
        System.out.println("Main ended");
    }
}

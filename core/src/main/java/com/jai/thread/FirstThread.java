package com.jai.thread;

public class FirstThread extends Thread{

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread is running..");
        }

    }

    public static void main(String[] args) {
        System.out.println("Main started");
        new FirstThread().start();
        System.out.println("Main ended");
    }
}

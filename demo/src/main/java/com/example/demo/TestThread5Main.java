package com.example.demo;

public class TestThread5Main {

    public static void main(String[] args) throws InterruptedException {

        TestThread5 thread5=new TestThread5();
        thread5.start();
        Thread.sleep(8000);
        thread5.stop();
    }
}

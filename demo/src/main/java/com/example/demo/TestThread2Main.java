package com.example.demo;

public class TestThread2Main {

    public static void main(String[] args) {

        try{
            TestThread2 thread2=new TestThread2();
            thread2.start();
            Thread.sleep(500);
            thread2.interrupt();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("main catch");
        }
        System.out.println("end");

    }
}

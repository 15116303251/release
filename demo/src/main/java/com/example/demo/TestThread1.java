package com.example.demo;

public class TestThread1 {

    public static void main(String[] args) {

        try{
            MyThread1 thread1=new MyThread1();
            thread1.start();
            Thread.sleep(500);
            thread1.interrupt();
        }catch (Exception e){
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end");
    }

}

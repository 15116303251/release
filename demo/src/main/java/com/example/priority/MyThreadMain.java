package com.example.priority;

public class MyThreadMain {

    public static void main(String[] args) {

        System.out.println("main thread begin priority="+Thread.currentThread().getPriority());

        Thread.currentThread().setPriority(6);

        System.out.println("main thread begin priority="+Thread.currentThread().getPriority());

        MyThread1 thread1=new MyThread1();
        thread1.start();

    }
}

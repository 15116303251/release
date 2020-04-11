package com.example.suspend;

public class SynchronizedObject {

    synchronized public void printString(){

        System.out.println("begin");
        if(Thread.currentThread().getName().equalsIgnoreCase("a")){
            System.out.println("a 线程永远的suspend 了");
            Thread.currentThread().suspend();
        }
        System.out.println("end");
    }
}

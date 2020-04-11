package com.example.priority;

public class MyThread2 extends Thread{

    @Override
    public void run() {

        System.out.println("the second thread priority is "+ this.getPriority());
        
    }
}

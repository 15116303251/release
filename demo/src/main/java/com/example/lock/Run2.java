package com.example.lock;

public class Run2 {

    public static void main(String[] args) throws InterruptedException {
        Service service=new Service();

        MyThread myThread=new MyThread(service);
        myThread.start();

        Thread.sleep(2000);
        MyThread1 myThread1=new MyThread1(service);
        myThread1.start();
    }
}

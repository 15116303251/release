package com.example.synchronize.synchronize10;

public class ThreadA extends Thread {

    private Service service;

    public ThreadA(Service service){
        super();
        this.service=service;
    }

    @Override
    public void run() {
        super.run();
        service.printA();
    }

}

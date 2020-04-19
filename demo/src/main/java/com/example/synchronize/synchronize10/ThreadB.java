package com.example.synchronize.synchronize10;

public class ThreadB extends Thread {

    private Service service;

    public ThreadB(Service service){
        super();
        this.service=service;
    }

    @Override
    public void run() {
        super.run();
        service.printB();
    }

}

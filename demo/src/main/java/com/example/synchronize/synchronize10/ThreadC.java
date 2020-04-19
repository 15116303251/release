package com.example.synchronize.synchronize10;

public class ThreadC extends Thread {

    private Service service;

    public ThreadC(Service service){
        super();
        this.service=service;
    }

    @Override
    public void run() {
        super.run();
        service.printC();
    }

}

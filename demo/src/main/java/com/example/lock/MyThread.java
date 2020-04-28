package com.example.lock;

public class MyThread extends Thread {

    private Service service;

    public MyThread(Service service){
        super();
        this.service=service;
    }

    @Override
    public void run() {
        super.run();
        service.waitMethod();
    }

}

package com.example.synchronize.synchronize9;

public class ThreadA extends Thread{

    @Override
    public void run() {
        super.run();
        Service.printA();
    }

}

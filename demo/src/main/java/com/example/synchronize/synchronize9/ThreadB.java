package com.example.synchronize.synchronize9;

public class ThreadB extends Thread{

    @Override
    public void run() {
        super.run();
        Service.printB();
    }

}

package com.example.waitnotify;

public class ThreadSubtract extends Thread {

    private Subtract b;

    public ThreadSubtract(Subtract b){
        super();
        this.b=b;
    }

    @Override
    public void run() {
        super.run();
        b.subtract();
    }

}

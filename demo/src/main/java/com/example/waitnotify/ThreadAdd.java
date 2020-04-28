package com.example.waitnotify;

public class ThreadAdd extends Thread {

    private Add a;

    public ThreadAdd(Add a){
        super();
        this.a=a;
    }

    @Override
    public void run() {
        super.run();
        a.add();
    }

}

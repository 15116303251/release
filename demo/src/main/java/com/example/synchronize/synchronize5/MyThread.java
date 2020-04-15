package com.example.synchronize.synchronize5;

public class MyThread extends Thread {

    @Override
    public void run() {
        Sub sub=new Sub();
        sub.operateMainMethod();
    }

}

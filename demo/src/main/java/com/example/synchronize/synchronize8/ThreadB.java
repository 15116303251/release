package com.example.synchronize.synchronize8;

import com.example.synchronize.synchronize8.MyObject;

public class ThreadB extends Thread{

    private MyObject object;

    public ThreadB(MyObject object){
        super();
        this.object=object;
    }

    @Override
    public void run() {
        super.run();
        object.speedPrintString();
    }

}

package com.example.suspend;

public class SuspendResumeLockStop extends Thread{

    private long i=0;

    @Override
    public void run() {

        while(true){
            i++;
            System.out.println(i);
        }
    }
}

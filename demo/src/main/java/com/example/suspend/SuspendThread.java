package com.example.suspend;

public class SuspendThread extends Thread{

    private long i=0;

    public long getId(){
        return i;
    }

    public void setId(long i){
        this.i=i;
    }

    @Override
    public void run() {

        while(true){
            i++;
        }
    }
}

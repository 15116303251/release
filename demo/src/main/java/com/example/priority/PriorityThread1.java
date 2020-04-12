package com.example.priority;


public class PriorityThread1 extends Thread {

    private long count=0;

    public long getCount() {
        return count;
    }

    @Override
    public void run() {
        while(true){
            count++;
        }
    }



}

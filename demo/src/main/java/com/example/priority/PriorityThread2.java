package com.example.priority;


public class PriorityThread2 extends Thread {
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

package com.example.demo;

public class TestReturnInterruptThread extends Thread{

    @Override
    public void run() {

        while(true){
            if(this.isInterrupted()){
                System.out.println("线程停止了");
                return;
            }
            System.out.println("time="+System.currentTimeMillis());
        }

    }

}

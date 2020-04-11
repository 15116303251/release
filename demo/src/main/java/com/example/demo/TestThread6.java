package com.example.demo;

public class TestThread6 extends Thread{


    @Override
    public void run() {
        super.run();
        try{
            this.stop();
        }catch (ThreadDeath e){
            System.out.println("线程进入了catch()");
            e.printStackTrace();
        }
    }
}

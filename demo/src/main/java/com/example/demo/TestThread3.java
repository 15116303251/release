package com.example.demo;

public class TestThread3 extends Thread{

    @Override
    public void run() {

        super.run();

        try{
            System.out.println("thread start");
            Thread.sleep(20000);
            System.out.println("thread end");
        }catch (Exception e){
            System.out.println("当前线程在沉睡中被停止！进入catch!"+this.isInterrupted());
            e.printStackTrace();
        }
    }
}

package com.example.demo;

public class TestThread4Main {

    public static void main(String[] args) {

        try{
            TestThread4 thread4=new TestThread4();
            thread4.start();
            Thread.sleep(200);
            thread4.interrupt();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

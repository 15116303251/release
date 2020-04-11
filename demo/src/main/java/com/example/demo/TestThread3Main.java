package com.example.demo;

public class TestThread3Main {

    public static void main(String[] args) {

        try{
            TestThread3 thread3=new TestThread3();
            thread3.start();
            Thread.sleep(200);
            thread3.interrupt();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}

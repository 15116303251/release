package com.example.synchronize.synchronize6;

public class Service {

    public void testMethod1(MyObject object){
        try{
            System.out.println("testMethod1----getLockTime"+System.currentTimeMillis()+"run ThreadName"+Thread.currentThread().getName());
            Thread.sleep(2000);
            System.out.println("testMethod1 releaseLockTime"+System.currentTimeMillis()+"run ThreadName"+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

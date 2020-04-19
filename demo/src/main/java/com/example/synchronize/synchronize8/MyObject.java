package com.example.synchronize.synchronize8;

public class MyObject {

    public void speedPrintString(){

        synchronized (this){
            System.out.println("get_lock_time"+System.currentTimeMillis()+"run_thread_name"+Thread.currentThread().getName());

            System.out.println("----------");

            System.out.println("release_lock_time"+System.currentTimeMillis()+"run_thread_name"+Thread.currentThread().getName());
        }
    }
}

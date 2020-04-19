package com.example.synchronize.synchronize7;

public class MyObject {

    synchronized public void speedPrintString(){

        System.out.println("get_lock_time"+System.currentTimeMillis()+"run_thread_name"+Thread.currentThread().getName());

        System.out.println("----------");

        System.out.println("release_lock_time"+System.currentTimeMillis()+"run_thread_name"+Thread.currentThread().getName());
    }
}

package com.example.synchronize.synchronize7;

public class Service {

    public void testMethod(MyObject object){

        synchronized (object){
            try{
                System.out.println("test_method_get_lock_time"+System.currentTimeMillis()+"run_thread_name"+Thread.currentThread().getName());

                Thread.sleep(5000);

                System.out.println("release_lock_time"+System.currentTimeMillis()+"run_thread_name"+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

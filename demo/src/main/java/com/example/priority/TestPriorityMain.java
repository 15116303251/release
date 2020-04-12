package com.example.priority;

import com.example.demo.TestThread1;

public class TestPriorityMain {

    public static void main(String[] args) {

        try{
            PriorityThread1 thread1=new PriorityThread1();
            thread1.setPriority(Thread.NORM_PRIORITY-3);
            thread1.start();


            PriorityThread2 thread2=new PriorityThread2();
            thread2.setPriority(Thread.NORM_PRIORITY+3);
            thread2.start();
            Thread.sleep(20000);
            thread1.stop();
            thread2.stop();

            System.out.println("thread1="+thread1.getCount());
            System.out.println("thread2="+thread2.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

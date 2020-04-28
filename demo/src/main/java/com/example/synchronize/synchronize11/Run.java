package com.example.synchronize.synchronize11;

public class Run {

    public static void main(String[] args) throws InterruptedException {

        DealThread thread=new DealThread();

        thread.setFlag("a");
        Thread thread1=new Thread(thread);
        thread1.start();

        Thread.sleep(100);

        thread.setFlag("b");
        Thread thread2=new Thread(thread);
        thread2.start();
    }
}

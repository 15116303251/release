package com.example.suspend;

public class SuspendThreadMain {

    public static void main(String[] args) {
        try{
            SuspendThread thread=new SuspendThread();
            thread.start();
            Thread.sleep(5000);


            thread.suspend();
            System.out.println("A="+System.currentTimeMillis()+"i="+thread.getId());
            Thread.sleep(5000);
            System.out.println("A="+System.currentTimeMillis()+"i="+thread.getId());


            thread.resume();
            Thread.sleep(5000);

            thread.suspend();
            System.out.println("B="+System.currentTimeMillis()+"i="+thread.getId());
            Thread.sleep(5000);
            System.out.println("B="+System.currentTimeMillis()+"i="+thread.getId());
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

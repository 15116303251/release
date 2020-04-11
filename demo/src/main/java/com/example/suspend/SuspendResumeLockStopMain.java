package com.example.suspend;

public class SuspendResumeLockStopMain {

    public static void main(String[] args) {

        try{
            SuspendResumeLockStop thread=new SuspendResumeLockStop();
            thread.start();

            Thread.sleep(1000);

            thread.suspend();
            System.out.println("main end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

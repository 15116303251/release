package com.example.suspend;

public class SuspendResumeNoSameValueMain {


    public static void main(String[] args) throws InterruptedException {
        final SuspendResumeNoSameValue object = new SuspendResumeNoSameValue();

        Thread thread1 = new Thread() {

            @Override
            public void run() {
                object.setValue("a", "aa");
            }
        };

        thread1.setName("a");
        thread1.start();
        Thread.sleep(500);


        Thread thread2 = new Thread() {

            @Override
            public void run() {
                object.printUserNamePassword();
            }
        };

        thread2.start();
    }

}

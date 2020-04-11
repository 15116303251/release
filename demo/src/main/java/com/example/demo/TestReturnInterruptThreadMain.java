package com.example.demo;

public class TestReturnInterruptThreadMain {

    public static void main(String[] args) throws InterruptedException {
        TestReturnInterruptThread thread=new TestReturnInterruptThread();
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }
}

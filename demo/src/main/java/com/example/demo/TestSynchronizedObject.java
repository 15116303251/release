package com.example.demo;

public class TestSynchronizedObject extends Thread{

    private SynchronizedObject synchronizedObject;

    public TestSynchronizedObject(SynchronizedObject synchronizedObject){
        this.synchronizedObject=synchronizedObject;
    }

    @Override
    public void run() {
        super.run();
        synchronizedObject.printString("b","bb");
    }
}

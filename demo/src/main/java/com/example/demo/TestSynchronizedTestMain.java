package com.example.demo;

public class TestSynchronizedTestMain {

    public static void main(String[] args) {

        try{
           SynchronizedObject object=new SynchronizedObject();
           TestSynchronizedObject thread=new TestSynchronizedObject(object);
           thread.start();
           Thread.sleep(500);
           thread.stop();
           System.out.println(object.getUsername()+"--"+object.getPassword());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

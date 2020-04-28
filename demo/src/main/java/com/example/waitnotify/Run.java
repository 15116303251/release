package com.example.waitnotify;

public class Run {

    public static void main(String[] args) throws InterruptedException {

        String lock=new String("");

        Add add=new Add(lock);
        Subtract subtract=new Subtract(lock);

        ThreadSubtract subtract1=new ThreadSubtract(subtract);
        subtract1.setName("sub thread1");
        subtract1.start();

        ThreadSubtract subtract2=new ThreadSubtract(subtract);
        subtract2.setName("sub thread2");
        subtract2.start();


        Thread.sleep(500);

        ThreadAdd threadAdd=new ThreadAdd(add);
        threadAdd.setName("add thread");
        threadAdd.start();
    }
}

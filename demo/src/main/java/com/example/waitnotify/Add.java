package com.example.waitnotify;


public class Add {

    private String lock;

    public Add(String lock){
        super();
        this.lock=lock;
    }

    public void add(){
        synchronized (lock){
            ValueObject.list.add("test1");
            lock.notifyAll();
        }
    }
}

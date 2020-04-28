package com.example.waitnotify;

public class Subtract {

    private String lock;

    public Subtract(String lock){
        super();
        this.lock=lock;
    }

    public void subtract(){
        try{
            synchronized (lock){
                if(ValueObject.list.size()==0){
                    System.out.println("wait begin ThreadName="+Thread.currentThread().getName());
                    lock.wait();
                    ValueObject.list.remove(0);
                    System.out.println("wait end ThreadName="+Thread.currentThread().getName());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

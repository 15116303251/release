package com.example.synchronize.synchronize8;

public class Run {

    public static void main(String[] args) throws InterruptedException {

        Service service=new Service();
        MyObject myObject=new MyObject();

        ThreadA a=new ThreadA(service,myObject);
        a.setName("a");
        a.start();
        Thread.sleep(100);

        ThreadB threadB=new ThreadB(myObject);
        threadB.setName("b");
        threadB.start();

    }
}

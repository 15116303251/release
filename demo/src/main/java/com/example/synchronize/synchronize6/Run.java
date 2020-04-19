package com.example.synchronize.synchronize6;

public class Run {

    public static void main(String[] args) {

        Service service=new Service();
        MyObject object=new MyObject();

        ThreadA a=new ThreadA(service,object);
        a.setName("a");
        a.start();

        ThreadB threadB=new ThreadB(service,object);
        threadB.setName("b");
        threadB.start();
    }
}

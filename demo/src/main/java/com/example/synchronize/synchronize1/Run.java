package com.example.synchronize.synchronize1;

public class Run {

    public static void main(String[] args) {

        HasSelfPrivateNum numRef=new HasSelfPrivateNum();
        ThreadA a = new ThreadA(numRef);
        ThreadB b=new ThreadB(numRef);
        a.start();
        b.start();

    }
}

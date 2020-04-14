package com.example.synchronize.synchronize2;

public class Run {

    public static void main(String[] args) {
        HasSelfPrivateNum numRef=new HasSelfPrivateNum();
        ThreadA aThread=new ThreadA(numRef);
        ThreadB bThread=new ThreadB(numRef);
        aThread.start();
        bThread.start();
    }
}

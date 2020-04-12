package com.example.daemon;

public class TestMyThreadMain {

    public static void main(String[] args) {

        try{
            MyThread thread=new MyThread();
            thread.setDaemon(true);//当进程中不再存在非守护线程了，则守护线程将自动销毁
            thread.start();
            Thread.sleep(5000);
            System.out.println("我离开thread对象也不再打印了，也就是停止了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

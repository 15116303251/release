package com.example.demo;

public class TestInterrupt {

    public static void main(String[] args) {

        try {
            MyThread thread=new MyThread();
            thread.start();
            Thread.sleep(1000);
            thread.interrupt();
            System.out.println("是否停止1"+thread.isInterrupted());
            System.out.println("是否停止2"+thread.isInterrupted());

//            Thread.currentThread().interrupt();
//            System.out.println("是否停止1"+Thread.interrupted());
//            System.out.println("是否停止2"+Thread.interrupted());
            System.out.println("end");
        }catch (Exception e){
            System.out.println("main catch");
            e.printStackTrace();
        }
    }
}

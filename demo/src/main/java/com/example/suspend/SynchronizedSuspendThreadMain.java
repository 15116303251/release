package com.example.suspend;

public class SynchronizedSuspendThreadMain {

    public static void main(String[] args) {
        try {
            final SynchronizedObject object=new SynchronizedObject();

            Thread thread1=new Thread(){

                public void run(){
                    object.printString();
                }
            };

            thread1.setName("a");
            thread1.start();
            Thread.sleep(1000);


            Thread thread2=new Thread(){
                public void run(){
                    System.out.println("thread2 启动了，但进入不了printString()方法！只打印1个begin");
                    System.out.println("因为printString()方法被a 线程锁定并且被永远的suspend 了");
                    object.printString();
                }
            };
            thread2.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

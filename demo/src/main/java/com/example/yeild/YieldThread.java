package com.example.yeild;

public class YieldThread extends Thread{


    @Override
    public void run() {

        long beginTime=System.currentTimeMillis();
        int count=0;

        for(int i=0;i<50000000;i++){
            Thread.yield();//放弃当前的cpu资源，供其他任务使用
            count =count+(i+1);
        }
        long endTime=System.currentTimeMillis();

        System.out.println("用时："+(endTime-beginTime)+"毫秒");

    }
}

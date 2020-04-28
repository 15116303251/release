package com.example.synchronize.atomic;

import java.util.concurrent.atomic.AtomicLong;

public class MyService {

    public static AtomicLong aLong=new AtomicLong();

    public void addNum(){
        System.out.println(Thread.currentThread().getName()+"加了100之后的值是："+aLong.addAndGet(100));
        aLong.addAndGet(1);
    }
}

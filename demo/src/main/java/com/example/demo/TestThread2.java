package com.example.demo;

public class TestThread2 extends Thread{

    @Override
    public void run() {

        super.run();

        try {
            for(int i=1;i<500000;i++){
                if(this.interrupted()){
                    System.out.println("已经停止状态了！我要退出了！");
                    throw new InterruptedException();
                }
                System.out.println("i="+(i+1));
            }

            System.out.println("我在for循环下面");
        }catch (Exception e){
            System.out.println("捕捉到了异常的，正在处理异常相关的信息");
            e.printStackTrace();
        }
    }

}

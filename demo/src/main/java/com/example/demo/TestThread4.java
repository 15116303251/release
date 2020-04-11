package com.example.demo;

public class TestThread4 extends Thread {

    @Override
    public void run() {

        super.run();

        try {
            for (int i = 0; i < 100000; i++) {
                System.out.println("i=" + (i + 1));
            }
            System.out.println("run start");
            Thread.sleep(20000);
            System.out.println("run end");
        } catch (Exception e) {
            System.out.println("先停止，再遇到了sleep!进入了catch！");
            e.printStackTrace();
        }
    }

}

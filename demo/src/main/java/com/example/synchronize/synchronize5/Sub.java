package com.example.synchronize.synchronize5;

public class Sub extends Main {

    @Override
    synchronized public  void operateMainMethod() {
        try{
            while(i>0){
                i--;
                System.out.println("sub print i="+i);
                Thread.sleep(1000);
                super.operateMainMethod();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

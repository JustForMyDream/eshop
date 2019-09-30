package com.wyl.learn.concurrent.chapter81;

import java.util.concurrent.CyclicBarrier;

/**
 * @Author :wyl
 * @Date :2019/9/12 14:14
 * @Version 1.0 :
 * @Description :
 */
public class CyclicBarrierTest2 {

    static CyclicBarrier c = new CyclicBarrier(2,new A());
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                } catch (Exception e) {
                }
                System.out.println(1);
            }
        }).start();
        try {
            c.await();
        } catch (Exception e) {
        }
        System.out.println(2);
    }
    static class A implements Runnable {
        @Override
        public void run() {
            System.out.println(3);
        }
    }
}

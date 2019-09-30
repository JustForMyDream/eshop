package com.wyl.learn.concurrent.chapter81;

import java.util.concurrent.CountDownLatch;

/**
 * @Author :wyl
 * @Date :2019/9/12 14:02
 * @Version 1.0 :
 * @Description :
 */
public class CountDownLatchTest {
        static CountDownLatch c = new CountDownLatch(2);
        public static void main(String[] args) throws InterruptedException {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(1);
                    c.countDown();
                    System.out.println(2);
                    c.countDown();
                }
            }).start();
            c.await();
            System.out.println("3");
        }
}

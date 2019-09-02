package com.wyl.learn.thread.chapter421;

/**
 * @Author :wyl
 * @Date :2019/9/2 11:35
 * @Version 1.0 :
 * @Description :
 */
public class Run {
    public static void main(String[] args) throws Exception{
        Service service = new Service();
       Thread threadA = new Thread(new Runnable() {
           @Override
           public void run() {
               service.read();
           }
       },"A");
        threadA.start();

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                service.read();
            }
        },"B");
        threadB.start();

    }
}

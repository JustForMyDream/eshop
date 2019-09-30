package com.wyl.learn.thread.chapter73;

/**
 * @Author :wyl
 * @Date :2019/9/3 11:14
 * @Version 1.0 :
 * @Description :
 */
public class Run {

    public static void main(String[] args) {
        Object lock = new Object();
        MyThread a = new MyThread(lock,"A",1);
        MyThread b = new MyThread(lock,"B",2);
        MyThread c = new MyThread(lock,"C",0);

        a.start();
        b.start();
        c.start();
    }
}

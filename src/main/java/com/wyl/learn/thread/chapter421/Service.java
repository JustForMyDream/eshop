package com.wyl.learn.thread.chapter421;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author :wyl
 * @Date :2019/9/2 11:31
 * @Version 1.0 :
 * @Description :
 */
public class Service {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read(){
        try {
            lock.readLock().lock();
            System.out.println("获得锁："+Thread.currentThread().getName()+" "+System.currentTimeMillis());
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().lock();
        }
    }


}

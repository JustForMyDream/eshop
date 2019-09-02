package com.wyl.learn.thread.chapter4114;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author :wyl
 * @Date :2019/9/2 10:02
 * @Version 1.0 :
 * @Description :
 */
public class MyService {
    public ReentrantLock lock = new ReentrantLock();

    public void waitMethod(){

        try {
            if(lock.tryLock(3, TimeUnit.SECONDS)){
                System.out.println("  "+ Thread.currentThread().getName()+" 获得锁的时间:"+System.currentTimeMillis());
                Thread.sleep(1000);
            }else {
                System.out.println("  "+ Thread.currentThread().getName()+" 没有获得锁");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(lock.isHeldByCurrentThread()){
                lock.unlock();
            }
        }
    }

}

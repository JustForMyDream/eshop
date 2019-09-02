package com.wyl.learn.thread.chapter419;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author :wyl
 * @Date :2019/8/31 9:41
 * @Version 1.0 :
 * @Description :
 */
public class Service {
    private ReentrantLock lock;

    public Service(boolean isFair){
        super();
        lock = new ReentrantLock(isFair);
    }

    public void serviceMethod(){
        try {
            lock.lock();
            System.out.println("ThreadName = " + Thread.currentThread().getName() + "获得锁");
        } finally {
            lock.unlock();
        }

    }
}

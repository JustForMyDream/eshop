package com.wyl.learn.concurrent.chapter44;

/**
 * @Author :wyl
 * @Date :2019/9/5 17:24
 * @Version 1.0 :
 * @Description :
 */
public interface ThreadPool <Job extends Runnable> {

    void execute(Job job);

    void shutdown();

    void addWorkers(int num);

    void removeWorker(int num);

    int getJobSize();

}

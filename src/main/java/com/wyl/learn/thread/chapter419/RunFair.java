package com.wyl.learn.thread.chapter419;

/**
 * @Author :wyl
 * @Date :2019/9/2 9:12
 * @Version 1.0 :
 * @Description :
 */
public class RunFair {
    public static void main(String[] args) throws Exception{
        final Service service = new Service(true);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("*线程"+Thread.currentThread().getName()+"运行了");
                service.serviceMethod();
            }
        };

        Thread[] threadArrays = new Thread[10];
        for(int i = 0;i < 10; i ++){
            threadArrays[i] = new Thread(runnable);
        }

        for(int i = 0;i < 10; i ++){
            threadArrays[i].start();
        }
    }
}

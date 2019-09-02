package com.wyl.learn.thread.chapter4114;

/**
 * @Author :wyl
 * @Date :2019/9/2 10:06
 * @Version 1.0 :
 * @Description :
 */
public class Run {

    public static void main(String[] args) throws InterruptedException{
        final MyService service = new MyService();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"调用了"+  System.currentTimeMillis());
                service.waitMethod();
            }
        };
        Thread threadA = new Thread(runnable);
        threadA.setName("A");
        threadA.start();
        Thread threadB = new Thread(runnable);
        threadA.setName("B");
        threadA.start();
    }

}

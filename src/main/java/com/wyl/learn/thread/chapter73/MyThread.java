package com.wyl.learn.thread.chapter73;

/**
 * @Author :wyl
 * @Date :2019/9/2 15:36
 * @Version 1.0 :
 * @Description :
 */
public class MyThread extends Thread {
    private Object lock;
    private String showChar;
    private int showNumberPosition;
    private int printCount = 0;
    volatile private static int addNumber = 1;

    public MyThread(Object lock,String showChar, int showNumberPosition){
        super();
        this.lock = lock;
        this.showChar = showChar;
        this.showNumberPosition = showNumberPosition;
    }

    @Override
    public void run() {
        try {
            synchronized (lock){
                while (true){
                    if(addNumber % 3 == showNumberPosition){
                        System.out.println("threadname = "+Thread.currentThread().getName()+" runCount=" + addNumber + " " + showChar);
                        lock.notifyAll();
                        addNumber++;
                        printCount++;
                        if(printCount == 3){
                            break;
                        }
                    }else {
                        lock.wait();
                    }

                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package com.wyl.learn.thread.chapter62;

/**
 * @Author :wyl
 * @Date :2019/9/2 14:41
 * @Version 1.0 :
 * @Description :
 */
public class Single {

    private static volatile  Single single; // volatile 防止指令重排序

    private Single(){}

    public static Single getInstance(){
        if(single == null){  //double check lock 双检查锁机制
            synchronized (Single.class){
                if(single == null){
                    single = new Single();
                }
            }
        }
        return single;
    }
}

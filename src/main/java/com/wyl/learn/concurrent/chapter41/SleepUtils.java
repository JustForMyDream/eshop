package com.wyl.learn.concurrent.chapter41;

import java.util.concurrent.TimeUnit;

/**
 * @Author :wyl
 * @Date :2019/9/5 13:36
 * @Version 1.0 :
 * @Description :
 */
public class SleepUtils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
        }
    }
}

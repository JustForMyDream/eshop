package com.wyl.learn.test.algorithm;

/**
 * @Author :wyl
 * @Date :2019/9/23 13:46
 * @Version 1.0 :
 * @Description :
 */
public class Test01 {
    public static void main(String[] args) {
        System.out.println(stepNumer(2));

    }

    public static int stepNumer(int n) {
        if (n < 3)
            return n;
        else
            return stepNumer(n - 1) + stepNumer(n - 2);
    }
}

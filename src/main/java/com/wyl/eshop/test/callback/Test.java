package com.wyl.eshop.test.callback;

/**
 * @Author :wyl
 * @Date :2019/8/15 15:21
 * @Version 1.0 :
 * @Description :
 */
public class Test {
    public static void main(String[] args) {
        B b = new B();
        A a = new A(b);
        a.ask("1233");
    }
}

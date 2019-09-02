package com.wyl.learn.test.design;

/**
 * @Author :wyl
 * @Date :2019/8/16 17:44
 * @Version 1.0 :
 * @Description :
 */
public class Client {
    public static void main(String[] args) {
        HanFeiZi hanFeiZi = new HanFeiZi();

        hanFeiZi.addObserver(new LiSi());

        hanFeiZi.haveBreakfast();
    }
}

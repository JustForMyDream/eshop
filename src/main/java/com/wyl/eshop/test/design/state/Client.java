package com.wyl.eshop.test.design.state;

/**
 * @Author :wyl
 * @Date :2019/8/20 9:15
 * @Version 1.0 :
 * @Description :
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.setLiftState(new ClosingState());
        context.open();
        context.close();
        context.run();
        context.stop();
    }
}

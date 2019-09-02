package com.wyl.learn.test.callback;

/**
 * @Author :wyl
 * @Date :2019/8/15 15:17
 * @Version 1.0 :
 * @Description :
 */
public class B {
    public void excuteMessage(CallBack callBack,String question){
        System.out.println(callBack.getClass()+"问的问题--》"+question);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String result="答案是2";
        callBack.solve(result);
    }
}

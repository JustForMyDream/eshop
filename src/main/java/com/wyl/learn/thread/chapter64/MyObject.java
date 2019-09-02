package com.wyl.learn.thread.chapter64;

import java.io.Serializable;

/**
 * @Author :wyl
 * @Date :2019/9/2 14:52
 * @Version 1.0 :
 * @Description :
 */
public class MyObject implements Serializable {
    private static final long serialVersionUID = 888L;

    private static class MyObjectHandler{
        private static final MyObject myobject = new MyObject();
    }

    private MyObject(){}

    public static MyObject getInstance(){
        return MyObjectHandler.myobject;
    }
}

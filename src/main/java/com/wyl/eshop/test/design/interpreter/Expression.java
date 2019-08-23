package com.wyl.eshop.test.design.interpreter;

import java.util.HashMap;

/**
 * @Author :wyl
 * @Date :2019/8/20 10:27
 * @Version 1.0 :
 * @Description :
 */
public abstract class Expression {
    //解析公式和数值,其中var中的key值是是公式中的参数，value值是具体的数字
    public abstract int interpreter(HashMap<String,Integer> var);
}

package com.wyl.eshop.test.design.interpreter;

import java.util.HashMap;

/**
 * @Author :wyl
 * @Date :2019/8/20 10:28
 * @Version 1.0 :
 * @Description :
 */
public class VarExpression extends Expression {
    private String key;
    public VarExpression(String _key){
        this.key = _key;
    }
    //从map中取之
    public int interpreter(HashMap<String, Integer> var) {
        return var.get(this.key);
    }
}

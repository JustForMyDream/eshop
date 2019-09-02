package com.wyl.learn.test.design.interpreter;

import java.util.HashMap;

/**
 * @Author :wyl
 * @Date :2019/8/20 10:41
 * @Version 1.0 :
 * @Description :
 */
public class SubExpression  extends SymbolExpression {
    public SubExpression(Expression _left, Expression _right) {
        super(_left, _right);
    }
    //左右两个表达式相减
    public int interpreter(HashMap<String, Integer> var) {
        return super.left.interpreter(var) - super.right.interpreter(var);
    }
}

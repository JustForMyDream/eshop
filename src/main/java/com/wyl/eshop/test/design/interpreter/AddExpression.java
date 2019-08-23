package com.wyl.eshop.test.design.interpreter;

import java.util.HashMap;

/**
 * @Author :wyl
 * @Date :2019/8/20 10:38
 * @Version 1.0 :
 * @Description :
 */
public class AddExpression  extends SymbolExpression {
    public AddExpression(Expression _left, Expression _right) {
        super(_left, _right);
    }

    //把左右两个表达式运算的结果加起来
    public int interpreter(HashMap<String, Integer> var) {
        return super.left.interpreter(var) + super.right.interpreter(var);
    }
}

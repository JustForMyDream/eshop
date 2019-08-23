package com.wyl.eshop.test.design.medium;

/**
 * @Author :wyl
 * @Date :2019/8/20 10:00
 * @Version 1.0 :
 * @Description :
 */
public abstract class AbstractColleague {
    protected AbstractMediator mediator;
    public AbstractColleague(AbstractMediator _mediator){
        this.mediator = _mediator;
    }
}

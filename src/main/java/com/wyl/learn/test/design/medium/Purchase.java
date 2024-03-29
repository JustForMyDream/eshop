package com.wyl.learn.test.design.medium;

/**
 * @Author :wyl
 * @Date :2019/8/20 9:57
 * @Version 1.0 :
 * @Description :
 */
public class Purchase extends AbstractColleague {

    public Purchase(AbstractMediator _mediator) {
        super(_mediator);
    }

    //采购IBM型号的电脑
    public void buyIBMcomputer(int number){
        super.mediator.execute("purchase.buy", number);
    }
    //不在采购IBM电脑
    public void refuseBuyIBM(){
        System.out.println("不再采购IBM电脑");
    }
}

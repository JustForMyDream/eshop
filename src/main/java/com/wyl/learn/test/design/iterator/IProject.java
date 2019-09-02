package com.wyl.learn.test.design.iterator;

/**
 * @Author :wyl
 * @Date :2019/8/19 9:21
 * @Version 1.0 :
 * @Description :
 */
public interface IProject {
    //增加项目
    public void add(String name,int num,int cost);
    //从老板这里看到的就是项目信息
    public String getProjectInfo();
    //获得一个可以被遍历的对象
    public IProjectIterator iterator();
}

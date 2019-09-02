package com.wyl.learn.test.design.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author :wyl
 * @Date :2019/8/19 9:33
 * @Version 1.0 :
 * @Description :
 */
public class ProjectIterator implements IProjectIterator {

    //所有的项目都放在这里ArrayList中
    private List<IProject> projectList = new ArrayList<IProject>();
    private int currentItem = 0;

    //构造函数传入projectList
    public ProjectIterator(List<IProject> projectList){
        this.projectList = projectList;
    }

    @Override
    public boolean hasNext() {
        //定义一个返回值
        boolean b = true;
        if(this.currentItem>=projectList.size() ||
                this.projectList.get(this.currentItem) == null){
            b =false;
        }
        return b;
    }

    @Override
    public Object next() {
        return (IProject)this.projectList.get(this.currentItem++);
    }

    //删除一个对象
    public void remove() {
//暂时没有使用到
    }
}

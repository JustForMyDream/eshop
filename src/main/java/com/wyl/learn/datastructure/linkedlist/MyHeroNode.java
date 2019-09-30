package com.wyl.learn.datastructure.linkedlist;

/**
 * @Author :wyl
 * @Date :2019/9/16 14:28
 * @Version 1.0 :
 * @Description :
 */
public class MyHeroNode {
    public int no;
    public String name;
    public String nickName;
    public MyHeroNode next;

    public MyHeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "MyHeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}

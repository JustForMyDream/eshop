package com.wyl.learn.datastructure.linkedlist;

/**
 * @Author :wyl
 * @Date :2019/9/17 10:06
 * @Version 1.0 :
 * @Description :
 */
public class Josepfu {



    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.countBoy(1,2,5);
        circleSingleLinkedList.list();
    }
}

class CircleSingleLinkedList{
    private Boy first = null;

    /**
     * 增加小孩，构成环形单向链表
     * @param nums
     */
    public void addBoy(int nums){
        if(nums < 0){
            System.out.println("nums的值不正确");
            return;
        }

        Boy curBoy = null;
        for(int i = 1; i <= nums; i ++){
            Boy boy = new Boy(i);
            if(i == 1){
                first = boy;
                first.setNext(first);
                curBoy = boy;
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    public void list(){
        if(first == null){
            System.out.println("空");
            return;
        }

        Boy temp = first;
        while (true){
            System.out.printf("小孩编号%d",temp.getNo());
            if(temp.getNext() == first) {
                break;
            }
            temp = temp.getNext();
        }
    }

    public void countBoy(int startNo,int countNum,int nums){
        if(first == null || startNo < 1 || startNo > nums){
            System.out.println("输入参数有误，请重新输入");
            return;
        }

        Boy helper = first;
        while (true){
            if(helper.getNext() == first){
                break;
            }

            helper = helper.getNext();
        }
        for(int i = 0;i < startNo - 1 ;i ++){
            first = first.getNext();
            helper = helper.getNext();
        }

        while (true){
            if(helper == first){
                break;
            }
            for(int j = 0;j < countNum - 1;j ++){
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("出圈的小孩为%d",first.getNo());
            System.out.println();
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println();
        System.out.printf("最后留在圈中的小孩数%d",first.getNo());
    }
}

class Boy{
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
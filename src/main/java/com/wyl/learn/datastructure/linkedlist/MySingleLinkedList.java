package com.wyl.learn.datastructure.linkedlist;

/**
 * @Author :wyl
 * @Date :2019/9/16 14:29
 * @Version 1.0 :
 * @Description :
 */
public class MySingleLinkedList {
    private MyHeroNode head = new MyHeroNode(0,"","");



    public MyHeroNode getHead() {
        return head;
    }
    /**
     * 添加节点
     * @param heroNode
     */
    public void add(MyHeroNode heroNode){
        MyHeroNode temp = head;
        while (true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    /**
     * 通过顺序添加节点
     * @param heroNode
     */
    public void addByOrder(MyHeroNode heroNode){
        MyHeroNode temp = head;
        boolean flag = false;
        while (true){
            if(temp.next == null) {
                break; //
            }
            if(temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {

                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag) {
            System.out.printf("编号%d已经存在\n", heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    public void update(MyHeroNode heroNode){
        if(head.next == null){
            System.out.println("链表为空~");
            return;
        }
        MyHeroNode temp = head.next;
        boolean flag = false;
        while (true){
            if (temp == null) {
                break;
            }
            if(temp.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        }else {
            System.out.printf("没有找到编号为%d的节点", heroNode.no);
        }
    }

    public void del(int no){
        MyHeroNode temp = head;
        boolean flag = false;
        while (true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.next = temp.next.next;
        }else {
            System.out.printf("未找到%d节点",no);
        }
    }

    public void list(){
        if(head.next == null){
            System.out.println("链表为空");
        }
        MyHeroNode temp = head.next;
        while (true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }




}

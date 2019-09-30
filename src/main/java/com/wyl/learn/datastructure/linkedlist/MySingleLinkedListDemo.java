package com.wyl.learn.datastructure.linkedlist;

import java.util.Stack;

/**
 * @Author :wyl
 * @Date :2019/9/16 14:26
 * @Version 1.0 :
 * @Description :
 */
public class MySingleLinkedListDemo {

    public static void main(String[] args) {
        MySingleLinkedList list = new MySingleLinkedList();
        list.add(new MyHeroNode(1,"aa","aa"));
        list.add(new MyHeroNode(2,"bb","bb"));
        list.add(new MyHeroNode(3,"cc","cc"));
        list.add(new MyHeroNode(4,"dd","dd"));
        list.list();
        resersetList(list.getHead());
        System.out.println();
        list.list();
    }


    public static void reversePrint(MyHeroNode head) {
        if(head.next == null) {
            return;
        }
        Stack<MyHeroNode> stack = new Stack<MyHeroNode>();
        MyHeroNode cur = head.next;

        while(cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    public static void resersetList(MyHeroNode head){
        if(head.next == null || head.next.next == null){
            return;
        }
        MyHeroNode cur = head.next;
        MyHeroNode next = null;
        MyHeroNode reverseHead = new MyHeroNode(0, "", "");
        while(cur != null) {
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }

    public static MyHeroNode findLastIndexNode(MyHeroNode head,int index){
        if(head.next == null) {
            return null;
        }
        int size = getLength(head);
        if(index <= 0 || index > size ){
            return null;
        }
        MyHeroNode cur = head.next;
        for(int i = 0;i < size - index; i ++){
            cur = cur.next;
        }
        return cur;
    }

    public static int getLength(MyHeroNode head){
        if(head.next == null){
            return 0;
        }
        int length = 0;
        MyHeroNode cur = head.next;
        while(cur != null) {
            length++;
            cur = cur.next; //
        }
        return length;
    }
}



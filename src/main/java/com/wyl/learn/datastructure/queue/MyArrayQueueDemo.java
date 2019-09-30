package com.wyl.learn.datastructure.queue;

import java.util.Scanner;

/**
 * @Author :wyl
 * @Date :2019/9/16 11:34
 * @Version 1.0 :
 * @Description :
 */
public class MyArrayQueueDemo {

    public static void main(String[] args) {
        MyArrayQueue queue = new MyArrayQueue(3);
        char key = ' '; //�����û�����
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        //���һ���˵�
        while (loop) {
            System.out.println("s(show): ��ʾ����");
            System.out.println("e(exit): �˳�����");
            System.out.println("a(add): ������ݵ�����");
            System.out.println("g(get): �Ӷ���ȡ������");
            System.out.println("h(head): �鿴����ͷ������");
            key = scanner.next().charAt(0);//����һ���ַ�
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("���һ����");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g': //ȡ������
                    try {
                        int res = queue.getQueue();
                        System.out.printf("ȡ����������%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //�鿴����ͷ������
                    try {
                        int res = queue.headQueue();
                        System.out.printf("����ͷ��������%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': //�˳�
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("�����˳�~~");
    }
}

class MyArrayQueue{
        private int maxSize;
        private int rear;
        private int front;
        private int []arr;

        public MyArrayQueue(int maxSize){
            this.maxSize  = maxSize;
            rear = -1;
            front = -1;
            arr = new int[maxSize];
        }

        public boolean isEmpty(){
            return rear == front;
        }

        public boolean isFull(){
            return rear == maxSize - 1;
        }

        public void addQueue(int num){
            if(isFull()){
                System.out.println("队列满");
                return;
            }
            arr[++rear] = num;
        }

        public int getQueue(){
            if(isEmpty()){
                throw new RuntimeException("队列空");
            }
            front ++;
            return arr[front];
        }

        public void showQueue(){
            if(isEmpty()){
                System.out.println("队列空");
                return;
            }

            for(int i = 0;i < arr.length;i ++){
                System.out.printf("arr[%d]=%d\n", i, arr[i]);
            }

        }

        public int headQueue(){
            if (isEmpty()) {
                throw new RuntimeException("队列空");
            }
            return arr[front + 1];
        }

}


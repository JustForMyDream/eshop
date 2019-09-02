package com.wyl.learn.thread.chapter73;

/**
 * @Author :wyl
 * @Date :2019/9/2 15:36
 * @Version 1.0 :
 * @Description :
 */
public class MyThread extends Thread {
    private Object lock;
    private String showChar;
    private int showNumberPosition;
    private int printCount = 0;
    volatile private static int addNumber = 1;

    public static void main(String[] args) {
        String ids = "1,23,344";
        StringBuilder sb = new StringBuilder("delete from GM_RightSetting where orgId = ? and type = ? and hrmId in (");
        String []arrId = ids.split(",");
        for (int i = 0;i < arrId.length;i ++){
            sb.append("?,");
        }
        sb.replace(sb.length()-1,sb.length(),")");
        System.out.println(sb.toString());
    }
}

package com.wyl.learn.thread.chapter511;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author :wyl
 * @Date :2019/9/2 13:15
 * @Version 1.0 :
 * @Description :
 */
public class Run1 {
    private static Timer timer = new Timer();

    static public class MyTask extends TimerTask{
        public void run(){
            System.out.println("运行了！时间为："+new Date());
        }
    }

    public static void main(String[] args) throws Exception {
        MyTask myTask = new MyTask();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = "2019-09-02 13:58:00";
        Date dateRef = sdf.parse(dateString);
        System.out.println("字符穿时间："+ dateRef.toLocaleString() + " 当前时间："+new Date().toLocaleString());
        timer.schedule(myTask,dateRef,1000);
    }
}

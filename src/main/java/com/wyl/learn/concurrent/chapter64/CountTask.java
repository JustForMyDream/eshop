package com.wyl.learn.concurrent.chapter64;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @Author :wyl
 * @Date :2019/9/11 17:54
 * @Version 1.0 :
 * @Description :
 */
public class CountTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 100; //阈值
    private int start;
    private int end;
    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        boolean canCompute = (end - start) <= THRESHOLD;
        if(canCompute){
            for(int i = start;i <= end;i ++){
                sum += i;
            }
        }else {
            int middle = (start + end) / 2;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle + 1, end);
            leftTask.fork();
            rightTask.fork();
            int leftResult=leftTask.join();
            int rightResult=rightTask.join();

            sum = leftResult + rightResult;
        }

        return sum;
    }

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask task = new CountTask(1, 10000000);
        Future<Integer> result = forkJoinPool.submit(task);
        System.out.println(result.get());
        long end =  System.currentTimeMillis();
        System.out.println("1:"+(end-start));

        long start2 = System.currentTimeMillis();

        int sum = 0;
        for (int i = 1;i <= 10000000;i ++){
            sum += i;
        }
        System.out.println(sum);
        long end2 =  System.currentTimeMillis();
        System.out.println("2:"+(end2-start2));
    }
}

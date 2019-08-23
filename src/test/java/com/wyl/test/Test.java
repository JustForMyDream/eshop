package com.wyl.test;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

/**
 * @Author :wyl
 * @Date :2019/8/9 17:16
 * @Version 1.0 :
 * @Description :
 */
public class Test {
    @org.junit.Test
    public void test(){
        BufferedInputStream in = FileUtil.getInputStream("D:\\work\\wylwork\\eshop\\1.txt");
        BufferedOutputStream out = FileUtil.getOutputStream("D:\\work\\wylwork\\eshop\\test2.txt");

        long copySize = IoUtil.copy(in, out, IoUtil.DEFAULT_BUFFER_SIZE);
        System.out.println(copySize);
    }
}

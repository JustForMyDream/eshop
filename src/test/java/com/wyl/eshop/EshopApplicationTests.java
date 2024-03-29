package com.wyl.eshop;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EshopApplicationTests {

    @Test
    public void contextLoads() {
        BufferedInputStream in = FileUtil.getInputStream("D:\\work\\wylwork\\eshop\\1.txt");
        BufferedOutputStream out = FileUtil.getOutputStream("D:\\work\\wylwork\\eshop\\test2.txt");

        long copySize = IoUtil.copy(in, out, IoUtil.DEFAULT_BUFFER_SIZE);
        System.out.println(copySize);
    }

}

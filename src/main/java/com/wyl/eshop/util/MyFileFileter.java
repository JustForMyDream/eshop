package com.wyl.eshop.util;

import java.io.File;
import java.io.FileFilter;

/**
 * @Author :wyl
 * @Date :2019/8/7 16:38
 * @Version 1.0 :
 * @Description :
 */
public class MyFileFileter implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        if(pathname.isDirectory()){
            return true;
        }
        return false;
    }
}

package com.wyl.eshop.bean;

import java.io.Serializable;

/**
 * @Author :wyl
 * @Date :2019/8/23 10:00
 * @Version 1.0 :
 * @Description :
 */
public class DepartMent implements Serializable {

    private Integer id;

    private String departName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }
}

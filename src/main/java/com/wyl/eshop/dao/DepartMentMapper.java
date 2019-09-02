package com.wyl.eshop.dao;

import com.wyl.eshop.bean.DepartMent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @Author :wyl
 * @Date :2019/8/23 10:02
 * @Version 1.0 :
 * @Description :
 */
@Mapper
@Component
public interface DepartMentMapper {

    @Select("SELECT * FROM department where id = #{id} ")
    DepartMent getDept(int id);
}

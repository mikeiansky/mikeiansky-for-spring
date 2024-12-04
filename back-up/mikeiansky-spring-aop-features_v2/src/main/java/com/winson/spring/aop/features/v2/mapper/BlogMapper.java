package com.winson.spring.aop.features.v2.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

/**
 * @author winson
 * @date 2022/4/20
 **/
@Mapper
//@Component
public interface BlogMapper {

    @Select("select * from `course`")
    void selectOne();

    @Update("update `course` set cname ='winson-0009' where cid = 6")
    void updateOne();

}

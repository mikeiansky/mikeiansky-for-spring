package com.winson.spring.aop.features.v2.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author winson
 * @date 2022/4/20
 **/
public interface BlogMapper {

    @Select("select * from `sensitive`")
    void selectOne();

    @Update("update `sensitive` set content ='winson-0006' where id = 10000000")
    void updateOne();

}

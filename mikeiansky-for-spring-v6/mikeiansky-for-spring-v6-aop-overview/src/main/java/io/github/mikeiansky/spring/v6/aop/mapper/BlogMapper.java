package io.github.mikeiansky.spring.v6.aop.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author winson
 * @date 2022/4/20
 **/
@Mapper
//@Component
public interface BlogMapper {

    @Select("select * from `user` limit 1")
    void selectOne();

    @Update("update `user` set status = 1 where id = 4")
    void updateOne();

}

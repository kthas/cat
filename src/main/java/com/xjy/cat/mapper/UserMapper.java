package com.xjy.cat.mapper;


import com.xjy.cat.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {

    /**
     * 存入用户
     * @param user
     */
    void saveUser(User user);

    @Select("SELECT id, username, nickname, createTime, lastLoginTime WHERE BINARY username = #{username} AND password = #{password}")
    User findByUsernameAndPassword(@Param("username")String username, @Param("password")String password);

    @Select("SELECT id, username, nickname, createTime, lastLoginTime WHERE BINARY username = #{username}")
    User findByUsername(@Param("username")String username);

    User findById(@Param("id") int id);
}

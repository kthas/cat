package com.xjy.cat.mapper;


import com.xjy.cat.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {

    /**
     * 存入用户
     * @param user
     */
    void saveUser(User user);
}

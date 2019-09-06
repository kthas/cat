package com.xjy.cat.service;

import com.xjy.cat.intf.UserService;
import com.xjy.cat.mapper.UserMapper;
import com.xjy.cat.model.User;
import org.apache.tomcat.util.buf.UEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    public User findByUsernameAndPassword(String username, String password) {
        return userMapper.findByUsernameAndPassword(username, password);
    }

    public void saveUser(User user){
        userMapper.saveUser(user);
    }

    public void saveAvatar(String avatar,Integer id){
        userMapper.saveAvatar(avatar,id);
    }

}

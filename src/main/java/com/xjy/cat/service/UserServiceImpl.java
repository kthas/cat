package com.xjy.cat.service;

import com.xjy.cat.intf.UserService;
import com.xjy.cat.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private User user = new User();

    @Override
    public User findByUsername(String username) {
        return user;
    }
}

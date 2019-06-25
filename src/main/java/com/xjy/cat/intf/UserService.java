package com.xjy.cat.intf;

import com.xjy.cat.model.User;

public interface UserService {

    User findByUsername(String username);

    void saveUser(User user);
}

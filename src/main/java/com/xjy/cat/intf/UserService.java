package com.xjy.cat.intf;

import com.xjy.cat.model.User;

public interface UserService {

    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);

    void saveUser(User user);

}

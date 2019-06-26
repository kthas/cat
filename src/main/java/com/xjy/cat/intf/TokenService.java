package com.xjy.cat.intf;

import com.xjy.cat.model.User;

public interface TokenService {

    User check(String token);

    void addToken(String accessToken, int userId);

    void delete(int id);

}

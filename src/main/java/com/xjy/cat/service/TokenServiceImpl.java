package com.xjy.cat.service;

import com.xjy.cat.intf.TokenService;
import com.xjy.cat.mapper.TokenMapper;
import com.xjy.cat.mapper.UserMapper;
import com.xjy.cat.model.Token;
import com.xjy.cat.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class TokenServiceImpl implements TokenService {

    @Resource(type = TokenMapper.class)
    private TokenMapper tokenMapper;

    @Resource(type = UserMapper.class)
    private UserMapper userMapper;

    @Override
    public User check(String accessToken) {
        Token token = tokenMapper.getByToken(accessToken);
        if(token != null) {
            if(System.currentTimeMillis() - token.getCreateTime().getTime() > 604800000) {//ACCESS_TOKEN已经过期
                delete(token.getId());
                return null;
            }
            return userMapper.findById(token.getUserId());
        } else return null;
    }

    public void addToken(String accessToken, int userId) {
        Token token = new Token();
        token.setAccessToken(accessToken);
        token.setUserId(userId);
        token.setCreateTime(new Date());
        tokenMapper.insert(token);
    }

    @Override
    public void delete(int id) {
        tokenMapper.delete(id);
    }
}

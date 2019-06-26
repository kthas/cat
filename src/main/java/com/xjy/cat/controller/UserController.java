package com.xjy.cat.controller;

import com.xjy.cat.DO.LoginDO;
import com.xjy.cat.DO.ResponseDO;
import com.xjy.cat.intf.TokenService;
import com.xjy.cat.intf.UserService;
import com.xjy.cat.kits.AccessTokenKit;
import com.xjy.cat.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Resource(type = UserService.class)
    private UserService userService;

    @Resource(type = TokenService.class)
    private TokenService tokenService;

    @RequestMapping("/login")
    public ResponseDO login(String username, String password) {
        if(username == null || username.isEmpty()) {
            return build(false, "用户名不能为空");
        }
        if(password == null || password.isEmpty()) {
            return build(false, "密码不能为空");
        }
        User user = userService.findByUsernameAndPassword(username, password);
        if(user != null) {
            LoginDO loginDO = AccessTokenKit.getToken();
            tokenService.addToken(loginDO.getAccessToken(), user.getId());
            return build(true, "登陆成功", loginDO);
        }
        return build(false, "用户名或密码错误");
    }

    @RequestMapping("/user/info")
    public ResponseDO info(String token) {
        User user = tokenService.check(token);
        if(user != null) {
            return build(true, "", user);
        } return build(false, "你的ACCESS_TOKEN错误");
    }

    @RequestMapping("/register")
    public ResponseDO register(User user){
        userService.saveUser(user);
        return build(true,"注册成功");
    }

}

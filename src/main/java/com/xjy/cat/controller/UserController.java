package com.xjy.cat.controller;

import com.xjy.cat.DO.ResponseDO;
import com.xjy.cat.intf.UserService;
import com.xjy.cat.kits.AccessTokenKit;
import com.xjy.cat.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController extends BaseController {

    @Resource(type = UserService.class)
    private UserService userService;

    @RequestMapping("/login")
    public ResponseDO login(String username, String password) {
        if(username == null || username.isEmpty()) {
            return build(false, "用户名不能为空");
        }
        if(password == null || password.isEmpty()) {
            return build(false, "密码不能为空");
        }
        User user = userService.findByUsername(username);
        if(user != null) {
            return build(true, "登陆成功", AccessTokenKit.getToken());
        }
        return build(false, "用户名或密码错误");
    }

}

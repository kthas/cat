package com.xjy.cat.controller;


import com.xjy.cat.DO.ResponseDO;
import com.xjy.cat.intf.TokenService;
import com.xjy.cat.intf.UserService;
import com.xjy.cat.kits.SHAKit;
import com.xjy.cat.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Resource(type = UserService.class)
    private UserService userService;

    @Resource(type = TokenService.class)
    private TokenService tokenService;

    private SHAKit shaKit = new SHAKit();
    @RequestMapping("/login")
    public ResponseDO login(String username, String password,HttpServletRequest request) {
        //shiro用户认证
        //获取subject
        Subject subject = SecurityUtils.getSubject();
        password = shaKit.SHA(username+password);
        UsernamePasswordToken userToken = new UsernamePasswordToken(username,password);
        if(username==null||username.isEmpty()){
            return build(false, "用户名不能为空");
        }
        if(password==null||password.isEmpty()){
            return build(false, "密码不能为空");
        }
        try {
            User user = userService.findByUsernameAndPassword(username, password);
            subject.login(userToken);
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            user.setPassword("invisible");
            return build(true, "登陆成功",user);
        }catch (UnknownAccountException | IncorrectCredentialsException e) {
            return build(false, "用户名或密码错误");
        }
    }

    @RequestMapping("/getUserMsg")
    public ResponseDO getUserMsg(HttpSession session){
        User user = (User)session.getAttribute("user");
        return build(true,"获取成功",user);
    }

    @RequestMapping("/register")
    public ResponseDO register(User user){
        //密码加密
        user.setPassword(shaKit.SHA(user.getUsername()+user.getPassword()));
        user.setCreateTime(new Date());
        user.setLastLoginTime(new Date());
        user.setPermission("admin");
        user.setAvatar("img/avatar.jpg");
        userService.saveUser(user);
        return build(true,"注册成功");
    }

}

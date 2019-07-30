package com.xjy.cat.shiro;

import com.xjy.cat.intf.UserService;
import com.xjy.cat.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import javax.annotation.Resource;

public class UserRealm extends AuthorizingRealm {

    @Resource(name="userServiceImpl")
    private UserService userService;
    //执行授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
        // TODO Auto-generated method stub
        System.out.println("授权");
        //获取当前登录用户
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        //给资源授权
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermission(user.getPermission());
        return simpleAuthorizationInfo;
    }
    //执行认证逻辑
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
        // TODO Auto-generated method stub
        //shiro判断逻辑
        UsernamePasswordToken user = (UsernamePasswordToken) arg0;
        System.out.println("认证用户:"+user.getUsername());
        User newUser = userService.findByUsernameAndPassword(user.getUsername(),String.copyValueOf(user.getPassword()));
        if(newUser == null){
            //用户名错误
            //shiro会抛出UnknownAccountException异常
            return null;
        }
        return new SimpleAuthenticationInfo(newUser,newUser.getPassword(),"");
    }


}
package com.xjy.cat.controller;


import com.xjy.cat.DO.ResponseDO;
import com.xjy.cat.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @RequestMapping("/getUserMsg")
    public ResponseDO getUserMsg(HttpSession session){
        if(session.getAttribute("user")!=null){
            User user = (User)session.getAttribute("user");
            return build(true,"获取成功",user);
        }else{
            return build(false,"用户已退出",null);
        }
    }


    @RequestMapping("/userInfo")
    public ModelAndView userInfo(HttpSession session){
        return html("user_info/userInfo");
    }

    @RequestMapping("/editUser")
    public ModelAndView editUser(){
        return html("user_iframe/edit_user");
    }

    @RequestMapping("/myInvitation")
    public ModelAndView myInvitation(){
        return html("user_info/myInvitation");
    }

    @RequestMapping("/invitation")
    public ModelAndView invitation(){
        return html("user_iframe/invitation");
    }

    @RequestMapping("/myCollection")
    public ModelAndView myCollection(){
        return html("user_info/myCollection");
    }

    @RequestMapping("/collection")
    public ModelAndView collection(){
        return html("user_iframe/collection");
    }

    @RequestMapping("/myHistoryInvitation")
    public ModelAndView myHistoryInvitation(){
        return html("user_info/myHistoryInvitation");
    }


    @RequestMapping("/history")
    public ModelAndView historyInvitation(){
        return html("user_iframe/historyInvitation");
    }

}

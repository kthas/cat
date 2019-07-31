package com.xjy.cat.controller;

import com.xjy.cat.model.User;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class PageController extends BaseController {

    @RequestMapping("/hello")
    public ModelAndView hello(){
        return html("hello");
    }

    @RequestMapping("/login")
    public ModelAndView login(){
        return html("login");
    }


    @RequestMapping("/index")
    public ModelAndView index(){
        return html("index");
    }


    @RequestMapping("/permission")
    public ModelAndView permission(){
        return html("permission");
    }

    @RequestMapping("/one")
    public ModelAndView one(){
        return html("one");
    }

    @RequestMapping("/two")
    public ModelAndView two(){
        return html("two");
    }


}

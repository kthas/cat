package com.xjy.cat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController extends BaseController {

    @RequestMapping("/hello")
    public ModelAndView hello(){
        return html("hello");
    }

    @RequestMapping("/main")
    public ModelAndView mainPage(){
        System.out.println(1111);
        return html("main");
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

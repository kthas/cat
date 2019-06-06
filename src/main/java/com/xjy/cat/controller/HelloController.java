package com.xjy.cat.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {


    @RequestMapping("/hello")
    public ModelAndView hello(){
        ModelAndView mv  = new ModelAndView("hello");
        mv.addObject("name","thymeleaf");
        return mv;
    }

    @RequestMapping("/main")
    public ModelAndView mainPage(){
        ModelAndView mv =new ModelAndView("main");
        return mv;
    }
}

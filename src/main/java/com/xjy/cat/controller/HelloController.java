package com.xjy.cat.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController extends BaseController{


    @RequestMapping("/hello")
    public ModelAndView hello(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","thymeleaf");
        return html("hello",map);
    }

    @RequestMapping("/main")
    public ModelAndView mainPage(){
        return html("main");
    }
}

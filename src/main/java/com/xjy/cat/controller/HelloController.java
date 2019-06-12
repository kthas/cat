package com.xjy.cat.controller;

import com.xjy.cat.DO.ResponseDO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloController extends BaseController{

    @RequestMapping("/hello")
    public ResponseDO hello(){
        return build(true, "Hello", System.currentTimeMillis());
    }

    @RequestMapping("/main")
    public ModelAndView mainPage(){
        return html("main");
    }
}

package com.xjy.cat.controller;

import com.xjy.cat.DO.ResponseDO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController extends BaseController {

    @RequestMapping("/hello")
    @ResponseBody
    public ResponseDO hello(){
        return build(true, "Hello", System.currentTimeMillis());
    }

    @RequestMapping("/main")
    public ModelAndView mainPage(){
        return html("main");
    }

}

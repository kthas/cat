package com.xjy.cat.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

public class BaseController {

    public ModelAndView html(String path, Map<String,Object> map){
        return new ModelAndView(path,map);
    }

    public ModelAndView html(String path){
        return new ModelAndView(path);
    }
}

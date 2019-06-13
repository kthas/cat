package com.xjy.cat.controller;

import com.xjy.cat.DO.ResponseDO;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

public abstract class BaseController {

    public ModelAndView html(String path, Map<String,Object> map){
        return new ModelAndView(path,map);
    }

    public ModelAndView html(String path){
        return new ModelAndView(path);
    }

    public ResponseDO build(boolean success) {
        return new ResponseDO().setSuccess(success);
    }

    public ResponseDO build(boolean success, String msg) {
        return new ResponseDO().setSuccess(success).setMsg(msg);
    }

    public ResponseDO build(boolean success, String msg, Object data) {
        return new ResponseDO().setSuccess(success).setMsg(msg).setData(data);
    }

}

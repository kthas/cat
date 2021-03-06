package com.xjy.cat.controller;


import com.xjy.cat.DO.ResponseDO;
import com.xjy.cat.intf.UserService;
import com.xjy.cat.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/user")
@PropertySource("classpath:constant.properties")
public class UserController extends BaseController {

    @Value("${properties.uploadPath}")
    private String uploadPath;

    @Resource
    private UserService userService;

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


    /**
     * 头像修改控制类
     * @param file
     * @param session
     * @return
     */
    @RequestMapping("/changeAvatar")
    public ResponseDO changeAvatar(@RequestParam("file") MultipartFile file,HttpSession session){
        String prefixPath = "/images/avatar/";
        if(session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            SimpleDateFormat df = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
            String time = df.format(new Date());
            String fileName = "avatar"+"_"+user.getUsername()+"_"+time+".jpeg";
            File avatarDir = new File(uploadPath+File.separator+"avatar");
            File avatar = new File(uploadPath+File.separator+"avatar"+File.separator+fileName);
            if(!avatarDir.exists()){
                avatarDir.mkdirs();
            }
            if(avatar.exists()){
                avatar.delete();
            }else{
                try {
                    file.transferTo(avatar);
                    //存入头像
                    userService.saveAvatar(prefixPath+fileName,user.getId());
                    user.setAvatar(prefixPath+fileName);
                    //存入完成后刷新session
                    session.setAttribute("user",user);
                }catch (IOException e){
                    System.out.println("发生未知错误，头像上传失败");
                    return build(false,"修改失败");
                }
            }
            return build(true, "修改成功", null);
        }else{
            return null;
        }
    }
}

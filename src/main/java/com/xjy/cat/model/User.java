package com.xjy.cat.model;

import java.util.Date;

public class User {
    private int id;
    //用户名
    private String username;
    //用户密码
    private String password;
    //昵称
    private  String nickname;
    private Date createTime;
    private Date lastLoginTime;

    @Override
    public String toString() {
        return "User [" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", createTime=" + createTime +
                ", lastLoginTime=" + lastLoginTime +
                ']';
    }

    public User setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public User setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}

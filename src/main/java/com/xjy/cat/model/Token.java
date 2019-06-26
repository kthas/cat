package com.xjy.cat.model;

import java.util.Date;

public class Token {

    private int id;
    private String accessToken;
    private int userId;
    private Date createTime;

    @Override
    public String toString() {
        return "Token [" +
                "id=" + id +
                ", accessToken='" + accessToken + '\'' +
                ", userId=" + userId +
                ", createTime=" + createTime +
                ']';
    }

    public Token setId(int id) {
        this.id = id;
        return this;
    }

    public Token setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public Token setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public Token setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public int getUserId() {
        return userId;
    }

    public Date getCreateTime() {
        return createTime;
    }
}

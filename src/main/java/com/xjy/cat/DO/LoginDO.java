package com.xjy.cat.DO;

import java.util.Date;

public class LoginDO {

    private String access_token;

    private int random_id;

    private long date;

    public String getAccess_token() {
        return access_token;
    }

    public int getRandom_id() {
        return random_id;
    }

    public long getDate() {
        return date;
    }

    public LoginDO setAccess_token(String access_token) {
        this.access_token = access_token;
        return this;
    }

    public LoginDO setRandom_id(int random_id) {
        this.random_id = random_id;
        return this;
    }

    public LoginDO setDate(long date) {
        this.date = date;
        return this;
    }

    @Override
    public String toString() {
        return "LoginDO [" +
                "access_token='" + access_token + '\'' +
                ", random_id=" + random_id +
                ", date=" + date +
                ']';
    }
}

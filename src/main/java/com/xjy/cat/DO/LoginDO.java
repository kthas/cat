package com.xjy.cat.DO;

public class LoginDO {

    private String accessToken;

    private int randomId;

    private long date;

    public String getAccessToken() {
        return accessToken;
    }

    public int getRandomId() {
        return randomId;
    }

    public long getDate() {
        return date;
    }

    public LoginDO setAccessToken(String access_token) {
        this.accessToken = access_token;
        return this;
    }

    public LoginDO setRandomId(int random_id) {
        this.randomId = random_id;
        return this;
    }

    public LoginDO setDate(long date) {
        this.date = date;
        return this;
    }

    @Override
    public String toString() {
        return "LoginDO [" +
                "access_token='" + accessToken + '\'' +
                ", random_id=" + randomId +
                ", date=" + date +
                ']';
    }
}

package com.xjy.cat.DO;

public class ResponseDO {

    boolean success;

    String msg;

    Object data;

    public boolean isSuccess() {
        return success;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public ResponseDO setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public ResponseDO setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public ResponseDO setData(Object data) {
        this.data = data;
        return this;
    }


    @Override
    public String toString() {
        return "ResponseDO [" +
                "success=" + success +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ']';
    }
}

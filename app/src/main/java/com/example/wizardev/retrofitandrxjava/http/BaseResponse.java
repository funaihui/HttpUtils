package com.example.wizardev.retrofitandrxjava.http;

/**
 * author : wizardev
 * e-mail : wizarddev@163.com
 * time   : 2017/08/18
 * desc   :
 * version: 1.0
 */
public class BaseResponse<T> {
    private int code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    public boolean isSuccess(){
        if (getCode() == 100) {
            return true;
        }
        return false;
    }
}

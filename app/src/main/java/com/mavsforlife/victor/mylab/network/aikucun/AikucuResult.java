package com.mavsforlife.victor.mylab.network.aikucun;

/**
 * Created by victor on 2017/11/22.
 * Email: wwmdirk@gmail.com
 */

public class AikucuResult<T> {

    private String status;
    private T data;
    private int code;
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

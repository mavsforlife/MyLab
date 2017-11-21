package com.mavsforlife.victor.mylab.network;

/**
 * Created by victor on 2017/11/20.
 * Email: wwmdirk@gmail.com
 */

public class ApiException extends RuntimeException {
    private boolean error;
    private String msg;

    public ApiException(boolean error, String msg) {
        super(msg);
        this.error = error;
        this.msg = msg;
    }

    public boolean isError() {
        return error;
    }

    public String getMsg() {
        return msg;
    }
}

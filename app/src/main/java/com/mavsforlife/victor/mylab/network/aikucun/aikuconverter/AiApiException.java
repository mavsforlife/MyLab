package com.mavsforlife.victor.mylab.network.aikucun.aikuconverter;

/**
 * Created by victor on 2017/11/20.
 * Email: wwmdirk@gmail.com
 */

public class AiApiException extends RuntimeException {
    private int code;
    private String msg;

    public AiApiException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

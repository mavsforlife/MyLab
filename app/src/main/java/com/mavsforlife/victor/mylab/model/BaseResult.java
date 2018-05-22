package com.mavsforlife.victor.mylab.model;

import android.support.annotation.Keep;

/**
 * Created by victor on 2017/11/20.
 * Email: wwmdirk@gmail.com
 */
@Keep
public class BaseResult<T> {
    private boolean error;
    private String msg;
    private T results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}

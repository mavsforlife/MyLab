package com.mavsforlife.victor.mylab.network.aikucun.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by victor on 2017/11/22.
 * Email: wwmdirk@gmail.com
 */
public class LiveinfoBean {
    /**
     * begin : 2017-11-19 09:00:00
     * begintimestamp : 1511053200
     * buymodel : 0
     * comments : []
     * content :
     * corpid :
     * end : 2017-11-25 00:00:00
     * endtimestamp : 1511539200
     * liveid :
     * num : 0
     * pinpai :
     * pinpaiid :
     * pinpaiming :
     * pinpaiurl :
     * productcount : 0
     * skucount : 0
     * taskend :
     * taskendtimestamp : 0
     * today :
     * yugaoneirong :
     * yugaotupian :
     */

    private String begin;
    private int begintimestamp;
    private int buymodel;
    private String content;
    private String corpid;
    private String end;
    private int endtimestamp;
    private String liveid;
    private int num;
    private String pinpai;
    private String pinpaiid;
    private String pinpaiming;
    private String pinpaiurl;
    private int productcount;
    private int skucount;
    private String taskend;
    private int taskendtimestamp;
    private String today;
    private String yugaoneirong;
    private String yugaotupian;
    private List<?> comments;

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public int getBegintimestamp() {
        return begintimestamp;
    }

    public void setBegintimestamp(int begintimestamp) {
        this.begintimestamp = begintimestamp;
    }

    public int getBuymodel() {
        return buymodel;
    }

    public void setBuymodel(int buymodel) {
        this.buymodel = buymodel;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCorpid() {
        return corpid;
    }

    public void setCorpid(String corpid) {
        this.corpid = corpid;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getEndtimestamp() {
        return endtimestamp;
    }

    public void setEndtimestamp(int endtimestamp) {
        this.endtimestamp = endtimestamp;
    }

    public String getLiveid() {
        return liveid;
    }

    public void setLiveid(String liveid) {
        this.liveid = liveid;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getPinpai() {
        return pinpai;
    }

    public void setPinpai(String pinpai) {
        this.pinpai = pinpai;
    }

    public String getPinpaiid() {
        return pinpaiid;
    }

    public void setPinpaiid(String pinpaiid) {
        this.pinpaiid = pinpaiid;
    }

    public String getPinpaiming() {
        return pinpaiming;
    }

    public void setPinpaiming(String pinpaiming) {
        this.pinpaiming = pinpaiming;
    }

    public String getPinpaiurl() {
        return pinpaiurl;
    }

    public void setPinpaiurl(String pinpaiurl) {
        this.pinpaiurl = pinpaiurl;
    }

    public int getProductcount() {
        return productcount;
    }

    public void setProductcount(int productcount) {
        this.productcount = productcount;
    }

    public int getSkucount() {
        return skucount;
    }

    public void setSkucount(int skucount) {
        this.skucount = skucount;
    }

    public String getTaskend() {
        return taskend;
    }

    public void setTaskend(String taskend) {
        this.taskend = taskend;
    }

    public int getTaskendtimestamp() {
        return taskendtimestamp;
    }

    public void setTaskendtimestamp(int taskendtimestamp) {
        this.taskendtimestamp = taskendtimestamp;
    }

    public String getToday() {
        return today;
    }

    public void setToday(String today) {
        this.today = today;
    }

    public String getYugaoneirong() {
        return yugaoneirong;
    }

    public void setYugaoneirong(String yugaoneirong) {
        this.yugaoneirong = yugaoneirong;
    }

    public String getYugaotupian() {
        return yugaotupian;
    }

    public void setYugaotupian(String yugaotupian) {
        this.yugaotupian = yugaotupian;
    }

    public List<?> getComments() {
        return comments;
    }

    public void setComments(List<?> comments) {
        this.comments = comments;
    }
}

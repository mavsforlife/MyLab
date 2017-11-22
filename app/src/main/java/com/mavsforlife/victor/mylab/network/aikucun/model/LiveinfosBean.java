package com.mavsforlife.victor.mylab.network.aikucun.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by victor on 2017/11/22.
 * Email: wwmdirk@gmail.com
 */
public class LiveinfosBean {
    /**
     * begin : 2017-11-19 09:00:00
     * begintimestamp : 1511053200
     * buymodel : 0
     * comments : []
     * content : 11月20日（周一）: 拉夏旗下PA&LA女装  巴布豆17新品童鞋  17新品布维斯包包 柠檬宝宝婴童用品
     * 11月21日（周二）: GOZO女装  中赛集团贝贝王国童装  Dzone芙儿优宝宝枕  hugmil婴童用品  Cozysteps鞋  贝丽馨动物面膜
     * 11月22日（周三）: 绿波15/16年男女装  兽王男女皮鞋  森马集团16/17年迷你巴拉巴拉  尤里卡打底裤
     * 11月23日（周四）: 帝高羊绒  stride rite喜健步童鞋  利丰集团Jessica  莱夫双肩/斜跨包
     * 11月24日（周五）: 海贝女装  CROCS鞋  韩国moimoi童装
     * 11月25日（周六）: 佳人苑15/16年女装  稻草人男装  卡赛欧童装  宝娜斯内衣
     * 11月26日（周日）: 俞兆林婴童配件  双星运动休闲鞋  雅鹿羊毛裤
     * corpid : 8a9f95f55ce9851a015cecd977b006b3
     * end : 2017-11-25 00:00:00
     * endtimestamp : 1511539200
     * liveid : 8a9f95f55fc0dba8015fcfc40f923813
     * num : 0
     * pinpai : 8a9f95f55f0c23ad015f1a5ca4877797
     * pinpaiid : 8a9f95f55f0c23ad015f1a5ca4877797
     * pinpaiming : 本周预告
     * pinpaiurl : http://picture.akucun.com/logo/akucun.jpg
     * productcount : 0
     * skucount : 0
     * taskend :
     * taskendtimestamp : 0
     * today :
     * yugaoneirong : 11月20日（周一）: 拉夏旗下PA&LA女装  巴布豆17新品童鞋  17新品布维斯包包 柠檬宝宝婴童用品
     * 11月21日（周二）: GOZO女装  中赛集团贝贝王国童装  Dzone芙儿优宝宝枕  hugmil婴童用品  Cozysteps鞋  贝丽馨动物面膜
     * 11月22日（周三）: 绿波15/16年男女装  兽王男女皮鞋  森马集团16/17年迷你巴拉巴拉  尤里卡打底裤
     * 11月23日（周四）: 帝高羊绒  stride rite喜健步童鞋  利丰集团Jessica  莱夫双肩/斜跨包
     * 11月24日（周五）: 海贝女装  CROCS鞋  韩国moimoi童装
     * 11月25日（周六）: 佳人苑15/16年女装  稻草人男装  卡赛欧童装  宝娜斯内衣
     * 11月26日（周日）: 俞兆林婴童配件  双星运动休闲鞋  雅鹿羊毛裤
     * yugaotupian : http://picture.akucun.com/logo/BBD.jpg,http://picture.akucun.com/logo/BALA.jpg,http://picture.akucun.com/logo/7M.jpg,http://picture.akucun.com/logo/DGYR.jpg,http://picture.akucun.com/logo/JESSICA.jpg,http://picture.akucun.com/logo/SW.jpg
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

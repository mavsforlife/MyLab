package com.mavsforlife.victor.mylab.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Keep;

import com.google.gson.annotations.SerializedName;

/**
 * Created by victor on 2017/11/21.
 * Email: wwmdirk@gmail.com
 */
@Keep
public class Beauty implements Parcelable {
    /**
     * _id : 5a121895421aa90fe50c021e
     * createdAt : 2017-11-20T07:49:41.797Z
     * desc : 2017-11-20
     * publishedAt : 2017-11-20T12:42:06.454Z
     * source : chrome
     * type : 福利
     * url : http://7xi8d6.com1.z0.glb.clouddn.com/20171120074925_ZXDh6l_joanne_722_20_11_2017_7_49_16_336.jpeg
     * used : true
     * who : daimajia
     */

    @SerializedName("_id")
    private String id;

    @SerializedName("createdAt")
    private String createTime;

    private String desc;

    @SerializedName("publishedAt")
    private String publishTime;

    private String source;

    private String type;

    private String url;

    private boolean used;

    private String who;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.createTime);
        dest.writeString(this.desc);
        dest.writeString(this.publishTime);
        dest.writeString(this.source);
        dest.writeString(this.type);
        dest.writeString(this.url);
        dest.writeByte(this.used ? (byte) 1 : (byte) 0);
        dest.writeString(this.who);
    }

    public Beauty() {
    }

    protected Beauty(Parcel in) {
        this.id = in.readString();
        this.createTime = in.readString();
        this.desc = in.readString();
        this.publishTime = in.readString();
        this.source = in.readString();
        this.type = in.readString();
        this.url = in.readString();
        this.used = in.readByte() != 0;
        this.who = in.readString();
    }

    public static final Parcelable.Creator<Beauty> CREATOR = new Parcelable.Creator<Beauty>() {
        @Override
        public Beauty createFromParcel(Parcel source) {
            return new Beauty(source);
        }

        @Override
        public Beauty[] newArray(int size) {
            return new Beauty[size];
        }
    };
}

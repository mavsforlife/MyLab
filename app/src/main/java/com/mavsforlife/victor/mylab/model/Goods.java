package com.mavsforlife.victor.mylab.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by victor on 2017/11/14.
 * Email: wwmdirk@gmail.com
 */

public class Goods implements Parcelable {

    private String message;
    private List<Image> mImages;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Image> getImages() {
        return mImages;
    }

    public void setImages(List<Image> images) {
        mImages = images;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.message);
        dest.writeList(this.mImages);
    }

    public Goods() {
    }

    protected Goods(Parcel in) {
        this.message = in.readString();
        this.mImages = new ArrayList<Image>();
        in.readList(this.mImages, Image.class.getClassLoader());
    }

    public static final Parcelable.Creator<Goods> CREATOR = new Parcelable.Creator<Goods>() {
        @Override
        public Goods createFromParcel(Parcel source) {
            return new Goods(source);
        }

        @Override
        public Goods[] newArray(int size) {
            return new Goods[size];
        }
    };
}

package com.mavsforlife.victor.mylab.list;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.mavsforlife.victor.mylab.model.BaseResult;
import com.mavsforlife.victor.mylab.model.Beauty;
import com.mavsforlife.victor.mylab.model.Goods;
import com.mavsforlife.victor.mylab.model.Image;
import com.mavsforlife.victor.mylab.model.PostFactory;
import com.mavsforlife.victor.mylab.network.BaseObserver;
import com.mavsforlife.victor.mylab.network.NetWork;
import com.mavsforlife.victor.mylab.network.aikucun.AikucuResult;
import com.mavsforlife.victor.mylab.network.aikucun.AikucunNetWork;
import com.mavsforlife.victor.mylab.network.aikucun.model.DataBean;

import java.nio.channels.NetworkChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by victor on 2017/11/13.
 * Email: wwmdirk@gmail.com
 */

public class MainFragmentPresenter implements MainFragmentContract.Presenter {

    private Context mContext;
    private MainFragmentContract.View mView;

    public MainFragmentPresenter(Context context, MainFragmentContract.View view) {
        mContext = context;
        mView = view;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void onLoadGoods() {
        final List<Goods> list = PostFactory.fake();
        NetWork.getsBaseApi()
                .getBeauties(22, 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<BaseResult<List<Beauty>>>(){

                    @Override
                    public void onNext(BaseResult<List<Beauty>> listBaseResult) {
                        super.onNext(listBaseResult);
                        List<Beauty> list1 = listBaseResult.getResults();
                        for (int i = 0; i < list.size(); i++) {
                            Image image = new Image();
                            image.setUrl(list1.get(i).getUrl());
                            list.get(i).getImages().add(image);
                        }
                        mView.loadGoods(list);
                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                    }
                });

//        AikucunNetWork.getAikucunApi()
//                .getAction("getState2", getQueryMap())
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new BaseObserver<AikucuResult<DataBean>>() {
//
//                    @Override
//                    public void onNext(AikucuResult<DataBean> dataBeanAikucuResult) {
//                        super.onNext(dataBeanAikucuResult);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        super.onError(e);
//                    }
//                });

        String str = md5("action=getState2&appid=28769828&did=962f246b7d1115e7647ce90f3ce94579&noncestr=123456&sync=0&timestamp=1511329875&token=8a9b048d5fdf5b2f015fe1abcfb62ec0&userid=8a9b048d5fd72a9b015fd735abc507bb");
        Log.d("md5", str);
        String str2 = md5("appid=28769828&did=962f246b7d1115e7647ce90f3ce94579&noncestr=123456&sync=0&timestamp=1511329875&token=8a9b048d5fdf5b2f015fe1abcfb62ec0&userid=8a9b048d5fd72a9b015fd735abc507bb");
        Log.d("md5", str2);

    }
    //http://app.akucun.com/api/v1.0/live.do?action=getState2&appid=28769828&did=962f246b7d1115e7647ce90f3ce94579
    // &noncestr=123456&sync=0&timestamp=1511329875&token=8a9b048d5fdf5b2f015fe1abcfb62ec0&userid=8a9b048d5fd72a9b015fd735abc507bb&sig=2ae214ff9eba21302e81b61665cbbba84c51575b
    private LinkedHashMap<String, String> getQueryMap() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("appid", "28769828");
        map.put("did", "962f246b7d1115e7647ce90f3ce94579");
        map.put("noncestr", "123456");
        map.put("sync", "0");
        map.put("timestamp", "1511329875");
        map.put("token", "8a9b048d5fdf5b2f015fe1abcfb62ec0");
        map.put("userid", "8a9b048d5fd72a9b015fd735abc507bb");
        map.put("sig", "2ae214ff9eba21302e81b61665cbbba84c51575b");
        return map;
    }

    public static String md5(String string) {
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(string.getBytes());
            String result = "";
            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                result += temp;
            }
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}

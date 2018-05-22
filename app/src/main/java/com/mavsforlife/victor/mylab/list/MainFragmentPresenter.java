package com.mavsforlife.victor.mylab.list;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.MonthDisplayHelper;
import android.widget.Toast;

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
import com.mavsforlife.victor.mylab.util.DialogUtil;
import com.mavsforlife.victor.mylab.util.DownLoadImageUtil;
import com.mavsforlife.victor.mylab.util.StringUtil;

import org.reactivestreams.Publisher;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.channels.NetworkChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import static android.content.Context.CLIPBOARD_SERVICE;

/**
 * Created by victor on 2017/11/13.
 * Email: wwmdirk@gmail.com
 */

public class MainFragmentPresenter implements MainFragmentContract.Presenter {

    private Context mContext;
    private MainFragmentContract.View mView;
    private List<Goods> mList;
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
                        mList = list;
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

    }

    @Override
    public void onShare(final int position) {
        final Goods goods = mList.get(position);
        final List<File> files = new ArrayList<>();
        Observable.fromIterable(goods.getImages())
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .map(new Function<Image, File>() {
                    @Override
                    public File apply(Image image) throws Exception {
                        String fileName = position+ "_" + StringUtil.getImgName(image.getUrl());
                        return DownLoadImageUtil.savePicture(mContext, fileName, image.getUrl());
                    }
                })
                .subscribe(new Observer<File>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        DialogUtil.showProgressDialog(mContext);
                    }

                    @Override
                    public void onNext(File file) {
                        files.add(file);
                        Log.d("save", "图片已成功保存到" + file.getName());
                    }

                    @Override
                    public void onError(Throwable e) {
                        DialogUtil.hideProgressDialog();
                        e.printStackTrace();
                        Log.d("save", e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        DialogUtil.hideProgressDialog();
                        mView.shareTo(files);
                    }
                });


    }
}

package com.mavsforlife.victor.mylab.list;

import android.content.Context;

import com.mavsforlife.victor.mylab.model.BaseResult;
import com.mavsforlife.victor.mylab.model.Beauty;
import com.mavsforlife.victor.mylab.model.Goods;
import com.mavsforlife.victor.mylab.model.Image;
import com.mavsforlife.victor.mylab.model.PostFactory;
import com.mavsforlife.victor.mylab.network.BaseObserver;
import com.mavsforlife.victor.mylab.network.NetWork;

import java.nio.channels.NetworkChannel;
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

    }
}

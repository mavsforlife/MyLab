package com.mavsforlife.victor.mylab.list;

import android.content.Context;

import com.mavsforlife.victor.mylab.model.Goods;
import com.mavsforlife.victor.mylab.model.PostFactory;

import java.util.List;

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
        List<Goods> list = PostFactory.fake();
        mView.loadGoods(list);
    }
}

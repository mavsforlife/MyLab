package com.mavsforlife.victor.mylab.list;

import com.mavsforlife.victor.mylab.base.BasePresenter;
import com.mavsforlife.victor.mylab.base.BaseView;
import com.mavsforlife.victor.mylab.model.Goods;

import java.util.List;

/**
 * Created by victor on 2017/11/13.
 * Email: wwmdirk@gmail.com
 */

public interface MainFragmentContract {

    interface View extends BaseView {
        void loadGoods(List<Goods> list);
    }

    interface Presenter extends BasePresenter {
        void onLoadGoods();
    }
}

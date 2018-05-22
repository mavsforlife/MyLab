package com.mavsforlife.victor.mylab.network;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by victor on 2017/11/20.
 * Email: wwmdirk@gmail.com
 */

public class BaseObserver<T> implements Observer<T> {


    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {
        if (isCancel()) return;
    }

    @Override
    public void onError(Throwable e) {
        if (isCancel()) return;
    }

    @Override
    public void onComplete() {

    }

    protected boolean isCancel() {
        return false;
    }
}

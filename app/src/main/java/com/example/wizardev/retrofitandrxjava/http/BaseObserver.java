package com.example.wizardev.retrofitandrxjava.http;

import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * author : wizardev
 * e-mail : wizarddev@163.com
 * time   : 2017/08/18
 * desc   :
 * version: 1.0
 */
public abstract class BaseObserver implements Observer<String>{
    private static final String TAG = "BaseObserver";
    @Override
    public void onSubscribe(Disposable d) {

    }
    @Override
    public void onNext(String value) {
        onHandleSuccess(value);
    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG, "error:" + e.toString());
    }

    @Override
    public void onComplete() {
        Log.d(TAG, "onComplete");
    }


    protected abstract void onHandleSuccess(String t);

}

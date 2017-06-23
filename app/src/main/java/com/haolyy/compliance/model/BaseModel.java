package com.haolyy.compliance.model;

import android.app.Application;

import com.haolyy.compliance.base.BaseApplication;
import com.haolyy.compliance.base.LifeSubscription;
import com.haolyy.compliance.config.NetConstantValues;
import com.haolyy.compliance.utils.LogInterceptorHtml;
import com.haolyy.compliance.utils.LogUtils;
import com.haolyy.compliance.utils.WyUtils;
import com.xfqz.xjd.mylibrary.LogInterceptor;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 网络请求基类2.0版本
 * Created by NIUDEYANG on 2016/11/17.
 */

public class BaseModel {

    private static final int DEFAULT_TIMEOUT = 10;
    Retrofit retrofit;
    static Map<String, String> map = new HashMap<>();
    OkHttpClient.Builder httpClientBuilder;

    public BaseModel() {
        //手动创建一个OkHttpClient并设置超时时间
        httpClientBuilder = new OkHttpClient.Builder();
            httpClientBuilder.addInterceptor(new LogInterceptorHtml()).connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        new Retrofit.Builder();
        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(NetConstantValues.HOST_URL)
                .build();
    }

    //添加线程订阅
    public static <T> void invoke(LifeSubscription lifeSubscription, Observable<T> observable, Subscriber<T> subscriber) {
        LogUtils.e("ndy_params", map.toString());
        Subscription subscription = observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
        lifeSubscription.bindSubscription(subscription);
    }
}

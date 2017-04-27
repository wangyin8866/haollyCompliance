package com.haolyy.compliance.model;

import android.util.Log;

import com.haolyy.compliance.config.NetConstantValues;
import com.xfqz.xjd.mylibrary.LogInterceptor;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 网络请求基类2.0版本
 * Created by NIUDEYANG on 2016/11/17.
 */

public  class BaseModel {

    private static final int DEFAULT_TIMEOUT = 10;
    Retrofit retrofit;
    protected Map<String,String> map=new HashMap<>();
    public BaseModel() {
        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.addInterceptor(new LogInterceptor()).connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        new Retrofit.Builder();
        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(NetConstantValues.HOST_URL)
                .build();
    }
    //添加线程管理并订阅
    void toSubscribe(Observable o, Subscriber s) {
        Log.e("params", map.toString());
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);

    }
   
}

package com.haolyy.compliance.model;

import com.haolyy.compliance.base.BaseApplication;
import com.haolyy.compliance.config.NetConstantValues;
import com.haolyy.compliance.entity.login.SmsBean;
import com.haolyy.compliance.service.UserApi;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by LL on 2017/1/7.
 */

public class BigThreeModel extends BaseModel {
    private UserApi userApi;
    private static BigThreeModel userModel;

    private BigThreeModel() {
        super();
        retrofit=new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(NetConstantValues.HOST_URL2)
                .build();
        userApi = retrofit.create(UserApi.class);
    }

    public static BigThreeModel getInstance() {
        if (userModel == null) {
            synchronized (BigThreeModel.class) {
                if (userModel == null) {
                    userModel = new BigThreeModel();
                }
            }
        }
        return userModel;
    }

    public Observable<SmsBean> sendSms(String phone_num,String imagecode,String systemplate,String type) {
        map.put("type",type);
        map.put("mobile", phone_num);
        map.put("imagecode", imagecode);
        map.put("systemplate", systemplate);
        map.put("token", BaseApplication.token);
        return userApi.sendSms(map);
    }

}

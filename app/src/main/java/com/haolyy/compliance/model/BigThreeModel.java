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

    /**
     *
     * @param phone_num
     * @param imagecode
     * @param systemplate
     * @param type register forget
     * @return
     */
    public Observable<SmsBean> sendSms(String phone_num,String imagecode,String systemplate,String type) {
        return userApi.sendSms(phone_num,imagecode,systemplate,type,BaseApplication.token);
    }

}

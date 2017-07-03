package com.haolyy.compliance.model;

import com.haolyy.compliance.config.NetConstantValues;
import com.haolyy.compliance.service.ProductApi;
import com.haolyy.compliance.service.UserApi;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by wngyin on 2017/6/24.
 * 返回的是String
 */

public class StringTestModel extends BaseModel {
    private ProductApi productApi;
    private UserApi userApi;
    private static StringTestModel userModel;

    public StringTestModel() {
        //手动创建一个OkHttpClient并设置超时时间
        super();
        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(NetConstantValues.HOST_URL)
                .build();

        productApi = retrofit.create(ProductApi.class);
        userApi = retrofit.create(UserApi.class);
    }

    public static StringTestModel getInstance() {
        if (userModel == null) {
            synchronized (StringTestModel.class) {
                if (userModel == null) {
                    userModel = new StringTestModel();
                }
            }
        }
        return userModel;
    }


}

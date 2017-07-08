package com.haolyy.compliance.model;

import com.haolyy.compliance.service.ProductApi;
import com.haolyy.compliance.service.UserApi;

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

package com.haolyy.compliance.model;

import com.haolyy.compliance.base.BaseApplication;
import com.haolyy.compliance.entity.TokenResponseBean;
import com.haolyy.compliance.entity.login.UserInfoLogin;
import com.haolyy.compliance.service.UserApi;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by LL on 2017/1/7.
 */

public class UserModel extends BaseModel {
    private UserApi userApi;
    private static UserModel userModel;

    private UserModel() {
        super();
        userApi = retrofit.create(UserApi.class);
    }

    public static UserModel getInstance() {
        if (userModel == null) {
            synchronized (UserModel.class) {
                if (userModel == null) {
                    userModel = new UserModel();
                }
            }
        }
        return userModel;
    }

    /**
     * 获取token的方法
     * @param userId
     * @param subscriber
     */
    public void getToken(String userId,Subscriber<TokenResponseBean> subscriber){
        map.put("userId",userId);
        Observable observable = null;
        toSubscribe(observable, subscriber);
    }
    /**
     *  登录
     * @param subscriber
     * @param phone_num
     * @param password
     * @param validate_code
     */
    public void login(Subscriber<UserInfoLogin> subscriber, String phone_num, String password, String validate_code) {
        map.put("token", BaseApplication.token);
        map.put("phone_num",phone_num);
        map.put("password",password);
        map.put("validate_code",validate_code);
        Observable observable = userApi.login(map);
        toSubscribe(observable, subscriber);
    }
}

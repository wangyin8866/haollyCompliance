package com.haolyy.compliance.model;

import com.google.gson.Gson;
import com.haolyy.compliance.base.BaseApplication;
import com.haolyy.compliance.entity.TokenResponseBean;
import com.haolyy.compliance.entity.login.UserInfoLogin;
import com.haolyy.compliance.service.UserApi;

import okhttp3.RequestBody;
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
    public void login(Subscriber<Object> subscriber, String phone_num, String password, String validate_code) {
        map.put("mobile",phone_num);
        map.put("password",password);
        map.put("login_ip","192.168.1.1");
        map.put("platform","Android");
        map.put("client","haolyy");
        Gson gson=new Gson();
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),  gson.toJson(map));
        Observable observable = userApi.login(body);
        toSubscribe(observable, subscriber);
    }
}

package com.haolyy.compliance.model;

import com.haolyy.compliance.base.BaseApplication;
import com.haolyy.compliance.entity.BaseResponseBean;
import com.haolyy.compliance.entity.TokenResponseBean;
import com.haolyy.compliance.entity.login.CheckImageCode;
import com.haolyy.compliance.entity.login.LoginResponseBean;
import com.haolyy.compliance.entity.login.RegisterBean;
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
     */
    public Observable<TokenResponseBean> getToken() {
       return userApi.getToken();
    }

    /**
     * 登录
     *
     *
     */

    public Observable<LoginResponseBean>login(String phone_num, String password,String loginIp,String version,String platform,String client) {
        map.put("mobile", phone_num);
        map.put("password", password);
        map.put("loginIp", loginIp);
        map.put("version", version);
        map.put("platform", platform);
        map.put("client", client);
        return userApi.login(map);
    }

    public Observable<RegisterBean> register(String phone_num, String password,String smsCode,String imageCode,String client,String platform,String registBd,String version,String registerCode) {
        map.clear();
        map.put("mobile", phone_num);
        map.put("passWord", password);
        map.put("smsCode", smsCode);
        map.put("imageCode", imageCode);
        map.put("client", client);
        map.put("platform", platform);
        map.put("registBd", registBd);
        map.put("version", version);
        map.put("registIp","192.168.2.223");
        map.put("registerCode",registerCode);
        map.put("token",BaseApplication.token);
        return userApi.register(map);
    }

    public Observable<CheckImageCode> checkImageCode(String imagecode) {
        map.put("imagecode", imagecode);
        map.put("token", BaseApplication.token);
        return userApi.checkImage(map);
    }

    public Observable<BaseResponseBean> forgetPassWord(String phone_num, String password,String smsCode,String imageCode,String client,String platform) {
        map.clear();
        map.put("mobile", phone_num);
        map.put("passWord", password);
        map.put("smsCode", smsCode);
        map.put("imageCode", imageCode);
        map.put("client", client);
        map.put("platform", platform);
        map.put("token",BaseApplication.token);
        return userApi.forgetPassWord(map);
    }
}

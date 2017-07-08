package com.haolyy.compliance.model;

import com.haolyy.compliance.base.BaseApplication;
import com.haolyy.compliance.base.BaseBean;
import com.haolyy.compliance.config.Config;
import com.haolyy.compliance.config.NetConstantValues;
import com.haolyy.compliance.custom.wheelview.adapter.BaseWheelAdapter;
import com.haolyy.compliance.entity.BaseResponseBean;
import com.haolyy.compliance.entity.TokenResponseBean;
import com.haolyy.compliance.entity.login.CheckImageCode;
import com.haolyy.compliance.entity.login.FindUserStatusBean;
import com.haolyy.compliance.entity.login.LoginResponseBean;
import com.haolyy.compliance.entity.login.RegisterBean;
import com.haolyy.compliance.service.UserApi;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

import static com.haolyy.compliance.base.BaseApplication.version;
import static com.haolyy.compliance.config.Config.client;
import static com.haolyy.compliance.config.Config.platformhaolyy;

/**
 * Created by LL on 2017/1/7.
 */

public class UserModel extends BaseModel {
    private UserApi userApi;
    private static UserModel userModel;

    private UserModel() {
        super();
        retrofit=new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(NetConstantValues.HOST_URL3)
                .build();
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

    public Observable<LoginResponseBean>login(String phone_num, String password) {
        map.put("phone_num", phone_num);
        map.put("password", password);
//        map.put("token", BaseApplication.token);
        return userApi.login(map);
    }

    public Observable<BaseBean> register(String phone_num, String password, String smsCode, String imageCode, String channel, String inviteCode) {
        map.clear();
        map.put("phone_num", phone_num);
        map.put("password", password);
        map.put("smsCode", smsCode);
        map.put("validate_code", imageCode);
        map.put("client", Config.client);
        map.put("platform", Config.platform);
        map.put("version", version);
        map.put("channel",channel);
        map.put("inviteCode",inviteCode);
        map.put("token",BaseApplication.token);
        return userApi.register(map);
    }

    public Observable<CheckImageCode> sendTextSms(String phone_num) {
        return userApi.sendTextSms(phone_num);
    }

    public Observable<BaseBean> forgetPassWord(String phone_num, String password, String smsCode, String imageCode) {
        map.clear();
        map.put("phone_num", phone_num);
        map.put("password", password);
        map.put("smsCode", smsCode);
        map.put("validate_code", imageCode);
//        map.put("client", client);
//        map.put("platform", platformhaolyy);
        map.put("token",BaseApplication.token);
        return userApi.forgetPassWord(map);
    }

    /**
     * 查询用户状态
     * @return
     */
    public Observable<FindUserStatusBean> findUserStatus() {
        map.clear();
        map.put("mobile",BaseApplication.mUserName);
        map.put("platform", "1");
        return userApi.findStatus(map);
    }
}

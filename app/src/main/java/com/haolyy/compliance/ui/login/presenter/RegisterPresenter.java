package com.haolyy.compliance.ui.login.presenter;

import android.content.Context;

import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.config.Config;
import com.haolyy.compliance.model.UserModel;
import com.haolyy.compliance.ui.login.view.RegisterView;
import com.haolyy.compliance.utils.LogUtils;

import rx.Subscriber;


/**
 * Created by niudeyang on 2017/4/25.
 */

public class RegisterPresenter extends BasePresenter<RegisterView> {

    public RegisterPresenter(Context context) {
        super(context);
    }

    public void login(String phone, String pwd, String valid_code) {
        getToken(Config.LOGIN);

       /* UserModel.getInstance().login(new ProgressSubscriber<UserInfoLogin>(new SubscriberOnNextListener<UserInfoLogin>() {
            @Override
            public void onNext(UserInfoLogin userInfoLogin) {
                //登录成功刷新ui
                getView().refresh();
                //如果token失效
                getToken(LOGIN);
            }

            @Override
            public void onError(Throwable e) {
            //
            }
        },mContext),phone,pwd,valid_code);*/
    }

    public void register(String s, String qwe123) {
        invoke(UserModel.getInstance().register("112121", "1212121"), new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e(tag, e.getMessage());
            }

            @Override
            public void onNext(String s) {
                LogUtils.e(tag, s);
            }
        });

    }


    public void sendSms(String s) {
        invoke(UserModel.getInstance().sendSms(s), new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e(tag, e.getMessage());
            }

            @Override
            public void onNext(String s) {
                LogUtils.e(tag, s);
            }
        });
    }

    public void getImageCode() {


    }
}

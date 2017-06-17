package com.haolyy.compliance.ui.login.presenter;

import android.content.Context;

import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.config.Config;
import com.haolyy.compliance.entity.login.CheckImageCode;
import com.haolyy.compliance.entity.login.RegisterBean;
import com.haolyy.compliance.entity.login.SmsBean;
import com.haolyy.compliance.model.BigThreeModel;
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
    }

    public void register(String phone_num, String password,String smsCode,String imageCode,String client,String platform,String registBd,String version) {
        invoke(UserModel.getInstance().register(phone_num, password,smsCode,imageCode,client,platform,registBd,version), new Subscriber<RegisterBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e(tag, e.getMessage());
            }

            @Override
            public void onNext(RegisterBean s) {
                LogUtils.e(tag, s.toString());

                getView().skip();
            }
        });

    }


    public void sendSms(String phone_num,String imagecode,String systemplate) {
        invoke(BigThreeModel.getInstance().sendSms(phone_num,imagecode,systemplate), new Subscriber<SmsBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e(tag, e.getMessage());
            }

            @Override
            public void onNext(SmsBean s) {
                LogUtils.e(tag, s.toString());
            }
        });
    }

    public void checkImageCode(String image) {
        invoke(UserModel.getInstance().checkImageCode(image), new Subscriber<CheckImageCode>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e(tag, e.getMessage());
            }

            @Override
            public void onNext(CheckImageCode s) {
                LogUtils.e(tag, s.getData().getMsg() + s.getData().getStatus());

            }
        });
    }
}

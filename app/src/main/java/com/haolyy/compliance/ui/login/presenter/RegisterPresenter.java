package com.haolyy.compliance.ui.login.presenter;

import android.content.Context;

import com.haolyy.compliance.base.BaseApplication;
import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.entity.TokenResponseBean;
import com.haolyy.compliance.entity.login.CheckImageCode;
import com.haolyy.compliance.entity.login.RegisterBean;
import com.haolyy.compliance.entity.login.SmsBean;
import com.haolyy.compliance.model.BigThreeModel;
import com.haolyy.compliance.model.UserModel;
import com.haolyy.compliance.ui.login.view.RegisterView;
import com.haolyy.compliance.utils.LogUtils;
import com.haolyy.compliance.utils.UIUtils;

import rx.Subscriber;


/**
 * Created by niudeyang on 2017/4/25.
 */

public class RegisterPresenter extends BasePresenter<RegisterView> {

    public RegisterPresenter(Context context) {
        super(context);
    }

    public void login(String phone, String pwd, String valid_code) {

    }

    public void register(String phone_num, String password, String smsCode, String imageCode, String registBd,String chnnel, String regsiterCode) {
        invoke(UserModel.getInstance().register(phone_num, password, smsCode, imageCode, registBd,chnnel, regsiterCode), new Subscriber<RegisterBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e(tag, e.getMessage());
            }

            @Override
            public void onNext(RegisterBean s) {
                if (s.getStatus().equals("200")) {
                    if (s.getData().getStatus().equals("200")) {
                        getView().skip();
                    } else {
                        UIUtils.showToastCommon(mContext, s.getData().getMsg());
                    }
                } else {
                    UIUtils.showToastCommon(mContext, s.getMsg());
                }
            }
        });

    }


    public void sendSms(String phone_num, String imagecode, String systemplate) {
        invoke(BigThreeModel.getInstance().sendSms(phone_num, imagecode, systemplate,"register"), new Subscriber<SmsBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e(tag, e.getMessage());
                getView().countDown(false);
            }

            @Override
            public void onNext(SmsBean s) {
                if (s.getStatus().equals("200")) {
                    if (s.getData().getStatus().equals("200")) {
                        getView().countDown(true);
                    } else {
                        UIUtils.showToastCommon(mContext, s.getData().getMsg());
                        getView().countDown(false);
                    }
                } else {
                    UIUtils.showToastCommon(mContext, s.getMsg());
                    getView().countDown(false);
                }
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
                if (s.getStatus().equals("200")) {
                    if (s.getData().getStatus().equals("200")) {
                        getView().getSms(true);
                    }  else if(s.getData().getStatus().equals("10102")){
                        UIUtils.showToastCommon(mContext,s.getData().getMsg());
                        getView().modifyImageCode();
                        getView().getSms(false);
                    }else {
                        UIUtils.showToastCommon(mContext,s.getData().getMsg());
                        getView().getSms(false);
                    }
                } else {
                    UIUtils.showToastCommon(mContext, s.getMsg());
                    getView().getSms(false);
                }

            }
        });
    }

    public void getToken() {
        invoke(UserModel.getInstance().getToken(), new Subscriber<TokenResponseBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(TokenResponseBean s) {
                if (s.getStatus().equals("200")) {
                    if (s.getData().getStatus().equals("200")) {
                        String token = s.getData().getData().getToken();
                        BaseApplication.token = token;
                        getView().showImageCode();
                    } else {
                        UIUtils.showToastCommon(mContext, s.getData().getMsg());
                    }
                } else {
                    UIUtils.showToastCommon(mContext, s.getMsg());
                }

            }
        });

    }
}

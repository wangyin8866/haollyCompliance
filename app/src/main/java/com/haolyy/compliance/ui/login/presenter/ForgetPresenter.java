package com.haolyy.compliance.ui.login.presenter;

import android.content.Context;
import android.content.Intent;

import com.haolyy.compliance.base.BaseApplication;
import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.entity.BaseResponseBean;
import com.haolyy.compliance.entity.TokenResponseBean;
import com.haolyy.compliance.entity.login.CheckImageCode;
import com.haolyy.compliance.entity.login.SmsBean;
import com.haolyy.compliance.model.BigThreeModel;
import com.haolyy.compliance.model.UserModel;
import com.haolyy.compliance.ui.login.LoginActivity;
import com.haolyy.compliance.ui.login.view.ForgetView;
import com.haolyy.compliance.utils.LogUtils;
import com.haolyy.compliance.utils.UIUtils;

import rx.Subscriber;


/**
 * Created by niudeyang on 2017/4/25.
 */

public class ForgetPresenter extends BasePresenter<ForgetView> {
    public ForgetPresenter(Context context) {
        super(context);
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

    public void sendSms(String phone_num, String imagecode, String systemplate) {
        invoke(BigThreeModel.getInstance().sendSms(phone_num, imagecode, systemplate,"forget"), new Subscriber<SmsBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e(tag, e.getMessage());
            }

            @Override
            public void onNext(SmsBean s) {
                if (s.getStatus().equals("200")) {
                        getView().countDown();
                } else {
                    UIUtils.showToastCommon(mContext, s.getMsg());
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
                    } else {
                        UIUtils.showToastCommon(mContext, s.getData().getMsg());
                        getView().getSms(false);
                    }
                } else {
                    UIUtils.showToastCommon(mContext, s.getMsg());
                }

            }
        });
    }

    public void forgetPassWord(String phone_num, String password, String smsCode, String imageCode) {
        invoke(UserModel.getInstance().forgetPassWord(phone_num, password, smsCode, imageCode), new Subscriber<BaseResponseBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponseBean s) {
                if (s.getStatus().equals("200")) {
                    if (s.getData().getStatus().equals("200")) {
                        mContext.startActivity(new Intent(mContext, LoginActivity.class));
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

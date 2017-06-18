package com.haolyy.compliance.ui.login.presenter;

import android.content.Context;

import com.haolyy.compliance.base.BaseApplication;
import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.config.Config;
import com.haolyy.compliance.entity.BaseResponseBean;
import com.haolyy.compliance.entity.TokenResponseBean;
import com.haolyy.compliance.entity.login.CheckImageCode;
import com.haolyy.compliance.entity.login.SmsBean;
import com.haolyy.compliance.model.BigThreeModel;
import com.haolyy.compliance.model.UserModel;
import com.haolyy.compliance.ui.login.view.ForgetView;
import com.haolyy.compliance.utils.LogUtils;

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
                String token = s.getData().getData().getToken();
                BaseApplication.token = token;
                getView().showImageCode();
            }
        });

    }

    public void sendSms(String phone_num, String imagecode, String systemplate) {
        invoke(BigThreeModel.getInstance().sendSms(phone_num, imagecode, systemplate), new Subscriber<SmsBean>() {
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
                if (s.getData().getStatus().equals("200")) {
                    getView().getSms();
                }
            }
        });
    }

    public void forgetPassWord(String phone_num, String password, String smsCode, String imageCode, String client, String platform) {
        invoke(UserModel.getInstance().forgetPassWord(phone_num, password, smsCode, imageCode, client, platform), new Subscriber<BaseResponseBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponseBean baseResponseBean) {

            }
        });
    }
}

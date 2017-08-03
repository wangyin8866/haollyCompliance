package com.haolyy.compliance.ui.my;

import android.content.Context;

import com.haolyy.compliance.base.BaseApplication;
import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.config.Config;
import com.haolyy.compliance.entity.TokenResponseBean;
import com.haolyy.compliance.entity.login.ReBindPhoneBean;
import com.haolyy.compliance.entity.login.ValidateCode;
import com.haolyy.compliance.model.BigThreeModel;
import com.haolyy.compliance.model.UserModel;
import com.haolyy.compliance.utils.LogUtils;
import com.haolyy.compliance.utils.UIUtils;
import com.xfqz.xjd.mylibrary.ProgressSubscriber;
import com.xfqz.xjd.mylibrary.SubscriberOnNextListener;

import rx.Subscriber;

/**
 * Created by wangyin on 2017/8/2.
 */

public class CheckPhonePresenter extends BasePresenter<CheckPhoneView> {
    public CheckPhonePresenter(Context context) {
        super(context);
    }

    public void reBindPhone(final int type, String password, String phone,String smsCode, String imageCode) {
        invoke(UserModel.getInstance().reBindPhone(type, password, phone,smsCode, imageCode), new ProgressSubscriber<ReBindPhoneBean>(new SubscriberOnNextListener<ReBindPhoneBean>() {
            @Override
            public void onNext(ReBindPhoneBean reBindPhoneBean) {
                if (reBindPhoneBean.getCode().equals("200")) {
                    if (type == 1) {
                        getView().pushActivity(1);
                    } else {
                        getView().pushActivity(2);
                    }
                } else {
                    UIUtils.showToastCommon(mContext, reBindPhoneBean.getMsg());
                }
            }

            @Override
            public void onError(Throwable e) {

            }
        }, mContext));
    }

    public void requestValidateCode(String phone_num, String imagecode) {
        invoke(BigThreeModel.getInstance().requestValidateCode(phone_num, imagecode, Config.SMS_OPERATION_TYPE_REG), new Subscriber<ValidateCode>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e(tag, e.getMessage());
                getView().countDown(false);
            }

            @Override
            public void onNext(ValidateCode s) {
                if (s.getCode().equals("200")) {
                    if (s.getModel().getCode().equals("200")) {
                        getView().countDown(true);
                    } else {
                        UIUtils.showToastCommon(mContext, s.getModel().getMsg());
                        getView().countDown(false);
                    }
                } else {
                    UIUtils.showToastCommon(mContext, s.getMsg());
                    getView().countDown(false);
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
                if (s.getCode().equals("200")) {
                    String token = s.getModel().getToken();
                    BaseApplication.token = token;
                    getView().showImageCode();

                } else {
                    UIUtils.showToastCommon(mContext, s.getMsg());
                }

            }
        });

    }
}

package com.haolyy.compliance.ui.login.presenter;

import android.content.Context;

import com.haolyy.compliance.base.BaseApplication;
import com.haolyy.compliance.base.BaseBean;
import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.config.Config;
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

    public void register(String phone_num, String password, String smsCode, String imageCode, String chnnel, String regsiterCode) {
        invoke(UserModel.getInstance().register(phone_num, password, smsCode, imageCode,chnnel, regsiterCode), new Subscriber<BaseBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e(tag, e.getMessage());
            }

            @Override
            public void onNext(BaseBean s) {
                if (s.getCode().equals("200")) {
                    getView().skip();

                } else {
                    UIUtils.showToastCommon(mContext, s.getMsg());
                }
            }
        });

    }


    public void requestValidateCode(String phone_num, String imagecode) {
        invoke(BigThreeModel.getInstance().requestValidateCode(phone_num, imagecode,Config.SMS_OPERATION_TYPE_REG), new Subscriber<BaseBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e(tag, e.getMessage());
                getView().countDown(false);
            }

            @Override
            public void onNext(BaseBean s) {
                if (s.getCode().equals("200")) {
                    getView().countDown(true);
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

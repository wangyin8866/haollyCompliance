package com.haolyy.compliance.ui.login.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.haolyy.compliance.base.BaseBean;
import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.config.Config;
import com.haolyy.compliance.entity.TokenResponseBean;
import com.haolyy.compliance.entity.login.CheckImageCode;
import com.haolyy.compliance.entity.login.ValidateCode;
import com.haolyy.compliance.model.BigThreeModel;
import com.haolyy.compliance.model.UserModel;
import com.haolyy.compliance.ui.login.LoginActivity;
import com.haolyy.compliance.ui.login.view.ForgetView;
import com.haolyy.compliance.ui.my.ModificationPasswordStep2Activity;
import com.haolyy.compliance.ui.my.ModificationPasswordSucceed;
import com.haolyy.compliance.utils.LogUtils;
import com.haolyy.compliance.utils.UIUtils;
import com.xfqz.xjd.mylibrary.ProgressSubscriber;
import com.xfqz.xjd.mylibrary.SubscriberOnNextListener;

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
                if (s.getCode().equals("200")) {
                    String token = s.getModel().getToken();
                    token = token;
                    getView().showImageCode();

                } else {
                    UIUtils.showToastCommon(mContext, s.getMsg());
                }

            }
        });

    }

    public void requestValidateCode(String phone_num, String imagecode) {
        invoke(BigThreeModel.getInstance().requestValidateCode(phone_num, imagecode, Config.SMS_OPERATION_TYPE_FOR), new Subscriber<ValidateCode>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e(tag, e.getMessage());
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

    public void checkImageCode(String phone_num) {
        invoke(UserModel.getInstance().sendTextSms(phone_num), new Subscriber<CheckImageCode>() {
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
                    } else if (s.getData().getStatus().equals("10102")) {
                        //图形验证码错误
                        UIUtils.showToastCommon(mContext, s.getData().getMsg());
                        getView().modifyImageCode();
                        getView().getSms(false);
                    } else {
                        UIUtils.showToastCommon(mContext, s.getData().getMsg());
                        getView().getSms(false);
                    }
                } else {
                    UIUtils.showToastCommon(mContext, s.getMsg());
                    getView().getSms(false);
                }

            }
        });
    }

    /**
     *忘记密码
     * @param phone_num
     * @param password
     * @param smsCode
     * @param imageCode
     */
    public void forgetPassWord(String phone_num, String password, String smsCode, String imageCode) {
        invoke(UserModel.getInstance().forgetPassWord(phone_num, password, smsCode, imageCode), new Subscriber<BaseBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {


            }

            @Override
            public void onNext(BaseBean s) {
                if (s.getCode().equals("200")) {
                        mContext.startActivity(new Intent(mContext, LoginActivity.class));
                        ((Activity) mContext).finish();
                        UIUtils.showToastCommon(mContext,"设置成功");
                } else {
                    UIUtils.showToastCommon(mContext, s.getMsg());
                }
            }
        });
    }
    /**
     * 重置密码POST /v1/api/user/resetPasswordInMore
     */
    public void resetPasswordInMore(String userId, String password, String newPassword){
        invoke(UserModel.getInstance().resetPasswordInMore(userId,password,newPassword),new ProgressSubscriber<BaseBean>(new SubscriberOnNextListener<BaseBean>() {
            @Override
            public void onNext(BaseBean baseBean) {
                if (baseBean.getCode().equals("200")) {
                    mContext.startActivity(new Intent(mContext, ModificationPasswordSucceed.class));
                } else {
                    UIUtils.showToastCommon(mContext,baseBean.getMsg());
                }
            }

            @Override
            public void onError(Throwable e) {

            }
        },mContext));
    }
    /**
     * 身份校验
     * @param smsCode
     * @param validateCode
     * @param mobile
     * @param token
     */
    public void authentication(String smsCode, String validateCode, String mobile,String token){
        invoke(UserModel.getInstance().authentication(smsCode,validateCode,mobile,token),new ProgressSubscriber<BaseBean>(new SubscriberOnNextListener<BaseBean>() {
            @Override
            public void onNext(BaseBean baseBean) {
                if (baseBean.getCode().equals("200")) {
                    mContext.startActivity(new Intent(mContext, ModificationPasswordStep2Activity.class));
                } else {
                    UIUtils.showToastCommon(mContext,baseBean.getMsg());
                }
            }

            @Override
            public void onError(Throwable e) {

            }
        },mContext));
    }
}

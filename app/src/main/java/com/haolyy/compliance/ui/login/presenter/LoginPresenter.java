package com.haolyy.compliance.ui.login.presenter;

import android.content.Context;
import android.content.Intent;

import com.haolyy.compliance.base.ActivityCollector;
import com.haolyy.compliance.base.BaseApplication;
import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.entity.login.LoginResponseBean;
import com.haolyy.compliance.model.UserModel;
import com.haolyy.compliance.ui.MainActivity;
import com.haolyy.compliance.ui.login.view.LoginView;
import com.haolyy.compliance.utils.LogUtils;
import com.haolyy.compliance.utils.UIUtils;
import com.xfqz.xjd.mylibrary.ProgressSubscriber;
import com.xfqz.xjd.mylibrary.SubscriberOnNextListener;


/**
 * Created by niudeyang on 2017/4/25.
 */

public class LoginPresenter extends BasePresenter<LoginView> {

    public LoginPresenter(Context context) {
        super(context);
    }

    public void login(String phone_num, String password) {

        invoke(UserModel.getInstance().login(phone_num, password), new ProgressSubscriber<LoginResponseBean>(new SubscriberOnNextListener<LoginResponseBean>() {
            @Override
            public void onNext(LoginResponseBean loginResponseBean) {
                if (loginResponseBean.getCode().equals("200")) {
                    LogUtils.e("getCode",loginResponseBean.getCode());
                    BaseApplication.mLoginState = true;
                    BaseApplication.userId = loginResponseBean.getModel().getId();
                    BaseApplication.mUserName = loginResponseBean.getModel().getMobile();
                    BaseApplication.juid = loginResponseBean.getModel().getUserCode();
                    ActivityCollector.finishAll();
                   Intent intent = new Intent(mContext, MainActivity.class);
                    mContext.startActivity(intent);
                } else {
                    UIUtils.showToastCommon(mContext, loginResponseBean.getMsg());
                }
            }

            @Override
            public void onError(Throwable e) {

            }
        },mContext));
    }


}

package com.haolyy.compliance.ui.login.presenter;

import android.content.Context;
import android.content.Intent;

import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.entity.login.LoginResponseBean;
import com.haolyy.compliance.model.UserModel;
import com.haolyy.compliance.ui.MainActivity;
import com.haolyy.compliance.ui.login.view.LoginView;
import com.haolyy.compliance.utils.LogUtils;
import com.haolyy.compliance.utils.UIUtils;

import rx.Subscriber;


/**
 * Created by niudeyang on 2017/4/25.
 */

public class LoginPresenter extends BasePresenter<LoginView> {

    public LoginPresenter(Context context) {
        super(context);
    }

    public void login(String phone_num, String password, String loginIp, String version, String platform, String client) {

        invoke(UserModel.getInstance().login(phone_num, password, loginIp, version, platform, client), new Subscriber<LoginResponseBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e("ndyerr", e.getMessage());
            }

            @Override
            public void onNext(LoginResponseBean loginResponseBean) {
                if (loginResponseBean.getStatus().equals("200")) {
                    if (loginResponseBean.getData().getStatus().equals("200")) {
                        UIUtils.showToastCommon(mContext, "登陆成功");
                        mContext.startActivity(new Intent(mContext, MainActivity.class));
                    } else {
                        UIUtils.showToastCommon(mContext, loginResponseBean.getData().getMsg());
                    }
                } else {
                    UIUtils.showToastCommon(mContext, loginResponseBean.getMsg());
                }

            }
        });
    }


}

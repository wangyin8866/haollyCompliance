package com.haolyy.compliance.ui.login.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.entity.ErrorResponse;
import com.haolyy.compliance.entity.login.UserInfoLogin;
import com.haolyy.compliance.model.UserModel;
import com.haolyy.compliance.ui.login.view.LoginView;
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

    public void login(String phone, String pwd, String login_ip) {
//        getToken(LOGIN);

        UserModel.getInstance().login(new ProgressSubscriber<Object>(new SubscriberOnNextListener<Object>() {
            @Override
            public void onNext(Object userInfoLogin) {
                //登录成功刷新ui
                Gson gson=new Gson();
                ErrorResponse errorResponse = gson.fromJson(userInfoLogin.toString(), ErrorResponse.class);
                Log.e("tag",errorResponse.getError_response().getCode());
                getView().refresh();
            }

            @Override
            public void onError(Throwable e) {
                UIUtils.showToastCommon(mContext,"jinlaile");
            }
        }, mContext), phone, pwd, login_ip);
    }
}

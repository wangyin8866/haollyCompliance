package com.haolyy.compliance.ui.login.presenter;

import android.content.Context;
import android.widget.Toast;

import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.entity.login.UserInfoLogin;
import com.haolyy.compliance.model.UserModel;
import com.haolyy.compliance.ui.login.view.LoginView;
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

        UserModel.getInstance().login(new ProgressSubscriber<UserInfoLogin>(new SubscriberOnNextListener<UserInfoLogin>() {
            @Override
            public void onNext(UserInfoLogin userInfoLogin) {
                //登录成功刷新ui
                getView().refresh();
                Toast.makeText(mContext,"1",1).show();
            }

            @Override
            public void onError(Throwable e) {
                //
            }
        }, mContext), phone, pwd, login_ip);
    }
}

package com.haolyy.compliance.ui.login.presenter;

import android.content.Context;

import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.model.UserModel;
import com.haolyy.compliance.ui.login.view.LoginView;
import com.haolyy.compliance.utils.LogUtils;

import rx.Subscriber;


/**
 * Created by niudeyang on 2017/4/25.
 */

public class LoginPresenter extends BasePresenter<LoginView> {

    public LoginPresenter(Context context) {
        super(context);
    }

    public void login(String phone, String pwd) {
//        getToken(LOGIN);

//        UserModel.getInstance().login(new Subscriber<String>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                LogUtils.e("err", e.getMessage());
//            }
//
//            @Override
//            public void onNext(String s) {
//                LogUtils.e("onNext",s);
//            }
//        },"112121","1212121");

        invoke(UserModel.getInstance().getLogin("112121","1212121"),new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e("ndyerr", e.getMessage());
            }

            @Override
            public void onNext(String s) {
                LogUtils.e("ndyonNext",s);
            }
        });
    }



}

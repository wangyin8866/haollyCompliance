package com.haolyy.compliance.ui.forget.presenter;

import android.content.Context;

import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.config.Config;
import com.haolyy.compliance.ui.forget.view.ForgetView;


/**
 * Created by niudeyang on 2017/4/25.
 */

public class ForgetPresenter extends BasePresenter<ForgetView> {
    public ForgetPresenter(Context context) {
        super(context);
    }

    public void login(String phone, String pwd, String valid_code) {
        getToken(Config.LOGIN);

       /* UserModel.getInstance().login(new ProgressSubscriber<UserInfoLogin>(new SubscriberOnNextListener<UserInfoLogin>() {
            @Override
            public void onNext(UserInfoLogin userInfoLogin) {
                //登录成功刷新ui
                getView().refresh();
                //如果token失效
                getToken(LOGIN);
            }

            @Override
            public void onError(Throwable e) {
            //
            }
        },mContext),phone,pwd,valid_code);*/
    }
}

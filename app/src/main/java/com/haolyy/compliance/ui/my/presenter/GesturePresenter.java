package com.haolyy.compliance.ui.my.presenter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.custom.dialog.DialogLoginPassword;
import com.haolyy.compliance.entity.login.LoginResponseBean;
import com.haolyy.compliance.model.UserModel;
import com.haolyy.compliance.ui.my.GestureSettingActivity;
import com.haolyy.compliance.ui.my.view.GestureView;

import rx.Subscriber;


public class GesturePresenter extends BasePresenter<GestureView> {

    public GesturePresenter(Context context) {
        super(context);
    }

    public void checkPassword(String phone_num, final String password, final TextView tips, final DialogLoginPassword dialogLoginPassword) {

        invoke(UserModel.getInstance().login(phone_num, password), new Subscriber<LoginResponseBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(LoginResponseBean loginResponseBean) {
                        if (loginResponseBean.getCode().equals("200")) {
                            tips.setVisibility(View.GONE);
                            dialogLoginPassword.dismiss();
                            Intent intent = new Intent(mContext, GestureSettingActivity.class);
                            intent.putExtra("flag", true);
                            mContext.startActivity(intent);
                        } else {
                            tips.setVisibility(View.VISIBLE);
                            if (loginResponseBean.getCode().equals("1502")) {
                                dialogLoginPassword.setWrongTips("密码错误");
                            }
                            dialogLoginPassword.setWrongTips(loginResponseBean.getMsg());
                        }
                    }
                }
        );
    }

}

package com.haolyy.compliance.ui.my.presenter;

import android.content.Context;
import android.content.Intent;

import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.config.Config;
import com.haolyy.compliance.entity.home.AccountSecurityBean;
import com.haolyy.compliance.entity.home.UserInfoBean;
import com.haolyy.compliance.entity.login.FindUserStatusBean;
import com.haolyy.compliance.model.UserModel;
import com.haolyy.compliance.ui.bank.RebindBankActivity;
import com.haolyy.compliance.ui.my.view.AccountSecurityView;
import com.haolyy.compliance.utils.LogUtils;
import com.xfqz.xjd.mylibrary.ProgressSubscriber;
import com.xfqz.xjd.mylibrary.SubscriberOnNextListener;

/**
 * Created by User on 2017/7/12.
 */

public class AccountSecurityPresenter extends BasePresenter<AccountSecurityView> {

    public AccountSecurityPresenter(Context context) {
        super(context);
    }


    public void getAccountInfo() {
        invoke(UserModel.getInstance().getUserSecurityInfo(), new ProgressSubscriber<AccountSecurityBean>(new SubscriberOnNextListener<AccountSecurityBean>() {
            @Override
            public void onNext(AccountSecurityBean s) {
                if(s.getCode().equals("200")) {
                    getView().showData(s);
                }else {
                    getView().showErrorToast(s.getMsg());
                }

            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e(e.getMessage());

            }
        }, mContext));

    }

    @Override
    public void overwriteSelectUserState(FindUserStatusBean fb, int flag) {
        super.overwriteSelectUserState(fb, flag);
        if(fb.getModel().getModel().getIs_open_account()==0){
            //弹出框
            getView().showErrorToast("");
        }else {
               getView().pushActivity(flag);

        }

    }
}

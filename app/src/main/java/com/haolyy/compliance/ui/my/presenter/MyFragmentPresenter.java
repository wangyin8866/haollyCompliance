package com.haolyy.compliance.ui.my.presenter;

import android.content.Context;
import android.content.Intent;

import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.config.Config;
import com.haolyy.compliance.entity.home.UserInfoBean;
import com.haolyy.compliance.entity.login.FindUserStatusBean;
import com.haolyy.compliance.entity.my.ProductFund;
import com.haolyy.compliance.model.MyModel;
import com.haolyy.compliance.model.UserModel;
import com.haolyy.compliance.ui.bank.CheckBankActivity;
import com.haolyy.compliance.ui.bank.RechargeActivity;
import com.haolyy.compliance.ui.bank.WithDrawActivity;
import com.haolyy.compliance.ui.my.view.MyFragmentView;
import com.haolyy.compliance.utils.LogUtils;
import com.haolyy.compliance.utils.UIUtils;
import com.xfqz.xjd.mylibrary.ProgressSubscriber;
import com.xfqz.xjd.mylibrary.SubscriberOnNextListener;

/**
 * Created by niudeyang on 2017/5/24.
 */

public class MyFragmentPresenter extends BasePresenter<MyFragmentView> {
    public MyFragmentPresenter(Context context) {
        super(context);
    }

    @Override
    public void selectUserState(int flag) {
        super.selectUserState(flag);
    }

    @Override
    public void overwriteSelectUserState(FindUserStatusBean f,int flag) {
        super.overwriteSelectUserState(f,flag);
        if (f.getStatus().equals("200")) {
            if (f.getData().getStatus().equals("200")) {
                if (f.getData().getData().getOpen_account_flag() == 1) {
                     //开过户
                    if(flag== Config.status_with_draw){
                        mContext.startActivity(new Intent(mContext, WithDrawActivity.class));
                    }else if(flag==Config.staus_recharge){
                        mContext.startActivity(new Intent(mContext, RechargeActivity.class));
                    }
                } else {
                   //没开户
                     mContext.startActivity(new Intent(mContext, CheckBankActivity.class));
                }
            }else {
                UIUtils.showToastCommon(mContext, f.getData().getMsg());
            }
        } else {
            UIUtils.showToastCommon(mContext, f.getMsg());
        }
    }


    public void requestUserInfoDetail() {
        invoke(UserModel.getInstance().getUserInfo(), new ProgressSubscriber<UserInfoBean>(new SubscriberOnNextListener<UserInfoBean>() {
            @Override
            public void onNext(UserInfoBean s) {
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

    public void getProductFunds(String platform,String user_id){
        invoke(MyModel.getInstance().getProductFunds(platform,user_id),new ProgressSubscriber<ProductFund>(new SubscriberOnNextListener<ProductFund>() {
            @Override
            public void onNext(ProductFund productFund) {
                getView().getProductFunds(productFund);
            }

            @Override
            public void onError(Throwable e) {

            }
        },mContext));
    }
}

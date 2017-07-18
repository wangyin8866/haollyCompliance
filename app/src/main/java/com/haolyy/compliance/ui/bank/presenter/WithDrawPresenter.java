package com.haolyy.compliance.ui.bank.presenter;

import android.content.Context;

import com.google.gson.Gson;
import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.entity.bank.IsActivateBean;
import com.haolyy.compliance.entity.bank.WithDrawBean;
import com.haolyy.compliance.entity.bank.WithDrawFee;
import com.haolyy.compliance.entity.login.FindUserStatusBean;
import com.haolyy.compliance.entity.login.UserBaseInfoBean;
import com.haolyy.compliance.model.HuifuShModel;
import com.haolyy.compliance.ui.bank.view.WithDrawView;
import com.haolyy.compliance.utils.LogUtils;
import com.haolyy.compliance.utils.UIUtils;
import com.xfqz.xjd.mylibrary.ProgressSubscriber;
import com.xfqz.xjd.mylibrary.SubscriberOnNextListener;

import rx.Subscriber;

/**
 * Created by wangyin on 2017/6/24.
 */

public class WithDrawPresenter extends BasePresenter<WithDrawView> {
    public WithDrawPresenter(Context context) {
        super(context);
    }

    public void withDraw(String cash_serv_fee_,String trans_amt_, String method
    ) {
        invoke(HuifuShModel.getInstance().withDraw(cash_serv_fee_,trans_amt_, method), new ProgressSubscriber<WithDrawBean>(new SubscriberOnNextListener<WithDrawBean>() {
            @Override
            public void onNext(WithDrawBean s) {

                getView().pushActivity(new Gson().toJson(s));
            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e("withDrawonError", e.getMessage());

            }
        }, mContext));

    }

    public void calculateFeeAmount(String type, String amount) {
        invoke(HuifuShModel.getInstance().calculatefeeamount(type, amount), new Subscriber<WithDrawFee>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(WithDrawFee fee) {
                if (fee.getCode().equals("200")) {
                    getView().setFee(fee.getModel().getFee());
                }
            }
        });
    }

    public void getUserBaseInfo() {
        invoke(HuifuShModel.getInstance().getUSerBaseInfo(),new ProgressSubscriber<UserBaseInfoBean>(new SubscriberOnNextListener<UserBaseInfoBean>() {
            @Override
            public void onNext(UserBaseInfoBean userBaseInfoBean) {
                if(userBaseInfoBean.getCode().equals("200")){
                    getView().showCard(userBaseInfoBean);
                }else{
                    UIUtils.showToastCommon(mContext,userBaseInfoBean.getMsg());
                }
            }

            @Override
            public void onError(Throwable e) {

            }
        },mContext));
    }
}

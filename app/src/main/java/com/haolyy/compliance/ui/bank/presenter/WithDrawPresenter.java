package com.haolyy.compliance.ui.bank.presenter;

import android.content.Context;

import com.google.gson.Gson;
import com.haolyy.compliance.base.BaseBean;
import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.entity.bank.IsActivateBean;
import com.haolyy.compliance.entity.bank.IsWithDrawSuccess;
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

    private final HuifuShModel instance;

    public WithDrawPresenter(Context context) {
        super(context);
        instance = HuifuShModel.getInstance();
    }

    public void withDraw(String cash_serv_fee_, String trans_amt_, String method
    ) {
        invoke(instance.withDraw(cash_serv_fee_, trans_amt_, method), new ProgressSubscriber<WithDrawBean>(new SubscriberOnNextListener<WithDrawBean>() {
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
        invoke(instance.calculatefeeamount(type, amount), new Subscriber<WithDrawFee>() {
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
        invoke(instance.getUSerBaseInfo(), new ProgressSubscriber<UserBaseInfoBean>(new SubscriberOnNextListener<UserBaseInfoBean>() {
            @Override
            public void onNext(UserBaseInfoBean userBaseInfoBean) {
                if (userBaseInfoBean.getCode().equals("200")) {
                    getView().showCard(userBaseInfoBean);
                } else {
                    UIUtils.showToastCommon(mContext, userBaseInfoBean.getMsg());
                }
            }

            @Override
            public void onError(Throwable e) {

            }
        }, mContext));
    }

    /**
     * 查询提现是否成功
     */
    public void isWithDrawSuccess() {
        invoke(instance.isWithDrawSuccess(), new ProgressSubscriber<IsWithDrawSuccess>(new SubscriberOnNextListener<IsWithDrawSuccess>() {
            @Override
            public void onNext(IsWithDrawSuccess baseBean) {
                if (baseBean.getCode().equals("200")) {
                    UIUtils.showToastCommon(mContext, baseBean.getModel().getMsg());
                    //000：取现成功443：取现处理中100：取现失败
                    getView().showIsSucess(baseBean.getModel());

                } else {
                    UIUtils.showToastCommon(mContext, baseBean.getMsg());
                }
            }

            @Override
            public void onError(Throwable e) {

            }
        }, mContext));
    }
}

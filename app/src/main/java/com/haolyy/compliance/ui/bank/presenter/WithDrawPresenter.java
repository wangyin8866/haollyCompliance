package com.haolyy.compliance.ui.bank.presenter;

import android.content.Context;

import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.entity.bank.IsActivateBean;
import com.haolyy.compliance.entity.bank.WithDrawFee;
import com.haolyy.compliance.entity.login.FindUserStatusBean;
import com.haolyy.compliance.model.HuifuShModel;
import com.haolyy.compliance.ui.bank.view.WithDrawView;
import com.haolyy.compliance.utils.LogUtils;
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

    public void withDraw(String cash_serv_fee_, String UsrCustId, String trans_amt_, String method
    ) {
        invoke(HuifuShModel.getInstance().withDraw(cash_serv_fee_, UsrCustId, trans_amt_, method), new ProgressSubscriber<String>(new SubscriberOnNextListener<String>() {
            @Override
            public void onNext(String s) {
                LogUtils.e("withDraw", s);
                getView().pushActivity(s);
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
                if (fee.getStatus().equals("200")) {
                    getView().setFee(fee.getData().getFee());
                }
            }
        });
    }

    @Override
    public void overwriteSelectUserState(FindUserStatusBean fb, int flag) {
        super.overwriteSelectUserState(fb, flag);
        getView().showCard(fb);
    }
}

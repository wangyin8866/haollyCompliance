package com.haolyy.compliance.ui.bank.presenter;

import android.content.Context;

import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.entity.bank.RechargeBean;
import com.haolyy.compliance.entity.login.FindUserStatusBean;
import com.haolyy.compliance.entity.login.HuifuSmsBean;
import com.haolyy.compliance.model.HuifuShModel;
import com.haolyy.compliance.ui.bank.view.RechargeView;
import com.haolyy.compliance.utils.LogUtils;
import com.haolyy.compliance.utils.UIUtils;
import com.xfqz.xjd.mylibrary.ProgressSubscriber;
import com.xfqz.xjd.mylibrary.SubscriberOnNextListener;

/**
 * Created by wangyin on 2017/6/24.
 */

public class RechargePresenter extends BasePresenter<RechargeView> {
    public RechargePresenter(Context context) {
        super(context);
    }

    public void recharge(String from_mobile_, String gate_busi_id_, String sms_code_, String sms_seq_, String trans_amt_, String bank_id_
                         ) {
        invoke(HuifuShModel.getInstance().recharge(from_mobile_, gate_busi_id_, sms_code_, sms_seq_, trans_amt_, bank_id_), new ProgressSubscriber<RechargeBean>(new SubscriberOnNextListener<RechargeBean>() {
            @Override
            public void onNext(RechargeBean s) {
                if (s.getStatus().equals("200")) {
                    if (s.getModel().getCode().equals("1")) {
                        getView().showSucess();
                    }else {
                        //充值失败
                        getView().showFail();
                        UIUtils.showToastCommon(mContext, s.getModel().getMsg());
                    }
                } else {
                    UIUtils.showToastCommon(mContext, s.getMsg());
                }
            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e(tag, e.getMessage());
            }
        }, mContext));
    }

    public void sendSms(String busi_type_, String card_number_,String mobile_, String sms_type_) {
        invoke(HuifuShModel.getInstance().sendSms(busi_type_, card_number_,mobile_, sms_type_), new ProgressSubscriber<HuifuSmsBean>(new SubscriberOnNextListener<HuifuSmsBean>() {
            @Override
            public void onNext(HuifuSmsBean s) {
                if (s.getCode().equals("200")) {
                    if (s.getModel().getRespCode().equals("000")) {
                        getView().countDown(s.getModel().getSmsSeq(), false);
                    } else {
                        UIUtils.showToastCommon(mContext, s.getMsg());
                        getView().countDown("", true);
                    }
                } else {
                    UIUtils.showToastCommon(mContext, s.getMsg());
                    getView().countDown("", true);
                }
            }

            @Override
            public void onError(Throwable e) {

            }
        }, mContext));
    }

    @Override
    public void overwriteSelectUserState(FindUserStatusBean fb, int flag) {
        super.overwriteSelectUserState(fb, flag);
        getView().showCard(fb);
    }
}

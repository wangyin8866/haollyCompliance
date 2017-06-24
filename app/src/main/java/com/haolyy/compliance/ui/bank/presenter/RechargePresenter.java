package com.haolyy.compliance.ui.bank.presenter;

import android.content.Context;

import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.model.HuifuShModel2;
import com.haolyy.compliance.ui.bank.view.RechargeView;
import com.haolyy.compliance.utils.LogUtils;
import com.xfqz.xjd.mylibrary.ProgressSubscriber;
import com.xfqz.xjd.mylibrary.SubscriberOnNextListener;

/**
 * Created by wangyin on 2017/6/24.
 */

public class RechargePresenter extends BasePresenter<RechargeView>{
    public RechargePresenter(Context context) {
        super(context);
    }
    public void recharge(String from_mobile_, String gate_busi_id_, String ret_url_, String sms_code_, String sms_seq_, String trans_amt_, String mer_id_,String client_,String version_ ,String juid,String UsrCustId,String bank_id_){
            invoke(HuifuShModel2.getInstance().recharge(from_mobile_,gate_busi_id_,ret_url_,sms_code_,sms_seq_,trans_amt_,mer_id_,client_,version_ ,juid,UsrCustId,bank_id_),new ProgressSubscriber<String>(new SubscriberOnNextListener<String>() {
                @Override
                public void onNext(String s) {
                    LogUtils.e("recharge",s);
                    getView().pushActivity(s);

                }

                @Override
                public void onError(Throwable e) {
                    LogUtils.e("rechargeonError",e.getMessage());
                }
            },mContext));
    }
}

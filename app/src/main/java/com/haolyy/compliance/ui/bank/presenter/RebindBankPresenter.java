package com.haolyy.compliance.ui.bank.presenter;

import android.content.Context;

import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.entity.BaseResponseBean;
import com.haolyy.compliance.entity.login.HuifuSmsBean;
import com.haolyy.compliance.model.HuifuShModel;
import com.haolyy.compliance.ui.bank.view.BankReBindView;
import com.haolyy.compliance.utils.LogUtils;
import com.haolyy.compliance.utils.UIUtils;
import com.xfqz.xjd.mylibrary.ProgressSubscriber;
import com.xfqz.xjd.mylibrary.SubscriberOnNextListener;

import rx.Subscriber;

/**
 * Created by niudeyang on 2017/6/28.
 */

public class RebindBankPresenter extends BasePresenter<BankReBindView> {
    public RebindBankPresenter(Context context) {
        super(context);
    }


    public void sendSms(String busi_type_, String card_number_, String user_cust_id, final String mer_id_, String mobile_, String sms_type_, String client_) {
        invoke(HuifuShModel.getInstance().sendSms(busi_type_, card_number_, user_cust_id, mer_id_, mobile_, sms_type_,client_), new ProgressSubscriber<HuifuSmsBean>(new SubscriberOnNextListener<HuifuSmsBean>() {
            @Override
            public void onNext(HuifuSmsBean s) {
                if (s.getStatus().equals("200")) {
                    if (s.getData().getStatus().equals("000")) {
                        getView().countDown(s.getData().getData().getSmsSeq(),false);
                    } else {
                        UIUtils.showToastCommon(mContext, s.getMsg());
                        getView().countDown("",true);
                    }
                } else {
                    UIUtils.showToastCommon(mContext, s.getMsg());
                    getView().countDown("",true);
                }

            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e(e.getMessage());
            }
        }, mContext));
    }

    /**
     * 换绑定银行卡
     *
     * @param mer_id_
     * @param user_cust_id_
     * @param trade_type_
     * @param bank_code_
     * @param card_number_
     * @param mobile_
     * @param sms_code_
     * @param sms_seq_
     * @param ordsms_ext_
     */
    public void quikBind( String user_cust_id_, String trade_type_, String bank_code_, String card_number_, String mobile_, String sms_code_, String sms_seq_, String ordsms_ext_,String mer_id_,String client,String version) {
        invoke(HuifuShModel.getInstance().quikBind(user_cust_id_, trade_type_, bank_code_, card_number_, mobile_, sms_code_, sms_seq_, ordsms_ext_,mer_id_,client,version),new ProgressSubscriber<BaseResponseBean>(new SubscriberOnNextListener<BaseResponseBean>() {
            @Override
            public void onNext(BaseResponseBean baseResponseBean) {
            }

            @Override
            public void onError(Throwable e) {

            }
        },mContext));

    }
}
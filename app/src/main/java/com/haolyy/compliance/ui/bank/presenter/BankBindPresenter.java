package com.haolyy.compliance.ui.bank.presenter;

import android.content.Context;

import com.google.gson.Gson;
import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.entity.BaseResponseBean;
import com.haolyy.compliance.entity.bank.ToRegisterBean;
import com.haolyy.compliance.entity.login.HuifuSmsBean;
import com.haolyy.compliance.model.HuifuShModel;
import com.haolyy.compliance.ui.bank.view.BankBindView;
import com.haolyy.compliance.utils.LogUtils;
import com.haolyy.compliance.utils.UIUtils;
import com.xfqz.xjd.mylibrary.ProgressSubscriber;
import com.xfqz.xjd.mylibrary.SubscriberOnNextListener;

import rx.Subscriber;

/**
 * Created by niudeyang on 2017/5/24.
 */

public class BankBindPresenter extends BasePresenter<BankBindView> {
    public BankBindPresenter(Context context) {
        super(context);
    }

    public void sendSms(String busi_type_, String card_number_,String mobile_, String sms_type_, final int useType) {
        invoke(HuifuShModel.getInstance().sendSms(busi_type_, card_number_,mobile_, sms_type_), new ProgressSubscriber<HuifuSmsBean>(new SubscriberOnNextListener<HuifuSmsBean>() {
            @Override
            public void onNext(HuifuSmsBean s) {
                if (s.getCode().equals("200")) {
                    if (s.getModel().getRespCode().equals("000")) {
                        if (useType == 0) {
                            //验证码弹框
                            getView().showSmsDialog(s.getModel().getSmsSeq());
                        } else {
                            //验证码重发
                            getView().refreshDialog(s.getModel().getSmsSeq(), false);
                        }
                    } else {
                        UIUtils.showToastCommon(mContext, s.getMsg());
                        getView().refreshDialog("", true);
                    }
                } else {
                    UIUtils.showToastCommon(mContext, s.getMsg());
                    getView().refreshDialog("", true);
                }

            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e(e.getMessage());
            }
        }, mContext));
    }

    /**
     * 开户借口
     * @param moblie_
     * @param from_mobile_
     * @param id_number_
     * @param user_name_
     * @param card_number_
     * @param bank_id_
     * @param sms_code_
     * @param sms_seq_
     * @param PageType
     * @param user_type_
     */
    public void register(String moblie_, String from_mobile_, String id_number_, String user_name_, String card_number_, final String bank_id_,
                         String sms_code_, String sms_seq_, String PageType,String user_type_) {

        invoke(HuifuShModel.getInstance().register(moblie_, from_mobile_, id_number_, user_name_, card_number_, bank_id_, sms_code_, sms_seq_,
                PageType, user_type_), new ProgressSubscriber<ToRegisterBean>(new SubscriberOnNextListener<ToRegisterBean>() {
            @Override
            public void onNext(ToRegisterBean baseResponseBean) {
                if (baseResponseBean.getCode().equals("200")) {
                    getView().pushActivity(new Gson().toJson(baseResponseBean));
                } else {
                    UIUtils.showToastCommon(mContext, baseResponseBean.getMsg());
                }
            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e("Throwable", e.getMessage());
            }
        }, mContext));
    }




}

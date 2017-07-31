package com.haolyy.compliance.ui.bank.presenter;

import android.content.Context;

import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.entity.BaseResponseBean;
import com.haolyy.compliance.entity.bank.QuikBindBean;
import com.haolyy.compliance.entity.login.FindUserStatusBean;
import com.haolyy.compliance.entity.login.HuifuSmsBean;
import com.haolyy.compliance.entity.login.UserBaseInfoBean;
import com.haolyy.compliance.model.HuifuShModel;
import com.haolyy.compliance.ui.bank.view.BankReBindView;
import com.haolyy.compliance.utils.LogUtils;
import com.haolyy.compliance.utils.UIUtils;
import com.xfqz.xjd.mylibrary.ProgressSubscriber;
import com.xfqz.xjd.mylibrary.SubscriberOnNextListener;

/**
 * Created by niudeyang on 2017/6/28.
 */

public class RebindBankPresenter extends BasePresenter<BankReBindView> {

    private HuifuShModel instance;

    public RebindBankPresenter(Context context) {
        super(context);
    }

    @Override
    public void overwriteSelectUserState(FindUserStatusBean fb, int flag) {
        super.overwriteSelectUserState(fb, flag);
    }

    public void sendSms(String busi_type_, String card_number_, String mobile_, String sms_type_) {
        invoke(instance.sendSms(busi_type_, card_number_, mobile_, sms_type_), new ProgressSubscriber<HuifuSmsBean>(new SubscriberOnNextListener<HuifuSmsBean>() {
            @Override
            public void onNext(HuifuSmsBean s) {
                if (s.getCode().equals("200")) {
                    if (s.getModel().getRespCode().equals("000")) {
                        getView().countDown(s.getModel().getSmsSeq(), false);
                    } else {
                        UIUtils.showToastCommon(mContext, s.getModel().getRespDesc());
                        getView().countDown("", true);
                    }
                } else {
                    UIUtils.showToastCommon(mContext, s.getMsg());
                    getView().countDown("", true);
                }

            }

            @Override
            public void onError(Throwable e) {
                getView().countDown("", true);
                LogUtils.e(e.getMessage());
            }
        }, mContext));
    }

    /**
     * 换绑定银行卡
     *
     * @param trade_type_
     * @param bank_code_
     * @param card_number_
     * @param mobile_
     * @param sms_code_
     * @param sms_seq_
     * @param ordsms_ext_
     */
    public void quikBind(String trade_type_, final String bank_code_, String card_number_, final String mobile_, String sms_code_, String sms_seq_, String ordsms_ext_) {
        invoke(instance.quikBind(trade_type_, bank_code_, card_number_, mobile_, sms_code_, sms_seq_, ordsms_ext_), new ProgressSubscriber<QuikBindBean>(new SubscriberOnNextListener<QuikBindBean>() {
            @Override
            public void onNext(QuikBindBean bean) {
                if (bean.getCode().equals("200")) {
                    if (bean.getModel().getRespCode().equals("000")) {
                        getView().showSuccessToast(bean.getModel().getRespDesc());
                    } else {
                        UIUtils.showToastCommon(mContext, bean.getModel().getRespDesc());
                    }
                } else {
                    UIUtils.showToastCommon(mContext, bean.getMsg());
                }

            }

            @Override
            public void onError(Throwable e) {

            }
        }, mContext));

    }

    public void selectUserBaseInfo() {
        instance = HuifuShModel.getInstance();
        invoke(instance.getUSerBaseInfo(), new ProgressSubscriber<UserBaseInfoBean>(new SubscriberOnNextListener<UserBaseInfoBean>() {
            @Override
            public void onNext(UserBaseInfoBean userBaseInfoBean) {
                if (userBaseInfoBean.getCode().equals("200")) {
                    getView().setCardInfo(userBaseInfoBean);
                } else {
                    UIUtils.showToastCommon(mContext, userBaseInfoBean.getMsg());
                }
            }

            @Override
            public void onError(Throwable e) {

            }
        }, mContext));
    }
}

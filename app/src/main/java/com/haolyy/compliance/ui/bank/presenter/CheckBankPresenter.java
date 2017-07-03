package com.haolyy.compliance.ui.bank.presenter;

import android.content.Context;
import android.content.Intent;

import com.google.gson.Gson;
import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.entity.bank.ActivateBean;
import com.haolyy.compliance.entity.bank.IsActivateBean;
import com.haolyy.compliance.model.HuifuShModel;
import com.haolyy.compliance.ui.bank.BankBindActivity;
import com.haolyy.compliance.ui.bank.view.CheckBankView;
import com.haolyy.compliance.utils.UIUtils;
import com.xfqz.xjd.mylibrary.ProgressSubscriber;
import com.xfqz.xjd.mylibrary.SubscriberOnNextListener;

import rx.Observable;

/**
 * Created by niudeyang on 2017/6/30.
 */

public class CheckBankPresenter extends BasePresenter<CheckBankView> {
    public CheckBankPresenter(Context context) {
        super(context);
    }

    public void isBosAcctActivate(final String user_id, String idno, String realname, String user_type, final String mer_id_, String client_) {
        invoke(HuifuShModel.getInstance().isBosAcctActivate(user_id, idno, realname, user_type, mer_id_, client_),
                new ProgressSubscriber<IsActivateBean>(new SubscriberOnNextListener<IsActivateBean>() {
                    @Override
                    public void onNext(IsActivateBean s) {
                        //"type":"1,2"正常开户 3 发短息 4 掉激活接口
                        if (s.getStatus().equals("200")) {
                            String type = s.getData().getType();

                            if (type.equals("1") || type.equals("2")) {
                                 mContext.startActivity(new Intent(mContext, BankBindActivity.class));
                            } else if (type.equals("3")) {
                                //调取发送验证码接口
                            } else if (type.equals("4")) {
                                 activate(user_id,"","1","http://www.chinazyjr.com",mer_id_,"Android","1.0");
                            }
                        } else {
                            UIUtils.showToastCommon(mContext, s.getMsg());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                }, mContext));
    }

    /**
     * 激活接口
     *
     * @param user_id_
     * @param UsrCustId
     * @param PageType
     * @param RetUrl
     * @param mer_id_
     * @param client_
     * @param version_
     */
    public void activate(String user_id_, String UsrCustId, String PageType, String RetUrl, String mer_id_, String client_, String version_) {
        invoke(HuifuShModel.getInstance().activate(user_id_, UsrCustId, PageType, RetUrl, mer_id_, client_, version_), new ProgressSubscriber<ActivateBean>(new SubscriberOnNextListener<ActivateBean>() {
            @Override
            public void onNext(ActivateBean s) {
                if (s.getStatus().equals("200")) {
                    getView().pushActivity(new Gson().toJson(s));
                } else {
                    UIUtils.showToastCommon(mContext, s.getMsg());
                }
            }

            @Override
            public void onError(Throwable e) {

            }
        }, mContext));
    }


}

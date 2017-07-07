package com.haolyy.compliance.ui.bank.presenter;

import android.content.Context;
import android.content.Intent;

import com.google.gson.Gson;
import com.haolyy.compliance.base.ActivityCollector;
import com.haolyy.compliance.base.BaseApplication;
import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.entity.bank.ActivateBean;
import com.haolyy.compliance.entity.bank.IsActivateBean;
import com.haolyy.compliance.entity.login.FindUserStatusBean;
import com.haolyy.compliance.model.HuifuShModel;
import com.haolyy.compliance.ui.bank.BankBindActivity;
import com.haolyy.compliance.ui.bank.CheckBankActivity;
import com.haolyy.compliance.ui.bank.view.CheckBankView;
import com.haolyy.compliance.utils.UIUtils;
import com.xfqz.xjd.mylibrary.ProgressSubscriber;
import com.xfqz.xjd.mylibrary.SubscriberOnNextListener;

/**
 * Created by niudeyang on 2017/6/30.
 */

public class CheckBankPresenter extends BasePresenter<CheckBankView> {
    public CheckBankPresenter(Context context) {
        super(context);
    }

    public void isBosAcctActivate(String idno, String realname, String user_type) {
        invoke(HuifuShModel.getInstance().isBosAcctActivate(idno, realname, user_type),
                new ProgressSubscriber<IsActivateBean>(new SubscriberOnNextListener<IsActivateBean>() {
                    @Override
                    public void onNext(IsActivateBean s) {
                        //"type":"1,2"正常开户 3 发短息 4 掉激活接口
                        if (s.getStatus().equals("200")) {
                            String type = s.getData().getType();
                            if (type.equals("1") || type.equals("2")) {
                                 mContext.startActivity(new Intent(mContext, BankBindActivity.class));
                                ActivityCollector.finishActivity(CheckBankActivity.class);
                            } else if (type.equals("3")) {
                                //直接展示卡
                                getView().showCard(s);
                            } else if (type.equals("4")) {
                                //激活
                               activate("");
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
     * @param PageType
     */
    public void activate( String PageType) {
        invoke(HuifuShModel.getInstance().activate(PageType), new ProgressSubscriber<ActivateBean>(new SubscriberOnNextListener<ActivateBean>() {
            @Override
            public void onNext(ActivateBean s) {
                if (s.getStatus().equals("200")) {
                    getView().pushActivity(new Gson().toJson(s));
                    ActivityCollector.finishActivity(CheckBankActivity.class);
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

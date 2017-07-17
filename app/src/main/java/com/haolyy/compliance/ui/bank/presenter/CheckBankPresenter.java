package com.haolyy.compliance.ui.bank.presenter;

import android.content.Context;
import android.content.Intent;

import com.google.gson.Gson;
import com.haolyy.compliance.base.ActivityCollector;
import com.haolyy.compliance.base.BaseApplication;
import com.haolyy.compliance.base.BaseBean;
import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.config.Config;
import com.haolyy.compliance.entity.bank.ActivateBean;
import com.haolyy.compliance.entity.bank.IsActivateBean;
import com.haolyy.compliance.entity.login.CheckImageCode;
import com.haolyy.compliance.entity.login.FindUserStatusBean;
import com.haolyy.compliance.model.BigThreeModel;
import com.haolyy.compliance.model.HuifuShModel;
import com.haolyy.compliance.model.UserModel;
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
    private String account_platform_no;
    public void isBosAcctActivate(String idno, String realname, String user_type) {
        invoke(HuifuShModel.getInstance().isBosAcctActivate(idno, realname, user_type),
                new ProgressSubscriber<IsActivateBean>(new SubscriberOnNextListener<IsActivateBean>() {



                    @Override
                    public void onNext(IsActivateBean s) {
                        //"type":"1,2"正常开户 3 待激活  5发短息
                        if (s.getCode().equals("200")) {
                            String type = s.getModel().getType();
                            if (type.equals("1") || type.equals("2")) {
                                 mContext.startActivity(new Intent(mContext, BankBindActivity.class));
                                 ActivityCollector.finishActivity(CheckBankActivity.class);
                            } else if (type.equals("5")) {
                                  //发短息之后，直接展示卡,
                                  //getView().showCard(s);
                                  // getView().showSuccessToast();
                                //作业账户编号（老用户的）
                                account_platform_no = s.getModel().getAccount_platform_no();
                                RegisterSMS(s.getModel().getMobile());

                            } else if (type.equals("3")) {
                                BaseApplication.userCustId=s.getModel().getUsrCustId();
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
                if (s.getCode().equals("200")) {
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

    public void RegisterSMS(final String phone){
       invoke(BigThreeModel.getInstance().requestValidateCode(phone,"", Config.SMS_OPERATION_TYPE_REG),new ProgressSubscriber<BaseBean>(new SubscriberOnNextListener<BaseBean>() {
           @Override
           public void onNext(BaseBean baseBean) {
               if (baseBean.getCode().equals("200")){
                   getView().showSuccessToast(phone);
               }
           }

           @Override
           public void onError(Throwable e) {

           }
       },mContext));
    }

    public void validateOldUser(String mobile, String sms) {
        invoke(HuifuShModel.getInstance().validateOldUser(mobile,account_platform_no,sms),new ProgressSubscriber<IsActivateBean>(new SubscriberOnNextListener<IsActivateBean>() {
            @Override
            public void onNext(IsActivateBean isActivateBean) {

            }

            @Override
            public void onError(Throwable e) {

            }
        },mContext));
    }
}

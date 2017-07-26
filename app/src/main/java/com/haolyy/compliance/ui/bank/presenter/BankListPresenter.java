package com.haolyy.compliance.ui.bank.presenter;

import android.content.Context;

import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.base.BaseView;
import com.haolyy.compliance.entity.bank.BankListBean;
import com.haolyy.compliance.model.HuifuShModel;
import com.haolyy.compliance.model.UserModel;
import com.haolyy.compliance.ui.bank.view.BanklistView;
import com.xfqz.xjd.mylibrary.ProgressSubscriber;
import com.xfqz.xjd.mylibrary.SubscriberOnNextListener;

/**
 * Created by niudeyang on 2017/7/26.
 */

public class BankListPresenter extends BasePresenter<BanklistView> {
    public BankListPresenter(Context context) {
        super(context);
    }

    public void getBankList(){
        invoke(UserModel.getInstance().getBankList(),new ProgressSubscriber<BankListBean>(new SubscriberOnNextListener<BankListBean>() {
            @Override
            public void onNext(BankListBean bankListBean) {
                 if(bankListBean.getCode().equals("200")){
                     if(bankListBean.getModel().getCode().equals("200")){
                         getView().showList(bankListBean.getModel().getModel());
                     }
                 }
            }

            @Override
            public void onError(Throwable e) {

            }
        },mContext));
    }
}

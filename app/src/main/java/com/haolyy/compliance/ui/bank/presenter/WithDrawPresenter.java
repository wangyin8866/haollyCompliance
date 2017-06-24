package com.haolyy.compliance.ui.bank.presenter;

import android.content.Context;

import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.model.HuifuShModel2;
import com.haolyy.compliance.ui.bank.view.WithDrawView;
import com.haolyy.compliance.utils.LogUtils;
import com.xfqz.xjd.mylibrary.ProgressSubscriber;
import com.xfqz.xjd.mylibrary.SubscriberOnNextListener;

/**
 * Created by wangyin on 2017/6/24.
 */

public class WithDrawPresenter extends BasePresenter<WithDrawView>{
    public WithDrawPresenter(Context context) {
        super(context);
    }
    public void withDraw(String cash_serv_fee_, String UsrCustId, String from_mobile_, String ret_url_, String trans_amt_, String juid,
                         String mer_id_, String client_, String version_){
        invoke( HuifuShModel2.getInstance().withDraw(cash_serv_fee_,UsrCustId,from_mobile_, ret_url_,trans_amt_, juid, mer_id_,client_,version_),new ProgressSubscriber<String>(new SubscriberOnNextListener<String>() {
            @Override
            public void onNext(String s) {
                LogUtils.e("withDraw", s);
                getView().pushActivity(s);

            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e("withDrawonError", e.getMessage());

            }
        },mContext));

    }
}

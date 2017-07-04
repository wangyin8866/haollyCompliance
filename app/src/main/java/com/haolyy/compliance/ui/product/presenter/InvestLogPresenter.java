package com.haolyy.compliance.ui.product.presenter;

import android.content.Context;

import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.model.ProductModel;
import com.haolyy.compliance.ui.product.view.InvestLogView;
import com.xfqz.xjd.mylibrary.ProgressSubscriber;
import com.xfqz.xjd.mylibrary.SubscriberOnNextListener;

/**
 * Created by wangyin on 2017/7/1.
 */

public class InvestLogPresenter extends BasePresenter<InvestLogView>{
    public InvestLogPresenter(Context context) {
        super(context);
    }
    public void getInvestmentRecord(String projectNo, String pageIndex){
        invoke(ProductModel.getInstance().getInvestmentRecord(projectNo,pageIndex),new ProgressSubscriber<String>(new SubscriberOnNextListener<String>() {
            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable e) {

            }
        },mContext));
    }
}

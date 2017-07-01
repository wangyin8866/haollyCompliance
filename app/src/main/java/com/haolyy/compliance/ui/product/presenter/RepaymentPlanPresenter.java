package com.haolyy.compliance.ui.product.presenter;

import android.content.Context;

import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.model.StringTestModel;
import com.haolyy.compliance.ui.product.view.RepaymentPlanView;
import com.haolyy.compliance.utils.LogUtils;
import com.xfqz.xjd.mylibrary.ProgressSubscriber;
import com.xfqz.xjd.mylibrary.SubscriberOnNextListener;

/**
 * Created by wangyin on 2017/7/1.
 */

public class RepaymentPlanPresenter extends BasePresenter<RepaymentPlanView>{
    public RepaymentPlanPresenter(Context context) {
        super(context);
    }
    public void getProductReturnPlan(String projectNo, String pageIndex,String platform,String client){
        invoke(StringTestModel.getInstance().getProductReturnPlan(projectNo,pageIndex,platform,client),new ProgressSubscriber<String>(new SubscriberOnNextListener<String>() {
            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e("onError", e.getMessage());
            }
        },mContext));
    }
}

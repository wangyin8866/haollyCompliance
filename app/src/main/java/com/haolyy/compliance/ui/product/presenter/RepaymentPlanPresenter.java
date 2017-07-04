package com.haolyy.compliance.ui.product.presenter;

import android.content.Context;

import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.entity.product.RepaymentPlan;
import com.haolyy.compliance.model.ProductModel;
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
    public void getProductReturnPlan(final boolean isLoadMore,String projectNo, String pageIndex){
        invoke(ProductModel.getInstance().getProductReturnPlan(projectNo,pageIndex),new ProgressSubscriber<RepaymentPlan>(new SubscriberOnNextListener<RepaymentPlan>() {
            @Override
            public void onNext(RepaymentPlan s) {
                if (s.getStatus().equals("200")) {
                    if (s.getData().getStatus().equals("200")) {

                        if (isLoadMore) {
                            getView().showGetMoreData(s);
                        } else {
                            getView().showData(s);
                        }

                    } else {
                        getView().showErrorToast(s.getData().getMsg());
                    }
                } else {
                    getView().showErrorToast(s.getMsg());
                }
            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e("onError", e.getMessage());
            }
        },mContext));
    }
}

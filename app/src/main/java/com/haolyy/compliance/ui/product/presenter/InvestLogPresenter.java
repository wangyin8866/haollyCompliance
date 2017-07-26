package com.haolyy.compliance.ui.product.presenter;

import android.content.Context;

import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.entity.product.InvestLog;
import com.haolyy.compliance.model.ProductModel;
import com.haolyy.compliance.ui.product.view.InvestLogView;
import com.haolyy.compliance.utils.LogUtils;
import com.xfqz.xjd.mylibrary.ProgressSubscriber;
import com.xfqz.xjd.mylibrary.SubscriberOnNextListener;

/**
 * Created by wangyin on 2017/7/1.
 */

public class InvestLogPresenter extends BasePresenter<InvestLogView> {
    public InvestLogPresenter(Context context) {
        super(context);
    }

    public void getInvestmentRecord(final boolean isLoadMore, String borrowNid, String pageIndex) {
        invoke(ProductModel.getInstance().getInvestmentRecord(borrowNid, pageIndex), new ProgressSubscriber<InvestLog>(new SubscriberOnNextListener<InvestLog>() {
            @Override
            public void onNext(InvestLog s) {
                if (s.getCode().equals("200")) {
                    if (isLoadMore) {
                        getView().showGetMoreData(s);

                    } else {
                        getView().showData(s);
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e("InvestLogPresenter", e.getMessage());
            }
        }, mContext));
    }
}

package com.haolyy.compliance.ui.my.presenter;

import android.content.Context;

import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.entity.home.AccountSecurityBean;
import com.haolyy.compliance.entity.home.FundStatictisIncomeBean;
import com.haolyy.compliance.entity.home.UserInfoBean;
import com.haolyy.compliance.model.UserModel;
import com.haolyy.compliance.ui.my.view.FundStatictisView;
import com.haolyy.compliance.utils.LogUtils;
import com.xfqz.xjd.mylibrary.ProgressSubscriber;
import com.xfqz.xjd.mylibrary.SubscriberOnNextListener;

/**
 * Created by User on 2017/7/12.
 */

public class FundStatisticsPresenter extends BasePresenter<FundStatictisView> {
    public FundStatisticsPresenter(Context context) {
        super(context);
    }

    public void requestUserIncomeInfo(String platform,String user_id) {
        invoke(UserModel.getInstance().getUserIncomInfo(platform, user_id), new ProgressSubscriber<FundStatictisIncomeBean>(new SubscriberOnNextListener<FundStatictisIncomeBean>() {
            @Override
            public void onNext(FundStatictisIncomeBean s) {
                if(s.getCode().equals("200")) {
                    getView().showData(s);
                }else {
                    getView().showErrorToast(s.getMsg());
                }

            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e(e.getMessage());

            }
        }, mContext));


    }


}

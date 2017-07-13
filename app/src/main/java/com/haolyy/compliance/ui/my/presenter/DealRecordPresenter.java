package com.haolyy.compliance.ui.my.presenter;

import android.content.Context;

import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.model.UserModel;
import com.haolyy.compliance.ui.my.Bean.DealRecordBean;
import com.haolyy.compliance.ui.my.view.DealRecordView;
import com.haolyy.compliance.utils.LogUtils;
import com.xfqz.xjd.mylibrary.ProgressSubscriber;
import com.xfqz.xjd.mylibrary.SubscriberOnNextListener;

/**
 * Created by User on 2017/7/12.
 */

public class DealRecordPresenter  extends BasePresenter<DealRecordView>{
    public DealRecordPresenter(Context context) {
        super(context);
    }


    public void requestDealRecord(String capitalType,String user_id,String pageIndex,String dateFlag) {
        invoke(UserModel.getInstance().getDealRecord(capitalType, user_id,pageIndex,dateFlag), new ProgressSubscriber<DealRecordBean>(new SubscriberOnNextListener<DealRecordBean>() {
            @Override
            public void onNext(DealRecordBean s) {
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

package com.haolyy.compliance.ui.my.presenter;

import android.content.Context;

import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.model.ProductModel;
import com.haolyy.compliance.ui.my.Bean.AssetRatioBean;
import com.haolyy.compliance.ui.my.view.AssetsRatioView;
import com.haolyy.compliance.utils.LogUtils;
import com.xfqz.xjd.mylibrary.ProgressSubscriber;
import com.xfqz.xjd.mylibrary.SubscriberOnNextListener;

/**
 * Created by User on 2017/7/13.
 */

public class AssetsRatioPresenter extends BasePresenter<AssetsRatioView>{

    public AssetsRatioPresenter(Context context) {
        super(context);
    }


    public void requestUserProductInfo(String platform,String user_id) {
        invoke(ProductModel.getInstance().getUserProductInfo(platform, user_id), new ProgressSubscriber<AssetRatioBean>(new SubscriberOnNextListener<AssetRatioBean>() {
            @Override
            public void onNext(AssetRatioBean s) {
                if(s.getCode().equals("200")) {
                    getView().showData(s);
                }else {
//                    getView().showErrorToast(s.getMsg());
                }

            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e(e.getMessage());

            }
        }, mContext));


    }
}

package com.haolyy.compliance.ui.product.presenter;

import android.content.Context;

import com.google.gson.Gson;
import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.entity.home.UserInfoBean;
import com.haolyy.compliance.entity.product.Invest;
import com.haolyy.compliance.model.ProductModel;
import com.haolyy.compliance.model.UserModel;
import com.haolyy.compliance.ui.product.view.ProductSureInvestView;
import com.haolyy.compliance.utils.LogUtils;
import com.xfqz.xjd.mylibrary.ProgressSubscriber;
import com.xfqz.xjd.mylibrary.SubscriberOnNextListener;

/**
 * Created by wangyin on 2017/7/18.
 */

public class ProductSureInvestPresenter extends BasePresenter<ProductSureInvestView> {
    public ProductSureInvestPresenter(Context context) {
        super(context);
    }
    /**
     * 账户中心首页信息
     */

    public void requestUserInfoDetail() {
        invoke(UserModel.getInstance().getUserInfo(), new ProgressSubscriber<UserInfoBean>(new SubscriberOnNextListener<UserInfoBean>() {
            @Override
            public void onNext(UserInfoBean s) {
                if(s.getCode().equals("200")) {
                    getView().showData(s);
                }
            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e(e.getMessage());

            }
        }, mContext));


    }
    public void invest(String projectNo,String userId,String amount,String expectedRevenue,String return_url) {
        invoke(ProductModel.getInstance().invest(projectNo,userId,amount,expectedRevenue,return_url), new ProgressSubscriber<Invest>(new SubscriberOnNextListener<Invest>() {
            @Override
            public void onNext(Invest s) {
                if (s.getCode().equals("200")) {
                    getView().pushActivity(new Gson().toJson(s));
                }
            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e(e.getMessage());

            }
        }, mContext));


    }
}

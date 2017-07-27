package com.haolyy.compliance.ui.product.presenter;

import android.content.Context;

import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.entity.home.UserInfoBean;
import com.haolyy.compliance.entity.login.FindUserStatusBean;
import com.haolyy.compliance.entity.product.Earnings;
import com.haolyy.compliance.entity.product.ProductBaseDetail;
import com.haolyy.compliance.model.ProductModel;
import com.haolyy.compliance.model.UserModel;
import com.haolyy.compliance.ui.product.view.ProductTopView;
import com.haolyy.compliance.utils.AppToast;
import com.haolyy.compliance.utils.LogUtils;
import com.haolyy.compliance.utils.UIUtils;
import com.xfqz.xjd.mylibrary.ProgressSubscriber;
import com.xfqz.xjd.mylibrary.SubscriberOnNextListener;

import rx.Subscriber;

/**
 * Created by wangyin on 2017/6/28.
 */

public class ProductTopPresenter extends BasePresenter<ProductTopView>{

    public ProductTopPresenter(Context context) {
        super(context);
    }
    public void getBaseDetail(String project_no, String juid){
        invoke(ProductModel.getInstance().getBaseDetail(project_no,juid),new ProgressSubscriber<ProductBaseDetail>(new SubscriberOnNextListener<ProductBaseDetail>() {
            @Override
            public void onNext(ProductBaseDetail s) {
                if (s.getCode().equals("200")) {
                    if (s.getModel().getCode().equals("200")) {
                            getView().showData(s);
                    }
                }
            }

            @Override
            public void onError(Throwable e) {

            }
        },mContext));
    }

    @Override
    public void overwriteSelectUserState(FindUserStatusBean baseResponseBean,int flag) {
        getView().getUserState(baseResponseBean);
    }

    public void getEarnings(String amount,String rate,String timeType,String termTime,String borrowType){
        invoke(ProductModel.getInstance().getEarnings(amount, rate, timeType, termTime, borrowType), new Subscriber<Earnings>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Earnings earnings) {
                if (earnings.getCode().equals("200")) {
                    getView().getEarnings(earnings);

                } else {
                    UIUtils.showToastCommon(mContext,earnings.getMsg());
                }
            }
        });
    }

    public void getUserInfo(){
        invoke(UserModel.getInstance().getUserInfo(),new ProgressSubscriber<UserInfoBean>(new SubscriberOnNextListener<UserInfoBean>() {
            @Override
            public void onNext(UserInfoBean userInfoBean) {
                if (userInfoBean.getCode().equals("200")) {
                    if (userInfoBean.getModel().getCode().equals("200")) {
                        getView().showUserInfoData(userInfoBean);
                    } else {
                        AppToast.showShortText(mContext, userInfoBean.getModel().getMsg());
                    }
                } else {
                    AppToast.showShortText(mContext, userInfoBean.getMsg());
                }
            }

            @Override
            public void onError(Throwable e) {
            }
        },mContext));
    }
}

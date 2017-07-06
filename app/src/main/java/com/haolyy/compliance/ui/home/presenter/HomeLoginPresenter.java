package com.haolyy.compliance.ui.home.presenter;

import android.content.Context;

import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.entity.home.Banner;
import com.haolyy.compliance.entity.home.HomeActivity;
import com.haolyy.compliance.entity.home.HomeArticle;
import com.haolyy.compliance.entity.home.HomeProduct;
import com.haolyy.compliance.model.HomeModel;
import com.haolyy.compliance.ui.home.view.HomeLoginView;
import com.xfqz.xjd.mylibrary.ProgressSubscriber;
import com.xfqz.xjd.mylibrary.SubscriberOnNextListener;

/**
 * Created by wangyin on 2017/5/17.
 */

public class HomeLoginPresenter extends BasePresenter<HomeLoginView>{
    public HomeLoginPresenter(Context context) {
        super(context);
    }
    public void getBanner(String type){
        invoke(HomeModel.getInstance().getBanner(type),new ProgressSubscriber<Banner>(new SubscriberOnNextListener<Banner>() {
            @Override
            public void onNext(Banner s) {
                getView().showBannerData(s);
            }

            @Override
            public void onError(Throwable e) {

            }
        },mContext));

    }
    public void getHomeProduct(){
        invoke(HomeModel.getInstance().getHomeProduct(),new ProgressSubscriber<HomeProduct>(new SubscriberOnNextListener<HomeProduct>() {
            @Override
            public void onNext(HomeProduct s) {
                getView().showHomeProductData(s);
            }

            @Override
            public void onError(Throwable e) {

            }
        },mContext));

    }
    public void getHomeArticle(){
        invoke(HomeModel.getInstance().getHomeArticle(),new ProgressSubscriber<HomeArticle>(new SubscriberOnNextListener<HomeArticle>() {
            @Override
            public void onNext(HomeArticle s) {
                getView().showHomeArticleData(s);
            }

            @Override
            public void onError(Throwable e) {

            }
        },mContext));

    }
    public void getRecommend(String userId){
        invoke(HomeModel.getInstance().getRecommend(userId),new ProgressSubscriber<HomeActivity>(new SubscriberOnNextListener<HomeActivity>() {
            @Override
            public void onNext(HomeActivity s) {
                getView().showHomeActivityData(s);
            }
            @Override
            public void onError(Throwable e) {

            }
        },mContext));

    }
}

package com.haolyy.compliance.ui.home.presenter;

import android.content.Context;

import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.entity.home.Banner;
import com.haolyy.compliance.entity.home.HomeActivity;
import com.haolyy.compliance.entity.home.HomeArticle;
import com.haolyy.compliance.entity.home.HomeProduct;
import com.haolyy.compliance.entity.home.UserInfoBean;
import com.haolyy.compliance.model.HomeModel;
import com.haolyy.compliance.model.UserModel;
import com.haolyy.compliance.ui.home.view.HomeLoginView;
import com.haolyy.compliance.utils.LogUtils;
import com.xfqz.xjd.mylibrary.ProgressSubscriber;
import com.xfqz.xjd.mylibrary.SubscriberOnNextListener;

/**
 * Created by wangyin on 2017/5/17.
 */

public class HomeLoginPresenter extends BasePresenter<HomeLoginView> {
    public HomeLoginPresenter(Context context) {
        super(context);
    }

    /**
     * 首页轮播图
     *
     * @param type
     */
    public void getBanner(String type) {
        invoke(HomeModel.getInstance().getBanner(type), new ProgressSubscriber<Banner>(new SubscriberOnNextListener<Banner>() {
            @Override
            public void onNext(Banner s) {
                if (s.getCode().equals("200")) {
                    if (s.getModel().getCode().equals("200")) {
                        getView().showBannerData(s);
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e("getBanner", e.getMessage());
            }
        }, mContext));

    }

    /**
     * 首页产品
     */
    public void getHomeProduct() {
        invoke(HomeModel.getInstance().getHomeProduct(), new ProgressSubscriber<HomeProduct>(new SubscriberOnNextListener<HomeProduct>() {
            @Override
            public void onNext(HomeProduct s) {
                if (s.getCode().equals("200")) {
                    if (s.getModel().getCode().equals("200")) {
                        getView().showHomeProductData(s);

                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e("getHomeProduct", e.getMessage());
            }
        }, mContext));

    }

    /**
     * 首页新闻
     */
    public void getHomeArticle() {
        invoke(HomeModel.getInstance().getHomeArticle(), new ProgressSubscriber<HomeArticle>(new SubscriberOnNextListener<HomeArticle>() {
            @Override
            public void onNext(HomeArticle s) {
                if (s.getCode().equals("200")) {
                    if (s.getModel().getCode().equals("200")) {
                        getView().showHomeArticleData(s);
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e("getHomeArticle", e.getMessage());
            }
        }, mContext));

    }

    /**
     * 首页活动信息
     *
     * @param userId
     */
    public void getRecommend(String userId) {
        invoke(HomeModel.getInstance().getRecommend(userId), new ProgressSubscriber<HomeActivity>(new SubscriberOnNextListener<HomeActivity>() {
            @Override
            public void onNext(HomeActivity s) {
                if (s.getCode().equals("200")) {
                    if (s.getModel().getCode().equals("200")) {
                        getView().showHomeActivityData(s);
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e("getRecommend", e.getMessage());
            }
        }, mContext));

    }
    public void getUserInfo(){
        invoke(UserModel.getInstance().getUserInfo(),new ProgressSubscriber<UserInfoBean>(new SubscriberOnNextListener<UserInfoBean>() {
            @Override
            public void onNext(UserInfoBean userInfoBean) {
                if (userInfoBean.getCode().equals("200")) {
                    if (userInfoBean.getModel().getCode().equals("200")) {
                        LogUtils.e("userInfoBean",userInfoBean.toString());
                        getView().showUserInfoData(userInfoBean);

                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e("userInfoBean",e.getMessage());
            }
        },mContext));
    }
}

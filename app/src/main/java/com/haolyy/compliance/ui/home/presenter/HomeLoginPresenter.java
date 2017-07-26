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
import com.haolyy.compliance.utils.UIUtils;
import com.xfqz.xjd.mylibrary.ProgressSubscriber;
import com.xfqz.xjd.mylibrary.SubscriberOnNextListener;

import rx.Subscriber;

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
        invoke(HomeModel.getInstance().getBanner(type), new Subscriber<Banner>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Banner banner) {
                if (banner.getCode().equals("200")) {
                    if (banner.getModel().getCode().equals("200")) {
                        getView().showBannerData(banner);
                    } else {
                        UIUtils.showToastCommon(mContext, banner
                                .getModel().getMsg());
                    }
                } else {
                    UIUtils.showToastCommon(mContext, banner.getMsg());
                }
            }
        });

    }

    /**
     * 首页产品
     */
    public void getHomeProduct() {
        invoke(HomeModel.getInstance().getHomeProduct(), new ProgressSubscriber<HomeProduct>(new SubscriberOnNextListener<HomeProduct>() {
            @Override
            public void onNext(HomeProduct homeProduct) {
                if (homeProduct.getCode().equals("200")) {
                    if (homeProduct.getModel().getCode().equals("200")) {
                        getView().showHomeProductData(homeProduct);

                    } else {
                        UIUtils.showToastCommon(mContext, homeProduct.getModel().getMsg());
                    }


                } else {
                    UIUtils.showToastCommon(mContext, homeProduct.getMsg());
                }
            }

            @Override
            public void onError(Throwable e) {

            }
        }, mContext));

    }

    /**
     * 首页新闻
     */
    public void getHomeArticle() {
        invoke(HomeModel.getInstance().getHomeArticle(), new Subscriber<HomeArticle>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(HomeArticle homeArticle) {
                if (homeArticle.getCode().equals("200")) {
                    if (homeArticle.getModel().getCode().equals("200")) {
                        getView().showHomeArticleData(homeArticle);
                    } else {
                        UIUtils.showToastCommon(mContext, homeArticle.getModel().getMsg());
                    }
                } else {
                    UIUtils.showToastCommon(mContext,homeArticle.getMsg());
                }
            }
        });

    }

    /**
     * 首页活动信息
     *
     * @param userId
     */
    public void getRecommend(String userId) {
        invoke(HomeModel.getInstance().getRecommend(userId), new Subscriber<HomeActivity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(HomeActivity homeActivity) {
                if (homeActivity.getCode().equals("200")) {
                    if (homeActivity.getModel().getCode().equals("200")) {
                        getView().showHomeActivityData(homeActivity);
                    } else {
                        UIUtils.showToastCommon(mContext, homeActivity.getModel().getMsg());
                    }
                } else {
                    UIUtils.showToastCommon(mContext,homeActivity.getMsg());
                }
            }
        });

    }

    public void getUserInfo() {
        invoke(UserModel.getInstance().getUserInfo(), new Subscriber<UserInfoBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(UserInfoBean userInfoBean) {
                if (userInfoBean.getModel().getCode().equals("200")) {
                    LogUtils.e("userInfoBean", userInfoBean.toString());
                    getView().showUserInfoData(userInfoBean);

                } else {
                    UIUtils.showToastCommon(mContext,userInfoBean.getMsg());
                }
            }
        });
    }
}

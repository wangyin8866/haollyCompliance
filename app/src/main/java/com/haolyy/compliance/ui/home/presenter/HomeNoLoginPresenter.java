package com.haolyy.compliance.ui.home.presenter;

import android.content.Context;

import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.entity.home.Banner;
import com.haolyy.compliance.entity.home.HomeActivity;
import com.haolyy.compliance.model.HomeModel;
import com.haolyy.compliance.ui.home.view.HomeNoLoginView;
import com.haolyy.compliance.utils.LogUtils;
import com.xfqz.xjd.mylibrary.ProgressSubscriber;
import com.xfqz.xjd.mylibrary.SubscriberOnNextListener;

/**
 * Created by wangyin on 2017/5/17.
 */

public class HomeNoLoginPresenter extends BasePresenter<HomeNoLoginView>{
    public HomeNoLoginPresenter(Context context) {
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
}

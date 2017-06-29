package com.haolyy.compliance.ui.home.presenter;

import android.content.Context;

import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.model.HomeModel;
import com.haolyy.compliance.ui.home.view.HomeLoginView;
import com.haolyy.compliance.utils.LogUtils;
import com.xfqz.xjd.mylibrary.ProgressSubscriber;
import com.xfqz.xjd.mylibrary.SubscriberOnNextListener;

/**
 * Created by wangyin on 2017/5/17.
 */

public class HomeLoginPresenter extends BasePresenter<HomeLoginView>{
    public HomeLoginPresenter(Context context) {
        super(context);
    }
    public void getBanner(String type,String platform){
        invoke(HomeModel.getInstance().getBanner(type,platform),new ProgressSubscriber<String>(new SubscriberOnNextListener<String>() {
            @Override
            public void onNext(String s) {
                LogUtils.e("getBanner",s);
            }

            @Override
            public void onError(Throwable e) {

            }
        },mContext));

    }
    public void getHomeProduct(){
        invoke(HomeModel.getInstance().getHomeProduct(),new ProgressSubscriber<String>(new SubscriberOnNextListener<String>() {
            @Override
            public void onNext(String s) {
                LogUtils.e("getHomeProduct",s);
            }

            @Override
            public void onError(Throwable e) {

            }
        },mContext));

    }
    public void getHomeArticle(String platform){
        invoke(HomeModel.getInstance().getHomeArticle(platform),new ProgressSubscriber<String>(new SubscriberOnNextListener<String>() {
            @Override
            public void onNext(String s) {
                LogUtils.e("getHomeArticle",s);
            }

            @Override
            public void onError(Throwable e) {

            }
        },mContext));

    }
    public void getRecommend(String userId,String client){
        invoke(HomeModel.getInstance().getRecommend(userId,client),new ProgressSubscriber<String>(new SubscriberOnNextListener<String>() {
            @Override
            public void onNext(String s) {
                LogUtils.e("getRecommend",s);
            }

            @Override
            public void onError(Throwable e) {

            }
        },mContext));

    }
}

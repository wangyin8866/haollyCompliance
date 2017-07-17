package com.haolyy.compliance.ui.my.presenter;

import android.content.Context;

import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.entity.my.ProductFundList;
import com.haolyy.compliance.entity.product.ProductTitle;
import com.haolyy.compliance.model.MyModel;
import com.haolyy.compliance.model.ProductModel;
import com.haolyy.compliance.ui.my.view.ProductFundView;
import com.xfqz.xjd.mylibrary.ProgressSubscriber;
import com.xfqz.xjd.mylibrary.SubscriberOnNextListener;

/**
 * Created by wangyin on 2017/7/17.
 */

public class ProductFundPresenter extends BasePresenter<ProductFundView> {
    public ProductFundPresenter(Context context) {
        super(context);
    }

    /**
     * 获取菜单信息
     */
    public void getTitle() {
        invoke(ProductModel.getInstance().getTitle(), new ProgressSubscriber<ProductTitle>(new SubscriberOnNextListener<ProductTitle>() {
            @Override
            public void onNext(ProductTitle o) {
                if (o.getCode().equals("200")) {
                    if (o.getModel().getCode().equals("200")) {
                        getView().getTitle(o);
                    }
                }
            }

            @Override
            public void onError(Throwable e) {

            }
        }, mContext));
    }

    /**
     * 用户资产列表
     *
     * @param userId
     * @param platform
     * @param client
     * @param firstCategoryId
     * @param secondCategoryId
     * @param pageIndex
     * @param orderStatus
     */


    public void getAssetManagementList(final boolean isLoadMore,String userId, String platform, String client, String firstCategoryId, String secondCategoryId, String pageIndex, String orderStatus) {
        invoke(MyModel.getInstance().assetManagementList(userId, platform, client, firstCategoryId, secondCategoryId, pageIndex, orderStatus), new ProgressSubscriber<ProductFundList>(new SubscriberOnNextListener<ProductFundList>() {
            @Override
            public void onNext(ProductFundList productFundList) {
                if (productFundList.getCode().equals("200")) {
                    if (productFundList.getModel().getCode().equals("200")) {

                        if (isLoadMore) {
                            getView().showGetMoreData(productFundList);
                        } else {
                            getView().showData(productFundList);
                        }
                    }
                }
            }

            @Override
            public void onError(Throwable e) {

            }
        }, mContext));
    }
}

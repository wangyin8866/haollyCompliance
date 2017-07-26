package com.haolyy.compliance.ui.product.presenter;

import android.content.Context;

import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.entity.product.ProductList;
import com.haolyy.compliance.model.ProductModel;
import com.haolyy.compliance.ui.product.view.ProductListView;
import com.haolyy.compliance.utils.UIUtils;
import com.xfqz.xjd.mylibrary.ProgressSubscriber;
import com.xfqz.xjd.mylibrary.SubscriberOnNextListener;

/**
 * Created by wangyin on 2017/5/18.
 */

public class ProductListPresenter extends BasePresenter<ProductListView> {
    public ProductListPresenter(Context context) {
        super(context);
    }


    public void getProductList(final boolean isLoadMore, String product_category_id, String pageNum) {
        invoke(ProductModel.getInstance().getProductList(product_category_id,pageNum), new ProgressSubscriber<ProductList>(new SubscriberOnNextListener<ProductList>() {
            @Override
            public void onNext(ProductList o) {
                if (o.getCode().equals("200")) {
                    if (o.getModel().getCode().equals("200")) {
                        if (isLoadMore) {
                            getView().showGetMoreData(o);
                        } else {
                            getView().showData(o);
                        }
                    }
                } else {
                    UIUtils.showToastCommon(mContext,o.getMsg());
                }
            }

            @Override
            public void onError(Throwable e) {

            }
        }, mContext));
    }

}

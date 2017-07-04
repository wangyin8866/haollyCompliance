package com.haolyy.compliance.ui.product.presenter;

import android.content.Context;

import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.entity.product.ProductList;
import com.haolyy.compliance.model.ProductModel;
import com.haolyy.compliance.ui.product.view.ProductListView;
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
        invoke(ProductModel.getInstance().getProductList(product_category_id, "", "", "", pageNum), new ProgressSubscriber<ProductList>(new SubscriberOnNextListener<ProductList>() {
            @Override
            public void onNext(ProductList o) {
                if (o.getStatus().equals("200")) {
                    if (o.getData().getStatus().equals("200")) {
                        if (isLoadMore) {
                            getView().showGetMoreData(o);
                        } else {
                            getView().showData(o);
                        }

                    } else {
                        getView().showErrorToast(o.getData().getMsg());
                    }
                } else {
                    getView().showErrorToast(o.getMsg());
                }
            }

            @Override
            public void onError(Throwable e) {

            }
        }, mContext));
    }

    public void getDetail(String id, String juid,String project_type,String product_no){
        invoke(ProductModel.getInstance().getDetail(id,juid,project_type,product_no),new ProgressSubscriber<String>(new SubscriberOnNextListener<String>() {
            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable e) {

            }
        },mContext));
    }
}

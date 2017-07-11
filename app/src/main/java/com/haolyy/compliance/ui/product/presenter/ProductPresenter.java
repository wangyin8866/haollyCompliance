package com.haolyy.compliance.ui.product.presenter;

import android.content.Context;

import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.entity.product.ProductTitle;
import com.haolyy.compliance.model.ProductModel;
import com.haolyy.compliance.ui.product.view.ProductView;
import com.xfqz.xjd.mylibrary.ProgressSubscriber;
import com.xfqz.xjd.mylibrary.SubscriberOnNextListener;

/**
 * Created by wangyin on 2017/5/18.
 */

public class ProductPresenter extends BasePresenter<ProductView> {
    public ProductPresenter(Context context) {
        super(context);
    }

    /**
     * 获取菜单信息
     */
    public void getTitle() {
        invoke(ProductModel.getInstance().getTitle(),new ProgressSubscriber<ProductTitle>(new SubscriberOnNextListener<ProductTitle>() {
            @Override
            public void onNext(ProductTitle o) {
                if (o.getCode().equals("200")) {
                    if (o.getModel().getCode().equals("200")) {
                       getView().showData(o);
                    }
                }
            }

            @Override
            public void onError(Throwable e) {

            }
        },mContext));
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

package com.haolyy.compliance.ui.product.presenter;

import android.content.Context;

import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.entity.login.FindUserStatusBean;
import com.haolyy.compliance.ui.product.view.ProductDetailView;

/**
 * Created by wangyin on 2017/6/28.
 */

public class ProductDetailPresenter extends BasePresenter<ProductDetailView>{

    public ProductDetailPresenter(Context context) {
        super(context);
    }

    @Override
    public void overwriteSelectUserState(FindUserStatusBean baseResponseBean,int flag) {
        getView().getUserState(baseResponseBean);
    }


}

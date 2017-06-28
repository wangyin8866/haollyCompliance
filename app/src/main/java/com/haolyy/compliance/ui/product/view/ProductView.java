package com.haolyy.compliance.ui.product.view;

import com.haolyy.compliance.base.BaseView;
import com.haolyy.compliance.entity.product.ProductTitle;

/**
 * Created by wangyin on 2017/5/18.
 */

public interface ProductView extends BaseView{
    void showData(ProductTitle productTitle);
//    void showGetMoreData(ProductList productList);
}

package com.haolyy.compliance.ui.product.view;

import com.haolyy.compliance.base.BaseView;
import com.haolyy.compliance.entity.product.ProductList;

/**
 * Created by wangyin on 2017/5/18.
 */

public interface ProductListView extends BaseView{
    void showData(ProductList productList);
    void showGetMoreData(ProductList productList);
}

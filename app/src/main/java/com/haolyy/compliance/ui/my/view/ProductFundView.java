package com.haolyy.compliance.ui.my.view;

import com.haolyy.compliance.entity.my.ProductFundList;
import com.haolyy.compliance.entity.product.ProductTitle;

/**
 * Created by wangyin on 2017/7/17.
 */

public interface ProductFundView {
    void getTitle(ProductTitle productTitle);
    void showData(ProductFundList productFundList);

    void showGetMoreData(ProductFundList productFundList);
}

package com.haolyy.compliance.ui.my.view;


import com.haolyy.compliance.base.BaseView;
import com.haolyy.compliance.entity.home.UserInfoBean;
import com.haolyy.compliance.entity.my.ProductFund;

/**
 * Created by niudeyang on 2017/5/24.
 */

public interface MyFragmentView extends BaseView {

    void showData(UserInfoBean userInfoBean);
    void getProductFunds(ProductFund productFund);


}

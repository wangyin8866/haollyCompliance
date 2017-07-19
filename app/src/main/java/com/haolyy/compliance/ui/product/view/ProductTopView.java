package com.haolyy.compliance.ui.product.view;

import com.haolyy.compliance.base.BaseView;
import com.haolyy.compliance.entity.home.UserInfoBean;
import com.haolyy.compliance.entity.login.FindUserStatusBean;
import com.haolyy.compliance.entity.product.Earnings;
import com.haolyy.compliance.entity.product.ProductBaseDetail;

/**
 * Created by niudeyang on 2017/5/17.
 */

public interface ProductTopView extends BaseView{
    void showData(ProductBaseDetail productBaseDetail);
    void getUserState(FindUserStatusBean baseResponseBean);
    void getEarnings(Earnings earnings);
    void showUserInfoData(UserInfoBean userInfoBean);
}

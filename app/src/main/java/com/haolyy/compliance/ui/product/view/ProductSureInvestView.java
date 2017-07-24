package com.haolyy.compliance.ui.product.view;

import com.haolyy.compliance.base.BaseView;
import com.haolyy.compliance.entity.home.UserInfoBean;

/**
 * Created by wangyin on 2017/7/18.
 */

public interface ProductSureInvestView extends BaseView{
    void showData(UserInfoBean userInfoBean);

    void pushActivity(String baseResponseBean);
}

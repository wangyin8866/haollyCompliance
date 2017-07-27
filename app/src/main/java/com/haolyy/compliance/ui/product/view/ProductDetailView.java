package com.haolyy.compliance.ui.product.view;

import com.haolyy.compliance.base.BaseView;
import com.haolyy.compliance.entity.login.FindUserStatusBean;

/**
 * Created by niudeyang on 2017/5/17.
 */

public interface ProductDetailView extends BaseView{
    void getUserState(FindUserStatusBean baseResponseBean);
}

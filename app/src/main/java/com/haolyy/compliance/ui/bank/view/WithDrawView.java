package com.haolyy.compliance.ui.bank.view;

import com.haolyy.compliance.entity.login.FindUserStatusBean;

/**
 * Created by wangyin on 2017/6/24.
 */

public interface WithDrawView {
    void pushActivity(String baseResponseBean);

    void showCard(FindUserStatusBean fb);

    void setFee(double fee);
}

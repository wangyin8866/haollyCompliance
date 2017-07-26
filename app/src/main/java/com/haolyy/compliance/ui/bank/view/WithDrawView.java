package com.haolyy.compliance.ui.bank.view;

import com.haolyy.compliance.entity.bank.IsWithDrawSuccess;
import com.haolyy.compliance.entity.login.FindUserStatusBean;
import com.haolyy.compliance.entity.login.UserBaseInfoBean;

/**
 * Created by wangyin on 2017/6/24.
 */

public interface WithDrawView {
    void pushActivity(String baseResponseBean);

    void showCard(UserBaseInfoBean fb);

    void setFee(double fee);

    void showIsSucess(IsWithDrawSuccess.ModelBean model);
}

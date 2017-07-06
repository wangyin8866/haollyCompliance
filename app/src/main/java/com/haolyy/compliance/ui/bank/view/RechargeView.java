package com.haolyy.compliance.ui.bank.view;

import com.haolyy.compliance.entity.login.FindUserStatusBean;

/**
 * Created by wangyin on 2017/6/24.
 */

public interface RechargeView {
    void pushActivity(String baseResponseBean);

    void countDown(String smsSeq, boolean b);

    void showSucess();

    void showCard(FindUserStatusBean fb);

    void showFail();
}

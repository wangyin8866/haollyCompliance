package com.haolyy.compliance.ui.bank.view;

/**
 * Created by wangyin on 2017/6/24.
 */

public interface RechargeView {
    void pushActivity(String baseResponseBean);

    void countDown(String smsSeq, boolean b);

    void showSucess();
}

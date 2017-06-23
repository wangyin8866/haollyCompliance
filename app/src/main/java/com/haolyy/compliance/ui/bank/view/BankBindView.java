package com.haolyy.compliance.ui.bank.view;


import com.haolyy.compliance.base.BaseView;

/**
 * Created by niudeyang on 2017/5/24.
 */

public interface BankBindView extends BaseView {
    void showSmsDialog(String smsSeq);

    void refreshDialog(String smsSeq);

    void pushActivity(String baseResponseBean);
}

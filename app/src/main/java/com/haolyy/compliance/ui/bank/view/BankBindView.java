package com.haolyy.compliance.ui.bank.view;


import com.haolyy.compliance.base.BaseView;
import com.haolyy.compliance.entity.bank.ToRegisterBean;

/**
 * Created by niudeyang on 2017/5/24.
 */

public interface BankBindView extends BaseView {
    void showSmsDialog(String smsSeq);

    /**
     *
     * @param smsSeq 短信序列号
     * @param b true验证码按钮可点
     */
    void refreshDialog(String smsSeq, boolean b);

    void pushActivity(String baseResponseBean);
}

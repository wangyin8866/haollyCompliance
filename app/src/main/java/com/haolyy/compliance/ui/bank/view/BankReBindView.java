package com.haolyy.compliance.ui.bank.view;

import com.haolyy.compliance.base.BaseView;
import com.haolyy.compliance.entity.login.FindUserStatusBean;
import com.haolyy.compliance.entity.login.UserBaseInfoBean;

/**
 * Created by niudeyang on 2017/6/28.
 */

public interface BankReBindView extends BaseView {
    /**
     *
     * @param smsSeq
     * @param b true短息按钮可点击
     */
    void countDown(String smsSeq, boolean b);

    void setCardInfo(UserBaseInfoBean fb);
}

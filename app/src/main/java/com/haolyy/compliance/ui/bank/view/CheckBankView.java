package com.haolyy.compliance.ui.bank.view;

import com.haolyy.compliance.base.BaseView;
import com.haolyy.compliance.entity.bank.IsActivateBean;
import com.haolyy.compliance.entity.bank.OldUserBean;

/**
 * Created by niudeyang on 2017/6/30.
 */

public interface CheckBankView extends BaseView {
    void pushActivity(String s);

    void showCard(OldUserBean s);
}

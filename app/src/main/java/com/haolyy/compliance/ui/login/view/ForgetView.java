package com.haolyy.compliance.ui.login.view;

/**
 * Created by niudeyang on 2017/4/25.
 */

public interface ForgetView {
    void refresh();//刷新ui

    void showImageCode();

    void getSms(boolean isGetSms);

    void countDown(boolean b);

    void modifyImageCode();
}

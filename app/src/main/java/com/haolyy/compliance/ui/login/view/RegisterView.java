package com.haolyy.compliance.ui.login.view;

/**
 * Created by niudeyang on 2017/4/25.
 */

public interface RegisterView {
    void refresh();//刷新ui

    void skip();

    void getSms(boolean b);

    void showImageCode();

    void countDown(boolean b);

    void modifyImageCode();
}

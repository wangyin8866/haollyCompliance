package com.haolyy.compliance.ui.home;

import android.os.Bundle;
import android.util.Log;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseActivity;
import com.haolyy.compliance.config.Config;
import com.haolyy.compliance.ui.home.presenter.MainPresenter;
import com.haolyy.compliance.ui.home.view.MainView;
import com.haolyy.compliance.utils.UIUtils;

public class MainActivity extends BaseActivity<MainPresenter,MainView> implements MainView {
    private String phone, pwd, valid_code;



    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(mContext);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //登录的方法
        mPresenter.login(phone, pwd, valid_code);
        UIUtils.showToastCommon(mContext,tag);
//        DialogNoTitleDoubleButton dialogNoTitleDoubleButton = new DialogNoTitleDoubleButton(mContext);
//        dialogNoTitleDoubleButton.setContent("ssss").setButtonLeft("").setButtonRight("").setOnDoubleClickListener(new DialogNoTitleDoubleButton.OnDoubleClickListener() {
//            @Override
//            public void excuteLeft() {
//
//            }
//
//            @Override
//            public void excuteRight() {
//
//            }
//        }).show();
    }

    /**
     * 在activity销毁之后可解除订阅
     * 重新获取token后的回调
     * @param s
     */
    @Override
    protected void handleMessage(Integer s) {
        switch (s){
            case Config.LOGIN:
                Log.e(tag,"收到了1001");
                //mPresenter.login(phone, pwd, valid_code);
                break;
            case Config.GETUSERSTATUS:
                break;

        }
    }

    @Override
    public void refresh() {
        //刷新ui
    }

}

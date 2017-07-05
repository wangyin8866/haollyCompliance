package com.haolyy.compliance.ui.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.CheckBox;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseActivity;
import com.haolyy.compliance.custom.ClearEditText;
import com.haolyy.compliance.ui.login.presenter.RegisterPresenter;
import com.haolyy.compliance.ui.login.view.RegisterView;
import com.haolyy.compliance.utils.LogUtils;
import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxCompoundButton;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.functions.Action1;

/**
 * Created by wangyin on 2017/6/21.
 */

public class WyTestActivity extends BaseActivity<RegisterPresenter, RegisterView> implements RegisterView {
    @BindView(R.id.et_phone)
    ClearEditText etPhone;
    @BindView(R.id.textView3)
    TextView textView3;
    @BindView(R.id.cb_register)
    CheckBox cbRegister;


    @Override
    protected RegisterPresenter createPresenter() {
        return new RegisterPresenter(mContext);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        RxCompoundButton.checkedChanges(cbRegister).subscribe(new Action1<Boolean>() {
            @Override
            public void call(Boolean aBoolean) {
                LogUtils.e(aBoolean + "");
                if (aBoolean) {
                    textView3.setEnabled(true);
                } else {
                    textView3.setEnabled(false);
                }
            }
        });
        RxView.clicks(textView3).throttleFirst(2, TimeUnit.SECONDS).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                LogUtils.e("aaaa");
            }
        });
    }

    @Override
    protected void handleMessage(Integer s) {

    }

    @Override
    public void refresh() {

    }

    @Override
    public void skip() {

    }

    @Override
    public void getSms(boolean b) {

    }



    @Override
    public void showImageCode() {

    }

    @Override
    public void countDown(boolean b) {

    }

    @Override
    public void modifyImageCode() {

    }

}

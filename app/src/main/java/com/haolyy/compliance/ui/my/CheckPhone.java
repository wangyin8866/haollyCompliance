package com.haolyy.compliance.ui.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseActivity;
import com.haolyy.compliance.custom.TopBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wangyin on 2017/6/9.
 */

public class CheckPhone extends BaseActivity<CheckPhonePresenter,CheckPhoneView> implements CheckPhoneView {
    @BindView(R.id.top_security_check_phone)
    TopBar topSecurityPhone;
    @BindView(R.id.btn_next)
    Button btnNext;
    @BindView(R.id.bind_phone)
    TextView bindPhone;

    @Override
    protected CheckPhonePresenter createPresenter() {
        return new CheckPhonePresenter(mContext);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accout_security_check_phone);
        ButterKnife.bind(this);
        init();

        topSecurityPhone.setOnItemClickListener(new TopBar.OnItemClickListener() {
            @Override
            public void OnLeftButtonClicked() {
                finish();
            }

            @Override
            public void OnRightButtonClicked() {

            }
        });
    }

    @Override
    protected void handleMessage(Integer s) {

    }

    private void init() {
        bindPhone.setText(getIntent().getStringExtra("phone"));

    }

    @OnClick(R.id.btn_next)
    public void onViewClicked() {
        startActivity(new Intent(CheckPhone.this, UpdatePhone.class));
    }

    @Override
    public void countDown(boolean b) {

    }
}

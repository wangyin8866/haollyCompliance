package com.haolyy.compliance.ui.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseApplication;
import com.haolyy.compliance.custom.TopBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wangyin on 2017/6/9.
 */

public class CheckPhone extends AppCompatActivity {
    @BindView(R.id.top_security_check_phone)
    TopBar topSecurityPhone;
    @BindView(R.id.btn_next)
    Button btnNext;
    @BindView(R.id.bind_phone)
    TextView bindPhone;

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

    private void init() {
        bindPhone.setText(BaseApplication.mUserName);

    }

    @OnClick(R.id.btn_next)
    public void onViewClicked() {
        startActivity(new Intent(CheckPhone.this, UpdatePhone.class));
    }
}

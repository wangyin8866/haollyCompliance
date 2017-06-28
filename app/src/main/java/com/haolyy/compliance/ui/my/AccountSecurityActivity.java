package com.haolyy.compliance.ui.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.custom.TopBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class AccountSecurityActivity extends AppCompatActivity {

    @BindView(R.id.security_bind_phone)
    RelativeLayout securityBindPhone;
    @BindView(R.id.top_account_security)
    TopBar topAccountSecurity;
    @BindView(R.id.gesture_layout)
    RelativeLayout gesture_layout;
    @BindView(R.id.tv_bind_card)
    TextView tvBindCard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_security);
        ButterKnife.bind(this);
        topAccountSecurity.setOnItemClickListener(new TopBar.OnItemClickListener() {
            @Override
            public void OnLeftButtonClicked() {
                finish();
            }

            @Override
            public void OnRightButtonClicked() {

            }
        });
    }

    @OnClick({R.id.security_bind_phone, R.id.gesture_layout,R.id.tv_bind_card})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.security_bind_phone:
                startActivity(new Intent(AccountSecurityActivity.this, CheckPhone.class));
                break;
            case R.id.gesture_layout:
                startActivity(new Intent(AccountSecurityActivity.this, GestureManageActivity.class));
                break;
            case R.id.tv_bind_card:
                break;
        }
    }
}



package com.haolyy.compliance.ui.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseActivity;
import com.haolyy.compliance.config.ConstantKey;
import com.haolyy.compliance.custom.TopBar;
import com.haolyy.compliance.entity.home.UserInfoBean;
import com.haolyy.compliance.ui.bank.RebindBankActivity;
import com.haolyy.compliance.ui.my.presenter.AccountSecurityPresenter;
import com.haolyy.compliance.ui.my.view.AccountSecurityView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class AccountSecurityActivity extends BaseActivity<AccountSecurityPresenter,AccountSecurityView> {

    @BindView(R.id.security_bind_phone)
    RelativeLayout securityBindPhone;
    @BindView(R.id.top_account_security)
    TopBar topAccountSecurity;
    @BindView(R.id.gesture_layout)
    RelativeLayout gesture_layout;
    @BindView(R.id.tv_bind_card)
    TextView tvBindCard;

    @BindView(R.id.real_name_status)
    TextView real_name_status;

    @BindView(R.id.mobile)
    TextView mobile;
    @BindView(R.id.risk_assessment)
    TextView risk_assessment;
    @BindView(R.id.transaction_pwd_status)
    TextView transaction_pwd_status;
    @BindView(R.id.login_pwd_status)
    TextView login_pwd_status;
    @BindView(R.id.gesture_pwd_status)
    TextView gesture_pwd_status;
    @BindView(R.id.auto_invest)
    TextView auto_invest;


    private UserInfoBean userInfoBean;

    @Override
    protected AccountSecurityPresenter createPresenter() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_security);
        ButterKnife.bind(this);
        Bundle  bundle = getIntent().getExtras();
        if(bundle != null) {
            userInfoBean = (UserInfoBean) bundle.getSerializable(ConstantKey.USER_INFO_KEY);
        }

        if(userInfoBean != null) {
            showData();
        }

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

    @Override
    protected void handleMessage(Integer s) {

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
                startActivity(new Intent(getApplicationContext(), RebindBankActivity.class));
                break;
        }
    }


    private void showData(){
//        real_name_status.setText(userInfoBean.getModel().getModel().get);


    }





}



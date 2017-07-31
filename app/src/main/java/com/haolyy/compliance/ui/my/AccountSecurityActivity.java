package com.haolyy.compliance.ui.my;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseActivity;
import com.haolyy.compliance.config.Config;
import com.haolyy.compliance.config.ConstantKey;
import com.haolyy.compliance.custom.TopBar;
import com.haolyy.compliance.entity.home.AccountSecurityBean;
import com.haolyy.compliance.entity.home.UserInfoBean;
import com.haolyy.compliance.ui.bank.RebindBankActivity;
import com.haolyy.compliance.ui.my.presenter.AccountSecurityPresenter;
import com.haolyy.compliance.ui.my.view.AccountSecurityView;
import com.haolyy.compliance.utils.SPUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class AccountSecurityActivity extends BaseActivity<AccountSecurityPresenter, AccountSecurityView> implements AccountSecurityView {

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
        return new AccountSecurityPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_security);
        ButterKnife.bind(this);
        mPresenter.getAccountInfo();

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

    @OnClick({R.id.security_bind_phone, R.id.gesture_layout, R.id.tv_bind_card})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.security_bind_phone:
                startActivity(new Intent(AccountSecurityActivity.this, CheckPhone.class));
                break;
            case R.id.gesture_layout://手势密码
                startActivityForResult(new Intent(AccountSecurityActivity.this, GestureManageActivity.class), 100);
                break;
            case R.id.tv_bind_card:
//                mPresenter.selectUserState(Config.status_rebind);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            gesture_pwd_status.setText(TextUtils.isEmpty(SPUtils.getString(this, ConstantKey.GESTURE_KEY, "")) ? "未开启" : "已开启");
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        gesture_pwd_status.setText(TextUtils.isEmpty(SPUtils.getString(this, ConstantKey.GESTURE_KEY, "")) ? "未开启" : "已开启");
    }

    @Override
    public void showData(AccountSecurityBean accountSecurityBean) {
       AccountSecurityBean.ModelBeanX.ModelBean modelBean= accountSecurityBean.getModel().getModel();
        real_name_status.setText(modelBean.getStatus().equals("0") ? "未认证" : modelBean.getReal_name());
        tvBindCard.setText(accountSecurityBean.getModel().getModel().getBind_bank_card_flag().equals("1") ? "已绑定" : "未未绑定");
        mobile.setText(accountSecurityBean.getModel().getModel().getMobile());
        int riskLevel = accountSecurityBean.getModel().getModel().getRisk_level();
        String level = "未设置";
        switch (riskLevel) {
            case 0:
                level = "未设置";
                break;
            case 1:
                level = "低分险";
                break;
            case 2:
                level = "中低风险";
                break;
            case 3:
                level = "中风险";
                break;
            case 4:
                level = "中高风险";
                break;
            case 5:
                level = "高风险";
                break;
        }
        risk_assessment.setText(level);
        transaction_pwd_status.setText(accountSecurityBean.getModel().getModel().getIs_password() == 1 ? "已设置" : "未设置");
        login_pwd_status.setText(accountSecurityBean.getModel().getModel().getSet_login_password_flag().equals("1") ? "已设置" : "未设置");
        auto_invest.setText(accountSecurityBean.getModel().getModel().getIs_auto_tender() == 1 ? "已开启" : "未开启");
        gesture_pwd_status.setText(TextUtils.isEmpty(SPUtils.getString(this, ConstantKey.GESTURE_KEY, "")) ? "未开启" : "已开启");

    }

    @Override
    public void pushActivity(int flag) {
        if (flag == Config.status_rebind) {
            startActivity(new Intent(getApplicationContext(), RebindBankActivity.class));
            finish();
        }
    }

    @Override
    public void showSuccessToast(String msg) {

    }

    @Override
    public void showErrorToast(String msg) {

    }
}



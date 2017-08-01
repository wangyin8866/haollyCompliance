package com.haolyy.compliance.ui.my;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseActivity;
import com.haolyy.compliance.config.ConstantKey;
import com.haolyy.compliance.custom.TopBar;
import com.haolyy.compliance.custom.dialog.DialogBank;
import com.haolyy.compliance.entity.home.AccountSecurityBean;
import com.haolyy.compliance.entity.home.UserInfoBean;
import com.haolyy.compliance.ui.bank.CheckBankActivity;
import com.haolyy.compliance.ui.bank.RebindBankActivity;
import com.haolyy.compliance.ui.my.presenter.AccountSecurityPresenter;
import com.haolyy.compliance.ui.my.view.AccountSecurityView;
import com.haolyy.compliance.utils.AppToast;
import com.haolyy.compliance.utils.LogUtils;
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
    @BindView(R.id.rl_real_name)
    RelativeLayout rlRealName;
    @BindView(R.id.rl_bind_card)
    RelativeLayout rlBindCard;
    @BindView(R.id.rl_transaction_pwd_status)
    RelativeLayout rlTransactionPwdStatus;
    @BindView(R.id.rl_login_pwd_status)
    RelativeLayout rlLoginPwdStatus;
    @BindView(R.id.rl_auto_invest)
    RelativeLayout rlAutoInvest;
    private DialogBank dialogBank;
    private UserInfoBean userInfoBean;
    private AccountSecurityBean.ModelBeanX.ModelBean modelBean;
    private boolean isReal;
    private boolean isBank;
    private boolean isRisk;
    private boolean isPassword;
    private boolean isAutoTender;


    @Override
    protected AccountSecurityPresenter createPresenter() {
        return new AccountSecurityPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_security);
        ButterKnife.bind(this);
        dialogBank = new DialogBank(mContext);
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
    protected void onResume() {
        super.onResume();
        mPresenter.getAccountInfo();
    }

    @Override
    protected void handleMessage(Integer s) {

    }

    @OnClick({R.id.security_bind_phone, R.id.gesture_layout, R.id.rl_bind_card, R.id.rl_real_name, R.id.rl_transaction_pwd_status, R.id.rl_login_pwd_status, R.id.rl_auto_invest})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_real_name://真实姓名
                showRegisterDialog();
                break;
            case R.id.rl_bind_card://银行卡
                if (isBank) {
                    pushActivity();
                } else {
                    showRegisterDialog();
                }
                break;
            case R.id.security_bind_phone://绑定手机
                startActivity(new Intent(AccountSecurityActivity.this, CheckPhone.class));
                break;
            case R.id.rl_transaction_pwd_status://交易密码
                if (isPassword) {
                    //汇付修改
                } else {
                    showRegisterDialog();
                }
                break;
            case R.id.rl_login_pwd_status://登录密码
                break;
            case R.id.gesture_layout://手势密码
                Intent intent = new Intent(AccountSecurityActivity.this, GestureManageActivity.class);
                boolean flag = !TextUtils.isEmpty(SPUtils.getString(this, ConstantKey.GESTURE_KEY, ""));
                intent.putExtra("flag", flag);
                startActivityForResult(intent, 100);
                break;
            case R.id.rl_auto_invest://自动投标
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
         modelBean = accountSecurityBean.getModel().getModel();

        initState();
        initView();


    }

    private void initState() {
        isReal = modelBean.getStatus()==1;
        isBank = modelBean.getBank_card_no()==1;
        isPassword = modelBean.getIs_password() == 1;
        isAutoTender = modelBean.getIs_auto_tender() == 1;
    }

    private void initView() {
        if (isReal) {
            real_name_status.setText(modelBean.getReal_name());
            real_name_status.setCompoundDrawables(null, null, null, null);
            real_name_status.setEnabled(false);
        } else {
            real_name_status.setText("未认证");

        }
        tvBindCard.setText(isBank? "已绑定" : "未绑定");
        LogUtils.e("phone",modelBean.getMobile()+"'");
        mobile.setText(modelBean.getMobile());
        int riskLevel = modelBean.getRisk_level();
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
        transaction_pwd_status.setText(isPassword ? "已设置" : "未设置");
        login_pwd_status.setText(modelBean.getSet_login_password_flag().equals("1") ? "已设置" : "未设置");
        auto_invest.setText(isAutoTender ? "已开启" : "未开启");
        gesture_pwd_status.setText(TextUtils.isEmpty(SPUtils.getString(this, ConstantKey.GESTURE_KEY, "")) ? "未开启" : "已开启");
    }

    public void pushActivity() {
            startActivity(new Intent(getApplicationContext(), RebindBankActivity.class));
            finish();
    }

    @Override
    public void showRegisterDialog() {
        //开户
        dialogBank.setOnDoubleClickListener(new DialogBank.OnDoubleClickListener() {
            @Override
            public void excuteLeft() {

            }

            @Override
            public void excuteRight() {
                startActivity(new Intent(mContext, CheckBankActivity.class));
            }
        }).show();
    }

    @Override
    public void showSuccessToast(String msg) {

    }

    @Override
    public void showErrorToast(String msg) {
        AppToast.makeShortToast(mContext, msg);
    }


}



package com.haolyy.compliance.ui.login;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseActivity;
import com.haolyy.compliance.ui.login.presenter.LoginPresenter;
import com.haolyy.compliance.ui.login.view.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：User on 2017/4/27 14:08
 */
public class LoginActivity extends BaseActivity<LoginPresenter, LoginView> implements LoginView {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.et_account)
    EditText etAccount;
    @BindView(R.id.iv_account_del)
    ImageView ivAccountDel;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.iv_pwd_del)
    ImageView ivPwdDel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @Override
    protected void initView() {
        tvTitle.setText("登录");

    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(mContext);
    }

    @Override
    protected void handleMessage(Integer s) {

    }

    @Override
    public void refresh() {

    }


    @OnClick({R.id.iv_account_del, R.id.iv_pwd_del})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_account_del:
                etAccount.setText("");
                break;
            case R.id.iv_pwd_del:
                etPwd.setText("");
                break;
        }
    }
}

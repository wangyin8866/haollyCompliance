package com.haolyy.compliance.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseActivity;
import com.haolyy.compliance.ui.forget.ForgetActivity;
import com.haolyy.compliance.ui.login.presenter.LoginPresenter;
import com.haolyy.compliance.ui.login.view.LoginView;
import com.haolyy.compliance.ui.register.RegisterActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 登录页面
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
    @BindView(R.id.tv_login)
    TextView tvLogin;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.tv_forget)
    TextView tvForget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tvTitle.setText("登录");

        etAccount.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                String account = etAccount.getText().toString().trim();
                if (hasFocus) {
                    if (!TextUtils.isEmpty(account)) {
                        ivAccountDel.setVisibility(View.VISIBLE);
                    } else {
                        ivAccountDel.setVisibility(View.INVISIBLE);
                    }
                } else {
                    ivAccountDel.setVisibility(View.INVISIBLE);
                }
            }
        });

        etAccount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String account = charSequence.toString();
                if (TextUtils.isEmpty(account)) {
                    ivAccountDel.setVisibility(View.INVISIBLE);
                } else {
                    ivAccountDel.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        etPwd.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                String pwd = etPwd.getText().toString().trim();
                if (hasFocus) {
                    if (!TextUtils.isEmpty(pwd)) {
                        ivPwdDel.setVisibility(View.VISIBLE);
                    } else {
                        ivPwdDel.setVisibility(View.INVISIBLE);
                    }
                } else {
                    ivPwdDel.setVisibility(View.INVISIBLE);
                }
            }
        });

        etPwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String account = charSequence.toString();
                if (TextUtils.isEmpty(account)) {
                    ivPwdDel.setVisibility(View.INVISIBLE);
                } else {
                    ivPwdDel.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
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

    @OnClick({R.id.iv_account_del, R.id.iv_pwd_del, R.id.tv_login, R.id.tv_register,R.id.tv_forget})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.iv_account_del:
                etAccount.setText("");
                break;
            case R.id.iv_pwd_del:
                etPwd.setText("");
                break;
            case R.id.tv_login:
                break;
            case R.id.tv_register:
                intent = new Intent(mContext, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_forget:
                intent = new Intent(mContext, ForgetActivity.class);
                startActivity(intent);
                break;
        }
    }

}

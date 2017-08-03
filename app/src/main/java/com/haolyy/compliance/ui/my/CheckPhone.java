package com.haolyy.compliance.ui.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseActivity;
import com.haolyy.compliance.base.BaseApplication;
import com.haolyy.compliance.custom.TopBar;
import com.haolyy.compliance.utils.UIUtils;
import com.haolyy.compliance.utils.WYUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wangyin on 2017/6/9.
 */

public class CheckPhone extends BaseActivity<CheckPhonePresenter, CheckPhoneView> implements CheckPhoneView {
    @BindView(R.id.top_security_check_phone)
    TopBar topSecurityPhone;
    @BindView(R.id.et_next)
    EditText etNext;
    @BindView(R.id.btn_next)
    TextView btnNext;
    @BindView(R.id.tv_show_pwd)
    ImageView tvShowPwd;


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


    }
   boolean showPwd;
    @OnClick({R.id.btn_next, R.id.tv_show_pwd})
    public void onViewClicked(View v) {
        if (v.getId() == R.id.btn_next) {
            String trim = etNext.getText().toString().trim();
            if (TextUtils.isEmpty(trim) || !WYUtils.checkPass(trim)) {
                UIUtils.showToastCommon(mContext, "密码错误，请重新输入");
                return;
            }
            mPresenter.reBindPhone(1, trim, BaseApplication.mUserName,"", "");
        } else {

            if (showPwd) {
                showPwd = false;
                tvShowPwd.setImageResource(R.mipmap.login_show);
                etNext.setTransformationMethod(PasswordTransformationMethod.getInstance());
                if(!TextUtils.isEmpty(etNext.getText().toString())){
                    etNext.setSelection(etNext.getText().toString().length());
                }
            } else {
                showPwd = true;
                tvShowPwd.setImageResource(R.mipmap.login_unshow);
                etNext.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                if(!TextUtils.isEmpty(etNext.getText().toString())){
                    etNext.setSelection(etNext.getText().toString().length());
                }
            }
        }
    }

    @Override
    public void countDown(boolean b) {

    }

    @Override
    public void pushActivity(int i) {
        finish();
        startActivity(new Intent(mContext, RebindPhoneActivity.class));
    }

    @Override
    public void showImageCode() {

    }
}

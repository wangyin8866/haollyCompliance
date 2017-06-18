package com.haolyy.compliance.ui.login;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseActivity;
import com.haolyy.compliance.base.BaseApplication;
import com.haolyy.compliance.config.NetConstantValues;
import com.haolyy.compliance.custom.ClearEditText;
import com.haolyy.compliance.custom.dialog.DialogSuccess;
import com.haolyy.compliance.ui.login.presenter.RegisterPresenter;
import com.haolyy.compliance.ui.login.view.RegisterView;
import com.haolyy.compliance.utils.CodeUtils;
import com.haolyy.compliance.utils.UIUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 注册页面
 * 作者：User on 2017/4/27 16:54
 */
public class RegisterActivity extends BaseActivity<RegisterPresenter, RegisterView> implements RegisterView {

    @BindView(R.id.iv_finish)
    ImageView ivFinish;
    @BindView(R.id.iv_service)
    ImageView ivService;
    @BindView(R.id.tv_menu)
    TextView tvMenu;
    @BindView(R.id.iv_code)
    ImageView ivCode;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.view_line)
    View viewLine;
    @BindView(R.id.tv_register_sms)
    TextView tvRegisterSms;
    @BindView(R.id.titleBar)
    RelativeLayout titleBar;
    @BindView(R.id.tv_show_pwd)
    ImageView tvShowPwd;
    @BindView(R.id.iv_invite_code)
    ImageView ivInviteCode;
    @BindView(R.id.rl_invite_code)
    RelativeLayout rlInviteCode;
    @BindView(R.id.textView3)
    TextView textView3;
    @BindView(R.id.cb_register)
    CheckBox cbRegister;
    @BindView(R.id.tv_contract_register)
    TextView tvContractRegister;
    @BindView(R.id.et_phone)
    ClearEditText etPhone;
    @BindView(R.id.et_image_code)
    ClearEditText etImageCode;
    @BindView(R.id.et_sms_code)
    ClearEditText etSmsCode;
    @BindView(R.id.et_register_pwd)
    ClearEditText etRegisterPwd;
    @BindView(R.id.et_register_invite)
    ClearEditText etRegisterInvite;
    private String phone;
    private String passWord;
    private String imageCode;
    private String smsCode;
    private String password;
    private boolean showPwd;
    private String regsiterCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        initView();
    }

    public void initView() {
        tvTitle.setText("快速注册");
        viewLine.setVisibility(View.VISIBLE);

        cbRegister.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    textView3.setEnabled(true);
                } else {
                    textView3.setEnabled(false);
                }
            }
        });

        mPresenter.getToken();

//        etImageCode.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if(!hasFocus){
//                    mPresenter.checkImageCode(etImageCode.getText().toString());
//                }
//            }
//        });
    }


    @Override
    protected RegisterPresenter createPresenter() {
        return new RegisterPresenter(mContext);
    }

    @Override
    protected void handleMessage(Integer s) {

    }

    @Override
    public void refresh() {

    }

    @Override
    public void skip() {
        DialogSuccess dialogSuccess = new DialogSuccess(mContext);
        dialogSuccess.show();
        dialogSuccess.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                finish();
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

    }

    @Override
    public void getSms() {
        phone = etPhone.getText().toString();
        imageCode = etImageCode.getText().toString();
        if (TextUtils.isEmpty(phone)) {
            UIUtils.showToastCommon(mContext, "手机号码不能为空");
            return;
        } else if (TextUtils.isEmpty(imageCode)) {
            UIUtils.showToastCommon(mContext, "图形验证码不能为空");
            return;
        }
        mPresenter.sendSms(phone, imageCode, "regist");
    }

    @Override
    public void showImageCode() {
        Glide.with(mContext).load(NetConstantValues.HOST_URL + NetConstantValues.IMAGE_GET + "?token=" + BaseApplication.token).diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true).into(ivCode);
    }

    @OnClick({R.id.iv_code, R.id.textView3, R.id.tv_register_sms, R.id.tv_show_pwd, R.id.tv_contract_register, R.id.iv_finish})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_code:
                Glide.with(mContext).load(NetConstantValues.HOST_URL + NetConstantValues.IMAGE_GET + "?token=" + BaseApplication.token).diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true).into(ivCode);
                break;
            case R.id.textView3:
                phone = etPhone.getText().toString();
                passWord = etRegisterPwd.getText().toString();
                imageCode = etImageCode.getText().toString();
                smsCode = etSmsCode.getText().toString();
                passWord = etRegisterPwd.getText().toString();
                regsiterCode = etRegisterInvite.getText().toString();
                if (TextUtils.isEmpty(phone)) {
                    UIUtils.showToastCommon(mContext, "手机号码不能为空");
                    return;
                } else if (TextUtils.isEmpty(imageCode)) {
                    UIUtils.showToastCommon(mContext, "图形验证码不能为空");
                    return;
                } else if (TextUtils.isEmpty(smsCode)) {
                    UIUtils.showToastCommon(mContext, "短信验证码不能为空");
                    return;
                } else if (TextUtils.isEmpty(passWord)) {
                    UIUtils.showToastCommon(mContext, "密码不能为空");
                    return;
                } else if (TextUtils.isEmpty(regsiterCode)) {
                    regsiterCode = "000";

                }
                mPresenter.register(phone, passWord, smsCode, imageCode, "Android", "haolyy", "1", "1.0", regsiterCode);
                break;
            case R.id.tv_register_sms:
                imageCode = etImageCode.getText().toString();
                if (TextUtils.isEmpty(imageCode)) {
                    UIUtils.showToastCommon(mContext, "图形验证码不能为空");
                } else {
                    mPresenter.checkImageCode(imageCode);
                }
                break;
            case R.id.iv_finish:
                finish();
                break;
            case R.id.tv_show_pwd:
                if (showPwd) {
                    showPwd = false;
                    tvShowPwd.setImageResource(R.mipmap.login_unshow);
                    etRegisterPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    showPwd = true;
                    tvShowPwd.setImageResource(R.mipmap.login_show);
                    etRegisterPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                break;
        }
    }
}

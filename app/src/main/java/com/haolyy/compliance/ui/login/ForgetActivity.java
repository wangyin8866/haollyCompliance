package com.haolyy.compliance.ui.login;

import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseActivity;
import com.haolyy.compliance.base.BaseApplication;
import com.haolyy.compliance.config.Config;
import com.haolyy.compliance.config.NetConstantValues;
import com.haolyy.compliance.custom.ClearEditText;
import com.haolyy.compliance.ui.login.presenter.ForgetPresenter;
import com.haolyy.compliance.ui.login.view.ForgetView;
import com.haolyy.compliance.utils.DateUtil;
import com.haolyy.compliance.utils.UIUtils;
import com.haolyy.compliance.utils.WYUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 忘记密码
 * 作者：User on 2017/4/28 16:11
 */
public class ForgetActivity extends BaseActivity<ForgetPresenter, ForgetView> implements ForgetView {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.view_line)
    View viewLine;
    @BindView(R.id.iv_finish)
    ImageView ivFinish;
    @BindView(R.id.titleBar)
    RelativeLayout titleBar;
    @BindView(R.id.et_forget_account)
    ClearEditText etForgetAccount;
    @BindView(R.id.et_forget_image)
    ClearEditText etForgetImage;
    @BindView(R.id.et_forget_sms)
    ClearEditText etForgetSms;
    @BindView(R.id.tv_send_sms)
    TextView tvSendSms;
    @BindView(R.id.et_forget_pwd)
    ClearEditText etForgetPwd;
    @BindView(R.id.iv_service)
    ImageView ivService;
    @BindView(R.id.tv_menu)
    TextView tvMenu;
    @BindView(R.id.iv_share)
    ImageView ivShare;
    @BindView(R.id.iv_code)
    ImageView ivCode;
    @BindView(R.id.tv_forget_next)
    TextView tvForgetNext;
    @BindView(R.id.iv_show_pwd)
    ImageView ivShowPwd;

    private String phone;
    private String passWord;
    private String imageCode;
    private String smsCode;
    private boolean showPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        viewLine.setVisibility(View.VISIBLE);
        tvTitle.setText("忘记密码");
        mPresenter.getToken();
    }

    @Override
    protected ForgetPresenter createPresenter() {
        return new ForgetPresenter(mContext);
    }

    @Override
    protected void handleMessage(Integer s) {

    }

    @Override
    public void refresh() {

    }

    @Override
    public void showImageCode() {
        Glide.with(mContext).load(NetConstantValues.HOST_URL3 + NetConstantValues.IMAGE_GET + "?token=" + BaseApplication.token).diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true).into(ivCode);
    }

    /**
     * 图形验证码成功之后调用发送短息的接口
     *
     * @param isGetSms true 发送验证码 false 让按钮可点击
     */
    @Override
    public void getSms(boolean isGetSms) {
        if (isGetSms) {
//            phone = etForgetAccount.getText().toString();
//            imageCode = etForgetImage.getText().toString();
//            mPresenter.sendSms(phone, imageCode, "find_login_psd");
        } else {
            tvSendSms.setEnabled(true);
        }
    }

    @Override
    public void countDown(boolean b) {
        if (b) {
            DateUtil.countDown(tvSendSms, "重新发送");
        } else {
           tvSendSms.setEnabled(true);
        }
    }

    /**
     * 图形验证码获取焦点刷新
     */
    @Override
    public void modifyImageCode() {
        etForgetImage.requestFocus();
        etForgetImage.getText().clear();
        Glide.with(mContext).load(NetConstantValues.HOST_URL3 + NetConstantValues.IMAGE_GET + "?token=" + BaseApplication.token).diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true).into(ivCode);
    }

    @OnClick({R.id.iv_code, R.id.tv_send_sms, R.id.tv_forget_next, R.id.iv_finish, R.id.iv_show_pwd})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_code:
                Glide.with(mContext).load(NetConstantValues.HOST_URL3 + NetConstantValues.IMAGE_GET + "?token=" + BaseApplication.token).diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true).into(ivCode);
                break;
            case R.id.tv_send_sms:
                phone = etForgetAccount.getText().toString();
                imageCode = etForgetImage.getText().toString();
                if (TextUtils.isEmpty(phone) || !WYUtils.checkPhone(phone)) {
                    UIUtils.showToastCommon(mContext, Config.TIP_MOBILE);
                    return;
                } else if (TextUtils.isEmpty(imageCode)) {
                    UIUtils.showToastCommon(mContext, Config.TIP_IMAGE);
                    return;
                }
                tvSendSms.setEnabled(false);
                mPresenter.requestValidateCode(phone,imageCode,Config.SMS_TEMPLATE_CODE_HOLYY);
                break;
            case R.id.tv_forget_next:
                phone = etForgetAccount.getText().toString();
                imageCode = etForgetImage.getText().toString();
                passWord = etForgetPwd.getText().toString();
                smsCode = etForgetSms.getText().toString();
                if (TextUtils.isEmpty(phone) || !WYUtils.checkPhone(phone)) {
                    UIUtils.showToastCommon(mContext, Config.TIP_MOBILE);
                    return;
                } else if (TextUtils.isEmpty(imageCode)) {
                    UIUtils.showToastCommon(mContext, Config.TIP_IMAGE);
                    return;
                } else if (TextUtils.isEmpty(smsCode)) {
                    UIUtils.showToastCommon(mContext, Config.TIP_SMS);
                    return;
                } else if (TextUtils.isEmpty(passWord) || !WYUtils.checkPass(passWord)) {
                    UIUtils.showToastCommon(mContext, Config.TIP_PASSS);
                    return;
                }



                mPresenter.forgetPassWord(phone, passWord, smsCode, imageCode);
                break;
            case R.id.iv_show_pwd:
                if (showPwd) {
                    showPwd = false;
                    ivShowPwd.setImageResource(R.mipmap.login_unshow);
                    etForgetPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    showPwd = true;
                    ivShowPwd.setImageResource(R.mipmap.login_show);
                    etForgetPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                break;
            case R.id.iv_finish:
                finish();
                break;
        }
    }
}

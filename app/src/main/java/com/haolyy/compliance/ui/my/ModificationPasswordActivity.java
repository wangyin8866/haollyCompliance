package com.haolyy.compliance.ui.my;

import android.os.Bundle;
import android.text.TextUtils;
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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 修改密码
 * 作者：User on 2017/4/28 16:11
 */
public class ModificationPasswordActivity extends BaseActivity<ForgetPresenter, ForgetView> implements ForgetView {


    @BindView(R.id.iv_finish)
    ImageView ivFinish;
    @BindView(R.id.iv_service)
    ImageView ivService;
    @BindView(R.id.tv_menu)
    TextView tvMenu;
    @BindView(R.id.iv_share)
    ImageView ivShare;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.view_line)
    View viewLine;
    @BindView(R.id.titleBar)
    RelativeLayout titleBar;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.et_forget_image)
    ClearEditText etForgetImage;
    @BindView(R.id.iv_code)
    ImageView ivCode;
    @BindView(R.id.et_forget_sms)
    ClearEditText etForgetSms;
    @BindView(R.id.tv_send_sms)
    TextView tvSendSms;
    @BindView(R.id.tv_next)
    TextView tvNext;
    private String phone;
    private String imageCode;
    private String smsCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modification_password);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        phone = BaseApplication.mUserName;
        viewLine.setVisibility(View.VISIBLE);
        tvTitle.setText("身份验证");
        tvPhone.setText(getIntent().getStringExtra("phone"));

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
        Glide.with(mContext).load(NetConstantValues
                .HOST_URL + NetConstantValues.IMAGE_GET + "?token=" + BaseApplication.token).diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true).into(ivCode);
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
        Glide.with(mContext).load(NetConstantValues.HOST_URL + NetConstantValues.IMAGE_GET + "?token=" + BaseApplication.token).diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true).into(ivCode);
    }

    @OnClick({R.id.iv_code, R.id.tv_send_sms, R.id.tv_next, R.id.iv_finish})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_code:
                etForgetImage.getText().clear();
                Glide.with(mContext).load(NetConstantValues.HOST_URL + NetConstantValues.IMAGE_GET + "?token=" + BaseApplication.token).diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true).into(ivCode);
                break;
            case R.id.tv_send_sms:
                imageCode = etForgetImage.getText().toString();
               if (TextUtils.isEmpty(imageCode)) {
                    UIUtils.showToastCommon(mContext, Config.TIP_IMAGE);
                    return;
                }
                tvSendSms.setEnabled(false);
                mPresenter.requestValidateCode(phone, imageCode);
                break;
            case R.id.tv_next:
                imageCode = etForgetImage.getText().toString();
                smsCode = etForgetSms.getText().toString();
               if (TextUtils.isEmpty(imageCode)) {
                    UIUtils.showToastCommon(mContext, Config.TIP_IMAGE);
                    return;
               } else if (TextUtils.isEmpty(smsCode)) {
                   UIUtils.showToastCommon(mContext, Config.TIP_SMS);
                   return;
               }
               mPresenter.authentication(smsCode,imageCode,BaseApplication.mUserName,BaseApplication.token);
                break;
            case R.id.iv_finish:
                finish();
                break;
        }
    }
}

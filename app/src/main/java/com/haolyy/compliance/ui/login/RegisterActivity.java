package com.haolyy.compliance.ui.login;

import android.graphics.Bitmap;
import android.os.Bundle;
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
import com.haolyy.compliance.config.NetConstantValues;
import com.haolyy.compliance.custom.ClearEditText;
import com.haolyy.compliance.ui.login.presenter.RegisterPresenter;
import com.haolyy.compliance.ui.login.view.RegisterView;
import com.haolyy.compliance.utils.CodeUtils;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        initView();
    }

    public void initView() {
        Bitmap bitmap = CodeUtils.getInstance().createBitmap();
        ivCode.setImageBitmap(bitmap);

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

        etImageCode.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    mPresenter.checkImageCode(etImageCode.getText().toString());
                }
            }
        });
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

    @OnClick({R.id.iv_code, R.id.textView3, R.id.tv_register_sms, R.id.tv_show_pwd, R.id.tv_contract_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_code:
                Glide.with(mContext).load(NetConstantValues.HOST_URL+NetConstantValues.IMAGE_GET).diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true).into(ivCode);
                break;
            case R.id.textView3:
                phone = etPhone.getText().toString();
                passWord = etRegisterPwd.getText().toString();
                mPresenter.register(phone, passWord);
                break;
            case R.id.tv_register_sms:
                phone = etPhone.getText().toString();
                mPresenter.sendSms(phone);
                break;
        }
    }
}

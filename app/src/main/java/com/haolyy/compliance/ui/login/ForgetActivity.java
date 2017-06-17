package com.haolyy.compliance.ui.login;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseActivity;
import com.haolyy.compliance.custom.ClearEditText;
import com.haolyy.compliance.ui.login.presenter.ForgetPresenter;
import com.haolyy.compliance.ui.login.view.ForgetView;

import butterknife.BindView;
import butterknife.ButterKnife;

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
}

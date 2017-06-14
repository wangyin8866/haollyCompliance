package com.haolyy.compliance.ui.login;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseActivity;
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

    @OnClick({R.id.iv_code, R.id.textView3,R.id.tv_register_sms})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_code:
                Bitmap bitmap = CodeUtils.getInstance().createBitmap();
                ivCode.setImageBitmap(bitmap);
                mPresenter.getImageCode();
                break;
            case R.id.textView3:
                mPresenter.register("13821882946", "qwe123");
                break;
            case R.id.tv_register_sms:
              mPresenter.sendSms("13821882946");
                break;
        }
    }
}

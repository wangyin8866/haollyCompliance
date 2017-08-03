package com.haolyy.compliance.ui.my;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseActivity;
import com.haolyy.compliance.base.BaseApplication;
import com.haolyy.compliance.config.Config;
import com.haolyy.compliance.custom.ClearEditText;
import com.haolyy.compliance.ui.login.presenter.ForgetPresenter;
import com.haolyy.compliance.ui.login.view.ForgetView;
import com.haolyy.compliance.utils.UIUtils;
import com.haolyy.compliance.utils.WYUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 修改密码
 * 作者：User on 2017/4/28 16:11
 */
public class ModificationPasswordStep2Activity extends BaseActivity<ForgetPresenter, ForgetView> implements ForgetView {


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
    @BindView(R.id.new_password)
    ClearEditText newPassword;
    @BindView(R.id.sure_password)
    ClearEditText surePassword;
    @BindView(R.id.tv_next)
    TextView tvNext;
    private String password;
    private String secondPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modification_password_step2);
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

    @Override
    public void showImageCode() {
    }

    /**
     * 图形验证码成功之后调用发送短息的接口
     *
     * @param isGetSms true 发送验证码 false 让按钮可点击
     */
    @Override
    public void getSms(boolean isGetSms) {

    }

    @Override
    public void countDown(boolean b) {
    }

    /**
     * 图形验证码获取焦点刷新
     */
    @Override
    public void modifyImageCode() {
    }

    @OnClick({R.id.iv_finish, R.id.tv_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_next:
                password=newPassword.getText().toString().trim();
                secondPassword=surePassword.getText().toString().trim();
                if (TextUtils.isEmpty(password) || !WYUtils.checkPass(password)) {
                    UIUtils.showToastCommon(mContext, Config.TIP_PASSS);
                    return;
                }
                mPresenter.resetPasswordInMore(BaseApplication.userId+"", password, secondPassword);
                break;
            case R.id.iv_finish:
                finish();
                break;
        }
    }
}

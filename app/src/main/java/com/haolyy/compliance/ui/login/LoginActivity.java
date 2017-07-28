package com.haolyy.compliance.ui.login;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseActivity;
import com.haolyy.compliance.config.Config;
import com.haolyy.compliance.custom.ClearEditText;
import com.haolyy.compliance.ui.login.presenter.LoginPresenter;
import com.haolyy.compliance.ui.login.view.LoginView;
import com.haolyy.compliance.utils.UIUtils;
import com.haolyy.compliance.utils.WYUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 登录页面
 * 作者：User on 2017/4/27 14:08
 */
public class LoginActivity extends BaseActivity<LoginPresenter, LoginView> implements LoginView, View.OnTouchListener, GestureDetector.OnGestureListener {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.tv_forget)
    TextView tvForget;
    @BindView(R.id.iv_finish)
    ImageView ivFinish;
    @BindView(R.id.iv_service)
    ImageView ivService;
    @BindView(R.id.tv_menu)
    TextView tvMenu;
    @BindView(R.id.iv_share)
    ImageView ivShare;
    @BindView(R.id.view_line)
    View viewLine;
    @BindView(R.id.titleBar)
    RelativeLayout titleBar;
    @BindView(R.id.et_account)
    ClearEditText etAccount;
    @BindView(R.id.et_pwd)
    ClearEditText etPwd;
    @BindView(R.id.rl_root_login)
    RelativeLayout rlRootLogin;
    private String phone;
    private String pwd;
    private GestureDetector gd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initView();
        initGesture();
    }

    private void initGesture() {
        gd = new GestureDetector((GestureDetector.OnGestureListener) this);
        rlRootLogin.setOnTouchListener(this);
        rlRootLogin.setLongClickable(true);
    }

    private void initView() {
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

    @OnClick({R.id.iv_finish, R.id.tv_login, R.id.tv_register, R.id.tv_forget})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.iv_finish:
                finish();
                break;
            case R.id.tv_login:
                phone = etAccount.getText().toString();
                pwd = etPwd.getText().toString();
                if (TextUtils.isEmpty(phone) || !WYUtils.checkPhone(phone) || TextUtils.isEmpty(pwd) || !WYUtils.checkPass(pwd)) {
                    UIUtils.showToastCommon(mContext, Config.TIP_ALL);
                    return;
                }
                mPresenter.login(phone, pwd);
                break;
            case R.id.tv_register:
                intent = new Intent(mContext, RegisterActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.tv_forget:
                intent = new Intent(mContext, ForgetActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (e1.getX() - e2.getX() > 20 && Math.abs(velocityX) > 0) {
            //切换Activity
            Intent intent = new Intent(mContext, RegisterActivity.class);
            startActivity(intent);
            //startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());5.0转场动画
            overridePendingTransition(R.anim.in_anim, R.anim.out_anim);
        }
        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gd.onTouchEvent(event);
    }
}

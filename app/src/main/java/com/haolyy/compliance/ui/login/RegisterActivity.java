package com.haolyy.compliance.ui.login;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.transition.Slide;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.haolyy.compliance.R;
import com.haolyy.compliance.base.ActivityCollector;
import com.haolyy.compliance.base.BaseActivity;
import com.haolyy.compliance.base.BaseApplication;
import com.haolyy.compliance.config.Config;
import com.haolyy.compliance.config.NetConstantValues;
import com.haolyy.compliance.custom.ClearEditText;
import com.haolyy.compliance.custom.dialog.DialogSuccess;
import com.haolyy.compliance.ui.login.presenter.RegisterPresenter;
import com.haolyy.compliance.ui.login.view.RegisterView;
import com.haolyy.compliance.utils.DateUtil;
import com.haolyy.compliance.utils.LogUtils;
import com.haolyy.compliance.utils.UIUtils;
import com.haolyy.compliance.utils.WYUtils;
import com.liuguangqiang.swipeback.SwipeBackLayout;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 注册页面
 * 作者：User on 2017/4/27 16:54
 */
public class RegisterActivity extends BaseActivity<RegisterPresenter, RegisterView> implements RegisterView, SwipeBackLayout.SwipeBackListener {
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
    @BindView(R.id.ll_invite_code)
    LinearLayout llInviteCode;
    private String phone;
    private String passWord;
    private String imageCode;
    private String smsCode;
    private String password;
    private boolean showPwd, closeInvite;
    private String regsiterCode;

    private SwipeBackLayout swipeBackLayout;
    private ImageView ivShadow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContainer());
        View view = LayoutInflater.from(this).inflate(R.layout.activity_register, null);
        swipeBackLayout.addView(view);
        ButterKnife.bind(this);
        setDragEdge(SwipeBackLayout.DragEdge.LEFT);
        initView();
        //getWindow().setEnterTransition(new Slide(Gravity.RIGHT).setDuration(500));
        //getWindow().setExitTransition(new Slide(Gravity.RIGHT).setDuration(500));5.0转场动画
    }

    private View getContainer() {
        RelativeLayout container = new RelativeLayout(this);
        swipeBackLayout = new SwipeBackLayout(this);
        swipeBackLayout.setOnSwipeBackListener(this);
        ivShadow = new ImageView(this);
        ivShadow.setBackgroundColor(getResources().getColor(R.color.black_p50));
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        container.addView(ivShadow, params);
        container.addView(swipeBackLayout);
        return container;
    }

    public void setDragEdge(SwipeBackLayout.DragEdge dragEdge) {
        swipeBackLayout.setDragEdge(dragEdge);
    }

    public SwipeBackLayout getSwipeBackLayout() {
        return swipeBackLayout;
    }

    @Override
    public void onViewPositionChanged(float fractionAnchor, float fractionScreen) {
        ivShadow.setAlpha(1 - fractionScreen);
    }

    public void initView() {
        tvTitle.setText("快速注册");
        viewLine.setVisibility(View.VISIBLE);
        WYUtils.showSoftPan(etPhone);
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
        cbRegister.setChecked(true);
        textView3.setEnabled(true);
        mPresenter.getToken();
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
    public void showImageCode() {
        Glide.with(mContext).load(NetConstantValues.HOST_URL + NetConstantValues.IMAGE_GET + "?token=" + BaseApplication.token).diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true).into(ivCode);
        LogUtils.e(tag, NetConstantValues.HOST_URL + NetConstantValues.IMAGE_GET + "?token=" + BaseApplication.token);
    }

    /**
     * 短信倒计时
     *
     * @param b
     */
    @Override
    public void countDown(boolean b) {
        if (b) {
            countDown(tvRegisterSms, "重新发送");
        } else {
            tvRegisterSms.setEnabled(true);
        }
    }

    /**
     * 倒计时工具
     *
     * @param tv
     * @param reset
     * @return
     */
    public Subscription countDown(final TextView tv, final String reset) {
        final long[] currentTime = {Config.seconds - 1000};
        tv.setText((Config.seconds - 1000) / 1000 + "s");
        Subscription subscribe = Observable.interval(1, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        unsubscribe();
                        tv.setEnabled(true);

                    }

                    @Override
                    public void onNext(Long aLong) {
                        currentTime[0] -= 1000;
                        if (currentTime[0] < 0) {
                            etImageCode.getText().clear();
                            etImageCode.requestFocus();
                            Glide.with(mContext).load(NetConstantValues.HOST_URL + NetConstantValues.IMAGE_GET + "?token=" + BaseApplication.token).diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true).into(ivCode);
                            tv.setText(reset);
                            tv.setEnabled(true);
                            unsubscribe();
                        } else {
                            tv.setText(currentTime[0] / 1000 + "s");
                        }
                    }
                });
        return subscribe;
    }

    @OnClick({R.id.iv_code, R.id.textView3, R.id.tv_register_sms, R.id.tv_show_pwd, R.id.tv_contract_register, R.id.iv_finish, R.id.ll_invite_code})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_code:
                etImageCode.getText().clear();
                Glide.with(mContext).load(NetConstantValues.HOST_URL + NetConstantValues.IMAGE_GET + "?token=" + BaseApplication.token).diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true).into(ivCode);
                break;
            case R.id.textView3:
                phone = etPhone.getText().toString();
                passWord = etRegisterPwd.getText().toString();
                imageCode = etImageCode.getText().toString();
                smsCode = etSmsCode.getText().toString();
                passWord = etRegisterPwd.getText().toString();
                regsiterCode = etRegisterInvite.getText().toString();
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
                mPresenter.register(phone, passWord, smsCode, imageCode, "1", regsiterCode);
                break;
            case R.id.tv_register_sms:
                etSmsCode.requestFocus();
                phone = etPhone.getText().toString();
                imageCode = etImageCode.getText().toString();
                if (TextUtils.isEmpty(phone) || !WYUtils.checkPhone(phone)) {
                    UIUtils.showToastCommon(mContext, Config.TIP_MOBILE);
                    return;
                } else if (TextUtils.isEmpty(imageCode)) {
                    UIUtils.showToastCommon(mContext, Config.TIP_IMAGE);
                    return;
                } else {
                    tvRegisterSms.setEnabled(false);
                    mPresenter.requestValidateCode(phone, imageCode);
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
            case R.id.ll_invite_code:
                if (closeInvite) {
                    closeInvite = false;
                    etRegisterInvite.setVisibility(View.VISIBLE);
                } else {
                    closeInvite = true;
                    etRegisterInvite.setVisibility(View.GONE);
                }
                break;
        }
    }
}

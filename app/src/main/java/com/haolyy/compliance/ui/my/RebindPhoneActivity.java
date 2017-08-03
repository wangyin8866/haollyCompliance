package com.haolyy.compliance.ui.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseActivity;
import com.haolyy.compliance.base.BaseApplication;
import com.haolyy.compliance.config.Config;
import com.haolyy.compliance.config.NetConstantValues;
import com.haolyy.compliance.custom.TopBar;
import com.haolyy.compliance.utils.UIUtils;
import com.haolyy.compliance.utils.WYUtils;

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
 * Created by wangyin on 2017/6/9.
 */

public class RebindPhoneActivity extends BaseActivity<CheckPhonePresenter, CheckPhoneView> implements CheckPhoneView {
    @BindView(R.id.et_rebind_phone)
    EditText etRebindPhone;
    @BindView(R.id.et_rebind_img)
    EditText etRebindImg;
    @BindView(R.id.iv_code)
    ImageView ivCode;
    @BindView(R.id.et_rebind_sms)
    EditText etRebindSms;
    @BindView(R.id.tv_rebind_sms)
    TextView tvRebindSms;
    @BindView(R.id.btn_rebind_next)
    TextView btnRebindNext;
    @BindView(R.id.tv_success_amount)
    TextView tvSuccessAmount;
    @BindView(R.id.tv_go_security)
    TextView tvGoSecurity;
    @BindView(R.id.ll_rebind_success)
    LinearLayout llRebindSuccess;
    @BindView(R.id.top_rebind_phone)
    TopBar topRebindPhone;
    @BindView(R.id.ll_rebind_phone)
    LinearLayout llRebindPhone;


    @Override
    protected CheckPhonePresenter createPresenter() {
        return new CheckPhonePresenter(mContext);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rebind_phone);
        ButterKnife.bind(this);
        mPresenter.getToken();

        topRebindPhone.setOnItemClickListener(new TopBar.OnItemClickListener() {
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

    @OnClick({R.id.btn_rebind_next, R.id.iv_code, R.id.tv_rebind_sms, R.id.tv_go_security})
    public void onViewClicked(View v) {
        if (v.getId() == R.id.iv_code) {
            etRebindImg.getText().clear();
            Glide.with(mContext).load(NetConstantValues.HOST_URL + NetConstantValues.IMAGE_GET + "?token=" + BaseApplication.token).diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true).into(ivCode);
        } else if (v.getId() == R.id.tv_rebind_sms) {
            String phone = etRebindPhone.getText().toString();
            String imageCode = etRebindImg.getText().toString();
            if (TextUtils.isEmpty(phone) || !WYUtils.checkPhone(phone)) {
                UIUtils.showToastCommon(mContext, Config.TIP_MOBILE);
                return;
            } else if (TextUtils.isEmpty(imageCode)) {
                UIUtils.showToastCommon(mContext, Config.TIP_IMAGE);
                return;
            } else {
                tvRebindSms.setEnabled(false);
                mPresenter.requestValidateCode(phone, imageCode);
            }
        } else if (v.getId() == R.id.btn_rebind_next) {
            String phone = etRebindPhone.getText().toString();
            String imageCode = etRebindImg.getText().toString();
            String smsCode = etRebindSms.getText().toString();

            if (TextUtils.isEmpty(phone) || !WYUtils.checkPhone(phone)) {
                UIUtils.showToastCommon(mContext, Config.TIP_MOBILE);
                return;
            } else if (TextUtils.isEmpty(imageCode)) {
                UIUtils.showToastCommon(mContext, Config.TIP_IMAGE);
                return;
            } else if (TextUtils.isEmpty(smsCode)) {
                UIUtils.showToastCommon(mContext, Config.TIP_SMS);
                return;
            }
            mPresenter.reBindPhone(2, "",phone, smsCode, imageCode);
        } else if (v.getId() == R.id.tv_go_security) {
            finish();
        }
    }

    @Override
    public void countDown(boolean b) {
        if (b) {
            countDown(tvRebindSms, "重新发送");
        } else {
            tvRebindSms.setEnabled(true);
            etRebindImg.getText().clear();
            etRebindImg.requestFocus();
            Glide.with(mContext).load(NetConstantValues.HOST_URL + NetConstantValues.IMAGE_GET + "?token=" + BaseApplication.token).diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true).into(ivCode);
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
                            etRebindImg.getText().clear();
                            etRebindImg.requestFocus();
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

    @Override
    public void pushActivity(int i) {
        llRebindSuccess.setVisibility(View.VISIBLE);
        llRebindPhone.setVisibility(View.GONE);
    }

    @Override
    public void showImageCode() {
        Glide.with(mContext).load(NetConstantValues.HOST_URL + NetConstantValues.IMAGE_GET + "?token=" + BaseApplication.token).diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true).into(ivCode);
    }
}

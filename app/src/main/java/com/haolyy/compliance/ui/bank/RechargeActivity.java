package com.haolyy.compliance.ui.bank;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseActivity;
import com.haolyy.compliance.entity.bank.RechargeBean;
import com.haolyy.compliance.entity.login.UserBaseInfoBean;
import com.haolyy.compliance.ui.MainActivity;
import com.haolyy.compliance.ui.bank.presenter.RechargePresenter;
import com.haolyy.compliance.ui.bank.view.RechargeView;
import com.haolyy.compliance.utils.DateUtil;
import com.haolyy.compliance.utils.UIUtils;
import com.haolyy.compliance.utils.WYUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class RechargeActivity extends BaseActivity<RechargePresenter, RechargeView> implements RechargeView {
    @BindView(R.id.iv_finish)
    ImageView ivFinish;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_bank_name)
    TextView tvBankName;
    @BindView(R.id.tv_card_type)
    TextView tvCardType;
    @BindView(R.id.tv_card_no)
    TextView tvCardNo;
    @BindView(R.id.tv_limit_account)
    TextView tvLimitAccount;
    @BindView(R.id.btn_recharge)
    TextView btnRecharge;
    @BindView(R.id.tv_recharge_sms)
    TextView tvRechargeSms;
    @BindView(R.id.ll_recharge)
    LinearLayout llRecharge;
    @BindView(R.id.tv_try_again)
    TextView tvTryAgain;
    @BindView(R.id.tv_back_account)
    TextView tvBackAccount;
    @BindView(R.id.ll_recharge_error)
    LinearLayout llRechargeError;
    @BindView(R.id.tv_go_invest)
    TextView tvGoInvest;
    @BindView(R.id.tv_go_account)
    TextView tvGoAccount;
    @BindView(R.id.ll_recharge_success)
    LinearLayout llRechargeSuccess;
    @BindView(R.id.et_recharge_tmt)
    EditText etRechargeTmt;
    @BindView(R.id.et_recharge_phone)
    TextView etRechargePhone;
    @BindView(R.id.et_recharge_sms)
    EditText etRechargeSms;
    @BindView(R.id.tv_success_amount)
    TextView tvSuccessAmount;
    @BindView(R.id.tv_available)
    TextView tvAvailable;
    @BindView(R.id.tv_recharge_error)
    TextView tvRechargeError;
    @BindView(R.id.iv_logo)
    ImageView ivLogo;
    private String smsQue;
    private String phone;
    private String sms;
    private String amt;
    private String cardno;
    private String user_cust_id;
    private String bankId;
    private double availableCredit;

    @Override
    protected RechargePresenter createPresenter() {
        return new RechargePresenter(mContext);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    protected void handleMessage(Integer s) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.getUserBaseInfo();
    }

    private void initView() {
        tvTitle.setText("充值");
        tvLimitAccount.setText(Html.fromHtml("<font color='#b9b9b9'>招商银行 单笔限额</font><font color='#ff9933'>5万元</font><font color='#b9b9b9'>每日限额</font><font color='#ff9933'>5万元</font>"));
        etRechargeTmt.addTextChangedListener(new TextWatcher() {
            String contents;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                contents = s.toString().trim();
            }

            @Override
            public void afterTextChanged(Editable s) {
                //限制输入2位小数
                if (null != contents) {
                    int posDot = contents.indexOf(".");
                    if (posDot <= 0) {
                        return;
                    }
                    if (contents.length() - posDot - 1 > 2) {
                        s.delete(posDot + 3, posDot + 4);
                    }
                }
            }
        });

        etRechargeTmt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    //去除第一位为0的
                    String trim = etRechargeTmt.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim)) {
                        double inputNum = Double.parseDouble(trim);
                        String content = WYUtils.getTwoNumStr(inputNum);
                        etRechargeTmt.setText(content);
                        etRechargeTmt.setSelection(content.length());
                    }
                }
            }
        });
        WYUtils.showSoftPan(etRechargeTmt);
    }

    @OnClick({R.id.iv_finish, R.id.btn_recharge, R.id.tv_recharge_sms, R.id.tv_go_invest, R.id.tv_back_account, R.id.tv_try_again, R.id.tv_go_account})
    public void onViewClicked(View view) {
        amt = etRechargeTmt.getText().toString();
        phone = etRechargePhone.getText().toString();
        switch (view.getId()) {
            case R.id.iv_finish:
                finish();
                break;
            case R.id.tv_recharge_sms:
                if (TextUtils.isEmpty(amt)) {
                    UIUtils.showToastCommon(mContext, "充值金额不能为空");
                    return;
                } else if (TextUtils.isEmpty(phone)) {
                    UIUtils.showToastCommon(mContext, "电话号码不能为空");
                    return;
                }
                mPresenter.sendSms("recharge", cardno, phone, "");
                tvRechargeSms.setEnabled(false);
                break;
            case R.id.btn_recharge:
                sms = etRechargeSms.getText().toString();
                if (TextUtils.isEmpty(amt)) {
                    UIUtils.showToastCommon(mContext, "充值金额不能为空");
                    return;
                } else if (TextUtils.isEmpty(phone)) {
                    UIUtils.showToastCommon(mContext, "电话号码不能为空");
                    return;
                } else if (TextUtils.isEmpty(sms)) {
                    UIUtils.showToastCommon(mContext, "短信验证码不能为空");
                    return;
                }
                mPresenter.recharge(phone, "QP", "666666", "AAAAAAAA", amt, bankId);
                break;
            case R.id.tv_go_invest:
                //去投资
                startActivity(MainActivity.getMainIntent(mContext, 1));
                break;
            case R.id.tv_go_account:
                //去账户中心
                startActivity(MainActivity.getMainIntent(mContext, 3));
                break;
            case R.id.tv_try_again:
                //再试试
                llRechargeError.setVisibility(View.GONE);
                llRecharge.setVisibility(View.VISIBLE);
                break;
            case R.id.tv_back_account:
                //去账户中心
                startActivity(MainActivity.getMainIntent(mContext, 3));
                break;
        }
    }

    @Override
    public void pushActivity(String baseResponseBean) {
        Intent intent = new Intent(mContext, ShBankWebActivity.class);
        intent.setAction(baseResponseBean);
        startActivity(intent);
    }

    @Override
    public void countDown(String smsSeq, boolean b) {
        etRechargeSms.requestFocus();
        smsQue = smsSeq;
        if (b) {
            tvRechargeSms.setEnabled(true);
        } else {
            DateUtil.countDown(tvRechargeSms, "重新发送");
        }
    }


    @Override
    public void showSucess() {

    }

    /**
     * 展示失败页面
     *
     * @param s
     */
    @Override
    public void showFail(RechargeBean s) {
        llRecharge.setVisibility(View.GONE);
        llRechargeError.setVisibility(View.VISIBLE);
        llRechargeSuccess.setVisibility(View.GONE);
        tvRechargeError.setText(s.getModel().getMsg());
    }

    /**
     * 展示成功页面
     */
    @Override
    public void showSucess(String amount_) {
        tvSuccessAmount.setText("您本次充值金额为" + amount_ + "元");
        llRecharge.setVisibility(View.GONE);
        llRechargeError.setVisibility(View.GONE);
        llRechargeSuccess.setVisibility(View.VISIBLE);
    }

    /**
     * 展示银行卡
     *
     * @param fb
     */
    @Override
    public void showCard(UserBaseInfoBean fb) {
        bankId = fb.getModel().getBankNo();
        cardno = fb.getModel().getBankCardNo();
        availableCredit = fb.getModel().getAvailableCredit();
        tvAvailable.setText(availableCredit + "");
        tvBankName.setText(fb.getModel().getBankName());
        tvCardNo.setText(cardno);
        Glide.with(mContext).load(fb.getModel().getMapUrl()).into(ivLogo);
        etRechargePhone.setText(fb.getModel().getMobile());
        etRechargePhone.setEnabled(false);
        tvLimitAccount.setText(Html.fromHtml("<font color='#4a4a4a'>" + fb.getModel().getBankName() + "单笔限额</font><font color='#ff9933'>" + fb.getModel().getLimitSingle() + "</font><font color='#4a4a4a4a'>元,每日限额</font><font color='#ff9933'>" + fb.getModel().getLimitDay() + "</font><font color='#4a4a4a'>元</font>"));
    }


}

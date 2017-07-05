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

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseActivity;
import com.haolyy.compliance.entity.login.FindUserStatusBean;
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
    EditText etRechargePhone;
    @BindView(R.id.et_recharge_sms)
    EditText etRechargeSms;
    private String smsQue;
    private String phone;
    private String sms;
    private String amt;
    private String cardno;
    private String user_cust_id;
    private String bankId;

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

    private void initView() {
        tvTitle.setText("充值");
        mPresenter.selectUserState(-1);
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
    }

    @OnClick({R.id.iv_finish, R.id.btn_recharge, R.id.tv_recharge_sms})
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
                mPresenter.sendSms("recharge", cardno, user_cust_id, phone, "");
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
                mPresenter.recharge(phone, "QP", "666666", "AAAAAAAA", amt, bankId, user_cust_id);
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
        smsQue = smsSeq;
        if (b) {
            tvRechargeSms.setEnabled(true);
        } else {
            DateUtil.countDown(tvRechargeSms, "重新发送");
        }
    }

    /**
     * 展示成功页面
     */
    @Override
    public void showSucess() {
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
    public void showCard(FindUserStatusBean fb) {
        bankId = fb.getData().getData().getBank_no();
        cardno = fb.getData().getData().getBank_card_no();
        user_cust_id = fb.getData().getData().getThird_user_id();
    }
}

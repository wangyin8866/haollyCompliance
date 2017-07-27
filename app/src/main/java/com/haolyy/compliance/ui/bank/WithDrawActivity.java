package com.haolyy.compliance.ui.bank;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseActivity;
import com.haolyy.compliance.custom.dialog.WithDrawPopupWindow;
import com.haolyy.compliance.entity.bank.IsWithDrawSuccess;
import com.haolyy.compliance.entity.login.UserBaseInfoBean;
import com.haolyy.compliance.ui.MainActivity;
import com.haolyy.compliance.ui.bank.presenter.WithDrawPresenter;
import com.haolyy.compliance.ui.bank.view.WithDrawView;
import com.haolyy.compliance.utils.LogUtils;
import com.haolyy.compliance.utils.UIUtils;
import com.haolyy.compliance.utils.WYUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class WithDrawActivity extends BaseActivity<WithDrawPresenter, WithDrawView> implements WithDrawView {
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
    @BindView(R.id.btn_withdraw)
    TextView btnWithdraw;
    @BindView(R.id.tv_total_withdraw)
    TextView tvTotalWithdraw;
    @BindView(R.id.tv_withdraw_quan)
    TextView tvWithdrawQuan;
    private static WithDrawPopupWindow menuWindow;
    @BindView(R.id.tv_withdraw_way)
    TextView tvWithdrawWay;
    @BindView(R.id.view_line)
    View viewLine;
    @BindView(R.id.et_with_draw)
    EditText etWithDraw;
    @BindView(R.id.tv_cash_fee)
    TextView tvCashFee;
    @BindView(R.id.tv_actual)
    TextView tvActual;
    @BindView(R.id.titleBar)
    RelativeLayout titleBar;
    @BindView(R.id.tv_available)
    TextView tvAvailable;
    @BindView(R.id.tv_back_account)
    TextView tvBackAccount;
    @BindView(R.id.ll_withdraw_error)
    LinearLayout llWithdrawError;
    @BindView(R.id.tv_success_amount)
    TextView tvSuccessAmount;
    @BindView(R.id.tv_success_time)
    TextView tvSuccessTime;
    @BindView(R.id.tv_withdraw_complete)
    TextView tvWithdrawComplete;
    @BindView(R.id.ll_with_draw_success)
    LinearLayout llWithDrawSuccess;
    @BindView(R.id.scroll_withdraw)
    ScrollView scrollWithdraw;
    @BindView(R.id.iv_waiting)
    ImageView ivWaiting;
    @BindView(R.id.tv_error_withdraw)
    TextView tvErrorWithdraw;
    @BindView(R.id.iv_logo)
    ImageView ivLogo;
    private String cardno;
    private String user_cust_id;
    private String bankId;
    private String method = "1";
    private String amt;
    private double cashfee;
    private double availableCredit;
    private Handler handler = new Handler();

    /**
     * 延迟线程，看是否还有下一个字符输入
     */
    private Runnable delayRun = new Runnable() {

        @Override
        public void run() {
            //在这里调用服务器的接口，获取数据
            amt = etWithDraw.getText().toString();
            mPresenter.calculateFeeAmount(method, amt);
        }
    };
    private Runnable check;

    @Override
    protected WithDrawPresenter createPresenter() {
        return new WithDrawPresenter(mContext);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_draw);
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
        tvTitle.setText("提现");
        tvWithdrawQuan.setText(Html.fromHtml("<font color='#4a4a4a'>未使用</font><font color='#ff9933'>(1)</font>"));
        etWithDraw.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (delayRun != null) {
                    //每次editText有变化的时候，则移除上次发出的延迟线程
                    handler.removeCallbacks(delayRun);
                }
                if (TextUtils.isEmpty(s)) {
                    amt = "0";
                } else {
                    amt = s.toString().trim();
                }
                //延迟800ms，如果不再输入字符，则执行该线程的run方法
                handler.postDelayed(delayRun, 1000);

            }
        });
        WYUtils.showSoftPan(etWithDraw);
    }

    @OnClick({R.id.iv_finish, R.id.btn_withdraw, R.id.tv_withdraw_quan, R.id.tv_withdraw_way, R.id.tv_total_withdraw, R.id.tv_withdraw_complete, R.id.tv_back_account})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_finish:
                finish();
                break;
            case R.id.btn_withdraw:
                amt = etWithDraw.getText().toString();
                if (Double.parseDouble(amt) > availableCredit) {
                    UIUtils.showToastCommon(mContext, "提现金额不能大于可用余额");
                    return;
                } else if (Double.parseDouble(amt) < 100) {
                    UIUtils.showToastCommon(mContext, "提现金额不能小于100");
                    return;
                }
                mPresenter.withDraw(cashfee + "", amt, method);
                break;
            case R.id.tv_withdraw_quan:
                startActivity(new Intent(WithDrawActivity.this, WithDrawQuanActivity.class));
                break;
            case R.id.tv_total_withdraw:
                etWithDraw.setText(availableCredit + "");
                break;
            case R.id.tv_withdraw_way:
                amt = etWithDraw.getText().toString();
                if (TextUtils.isEmpty(amt)) {
                    UIUtils.showToastCommon(mContext, "提现金额不能为空");
                    return;
                }
                popupWindow(mContext, viewLine, amt);
                break;
            case R.id.tv_withdraw_complete:
                finish();
                break;
            case R.id.tv_back_account:
                startActivity(MainActivity.getMainIntent(mContext, 3));
                break;
        }
    }

    /**
     * 客服弹出框
     *
     * @param context
     * @param view
     */
    public void popupWindow(final Context context, View view, final String amt) {
        menuWindow = new WithDrawPopupWindow(context, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuWindow.dismiss();
                switch (v.getId()) {
                    case R.id.tv_normal_withdraw:
                        //选则正常1 有提现券
                        method = "1";
                        tvWithdrawWay.setText("普通提现");
                        mPresenter.calculateFeeAmount("1", amt);
                        break;
                    case R.id.tv_fast_withdraw:
                        //及时提现2 无提现券
                        method = "2";
                        tvWithdrawWay.setText("即时提现");
                        mPresenter.calculateFeeAmount("2", amt);
                        break;
                }
            }
        });
        menuWindow.showAtLocation(view, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
    }

    @Override
    public void pushActivity(String baseResponseBean) {
        Intent intent = new Intent(mContext, ShBankWebActivity.class);
        intent.setAction(baseResponseBean);
        startActivityForResult(intent, 0x11);
    }

    public static final int ret_withdraw = 101;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        LogUtils.e("ndy_result", "in");
        if (resultCode == ret_withdraw) {
            scrollWithdraw.setVisibility(View.GONE);
            ivWaiting.setVisibility(View.VISIBLE);
            //延时三秒
            check = new Runnable() {
                @Override
                public void run() {
                    ivWaiting.setVisibility(View.GONE);
                    mPresenter.isWithDrawSuccess();
                }
            };
            handler.postDelayed(check, 3000);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(check);
    }

    @Override
    public void showCard(UserBaseInfoBean fb) {
        bankId = fb.getModel().getBankNo();
        cardno = fb.getModel().getBankCardNo();
        availableCredit = fb.getModel().getAvailableCredit();
        tvAvailable.setText(availableCredit + "");
        tvBankName.setText(fb.getModel().getBankName());
        tvCardNo.setText(cardno);
        Glide.with(mContext).load(fb.getModel().getMapUrl()).into(ivLogo);
    }

    /**
     * 手续费
     *
     * @param fee
     */
    @Override
    public void setFee(double fee) {
        cashfee = fee;
        tvCashFee.setText(cashfee + "");
        LogUtils.e("ndy", amt + "==" + cashfee);
        tvActual.setText((Double.parseDouble(amt) - cashfee) + "");
    }

    /**
     * 展示提现成功失败的页面
     *
     * @param
     */
    @Override
    public void showIsSucess(IsWithDrawSuccess.ModelBean baseBean) {
        if (baseBean.getCode().equals("1")) {
            scrollWithdraw.setVisibility(View.GONE);
            llWithDrawSuccess.setVisibility(View.VISIBLE);
            tvSuccessAmount.setText(Html.fromHtml("<font color='#4a4a4a'>您本次提现金额为</font><font color='#ff9933'>" + baseBean.getAmonut() + "</font><font color='#4a4a4a'>元</font>"));
            tvSuccessTime.setText("预计到账时间" + baseBean.getCreateTime());
        } else if (baseBean.getCode().equals("2")) {
            scrollWithdraw.setVisibility(View.GONE);
            ivWaiting.setVisibility(View.VISIBLE);
        } else if (baseBean.getCode().equals("3")) {
            scrollWithdraw.setVisibility(View.GONE);
            llWithdrawError.setVisibility(View.VISIBLE);
            tvErrorWithdraw.setText(baseBean.getMsg());
        } else {

        }
    }
}

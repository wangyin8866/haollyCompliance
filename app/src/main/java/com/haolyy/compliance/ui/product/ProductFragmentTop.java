package com.haolyy.compliance.ui.product;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseApplication;
import com.haolyy.compliance.base.BaseFragment;
import com.haolyy.compliance.custom.BottomScrollView;
import com.haolyy.compliance.custom.CircleProgressView;
import com.haolyy.compliance.custom.dialog.DialogBank;
import com.haolyy.compliance.entity.home.UserInfoBean;
import com.haolyy.compliance.entity.login.FindUserStatusBean;
import com.haolyy.compliance.entity.product.Earnings;
import com.haolyy.compliance.entity.product.ProductBaseDetail;
import com.haolyy.compliance.ui.bank.CheckBankActivity;
import com.haolyy.compliance.ui.bank.RechargeActivity;
import com.haolyy.compliance.ui.login.LoginActivity;
import com.haolyy.compliance.ui.product.presenter.ProductTopPresenter;
import com.haolyy.compliance.ui.product.view.ProductTopView;
import com.haolyy.compliance.utils.DateUtil;
import com.haolyy.compliance.utils.LogUtils;
import com.haolyy.compliance.utils.WYUtils;

import java.math.BigDecimal;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.haolyy.compliance.base.BaseApplication.juid;
import static com.haolyy.compliance.base.BaseApplication.mLoginState;

/**
 * 产品详情顶部页面
 * Created by wangyin on 2017/5/16.
 */

public class ProductFragmentTop extends BaseFragment<ProductTopPresenter, ProductTopView> implements ProductTopView {
    Unbinder unbinder;

    @BindView(R.id.tv_mirror_plan)
    TextView tvMirrorPlan;
    @BindView(R.id.tv_use_quan)
    TextView tvUseQuan;
    @BindView(R.id.arc_progress_view)
    CircleProgressView arcProgressView;
    @BindView(R.id.bottom_scroll)
    BottomScrollView bottomScroll;
    @BindView(R.id.join_image_circle4)
    ImageView joinImageCircle4;
    @BindView(R.id.tv_time1)
    TextView tvTime1;

    @BindView(R.id.tv_time_data1)
    TextView tvTimeData1;
    @BindView(R.id.tv_time2)
    TextView tvTime2;
    @BindView(R.id.tv_time_data2)
    TextView tvTimeData2;
    @BindView(R.id.tv_time3)
    TextView tvTime3;
    @BindView(R.id.et_invest_account)
    EditText etInvestAccount;
    @BindView(R.id.join_image_circle3)
    ImageView joinImageCircle3;
    @BindView(R.id.join_line3)
    View joinLine3;
    @BindView(R.id.pro_yield1)
    TextView proYield1;
    @BindView(R.id.rate_add)
    TextView rateAdd;
    @BindView(R.id.pro_yield2)
    TextView proYield2;
    @BindView(R.id.extra_rate_percent)
    TextView extraRatePercent;
    @BindView(R.id.join_image_circle1)
    ImageView joinImageCircle1;
    @BindView(R.id.join_line1)
    View joinLine1;
    @BindView(R.id.join_image_circle2)
    ImageView joinImageCircle2;
    @BindView(R.id.join_line2)
    View joinLine2;
    @BindView(R.id.tv_time_data3)
    TextView tvTimeData3;
    @BindView(R.id.tv_time4)
    TextView tvTime4;
    @BindView(R.id.tv_time_data4)
    TextView tvTimeData4;
    @BindView(R.id.amount_wait)
    TextView amountWait;
    @BindView(R.id.interest_end_date)
    TextView interestEndDate;
    @BindView(R.id.tv_pull)
    TextView tvPull;
    @BindView(R.id.invest_deadline)
    TextView investDeadline;
    @BindView(R.id.lock_period)
    TextView lockPeriod;
    @BindView(R.id.join_progress)
    LinearLayout joinProgress;
    @BindView(R.id.join_progress4)
    LinearLayout joinProgress4;
    @BindView(R.id.left_label)
    ImageView leftLabel;
    @BindView(R.id.tv_mirror_plan1)
    TextView tvMirrorPlan1;
    @BindView(R.id.tv_profit_plan)
    TextView tvProfitPlan;
    @BindView(R.id.tv_income)
    TextView tvIncome;
    @BindView(R.id.tv_balance)
    TextView tvBalance;
    @BindView(R.id.tv_withdraw)
    TextView tvWithdraw;
    @BindView(R.id.tv_invest_all)
    TextView tvInvestAll;
    private String projectNo;
    private int project_type;
    private String product_no;
    private long currentTime;
    private double amount;
    private String rate;
    private String timeType;
    private String termTime;
    private String borrowType;
    private BigDecimal income;
    private Handler handler = new Handler();
    private String balance;

    /**
     * 延迟线程，看是否还有下一个字符输入
     */
    private Runnable delayRun = new Runnable() {

        @Override
        public void run() {
            //在这里调用服务器的接口，获取数据
            mPresenter.getEarnings(amount + "", rate, timeType, termTime, borrowType);
        }
    };
    private ProductBaseDetail.ModelBeanX.ModelBean.InfoBean infoBean;
    private int state;


    public interface CallBackProductDetail {
        void callBackInfo(ProductBaseDetail.ModelBeanX.ModelBean.InfoBean infoBean);

        void callBackAmount(double amount);

        void callBackIncome(BigDecimal income, BigDecimal earning);

        void callBackUseful(double usefulAmount);
    }

    private CallBackProductDetail callBackProductDetail;

    public void setCallBackProductDetail(CallBackProductDetail callBackProductDetail) {
        this.callBackProductDetail = callBackProductDetail;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_top, container, false);
        unbinder = ButterKnife.bind(this, view);
        init();

        bottomScroll.setOnScrollToBottomLintener(new BottomScrollView.OnScrollToBottomListener() {
            @Override
            public void onScrollBottomListener(boolean isBottom) {
                if (isBottom) {
                    bottomScroll.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            switch (event.getAction()) {
                                case MotionEvent.ACTION_MOVE:
                                    //解决滑动冲突
                                    bottomScroll.getParent().requestDisallowInterceptTouchEvent(false);
                                    break;
                            }
                            return false;
                        }
                    });
                }
            }
        });

        etInvestAccount.addTextChangedListener(new TextWatcher() {
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
                if (TextUtils.isEmpty(etInvestAccount.getText().toString().trim())) {
                    amount = 0;
                } else {
                    amount = Double.valueOf(etInvestAccount.getText().toString().trim());
                }
                LogUtils.e("afterTextChanged", amount + "");
                callBackProductDetail.callBackAmount(amount);
                //延迟500ms，如果不再输入字符，则执行该线程的run方法
                handler.postDelayed(delayRun, 500);

            }
        });
        //自动弹出软键盘
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                etInvestAccount.requestFocus();
                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }, 500);

        return view;
    }

    @Override
    protected ProductTopPresenter createPresenter() {
        return new ProductTopPresenter(mContext);
    }

    private void init() {
       /* if (mLoginState) {
            LogUtils.e("mLoginState", mLoginState + "");
            tvBalance.setClickable(false);
            //查询用户余额
            mPresenter.getUserInfo();

        } else {
            tvBalance.setClickable(true);
        }*/
        projectNo = getActivity().getIntent().getStringExtra("projectNo");
        LogUtils.e("ProductFragmentTop_projectNo", projectNo);
        project_type = getActivity().getIntent().getIntExtra("project_type", 0);
        LogUtils.e("ProductFragmentTop_project_type", project_type + "");
        product_no = getActivity().getIntent().getStringExtra("product_no");
        LogUtils.e("ProductFragmentTop_product_no", product_no + "");
        mPresenter.getBaseDetail(projectNo + "", juid);
        //显示进度
        if (project_type == 1) {//散标
            joinProgress.setVisibility(View.GONE);
            lockPeriod.setVisibility(View.GONE);
        } else {
            if (product_no.equalsIgnoreCase("scd")) {//新手标
                joinLine3.setVisibility(View.GONE);
                joinImageCircle4.setVisibility(View.GONE);
                joinProgress4.setVisibility(View.GONE);
            }
        }
        //显示left label
        if (!product_no.equalsIgnoreCase("pjd")) {//票据贷
            leftLabel.setVisibility(View.GONE);
        }


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick({R.id.tv_mirror_plan, R.id.tv_use_quan, R.id.tv_balance, R.id.tv_withdraw, R.id.tv_invest_all})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_mirror_plan:
                break;

            case R.id.tv_use_quan:
                startActivityForResult(new Intent(mContext, SelectQuanActivity.class), 0x00);
                break;
            case R.id.tv_balance:
                startActivity(new Intent(mContext, LoginActivity.class));

                break;
            case R.id.tv_withdraw:
                if (!mLoginState) {
                    startActivity(new Intent(mContext, LoginActivity.class));
                } else {
                    if (!TextUtils.isEmpty(BaseApplication.mUserName)) {
                        mPresenter.selectUserState(0);
                    }
                }
                break;
            case R.id.tv_invest_all:
                if (!TextUtils.isEmpty(balance)) {
                    etInvestAccount.setText(balance);
                }
                break;
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public void showData(ProductBaseDetail productBaseDetail) {
        if (mLoginState) {
            LogUtils.e("mLoginState", mLoginState + "");
            tvBalance.setClickable(false);
            //查询用户余额
            mPresenter.getUserInfo();

        } else {
            tvBalance.setClickable(true);
        }
        LogUtils.e("productBaseDetail", productBaseDetail.toString());
        currentTime = productBaseDetail.getModel().getModel().getNow();
        infoBean = productBaseDetail.getModel().getModel().getInfo();
        callBackProductDetail.callBackInfo(infoBean);

        //利率
        proYield1.setText(infoBean.getAnnualizedRate());
        //额外利率
        proYield2.setText(infoBean.getAppendRate());

        WYUtils.setVisibility(rateAdd, proYield2, extraRatePercent, infoBean.getAppendRate());
        //回款方式
        tvProfitPlan.setText(WYUtils.getProfitPlan(infoBean.getProfitPlan()));

        //剩余可投金额
        amountWait.setText(infoBean.getAmountWait() + "元");
        //退出日期
        interestEndDate.setText(DateUtil.getTimeyyyymmdd(infoBean.getInterestEndDate()) + "到期");
        //投资期限
        investDeadline.setText(infoBean.getPeriodLength() + WYUtils.getInvestDeadline(infoBean.getPeriodUnit()));
        //锁定期
        lockPeriod.setText(infoBean.getLockPeriod() + "天");
        //计划金额
        Double amount = Double.valueOf(infoBean.getContractAmount().replace(",", ""));
        double scale = Double.valueOf(infoBean.getAmountScale()) / 100;

        arcProgressView.setData(amount * scale, amount);
        processProgress(infoBean.getBeginDate(), infoBean.getBidEndDate(), infoBean.getLockDate(), infoBean.getInterestEndDate());

        rate = Float.valueOf(infoBean.getAnnualizedRate()) + Float.valueOf(infoBean.getAppendRate()) + "";
        timeType = infoBean.getPeriodUnit() + "";
        termTime = infoBean.getPeriodLength() + "";
        borrowType = infoBean.getProfitPlan() + "";
    }

    @Override
    public void getUserState(FindUserStatusBean baseResponseBean) {
        state = baseResponseBean.getModel().getModel().getIs_open_account();
        if (state == 1) {//chongzhi
            startActivity(new Intent(mContext, RechargeActivity.class));
        } else {
            showDialog();
        }
        LogUtils.e(state + "");
    }

    @Override
    public void getEarnings(Earnings earnings) {
        income = earnings.getModel().getExpectedRevenue();
        LogUtils.e("income", income + "");
        BigDecimal account = new BigDecimal(etInvestAccount.getText().toString().trim());
        account.setScale(2, BigDecimal.ROUND_DOWN);
        BigDecimal earning = income.subtract(account);
        tvIncome.setText(earning.toString() + "元");
        callBackProductDetail.callBackIncome(income, earning);
    }

    @Override
    public void showUserInfoData(UserInfoBean userInfoBean) {
        balance = WYUtils.processAmountString(userInfoBean.getModel().getModel().getAvailable_credit());
        tvBalance.setText(balance + "元");
        callBackProductDetail.callBackUseful(Double.parseDouble(balance));

    }

    public void showDialog() {
        DialogBank dialogBank = new DialogBank(mContext);
        dialogBank.setOnDoubleClickListener(new DialogBank.OnDoubleClickListener() {
            @Override
            public void excuteLeft() {

            }

            @Override
            public void excuteRight() {
                startActivity(new Intent(mContext, CheckBankActivity.class));
            }
        }).show();
    }


    /**
     * 处理进度条
     *
     * @param begin_date   开始加入时间
     * @param bid_end_date 投标结束时间
     * @param lock_date    锁定到期时间
     * @param period_unit  计划到期时间
     */
    private void processProgress(long begin_date, long bid_end_date, long lock_date, long period_unit) {
        rest();
        if (begin_date >= currentTime) {
            switchState(1, begin_date, bid_end_date, lock_date, period_unit);
        }
        if (bid_end_date >= currentTime) {
            switchState(2, begin_date, bid_end_date, lock_date, period_unit);
        }
        if (lock_date >= currentTime) {
            switchState(3, begin_date, bid_end_date, lock_date, period_unit);
        }
        if (period_unit >= currentTime) {
            switchState(4, begin_date, bid_end_date, lock_date, period_unit);
        }

    }

    /**
     * @param state 状态码
     */
    private void switchState(int state, long begin_date, long bid_end_date, long lock_date, long period_unit) {
        rest();
        switch (state) {
            case 1:
                setText(begin_date, bid_end_date, lock_date, period_unit);
                joinImageCircle1.setImageResource(R.mipmap.icon_join_circle);
                joinLine1.setBackgroundColor(Color.parseColor("#FF9933"));
                tvTime1.setTextColor(Color.parseColor("#FF4A4A4A"));
                tvTimeData1.setTextColor(Color.parseColor("#FF4A4A4A"));
                break;
            case 2:
                setText(begin_date, bid_end_date, lock_date, period_unit);
                joinImageCircle1.setImageResource(R.mipmap.icon_join_circle);
                joinImageCircle2.setImageResource(R.mipmap.icon_join_circle);
                joinLine1.setBackgroundColor(Color.parseColor("#FF9933"));
                joinLine2.setBackgroundColor(Color.parseColor("#FF9933"));
                tvTime1.setTextColor(Color.parseColor("#FF4A4A4A"));
                tvTime2.setTextColor(Color.parseColor("#FF4A4A4A"));
                tvTimeData1.setTextColor(Color.parseColor("#FF4A4A4A"));
                tvTimeData2.setTextColor(Color.parseColor("#FF4A4A4A"));
                break;
            case 3:
                setText(begin_date, bid_end_date, lock_date, period_unit);
                joinLine1.setBackgroundColor(Color.parseColor("#FF9933"));
                joinLine2.setBackgroundColor(Color.parseColor("#FF9933"));
                joinLine3.setBackgroundColor(Color.parseColor("#FF9933"));
                joinImageCircle1.setImageResource(R.mipmap.icon_join_circle);
                joinImageCircle2.setImageResource(R.mipmap.icon_join_circle);
                joinImageCircle3.setImageResource(R.mipmap.icon_join_circle);
                tvTime1.setTextColor(Color.parseColor("#FF4A4A4A"));
                tvTime2.setTextColor(Color.parseColor("#FF4A4A4A"));
                tvTime3.setTextColor(Color.parseColor("#FF4A4A4A"));
                tvTimeData1.setTextColor(Color.parseColor("#FF4A4A4A"));
                tvTimeData2.setTextColor(Color.parseColor("#FF4A4A4A"));
                tvTimeData3.setTextColor(Color.parseColor("#FF4A4A4A"));
                break;
            case 4:
                setText(begin_date, bid_end_date, lock_date, period_unit);
                joinLine1.setBackgroundColor(Color.parseColor("#FF9933"));
                joinLine2.setBackgroundColor(Color.parseColor("#FF9933"));
                joinLine3.setBackgroundColor(Color.parseColor("#FF9933"));
                joinImageCircle1.setImageResource(R.mipmap.icon_join_circle);
                joinImageCircle2.setImageResource(R.mipmap.icon_join_circle);
                joinImageCircle3.setImageResource(R.mipmap.icon_join_circle);
                joinImageCircle4.setImageResource(R.mipmap.icon_join_circle);
                tvTime1.setTextColor(Color.parseColor("#FF4A4A4A"));
                tvTime2.setTextColor(Color.parseColor("#FF4A4A4A"));
                tvTime3.setTextColor(Color.parseColor("#FF4A4A4A"));
                tvTime4.setTextColor(Color.parseColor("#FF4A4A4A"));
                tvTimeData1.setTextColor(Color.parseColor("#FF4A4A4A"));
                tvTimeData2.setTextColor(Color.parseColor("#FF4A4A4A"));
                tvTimeData3.setTextColor(Color.parseColor("#FF4A4A4A"));
                tvTimeData4.setTextColor(Color.parseColor("#FF4A4A4A"));
                break;
        }
    }


    /**
     * 设置文本值
     *
     * @param begin_date
     * @param bid_end_date
     * @param lock_date
     * @param period_unit
     */
    private void setText(long begin_date, long bid_end_date, long lock_date, long period_unit) {
        if (begin_date != 0) {
            tvTime1.setText(DateUtil.getTimeyyyymmdd(begin_date));
        }
        if (bid_end_date != 0) {
            tvTime2.setText(DateUtil.getTimeyyyymmdd(bid_end_date));
        }
        if (lock_date != 0) {
            tvTime3.setText(DateUtil.getTimeyyyymmdd(lock_date));
        }
        if (period_unit != 0) {

            tvTime4.setText(DateUtil.getTimeyyyymmdd(period_unit));
        }
    }

    private void rest() {
        joinLine1.setBackgroundColor(Color.parseColor("#D8D8D8"));
        joinLine2.setBackgroundColor(Color.parseColor("#D8D8D8"));
        joinLine3.setBackgroundColor(Color.parseColor("#D8D8D8"));
        joinImageCircle1.setImageResource(R.mipmap.icon_join_circle_gray);
        joinImageCircle2.setImageResource(R.mipmap.icon_join_circle_gray);
        joinImageCircle3.setImageResource(R.mipmap.icon_join_circle_gray);
        joinImageCircle4.setImageResource(R.mipmap.icon_join_circle_gray);
        tvTime1.setTextColor(Color.parseColor("#B9B9B9"));
        tvTime1.setText("- -");
        tvTime2.setTextColor(Color.parseColor("#B9B9B9"));
        tvTime2.setText("- -");
        tvTime3.setTextColor(Color.parseColor("#B9B9B9"));
        tvTime3.setText("- -");
        tvTime4.setTextColor(Color.parseColor("#B9B9B9"));
        tvTime4.setText("- -");
        tvTimeData1.setTextColor(Color.parseColor("#B9B9B9"));
        tvTimeData2.setTextColor(Color.parseColor("#B9B9B9"));
        tvTimeData3.setTextColor(Color.parseColor("#B9B9B9"));
        tvTimeData4.setTextColor(Color.parseColor("#B9B9B9"));
    }


    @Override
    public void showSuccessToast(String msg) {

    }

    @Override
    public void showErrorToast(String msg) {

    }


}

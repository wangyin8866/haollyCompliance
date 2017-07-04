package com.haolyy.compliance.ui.product;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseFragment;
import com.haolyy.compliance.custom.BottomScrollView;
import com.haolyy.compliance.custom.CircleProgressView;
import com.haolyy.compliance.entity.BaseResponseBean;
import com.haolyy.compliance.entity.product.ProductBaseDetail;
import com.haolyy.compliance.ui.product.presenter.ProductTopPresenter;
import com.haolyy.compliance.ui.product.view.ProductTopView;
import com.haolyy.compliance.utils.DateUtil;
import com.haolyy.compliance.utils.LogUtils;
import com.haolyy.compliance.utils.WYUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

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
    @BindView(R.id.invest_scrollview)
    ScrollView investScrollview;
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
    private String projectNo;
    private int project_type;
    private String product_no;
    private int progressState;
    private long currentTime;

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
        etInvestAccount.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                changeScrollView();
                return false;
            }
        });
        return view;
    }

    @Override
    protected ProductTopPresenter createPresenter() {
        return new ProductTopPresenter(mContext);
    }

    private void init() {
        projectNo = getActivity().getIntent().getStringExtra("projectNo");
        LogUtils.e("projectNo",projectNo);
        project_type = getActivity().getIntent().getIntExtra("project_type", 0);
        LogUtils.e("project_type",project_type+"");
        product_no = getActivity().getIntent().getStringExtra("product_no");
        LogUtils.e("product_no",product_no+"");
        //显示进度
        if (project_type == 1) {//散标
            joinProgress.setVisibility(View.GONE);
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
        mPresenter.getBaseDetail(projectNo + "", "12");


//        mPresenter.selectUserState();

    }

    void changeScrollView() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                investScrollview.scrollTo(0, investScrollview.getHeight());
            }
        }, 100);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick({R.id.tv_mirror_plan, R.id.tv_use_quan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_mirror_plan:
                break;

            case R.id.tv_use_quan:
                startActivityForResult(new Intent(mContext, SelectQuanActivity.class), 0x00);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public void showData(ProductBaseDetail productBaseDetail) {
        currentTime = productBaseDetail.getData().getData().getNow();
        ProductBaseDetail.DataBeanX.DataBean.InfoBean infoBean = productBaseDetail.getData().getData().getInfo();
        //利率
        proYield1.setText(infoBean.getAnnualized_rate());
        //额外利率
        proYield2.setText(infoBean.getAppend_rate());
        rateAdd.setVisibility(Double.valueOf(infoBean.getAppend_rate()) == 0 ? View.GONE : View.VISIBLE);
        proYield2.setVisibility(Double.valueOf(infoBean.getAppend_rate()) == 0 ? View.GONE : View.VISIBLE);
        extraRatePercent.setVisibility(Double.valueOf(infoBean.getAppend_rate()) == 0 ? View.GONE : View.VISIBLE);
        //剩余可投金额
        amountWait.setText(infoBean.getAmount_wait() + "元");
        //退出日期
        interestEndDate.setText(DateUtil.getTimeyyyymmdd(infoBean.getInterest_end_date()) + "到期");
        //投资期限
        investDeadline.setText(infoBean.getPeriod_length() + WYUtils.getInvestDeadline(infoBean.getPeriod_unit()));
        //锁定期
        lockPeriod.setText(infoBean.getLock_period() + "天");
        //计划金额
        Double amount = Double.valueOf(infoBean.getContract_amount().replace(",", ""));
        double scale = Double.valueOf(infoBean.getAmount_scale()) / 100;
        //剩余可投金额
        Double amount_wait = Double.valueOf(infoBean.getAmount_wait().replace(",", ""));
        arcProgressView.setData(amount * scale, amount);
        processProgress(infoBean.getBegin_date(), infoBean.getBid_end_date(), infoBean.getLock_date(), infoBean.getInterest_end_date());
    }

    @Override
    public void getUserState(BaseResponseBean baseResponseBean) {

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

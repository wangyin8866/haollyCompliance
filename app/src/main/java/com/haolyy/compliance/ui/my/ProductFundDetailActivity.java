package com.haolyy.compliance.ui.my;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.adapter.TabAdapter;
import com.haolyy.compliance.custom.TopBar;
import com.haolyy.compliance.entity.product.ProductBaseDetail;
import com.haolyy.compliance.ui.product.FragmentBottomBorrowDetail;
import com.haolyy.compliance.ui.product.FragmentBottomCreditorInfo;
import com.haolyy.compliance.ui.product.FragmentBottomInvestLog;
import com.haolyy.compliance.ui.product.FragmentBottomProductDetail;
import com.haolyy.compliance.ui.product.FragmentBottomRepaymentPlan;
import com.haolyy.compliance.utils.DateUtil;
import com.haolyy.compliance.utils.LogUtils;
import com.haolyy.compliance.utils.WYUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ProductFundDetailActivity extends AppCompatActivity {

    @BindView(R.id.top_bar)
    TopBar topBar;
    @BindView(R.id.left_label)
    ImageView leftLabel;
    @BindView(R.id.pro_yield1)
    TextView proYield1;
    @BindView(R.id.rate_add)
    TextView rateAdd;
    @BindView(R.id.pro_yield2)
    TextView proYield2;
    @BindView(R.id.extra_rate_percent)
    TextView extraRatePercent;
    @BindView(R.id.amount_wait)
    TextView amountWait;
    @BindView(R.id.interest_end_date)
    TextView interestEndDate;
    @BindView(R.id.invest_deadline)
    TextView investDeadline;
    @BindView(R.id.lock_period)
    TextView lockPeriod;
    @BindView(R.id.tv_mirror_plan1)
    TextView tvMirrorPlan1;
    @BindView(R.id.tv_mirror_plan)
    TextView tvMirrorPlan;
    @BindView(R.id.join_image_circle1)
    ImageView joinImageCircle1;
    @BindView(R.id.join_line1)
    View joinLine1;
    @BindView(R.id.join_image_circle2)
    ImageView joinImageCircle2;
    @BindView(R.id.join_line2)
    View joinLine2;
    @BindView(R.id.join_image_circle3)
    ImageView joinImageCircle3;
    @BindView(R.id.join_line3)
    View joinLine3;
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
    @BindView(R.id.tv_time_data3)
    TextView tvTimeData3;
    @BindView(R.id.tv_time4)
    TextView tvTime4;
    @BindView(R.id.tv_time_data4)
    TextView tvTimeData4;
    @BindView(R.id.join_progress4)
    LinearLayout joinProgress4;
    @BindView(R.id.join_progress)
    LinearLayout joinProgress;
    @BindView(R.id.tablayout_bottom)
    TabLayout tablayoutBottom;
    @BindView(R.id.vp_join_record)
    ViewPager vpJoinRecord;


    private List<String> titles = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();

    FragmentBottomProductDetail bottomProductDetail;
    FragmentBottomInvestLog bottomInvestLog;
    FragmentBottomCreditorInfo bottomCreditorInfo;
    FragmentBottomBorrowDetail bottomBorrowDetail;
    FragmentBottomRepaymentPlan bottomRepaymentPlan;
    ProductBaseDetail productBaseDetail;
    private String product_no;

    private int project_type;
    private long currentTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_fund_detail);
        ButterKnife.bind(this);
        init();

        topBar.setOnItemClickListener(new TopBar.OnItemClickListener() {
            @Override
            public void OnLeftButtonClicked() {
                finish();
            }

            @Override
            public void OnRightButtonClicked() {

            }
        });
    }


    private void init() {
        productBaseDetail = (ProductBaseDetail) getIntent().getSerializableExtra("productBaseDetail");
        LogUtils.e("productBaseDetail",productBaseDetail.toString());
        currentTime = productBaseDetail.getModel().getModel().getNow();
        ProductBaseDetail.ModelBeanX.ModelBean.InfoBean infoBean = productBaseDetail.getModel().getModel().getInfo();
        //利率
        proYield1.setText(infoBean.getAnnualizedRate());
        //额外利率
        proYield2.setText(infoBean.getAppendRate());

        WYUtils.setVisibility(rateAdd,proYield2,extraRatePercent,infoBean.getAppendRate());
        //剩余可投金额
        amountWait.setText(infoBean.getAmountWait() + "元");
        //退出日期
        interestEndDate.setText(DateUtil.getTimeyyyymmdd(infoBean.getInterestEndDate()) + "到期");
        //投资期限
        investDeadline.setText(infoBean.getPeriodLength() + WYUtils.getInvestDeadline(infoBean.getPeriodUnit()));
        //锁定期
        lockPeriod.setText(infoBean.getLockPeriod()+ "天");
        processProgress(infoBean.getBeginDate(), infoBean.getBidEndDate(), infoBean.getLockDate(), infoBean.getInterestEndDate());

        topBar.setTitle(infoBean.getProjectName());


        product_no = getIntent().getStringExtra("product_no");

        project_type = getIntent().getIntExtra("project_type", 0);
        LogUtils.e("ProductFragmentTop_project_type", project_type + "");

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




        bottomProductDetail = new FragmentBottomProductDetail();
        bottomInvestLog = new FragmentBottomInvestLog();
        bottomCreditorInfo = new FragmentBottomCreditorInfo();
        bottomBorrowDetail = new FragmentBottomBorrowDetail();
        bottomRepaymentPlan = new FragmentBottomRepaymentPlan();

        LogUtils.e("ProductFragmentBottom_product_no", product_no);
        if (product_no.contains("YJH")||product_no.contains("DQY")||product_no.contains("XSB")) {//赢计划,短期赢,新手标
            titles.add("产品详情");
            fragments.add(bottomProductDetail);
            titles.add("投资记录");
            fragments.add(bottomInvestLog);
        } else if (product_no.contains("XFD")||product_no.contains("SCD")) {//消费贷,闪车贷
            titles.add("借款明细");
            fragments.add(bottomBorrowDetail);
            titles.add("投资记录");
            fragments.add(bottomInvestLog);
            titles.add("还款计划");
            fragments.add(bottomRepaymentPlan);
        } else if (product_no.contains("PJD")) {//票据贷
            titles.add("借款明细");
            fragments.add(bottomBorrowDetail);
            titles.add("投资记录");
            fragments.add(bottomInvestLog);
        } else if (product_no.contains("ZZY")) {//周周赢
            titles.add("产品详情");
            fragments.add(bottomProductDetail);
            titles.add("债权信息");
            fragments.add(bottomCreditorInfo);
            titles.add("投资记录");
            fragments.add(bottomInvestLog);
        }
        vpJoinRecord.setAdapter(new TabAdapter(getSupportFragmentManager(),fragments,titles));
        vpJoinRecord.setOffscreenPageLimit(3);
        tablayoutBottom.setupWithViewPager(vpJoinRecord);

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
}

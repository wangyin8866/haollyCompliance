package com.haolyy.compliance.ui.my;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.ActivityCollector;
import com.haolyy.compliance.custom.TopBar;
import com.haolyy.compliance.utils.DateUtil;
import com.haolyy.compliance.utils.LogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wangyin on 2017/5/24.
 */

public class DealDetailWithDraw extends AppCompatActivity {
    @BindView(R.id.top_deal_recycle)
    TopBar topDealRecycle;
    @BindView(R.id.tv_amount)
    TextView tvAmount;
    @BindView(R.id.iv_withdraw)
    ImageView ivWithdraw;
    @BindView(R.id.withdraw_tv1)
    TextView withdrawTv1;
    @BindView(R.id.withdraw_tv2)
    TextView withdrawTv2;
    @BindView(R.id.iv_withdraw2)
    ImageView ivWithdraw2;
    @BindView(R.id.withdraw_tv3)
    TextView withdrawTv3;
    @BindView(R.id.withdraw_tv4)
    TextView withdrawTv4;
    @BindView(R.id.iv_withdraw3)
    ImageView ivWithdraw3;
    @BindView(R.id.withdraw_tv5)
    TextView withdrawTv5;
    @BindView(R.id.withdraw_tv6)
    TextView withdrawTv6;
    @BindView(R.id.tv_capital_no)
    TextView tvCapitalNo;
    @BindView(R.id.tv_trade_time)
    TextView tvTradeTime;
    @BindView(R.id.tv_mark)
    TextView tvMark;

    public static Intent getMainIntent(Context context, String amount, String transferDate, String capitalNo, String remark, String requestTime, String finishTime) {
        Intent intent = new Intent(context, DealDetailWithDraw.class);
        intent.putExtra("amount", amount);
        intent.putExtra("transferDate", transferDate);
        intent.putExtra("capitalNo", capitalNo);
        intent.putExtra("remark", remark);
        intent.putExtra("requestTime", requestTime);
        intent.putExtra("finishTime", finishTime);
        return intent;

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deal_detail_withdraw);
        ButterKnife.bind(this);
        ActivityCollector.addActivity(this);
        init();
    }

    private void init() {
        topDealRecycle.setOnItemClickListener(new TopBar.OnItemClickListener() {
            @Override
            public void OnLeftButtonClicked() {
                finish();
            }

            @Override
            public void OnRightButtonClicked() {

            }
        });

        Intent intent = getIntent();
        String timeYHMDHM = DateUtil.getTimeYHMDHM(Long.parseLong(intent.getStringExtra("transferDate")) * 1000);
        tvTradeTime.setText(timeYHMDHM);
        tvCapitalNo.setText(intent.getStringExtra("capitalNo"));
        tvMark.setText(intent.getStringExtra("remark"));

        String amount = intent.getStringExtra("amount");
        tvAmount.setText("-" + amount + "元");
        withdrawTv2.setText(intent.getStringExtra("requestTime"));
        withdrawTv4.setText(intent.getStringExtra("finishTime"));
        withdrawTv6.setText(intent.getStringExtra("finishTime"));
        LogUtils.e("ndy",intent.getStringExtra("requestTime"));
    }
}

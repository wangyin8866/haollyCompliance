package com.haolyy.compliance.ui.my;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.ActivityCollector;
import com.haolyy.compliance.custom.TopBar;
import com.haolyy.compliance.utils.DateUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wangyin on 2017/5/24.
 * (0:全部;2001:充值;200303:提现;300611:投资;300606:回息;300605:回本;200304手续费;300634:奖励;8:其他)
 */

public class DealDetailRecycle extends AppCompatActivity {
    @BindView(R.id.top_deal_recycle)
    TopBar topDealRecycle;
    @BindView(R.id.tv_capital_type)
    TextView tvCapitalType;
    @BindView(R.id.tv_amount)
    TextView tvAmount;
    @BindView(R.id.tv_capital_no)
    TextView tvCapitalNo;
    @BindView(R.id.tv_trade_time)
    TextView tvTradeTime;
    @BindView(R.id.tv_mark)
    TextView tvMark;

    public static Intent getMainIntent(Context context, int capitalType, String amount, String transferDate, String capitalNo, String remark) {
        Intent intent = new Intent(context, DealDetailRecycle.class);
        intent.putExtra("capitalType", capitalType);
        intent.putExtra("transferDate", transferDate);
        intent.putExtra("capitalNo", capitalNo);
        intent.putExtra("remark", remark);
        intent.putExtra("amount", amount);
        return intent;

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deal_detail_recycle);
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
        switch (intent.getIntExtra("capitalType", -1)) {
            case 2001:
                tvCapitalType.setText("充值");
                tvAmount.setText("+" + amount + "元");
                break;
            case 300611:
                tvAmount.setText("-" + amount + "元");
                tvCapitalType.setText("投资");
                break;
            case 300606:
                tvCapitalType.setText("回息");
                tvAmount.setText("+" + amount + "元");
                break;
            case 300605:
                tvCapitalType.setText("回本");
                tvAmount.setText("+" + amount + "元");
                break;
            case 200304:
                tvAmount.setText("-" + amount + "元");
                tvCapitalType.setText("手续费");
                break;
            case 300634:
                tvAmount.setText("-" + amount + "元");
                tvCapitalType.setText("奖励");
                break;
            case 8:
                tvCapitalType.setText("其他");
                tvAmount.setText("+" + amount + "元");
                break;
        }

    }
}

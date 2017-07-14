package com.haolyy.compliance.ui.my;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.adapter.DealLogAdapter;
import com.haolyy.compliance.base.BaseActivity;
import com.haolyy.compliance.custom.TopBar;
import com.haolyy.compliance.custom.XListView;
import com.haolyy.compliance.ui.my.Bean.DealRecordBean;
import com.haolyy.compliance.ui.my.presenter.DealRecordPresenter;
import com.haolyy.compliance.ui.my.view.DealRecordView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wangyin on 2017/5/24.
 */

public class DealLogActivity extends BaseActivity<DealRecordPresenter,DealRecordView> implements XListView.IXListViewListener,DealRecordView {
    @BindView(R.id.top_fund)
    TopBar topFund;
    @BindView(R.id.xlv_deal_log)
    XListView xlvDealLog;
    @BindView(R.id.ll_deal_tab)
    LinearLayout llDealTab;
    @BindView(R.id.tv_deal_1)
    TextView tvDeal1;
    @BindView(R.id.tv_deal_2)
    TextView tvDeal2;
    @BindView(R.id.tv_deal_3)
    TextView tvDeal3;
    @BindView(R.id.tv_deal_4)
    TextView tvDeal4;
    @BindView(R.id.tv_deal_5)
    TextView tvDeal5;
    @BindView(R.id.tv_deal_6)
    TextView tvDeal6;
    @BindView(R.id.tv_deal_7)
    TextView tvDeal7;
    @BindView(R.id.tv_deal_8)
    TextView tvDeal8;
    @BindView(R.id.tv_deal_9)
    TextView tvDeal9;
//    private List<InvestLog> investLogs;
    private boolean doubleClick;

    private String[] capitalTypes = {"0","1","2","3","4","5","6","7","8"};
    private int capitalIndex = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deal_log);
        ButterKnife.bind(this);

        topFund.setOnItemClickListener(new TopBar.OnItemClickListener() {
            @Override
            public void OnLeftButtonClicked() {
                finish();

            }

            @Override
            public void OnRightButtonClicked() {
                doubleClick = !doubleClick;
                if (doubleClick) {
                    llDealTab.setVisibility(View.VISIBLE);
                } else {
                    llDealTab.setVisibility(View.GONE);
                }
            }
        });
        mPresenter.requestDealRecord("","1","1","0");



    }

    @Override
    public void showData(DealRecordBean dealRecordBean) {
        if(dealRecordBean.getModel().getModel().getFundsRecordList() == null) return;
        xlvDealLog.setAdapter(new DealLogAdapter(dealRecordBean.getModel().getModel().getFundsRecordList() , this));
        xlvDealLog.setXListViewListener(this);
    }

    @Override
    protected DealRecordPresenter createPresenter() {
        return new DealRecordPresenter(this);
    }

    @Override
    protected void handleMessage(Integer s) {

    }

    @Override
    public void showSuccessToast(String msg) {

    }

    @Override
    public void showErrorToast(String msg) {

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }

    @OnClick({R.id.tv_deal_1, R.id.tv_deal_2, R.id.tv_deal_3, R.id.tv_deal_4, R.id.tv_deal_5, R.id.tv_deal_6, R.id.tv_deal_7, R.id.tv_deal_8, R.id.tv_deal_9})
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.tv_deal_1:
                reset();
                selectTab(tvDeal1);
                break;
            case R.id.tv_deal_2:
                reset();
                selectTab(tvDeal2);
                break;
            case R.id.tv_deal_3:
                reset();
                selectTab(tvDeal3);
                break;
            case R.id.tv_deal_4:
                reset();
                selectTab(tvDeal4);
                break;
            case R.id.tv_deal_5:
                reset();
                selectTab(tvDeal5);
                break;
            case R.id.tv_deal_6:
                reset();
                selectTab(tvDeal6);
                break;
            case R.id.tv_deal_7:
                reset();
                selectTab(tvDeal7);
                break;
            case R.id.tv_deal_8:
                reset();
                selectTab(tvDeal8);
                break;
            case R.id.tv_deal_9:
                reset();
                selectTab(tvDeal9);
                break;
        }
    }

    private void selectTab(TextView textView) {
        textView.setBackground(getResources().getDrawable(R.drawable.bg_deal_select));
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        llDealTab.setVisibility(View.GONE);
        doubleClick = !doubleClick;
    }


    private void refreshView(String capitalType) {
        mPresenter.requestDealRecord("2001","1","1","0");
    }

    private void reset() {
        tvDeal1.setBackground(getResources().getDrawable(R.drawable.bg_deal_no_select));
        tvDeal1.setTextColor(Color.parseColor("#FF9933"));
        tvDeal2.setBackground(getResources().getDrawable(R.drawable.bg_deal_no_select));
        tvDeal2.setTextColor(Color.parseColor("#FF9933"));
        tvDeal3.setBackground(getResources().getDrawable(R.drawable.bg_deal_no_select));
        tvDeal3.setTextColor(Color.parseColor("#FF9933"));
        tvDeal4.setBackground(getResources().getDrawable(R.drawable.bg_deal_no_select));
        tvDeal4.setTextColor(Color.parseColor("#FF9933"));
        tvDeal5.setBackground(getResources().getDrawable(R.drawable.bg_deal_no_select));
        tvDeal5.setTextColor(Color.parseColor("#FF9933"));
        tvDeal6.setBackground(getResources().getDrawable(R.drawable.bg_deal_no_select));
        tvDeal6.setTextColor(Color.parseColor("#FF9933"));
        tvDeal7.setBackground(getResources().getDrawable(R.drawable.bg_deal_no_select));
        tvDeal7.setTextColor(Color.parseColor("#FF9933"));
        tvDeal8.setBackground(getResources().getDrawable(R.drawable.bg_deal_no_select));
        tvDeal8.setTextColor(Color.parseColor("#FF9933"));
        tvDeal9.setBackground(getResources().getDrawable(R.drawable.bg_deal_no_select));
        tvDeal9.setTextColor(Color.parseColor("#FF9933"));
    }
}

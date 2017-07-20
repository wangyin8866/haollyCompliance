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
import com.haolyy.compliance.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wangyin on 2017/5/24.
 * 资金明细列表
 */

public class DealLogActivity extends BaseActivity<DealRecordPresenter, DealRecordView> implements XListView.IXListViewListener, DealRecordView {
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
    /**
     * 用户资金明细列表;userId-用户id;capitalType-业务类型:(0:全部;2001:充值;200303:提现;300611:投资;300606:回息;300605:回本;6:手续费;7:奖励;8:其他);pageIndex-页码(开始页为1);dateFlag-时间标识(0:全部,1:自由选择2:七天,3:一个月,4:三个月);startDate:开始日期;endDate结束日期
     */
    private int capitalType;
    private int pageIndex = 0;
    private List datas;
    private List<DealRecordBean.ModelBeanX.ModelBean.FundsRecordListBean> list;
    private List<DealRecordBean.ModelBeanX.ModelBean.FundsRecordListBean> newList;

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
        mPresenter.requestDealRecord(true, capitalType + "", "1", "0");
        xlvDealLog.setXListViewListener(this);


    }

    @Override
    public void showData(DealRecordBean dealRecordBean, boolean isRefresh) {
        if (dealRecordBean.getModel().getModel().getFundsRecordList() == null) return;
        if (isRefresh) {
            list = new ArrayList<>();
            list = dealRecordBean.getModel().getModel().getFundsRecordList();
            if (list.size() == 0) {
                UIUtils.showToastCommon(mContext, "暂无数据");
                xlvDealLog.setPullLoadEnable(false);
            } else {
                if (list.size() < 10) {
                    xlvDealLog.setPullLoadEnable(false);
                } else {
                    xlvDealLog.setPullLoadEnable(true);
                }
                xlvDealLog.setAdapter(new DealLogAdapter(list, this));
                xlvDealLog.setXListViewListener(this);
            }
        } else {
            if (dealRecordBean.getModel().getModel().getFundsRecordList().size() == 0) {
                UIUtils.showToastCommon(mContext, "没有更多数据了");
                xlvDealLog.setPullLoadEnable(false);
            } else {
                list.addAll(dealRecordBean.getModel().getModel().getFundsRecordList());
                xlvDealLog.setAdapter(new DealLogAdapter(list, this));
                xlvDealLog.setSelection(list.size() - dealRecordBean.getModel().getModel().getFundsRecordList().size());
            }
        }
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

    /**
     * 刷洗
     */
    @Override
    public void onRefresh() {
        pageIndex = 0;
        mPresenter.requestDealRecord(true, capitalType + "", "1", "0");
    }

    /**
     * 加载更多
     */
    @Override
    public void onLoadMore() {
        pageIndex += 1;
        mPresenter.requestDealRecord(false, capitalType + "", pageIndex + "", "0");
    }

    @OnClick({R.id.tv_deal_1, R.id.tv_deal_2, R.id.tv_deal_3, R.id.tv_deal_4, R.id.tv_deal_5, R.id.tv_deal_6, R.id.tv_deal_7, R.id.tv_deal_8, R.id.tv_deal_9})
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.tv_deal_1:
                capitalType = 0;
                reset();
                selectTab(tvDeal1);
                break;
            case R.id.tv_deal_2:
                capitalType = 2001;
                reset();
                selectTab(tvDeal2);
                break;
            case R.id.tv_deal_3:
                capitalType = 200303;
                reset();
                selectTab(tvDeal3);
                break;
            case R.id.tv_deal_4:
                capitalType = 300611;
                reset();
                selectTab(tvDeal4);
                break;
            case R.id.tv_deal_5:
                capitalType = 300606;
                reset();
                selectTab(tvDeal5);
                break;
            case R.id.tv_deal_6:
                capitalType = 300605;
                reset();
                selectTab(tvDeal6);
                break;
            case R.id.tv_deal_7:
                capitalType = 6;
                reset();
                selectTab(tvDeal7);
                break;
            case R.id.tv_deal_8:
                capitalType = 7;
                reset();
                selectTab(tvDeal8);
                break;
            case R.id.tv_deal_9:
                capitalType = 8;
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
        if(capitalType==0){
            xlvDealLog.setAdapter(new DealLogAdapter(list, this));
        }
        else {
            if (list.size() != 0) {
                newList = new ArrayList<>();
                for (DealRecordBean.ModelBeanX.ModelBean.FundsRecordListBean bean : list) {
                    if (bean.getCapitalType() == capitalType) {
                        newList.add(bean);
                    }
                }

                xlvDealLog.setAdapter(new DealLogAdapter(newList, this));
            }
        }
    }
    private void reset() {
        tvDeal1.setBackground(getResources().getDrawable(R.drawable.shape_yellow_radius));
        tvDeal1.setTextColor(Color.parseColor("#FF9933"));
        tvDeal2.setBackground(getResources().getDrawable(R.drawable.shape_yellow_radius));
        tvDeal2.setTextColor(Color.parseColor("#FF9933"));
        tvDeal3.setBackground(getResources().getDrawable(R.drawable.shape_yellow_radius));
        tvDeal3.setTextColor(Color.parseColor("#FF9933"));
        tvDeal4.setBackground(getResources().getDrawable(R.drawable.shape_yellow_radius));
        tvDeal4.setTextColor(Color.parseColor("#FF9933"));
        tvDeal5.setBackground(getResources().getDrawable(R.drawable.shape_yellow_radius));
        tvDeal5.setTextColor(Color.parseColor("#FF9933"));
        tvDeal6.setBackground(getResources().getDrawable(R.drawable.shape_yellow_radius));
        tvDeal6.setTextColor(Color.parseColor("#FF9933"));
        tvDeal7.setBackground(getResources().getDrawable(R.drawable.shape_yellow_radius));
        tvDeal7.setTextColor(Color.parseColor("#FF9933"));
        tvDeal8.setBackground(getResources().getDrawable(R.drawable.shape_yellow_radius));
        tvDeal8.setTextColor(Color.parseColor("#FF9933"));
        tvDeal9.setBackground(getResources().getDrawable(R.drawable.shape_yellow_radius));
        tvDeal9.setTextColor(Color.parseColor("#FF9933"));
    }
}

package com.haolyy.compliance.ui.product;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.adapter.InvestLogAdapter;
import com.haolyy.compliance.base.BaseFragment;
import com.haolyy.compliance.custom.XListView;
import com.haolyy.compliance.entity.product.InvestLog;
import com.haolyy.compliance.ui.product.presenter.InvestLogPresenter;
import com.haolyy.compliance.ui.product.view.InvestLogView;
import com.haolyy.compliance.utils.LogUtils;
import com.haolyy.compliance.utils.UIUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 投资记录
 * Created by niudeyang on 2017/5/17.
 */

public class FragmentBottomInvestLog extends BaseFragment<InvestLogPresenter, InvestLogView> implements XListView.IXListViewListener, InvestLogView {
    Unbinder unbinder;
    @BindView(R.id.xl_invest_log)
    XListView xlInvestLog;
    @BindView(R.id.iv_empty)
    ImageView ivEmpty;
    private String projectNo;
    private int pageNum = 1;
    private int pageSize;
    private InvestLog investLog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottom_invest_log, container, false);
        unbinder = ButterKnife.bind(this, view);
        init();


        xlInvestLog.setXListViewListener(this);
        xlInvestLog.setPullRefreshEnable(false);
        return view;
    }

    private void init() {
        projectNo = getActivity().getIntent().getStringExtra("projectNo");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            mPresenter.getInvestmentRecord(false,projectNo, pageNum + "");
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onRefresh() {
        pageNum = 1;
        mPresenter.getInvestmentRecord(false,projectNo, pageNum + "");
    }

    @Override
    public void onLoadMore() {
        pageNum += 1;
        mPresenter.getInvestmentRecord(true,projectNo, pageNum + "");
    }

    @Override
    protected InvestLogPresenter createPresenter() {
        return new InvestLogPresenter(mContext);
    }

    @Override
    public void showData(InvestLog investLog) {

        pageSize = investLog.getModel().getModel().getInvestmentRecordList().size();

        LogUtils.e("pageSize", pageSize + "");
        this.investLog = investLog;
        if (pageSize == 0) {
            xlInvestLog.setPullLoadEnable(false);
            ivEmpty.setVisibility(View.VISIBLE);
            xlInvestLog.setVisibility(View.GONE);
        } else {
            if (pageSize < 10) {
                xlInvestLog.setPullLoadEnable(false);
            } else {
                xlInvestLog.setPullLoadEnable(true);
            }
            ivEmpty.setVisibility(View.GONE);
            xlInvestLog.setVisibility(View.VISIBLE);
            xlInvestLog.setAdapter(new InvestLogAdapter(this.investLog.getModel().getModel().getInvestmentRecordList(), getActivity()));
        }
    }
    @Override
    public void showGetMoreData(InvestLog investLog) {
        if (investLog.getModel().getModel().getInvestmentRecordList().size() == 0) {
            pageNum = 1;
            UIUtils.showToastCommon(mContext, "没有更多数据了！");
            xlInvestLog.setPullLoadEnable(false);
        } else {
            this.investLog.getModel().getModel().getInvestmentRecordList().addAll(investLog.getModel().getModel().getInvestmentRecordList());
            xlInvestLog.setPullLoadEnable(true);
            xlInvestLog.setAdapter(new InvestLogAdapter(this.investLog.getModel().getModel().getInvestmentRecordList(), getActivity()));
            xlInvestLog.setSelection(this.investLog.getModel().getModel().getInvestmentRecordList().size() - investLog.getModel().getModel().getInvestmentRecordList().size());//定位
        }
    }
}

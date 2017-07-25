package com.haolyy.compliance.ui.product;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.haolyy.compliance.R;
import com.haolyy.compliance.adapter.InvestLogAdapter;
import com.haolyy.compliance.base.BaseFragment;
import com.haolyy.compliance.custom.XListView;
import com.haolyy.compliance.entity.product.InvestLog;
import com.haolyy.compliance.ui.product.presenter.InvestLogPresenter;
import com.haolyy.compliance.ui.product.view.InvestLogView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 投资记录
 * Created by niudeyang on 2017/5/17.
 */

public class FragmentBottomInvestLog extends BaseFragment<InvestLogPresenter,InvestLogView> implements XListView.IXListViewListener,InvestLogView{
    Unbinder unbinder;
    @BindView(R.id.xl_invest_log)
    XListView xlInvestLog;
    private List<InvestLog> investLogs;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottom_invest_log, container, false);
        unbinder = ButterKnife.bind(this, view);



        xlInvestLog.setXListViewListener(this);
        xlInvestLog.setPullRefreshEnable(false);
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
                mPresenter.getInvestmentRecord("PJD0000253","1");
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }

    @Override
    protected InvestLogPresenter createPresenter() {
        return new InvestLogPresenter(mContext);
    }

    @Override
    public void showData(InvestLog investLog) {
        xlInvestLog.setAdapter(new InvestLogAdapter(investLog.getModel().getModel().getInvestmentRecordList(), getActivity()));
    }
}

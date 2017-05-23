package com.haolyy.compliance.ui.product;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.haolyy.compliance.R;
import com.haolyy.compliance.adapter.InvestLogAdapter;
import com.haolyy.compliance.custom.XListView;
import com.haolyy.compliance.entity.InvestLog;

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

public class FragmentBottomInvestLog extends Fragment implements XListView.IXListViewListener{
    Unbinder unbinder;
    @BindView(R.id.xl_invest_log)
    XListView xlInvestLog;
    private List<InvestLog> investLogs;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottom_invest_log, container, false);
        unbinder = ButterKnife.bind(this, view);
        investLogs = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            InvestLog investLog = new InvestLog("0000000000" + i, new SimpleDateFormat("HH:mm:ss", Locale.CHINA).format(new Date()),  1000 * i+"元");
            investLogs.add(investLog);
        }
        xlInvestLog.setAdapter(new InvestLogAdapter(investLogs, getActivity()));
        xlInvestLog.setXListViewListener(this);
        xlInvestLog.setPullRefreshEnable(false);
        return view;
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

}

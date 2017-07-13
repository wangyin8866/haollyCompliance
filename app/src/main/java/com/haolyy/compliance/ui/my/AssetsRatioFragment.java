package com.haolyy.compliance.ui.my;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseFragment;
import com.haolyy.compliance.custom.MagnificentChart;
import com.haolyy.compliance.custom.MagnificentChartItem;
import com.haolyy.compliance.entity.home.FundStatictisIncomeBean;
import com.haolyy.compliance.ui.my.presenter.FundStatisticsPresenter;
import com.haolyy.compliance.ui.my.view.FundStatictisView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by wangyin on 2017/5/16.
 */

public class AssetsRatioFragment extends BaseFragment<FundStatisticsPresenter,FundStatictisView> implements FundStatictisView {
    @BindView(R.id.magnificentChart)
    MagnificentChart magnificentChart;
    Unbinder unbinder;
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_assets_ratio, container, false);
        unbinder = ButterKnife.bind(this, view);
        initRatio();
        return view;
    }

    private void initRatio() {
        MagnificentChartItem firstItem = new MagnificentChartItem("first", 30, Color.parseColor("#BAF0A2"));
        MagnificentChartItem secondItem = new MagnificentChartItem("second", 12, Color.parseColor("#2F6994"));
        MagnificentChartItem thirdItem = new MagnificentChartItem("third", 3, Color.parseColor("#FF6600"));
        MagnificentChartItem fourthItem = new MagnificentChartItem("fourth", 31, Color.parseColor("#800080"));
        MagnificentChartItem fifthItem = new MagnificentChartItem("fifth", 14, Color.parseColor("#708090"));
        MagnificentChartItem sixthItem = new MagnificentChartItem("sixth", 10, Color.parseColor("#708090"));
        List<MagnificentChartItem> chartItemsList = new ArrayList<MagnificentChartItem>();
        chartItemsList.add(firstItem);
        chartItemsList.add(secondItem);
        chartItemsList.add(thirdItem);
        chartItemsList.add(fourthItem);
        chartItemsList.add(fifthItem);
        chartItemsList.add(sixthItem);
        magnificentChart.setChartItemsList(chartItemsList);
        magnificentChart.setMaxValue(100);
        magnificentChart.setShadowShowingState(false);
        magnificentChart.setAnimationState(true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();

    }

    @Override
    protected FundStatisticsPresenter createPresenter() {
        return new FundStatisticsPresenter(mContext);
    }

    @Override
    public void showSuccessToast(String msg) {

    }

    @Override
    public void showErrorToast(String msg) {

    }


    @Override
    public void showData(FundStatictisIncomeBean fundStatictisIncomeBean) {

    }
}

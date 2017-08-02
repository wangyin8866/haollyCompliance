package com.haolyy.compliance.ui.my;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.adapter.RatioAdapter;
import com.haolyy.compliance.base.BaseFragment;
import com.haolyy.compliance.custom.MagnificentChart;
import com.haolyy.compliance.custom.MagnificentChartItem;
import com.haolyy.compliance.entity.my.ProductRatioBean;
import com.haolyy.compliance.entity.home.FundStatictisIncomeBean;
import com.haolyy.compliance.ui.my.presenter.FundStatisticsPresenter;
import com.haolyy.compliance.ui.my.view.FundStatictisView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Observable;
import rx.functions.Action1;

/**
 * Created by wangyin on 2017/5/16.
 */

public class AssetsRatioFragment extends BaseFragment<FundStatisticsPresenter, FundStatictisView> implements FundStatictisView {
    @BindView(R.id.magnificentChart)
    MagnificentChart magnificentChart;
    Unbinder unbinder;
    @BindView(R.id.lv_ratio_item)
    ListView lvRatioItem;
    private View view;
    private MagnificentChartItem firstItem, secondItem, thirdItem, fourthItem, fifthItem, sixthItem, sevenItem, eightItem;
    private String allHoldAmount;
    private List<ProductRatioBean.ModelBeanX.ModelBean.HoldProductListBean> holdProductList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_assets_ratio, container, false);
        unbinder = ButterKnife.bind(this, view);
        mPresenter.userHoldProductRecord();
        return view;
    }

    /**
     * 依次为
     * 短期赢 鹰计划 周周赢 消费贷 闪车袋 票据袋 可用金额 冻结金额
     */
    private void initRatio() {
        List<MagnificentChartItem> chartItemsList = new ArrayList<MagnificentChartItem>();

        firstItem = new MagnificentChartItem("first", holdProductList.get(0).getProportion(), Color.parseColor("#FF7753"));

        secondItem = new MagnificentChartItem("second", holdProductList.get(1).getProportion(), Color.parseColor("#FDD000"));

        thirdItem = new MagnificentChartItem("third", holdProductList.get(2).getProportion(), Color.parseColor("#7ED321"));

        fourthItem = new MagnificentChartItem("fourth", holdProductList.get(3).getProportion(), Color.parseColor("#70a5ff"));

        fifthItem = new MagnificentChartItem("fifth", holdProductList.get(4).getProportion(), Color.parseColor("#CA98F6"));
        if (0 == holdProductList.get(5).getProportion()) {
            sixthItem = new MagnificentChartItem("sixth", holdProductList.get(5).getProportion(), Color.parseColor("#70a5ff"));
        } else {
            sixthItem = new MagnificentChartItem("sixth", holdProductList.get(5).getProportion(), Color.parseColor("#FBB2CD"));
        }
        sevenItem = new MagnificentChartItem("seven", holdProductList.get(6).getProportion(), Color.parseColor("#FF9F86"));

        eightItem = new MagnificentChartItem("eight", holdProductList.get(7).getProportion(), Color.parseColor("#CF9F92"));

        chartItemsList.add(firstItem);
        chartItemsList.add(secondItem);
        chartItemsList.add(thirdItem);
        chartItemsList.add(fourthItem);
        chartItemsList.add(fifthItem);
        chartItemsList.add(sixthItem);
        chartItemsList.add(sevenItem);
        chartItemsList.add(eightItem);
        magnificentChart.setChartItemsList(chartItemsList);
        magnificentChart.setMaxValue(100);
        magnificentChart.setShadowShowingState(false);
        magnificentChart.setAnimationState(true);
        magnificentChart.setText(allHoldAmount);
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

    /**
     * 不用
     *
     * @param incomeBean
     */
    @Override
    public void showData(FundStatictisIncomeBean incomeBean) {

    }

    @Override
    public void showRatio(ProductRatioBean.ModelBeanX.ModelBean productRatioBean) {
        allHoldAmount = productRatioBean.getAllHoldAmount();
        holdProductList = productRatioBean.getHoldProductList();
        Collections.sort(holdProductList, new Comparator<ProductRatioBean.ModelBeanX.ModelBean.HoldProductListBean>() {

                    @Override
                    public int compare(ProductRatioBean.ModelBeanX.ModelBean.HoldProductListBean o1, ProductRatioBean.ModelBeanX.ModelBean.HoldProductListBean o2) {
                        return Integer.parseInt(o1.getId()) - Integer.parseInt(o2.getId());
                    }
                }
        );
        initRatio();
        RatioAdapter ratioAdapter = new RatioAdapter(holdProductList, mContext);
        lvRatioItem.setAdapter(ratioAdapter);
    }
}

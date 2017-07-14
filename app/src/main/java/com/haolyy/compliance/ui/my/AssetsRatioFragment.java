package com.haolyy.compliance.ui.my;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.haolyy.compliance.entity.ProductRatioBean;
import com.haolyy.compliance.entity.home.FundStatictisIncomeBean;
import com.haolyy.compliance.ui.my.presenter.FundStatisticsPresenter;
import com.haolyy.compliance.ui.my.view.FundStatictisView;

import java.util.ArrayList;
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
    @BindView(R.id.tv_ratio_avaible)
    TextView tvRatioAvaible;
    @BindView(R.id.tv_ratio_frozen)
    TextView tvRatioFrozen;
    private View view;
    private MagnificentChartItem firstItem, secondItem, thirdItem, fourthItem, fifthItem, sixthItem, sevenItem, eightItem;

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
        productRatioBean.getAllHoldAmount();
        tvRatioAvaible.setText(productRatioBean.getAvailable_balance());
        tvRatioFrozen.setText(productRatioBean.getFrozen_balance());
        List<ProductRatioBean.ModelBeanX.ModelBean.HoldProductListBean> holdProductList = productRatioBean.getHoldProductList();
        Observable.from(holdProductList)
                .subscribe(new Action1<ProductRatioBean.ModelBeanX.ModelBean.HoldProductListBean>() {
                    @Override
                    public void call(ProductRatioBean.ModelBeanX.ModelBean.HoldProductListBean u) {
                        switch (u.getId()) {
                            case "1":
                                firstItem = new MagnificentChartItem("first", Integer.parseInt(u.getProportion()), Color.parseColor("#FF7753"));

                                break;
                            case "2":
                                secondItem = new MagnificentChartItem("second", Integer.parseInt(u.getProportion()), Color.parseColor("#FDD000"));

                                break;
                            case "3":
                                thirdItem = new MagnificentChartItem("third", Integer.parseInt(u.getProportion()), Color.parseColor("#7ED321"));

                                break;
                            case "4":
                                fourthItem = new MagnificentChartItem("fourth", Integer.parseInt(u.getProportion()), Color.parseColor("#70a5ff"));

                                break;
                            case "5":
                                fifthItem = new MagnificentChartItem("fifth", Integer.parseInt(u.getProportion()), Color.parseColor("#CA98F6"));

                                break;
                            case "6":
                                sixthItem = new MagnificentChartItem("sixth", Integer.parseInt(u.getProportion()), Color.parseColor("#FBB2CD"));
                                break;
                        }
                    }
                });
        initRatio();
        RatioAdapter ratioAdapter = new RatioAdapter(holdProductList, mContext);
        lvRatioItem.setAdapter(ratioAdapter);
    }
}

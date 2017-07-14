package com.haolyy.compliance.ui.my;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseFragment;
import com.haolyy.compliance.config.Config;
import com.haolyy.compliance.custom.MagnificentChart;
import com.haolyy.compliance.custom.MagnificentChartItem;
import com.haolyy.compliance.ui.my.Bean.AssetRatioBean;
import com.haolyy.compliance.ui.my.presenter.AssetsRatioPresenter;
import com.haolyy.compliance.ui.my.view.AssetsRatioView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by wangyin on 2017/5/16.
 */

public class AssetsRatioFragment extends BaseFragment<AssetsRatioPresenter,AssetsRatioView> implements AssetsRatioView {
    @BindView(R.id.magnificentChart)
    MagnificentChart magnificentChart;

    @BindView(R.id.short_win_plan_num)
    TextView short_win_plan_num;
    @BindView(R.id.short_win_plan)
    TextView short_win_plan;
    @BindView(R.id.win_plan_num)
    TextView win_plan_num;
    @BindView(R.id.win_plan)
    TextView win_plan;
    @BindView(R.id.week_win_plan_num)
    TextView week_win_plan_num;
    @BindView(R.id.week_win_plan)
    TextView week_win_plan;
    @BindView(R.id.consumer_credit_num)
    TextView consumer_credit_num;
    @BindView(R.id.consumer_credit_value)
    TextView consumer_credit_value;
    @BindView(R.id.bill_loan_num)
    TextView bill_loan_num;
    @BindView(R.id.bill_loan)
    TextView bill_loan;
    @BindView(R.id.available_amount)
    TextView available_amount;
    @BindView(R.id.frozen_loan)
    TextView frozen_loan;
    @BindView(R.id.fast_car_loan_num)
    TextView fast_car_loan_num;
    @BindView(R.id.fast_car_loan)
    TextView fast_car_loan;

    Unbinder unbinder;
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_assets_ratio, container, false);
        unbinder = ButterKnife.bind(this, view);
        mPresenter.requestUserProductInfo(Config.platform,"2");

        return view;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();

    }

    @Override
    protected AssetsRatioPresenter createPresenter() {
        return new AssetsRatioPresenter(mContext);
    }

    @Override
    public void showSuccessToast(String msg) {

    }

    @Override
    public void showErrorToast(String msg) {

    }


    @Override
    public void showData(AssetRatioBean assetRatioBean) {
        available_amount.setText(assetRatioBean.getModel().getModel().getAvailable_balance());
        frozen_loan.setText(assetRatioBean.getModel().getModel().getFrozen_balance());
        int short_win_plan_per = 0,bill_loan_per = 0,consumer_credit_per = 0,win_plan_per = 0,week_win_plan_per = 0,fast_loan_per = 0;
        for(AssetRatioBean.ModelBeanX.ModelBean.HoldProductListBean bean : assetRatioBean.getModel().getModel().getHoldProductList()) {
            int id = Integer.parseInt(bean.getId());
            switch (id) {
                case 1:
                    short_win_plan_num.setText(bean.getHold_count());
                    short_win_plan.setText(bean.getHold_amount());
                    short_win_plan_per = Integer.parseInt(bean.getProportion());
                break;
                case 6:
                    bill_loan_num.setText(bean.getHold_count());
                    bill_loan.setText(bean.getHold_amount());
                    bill_loan_per = Integer.parseInt(bean.getProportion());
                    break;
                case 4:
                    consumer_credit_num.setText(bean.getHold_count());
                    consumer_credit_value.setText(bean.getHold_amount());
                    consumer_credit_per = Integer.parseInt(bean.getProportion());
                    break;
                case 2:
                    win_plan_num.setText(bean.getHold_count());
                    win_plan.setText(bean.getHold_amount());
                    win_plan_per = Integer.parseInt(bean.getProportion());
                    break;
                case 3:
                    week_win_plan_num.setText(bean.getHold_count());
                    week_win_plan.setText(bean.getHold_amount());
                    week_win_plan_per = Integer.parseInt(bean.getProportion());
                    break;
                case 5:
                    fast_car_loan_num.setText(bean.getHold_count());
                    fast_car_loan.setText(bean.getHold_amount());
                    fast_loan_per = Integer.parseInt(bean.getProportion());
                    break;

            }
        }

        MagnificentChartItem firstItem = new MagnificentChartItem("first", short_win_plan_per, Color.parseColor("#FF7753"));
        MagnificentChartItem secondItem = new MagnificentChartItem("second",win_plan_per , Color.parseColor("#FDD000"));
        MagnificentChartItem thirdItem = new MagnificentChartItem("third", week_win_plan_per, Color.parseColor("#7ED321"));
        MagnificentChartItem fourthItem = new MagnificentChartItem("fourth", consumer_credit_per, Color.parseColor("#5A96FA"));
        MagnificentChartItem fifthItem = new MagnificentChartItem("fifth", fast_loan_per, Color.parseColor("#CA98F6"));
        MagnificentChartItem sixthItem = new MagnificentChartItem("sixth", bill_loan_per, Color.parseColor("#FBB2CD"));
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
}

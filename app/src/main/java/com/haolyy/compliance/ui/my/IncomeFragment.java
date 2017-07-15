package com.haolyy.compliance.ui.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseFragment;
import com.haolyy.compliance.custom.RevenueLineView;
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

/**
 * Created by wangyin on 2017/5/16.
 */

public class IncomeFragment extends BaseFragment<FundStatisticsPresenter, FundStatictisView> implements FundStatictisView {

    private View view;
    Unbinder unbinder;
    @BindView(R.id.income_line_view)
    RevenueLineView incomeLineView;
    @BindView(R.id.date)
    TextView date;
    @BindView(R.id.total_amount)
    TextView total_amount;
    @BindView(R.id.win_plan_value)
    TextView win_plan_value;
    @BindView(R.id.win_plan_week_value)
    TextView win_plan_week_value;
    @BindView(R.id.consumer_credit_value)
    TextView consumer_credit_value;
    @BindView(R.id.bill_loan_value)
    TextView bill_loan_value;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_income, container, false);
        unbinder = ButterKnife.bind(this, view);
        mPresenter.requestUserIncomeInfo();
        return view;
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
    public void showData(FundStatictisIncomeBean fundStatictisIncomeBean) {
        List<Double> data = new ArrayList<Double>();

        String[] XLabel = new String[fundStatictisIncomeBean.getModel().getModel().getIncome_list_7().size()];
        for (int i = 0; i < fundStatictisIncomeBean.getModel().getModel().getIncome_list_7().size(); i++) {
            XLabel[i] = fundStatictisIncomeBean.getModel().getModel().getIncome_list_7().get(i).getIncomeDate().substring(5);
        }

        List<FundStatictisIncomeBean.ModelBeanX.ModelBean.IncomeList7Bean> income_list_7 = new ArrayList<FundStatictisIncomeBean.ModelBeanX.ModelBean.IncomeList7Bean>();
        income_list_7.addAll(fundStatictisIncomeBean.getModel().getModel().getIncome_list_7());
        for (int i = 0; i < income_list_7.size(); i++) {
            data.add(Double.parseDouble(income_list_7.get(i).getIncomeSum()));
        }
        total_amount.setText(income_list_7.get(income_list_7.size() - 1).getIncomeSum());
        date.setText(income_list_7.get(income_list_7.size() - 1).getIncomeDate());
        win_plan_value.setText(income_list_7.get(income_list_7.size() - 1).getXSB());
        win_plan_week_value.setText(income_list_7.get(income_list_7.size() - 1).getDQY());
        consumer_credit_value.setText(income_list_7.get(income_list_7.size() - 1).getYJH());
        bill_loan_value.setText(income_list_7.get(income_list_7.size() - 1).getYXJH());
        Collections.sort(income_list_7, new Comparator<FundStatictisIncomeBean.ModelBeanX.ModelBean.IncomeList7Bean>() {
                    @Override
                    public int compare(FundStatictisIncomeBean.ModelBeanX.ModelBean.IncomeList7Bean incomeList7Bean, FundStatictisIncomeBean.ModelBeanX.ModelBean.IncomeList7Bean t1) {
                        return (int) (Double.parseDouble(t1.getIncomeSum()) - Double.parseDouble(incomeList7Bean.getIncomeSum()));

                    }
                }
        );
        double max = Double.parseDouble(income_list_7.get(0).getIncomeSum());
        double min = Double.parseDouble(income_list_7.get(income_list_7.size() - 1).getIncomeSum());
        int inter = Math.round(Math.round((max - min) / 3));
        String[] YLabel = new String[fundStatictisIncomeBean.getModel().getModel().getIncome_list_7().size()];
        for (int i = 0; i < income_list_7.size(); i++) {
            YLabel[i] = ((int) (i * inter + min)) + "元";
        }

        double temp = 0.0;
        for (int i = 0; i < data.size(); i++) {
            temp = (data.get(i) - min) / inter;
            data.set(i, temp);
        }
        incomeLineView.setXLabel(XLabel);
        incomeLineView.setYLabel(YLabel);
        incomeLineView.setData(data);


    }

    /**
     * 不用
     *
     * @param productRatioBean
     */
    @Override
    public void showRatio(ProductRatioBean.ModelBeanX.ModelBean productRatioBean) {

    }


}

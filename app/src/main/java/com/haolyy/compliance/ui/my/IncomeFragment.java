package com.haolyy.compliance.ui.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
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
import com.haolyy.compliance.utils.DateUtil;
import com.haolyy.compliance.utils.LogUtils;

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
    private int inter;
    private String[] yLabel;
    private String[] xLabel;

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
        if ( fundStatictisIncomeBean.getModel().getModel().getIncomeList7()==null) {
            xLabel = new String[]{" ", " ", " ", " ", " ", " ", " " };
            yLabel = new String[]{"0元", "0元", "0元", "0元" };
            for (int i = 0; i < 7; i++) {
                data.set(i, 0.0);
            }
        } else {
            xLabel = new String[fundStatictisIncomeBean.getModel().getModel().getIncomeList7().size()];

            for (int i = 0; i < fundStatictisIncomeBean.getModel().getModel().getIncomeList7().size(); i++) {
                long xdate=fundStatictisIncomeBean.getModel().getModel().getIncomeList7().get(i).getIncomeDate();
                LogUtils.e("ndy_date",xdate+"");
                 xLabel[i] = DateUtil.getTimeMd(xdate*1000);
            }
            List<FundStatictisIncomeBean.ModelBeanX.ModelBean.IncomeList7Bean> income_list_7 = new ArrayList<FundStatictisIncomeBean.ModelBeanX.ModelBean.IncomeList7Bean>();
            income_list_7.addAll(fundStatictisIncomeBean.getModel().getModel().getIncomeList7());
            for (int i = 0; i < income_list_7.size(); i++) {
                data.add(income_list_7.get(i).getIncomeSum());
            }
            //与折线图无关数据
            total_amount.setText(income_list_7.get(income_list_7.size() - 1).getIncomeSum()+"");
            long datelong=income_list_7.get(income_list_7.size() - 1).getIncomeDate();
            date.setText(DateUtil.getTimeyyyymmdd(datelong*1000));
            win_plan_value.setText(income_list_7.get(income_list_7.size() - 1).getXSB()+"");
            win_plan_week_value.setText(income_list_7.get(income_list_7.size() - 1).getDQY()+"");
            consumer_credit_value.setText(income_list_7.get(income_list_7.size() - 1).getYJH()+"");
            bill_loan_value.setText(income_list_7.get(income_list_7.size() - 1).getYXJH()+"");
            //--------------------------------------------------------------------------------------

            Collections.sort(income_list_7, new Comparator<FundStatictisIncomeBean.ModelBeanX.ModelBean.IncomeList7Bean>() {
                        @Override
                        public int compare(FundStatictisIncomeBean.ModelBeanX.ModelBean.IncomeList7Bean incomeList7Bean, FundStatictisIncomeBean.ModelBeanX.ModelBean.IncomeList7Bean t1) {
                            return (int) (t1.getIncomeSum() - incomeList7Bean.getIncomeSum());

                        }
                    }
            );
            double max = income_list_7.get(0).getIncomeSum();
            double min = income_list_7.get(income_list_7.size() - 1).getIncomeSum();
            yLabel = new String[fundStatictisIncomeBean.getModel().getModel().getIncomeList7().size()];
            inter = Math.round(Math.round((max - min) / 3));
            if (max == 0) {
                //全为0
                for (int i = 0; i < income_list_7.size(); i++) {
                    yLabel[i] = "0元";
                }
            } else if (max == min) {
                //全相等
                for (int i = 0; i < income_list_7.size(); i++) {
                    yLabel[i] = ((int) (i * Math.round(max/3) + min)) + "元";
                }
            } else {
                for (int i = 0; i < income_list_7.size(); i++) {
                    yLabel[i] = ((int) (i * inter + min)) + "元";
                }

                double temp = 0.0;
                for (int i = 0; i < data.size(); i++) {
                    temp = (data.get(i) - min) / inter;
                    data.set(i, temp);
                }
            }

        }
        incomeLineView.setXLabel(xLabel);
        incomeLineView.setYLabel(yLabel);
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

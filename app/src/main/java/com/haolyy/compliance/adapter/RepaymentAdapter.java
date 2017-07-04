package com.haolyy.compliance.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.View;
import android.view.ViewGroup;

import com.haolyy.compliance.R;
import com.haolyy.compliance.databinding.RepaymentBinding;
import com.haolyy.compliance.entity.product.RepaymentPlan;

import java.util.List;

/**
 * Created by wangyin on 2017/5/22.
 */

public class RepaymentAdapter extends WyBaseAdapter {
    private RepaymentBinding binding;
    public RepaymentAdapter(List list, Context context) {
        super(list, context);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RepaymentPlan.DataBeanX.DataBean.DataListBean repayment = ( RepaymentPlan.DataBeanX.DataBean.DataListBean) list.get(position);
        binding = DataBindingUtil.inflate(inflater, R.layout.item_repayment_plan, parent, false);
        binding.setRepayment(repayment);
        binding.tvRepaymentPeriods.setText(String.valueOf(repayment.getPeriod_no())+"期");
        return binding.getRoot();
    }
}

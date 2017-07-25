package com.haolyy.compliance.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.View;
import android.view.ViewGroup;

import com.haolyy.compliance.R;
import com.haolyy.compliance.databinding.InvestLogBinding;
import com.haolyy.compliance.entity.product.InvestLog;

import java.util.List;

/**
 * Created by wangyin on 2017/5/22.
 */

public class InvestLogAdapter extends WyBaseAdapter {
    private InvestLogBinding binding;

    public InvestLogAdapter(List list, Context context) {
        super(list, context);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        InvestLog.ModelBeanX.ModelBean.InvestmentRecordListBean investLog = (InvestLog.ModelBeanX.ModelBean.InvestmentRecordListBean) list.get(position);
        binding = DataBindingUtil.inflate(inflater, R.layout.item_invest_log, parent, false);
        binding.setInvestLog(investLog);
        return binding.getRoot();
    }
}

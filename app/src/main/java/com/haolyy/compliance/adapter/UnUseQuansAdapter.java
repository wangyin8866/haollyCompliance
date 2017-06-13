package com.haolyy.compliance.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.View;
import android.view.ViewGroup;

import com.haolyy.compliance.R;
import com.haolyy.compliance.databinding.TicketDisableBinding;
import com.haolyy.compliance.entity.Repayment;

import java.util.List;

/**
 * Created by wangyin on 2017/6/13.
 */

public class UnUseQuansAdapter extends WyBaseAdapter {
    private TicketDisableBinding binding;
    public UnUseQuansAdapter(List list, Context context) {
        super(list, context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Repayment repayment = (Repayment) list.get(position);
        binding = DataBindingUtil.inflate(inflater, R.layout.item_unuseful_quan, parent, false);
        binding.setRepayment(repayment);
        binding.tvQuanRate.setText(repayment.getPeriods() + "%");
        return binding.getRoot();

    }
}

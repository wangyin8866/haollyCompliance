package com.haolyy.compliance.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.View;
import android.view.ViewGroup;

import com.haolyy.compliance.R;
import com.haolyy.compliance.databinding.CreditorBinding;
import com.haolyy.compliance.entity.CreditorInfo;

import java.util.List;

/**
 * Created by wangyin on 2017/5/22.
 */

public class CreditorInfoAdapter extends WyBaseAdapter {
    private CreditorBinding creditorBinding;
    private CreditorInfo creditorInfo;

    public CreditorInfoAdapter(List list, Context context) {
        super(list, context);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        creditorInfo = (CreditorInfo) list.get(position);
        creditorBinding = DataBindingUtil.inflate(inflater, R.layout.item_creditor_info, parent, false);
        creditorBinding.setCreditor(creditorInfo);
        return creditorBinding.getRoot();
    }


}

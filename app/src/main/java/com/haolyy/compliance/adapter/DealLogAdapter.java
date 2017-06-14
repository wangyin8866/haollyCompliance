package com.haolyy.compliance.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.View;
import android.view.ViewGroup;

import com.haolyy.compliance.R;
import com.haolyy.compliance.databinding.InvestLogBinding;
import com.haolyy.compliance.entity.InvestLog;

import java.util.List;

/**
 * Created by wangyin on 2017/5/22.
 */

public class DealLogAdapter extends WyBaseAdapter {

    public DealLogAdapter(List list, Context context) {
        super(list, context);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DealHolder dealHolder=null;
        if(null==convertView){
            dealHolder=new DealHolder();
            convertView=dealHolder.view;
            convertView.setTag(dealHolder);
        }
        else {
            dealHolder= (DealHolder) convertView.getTag();
        }
        return convertView;
    }

    public class DealHolder{
         View view;
        public DealHolder() {
            view = View.inflate(mContext, R.layout.item_deal_log, null);
        }
    }
}

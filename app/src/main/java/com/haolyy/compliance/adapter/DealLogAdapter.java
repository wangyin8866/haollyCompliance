package com.haolyy.compliance.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.databinding.InvestLogBinding;
import com.haolyy.compliance.entity.InvestLog;
import com.haolyy.compliance.ui.my.Bean.DealRecordBean;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by wangyin on 2017/5/22.
 */

public class DealLogAdapter extends WyBaseAdapter {
    private List<DealRecordBean.ModelBeanX.ModelBean.FundsRecordListBean> list;

    public DealLogAdapter(List<DealRecordBean.ModelBeanX.ModelBean.FundsRecordListBean> list, Context context) {
        super(list, context);
        this.list = list;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DealHolder dealHolder=null;
        if(null==convertView){
            dealHolder=new DealHolder();
            convertView=dealHolder.view;
            dealHolder.title = (TextView) convertView.findViewById(R.id.title);
            dealHolder.tv_recharge_date = (TextView) convertView.findViewById(R.id.tv_recharge_date);
            dealHolder.tv_recharge_account = (TextView) convertView.findViewById(R.id.tv_recharge_account);
            dealHolder.tv_recharge_process = (TextView) convertView.findViewById(R.id.tv_recharge_process);
            convertView.setTag(dealHolder);
        }
        else {
            dealHolder= (DealHolder) convertView.getTag();
        }

        for(DealRecordBean.ModelBeanX.ModelBean.FundsRecordListBean bean : list) {
//            dealHolder.title = bean.get
            dealHolder.tv_recharge_date.setText(bean.getTransferDate());
            dealHolder.tv_recharge_account.setText("+"+bean.getAmount()+"元");
            dealHolder.tv_recharge_process.setText("余额："+bean.getAvailableAmount()+"元");
        }


        return convertView;
    }

    public class DealHolder{
         View view;
        TextView title,tv_recharge_date,tv_recharge_account,tv_recharge_process;
        public DealHolder() {
            view = View.inflate(mContext, R.layout.item_deal_log, null);
        }
    }
}

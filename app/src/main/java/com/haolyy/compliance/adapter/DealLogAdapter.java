package com.haolyy.compliance.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.ui.my.Bean.DealRecordBean;
import com.haolyy.compliance.utils.DateUtil;
import com.haolyy.compliance.utils.LogUtils;

import java.util.List;

/**
 * Created by wangyin on 2017/5/22.
 */

public class DealLogAdapter extends WyBaseAdapter {
    private List<DealRecordBean.ModelBeanX.ModelBean.FundsRecordListBean> list;

    public DealLogAdapter(List<DealRecordBean.ModelBeanX.ModelBean.FundsRecordListBean> list, Context context) {
        super(list, context);
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DealHolder dealHolder = null;
        if (null == convertView) {
            dealHolder = new DealHolder();
            convertView = dealHolder.view;
            dealHolder.title = (TextView) convertView.findViewById(R.id.title);
            dealHolder.tv_recharge_date = (TextView) convertView.findViewById(R.id.tv_recharge_date);
            dealHolder.tv_recharge_account = (TextView) convertView.findViewById(R.id.tv_recharge_account);
            dealHolder.tv_recharge_process = (TextView) convertView.findViewById(R.id.tv_recharge_process);
            dealHolder.tv_group = (TextView) convertView.findViewById(R.id.tv_group);
            convertView.setTag(dealHolder);
        } else {
            dealHolder = (DealHolder) convertView.getTag();
        }
        DealRecordBean.ModelBeanX.ModelBean.FundsRecordListBean bean = list.get(position);
        String timeYHMDHM = DateUtil.getTimeYHMDHM(Long.parseLong(bean.getTransferDate()) * 1000);
        dealHolder.tv_recharge_date.setText(timeYHMDHM);
        String year = timeYHMDHM.substring(0, 7);
        if (position == 0) {
            LogUtils.e("ndy","position0");
            dealHolder.tv_group.setVisibility(View.VISIBLE);
            dealHolder.tv_group.setText(year);
        } else if (!DateUtil.getTimeYHMDHM(Long.parseLong(list.get(position - 1).getTransferDate()) * 1000).substring(0, 7).equals(year)) {
            //LogUtils.e("ndy",DateUtil.getTimeYHMDHM(Long.parseLong(list.get(position - 1).getTransferDate()) * 1000).substring(0, 7)+position+year);
            dealHolder.tv_group.setVisibility(View.VISIBLE);
            dealHolder.tv_group.setText(year);
        }else {
            dealHolder.tv_group.setVisibility(View.GONE);
        }
        dealHolder.tv_recharge_process.setText("余额：" + bean.getAvailableAmount() + "元");
        switch (bean.getCapitalType()) {
            case 2001:
                dealHolder.title.setText("充值");
                dealHolder.tv_recharge_account.setTextColor(Color.parseColor("#f8676f"));
                dealHolder.tv_recharge_account.setText("+" + bean.getAmount() + "元");
                break;
            case 200303:
                dealHolder.tv_recharge_account.setTextColor(Color.parseColor("#20b795"));
                dealHolder.tv_recharge_account.setText("-" + bean.getAmount() + "元");
                dealHolder.title.setText("提现");
                break;
            case 300611:
                dealHolder.tv_recharge_account.setTextColor(Color.parseColor("#20b795"));
                dealHolder.tv_recharge_account.setText("-" + bean.getAmount() + "元");
                dealHolder.title.setText("投资");
                break;
            case 300606:
                dealHolder.title.setText("回息");
                dealHolder.tv_recharge_account.setTextColor(Color.parseColor("#f8676f"));
                dealHolder.tv_recharge_account.setText("+" + bean.getAmount() + "元");
                break;
            case 300605:
                dealHolder.title.setText("回本");
                dealHolder.tv_recharge_account.setTextColor(Color.parseColor("#f8676f"));
                dealHolder.tv_recharge_account.setText("+" + bean.getAmount() + "元");
                break;
            case 200304:
                dealHolder.tv_recharge_account.setTextColor(Color.parseColor("#20b795"));
                dealHolder.tv_recharge_account.setText("-" + bean.getAmount() + "元");
                dealHolder.title.setText("手续费");
                break;
            case 300634:
                dealHolder.tv_recharge_account.setTextColor(Color.parseColor("#20b795"));
                dealHolder.tv_recharge_account.setText("-" + bean.getAmount() + "元");
                dealHolder.title.setText("奖励");
                break;
            case 8:
                dealHolder.title.setText("其他");
                dealHolder.tv_recharge_account.setTextColor(Color.parseColor("#f8676f"));
                dealHolder.tv_recharge_account.setText("+" + bean.getAmount() + "元");
                break;
        }

        return convertView;
    }

    public class DealHolder {
        View view;
        TextView title, tv_recharge_date, tv_recharge_account, tv_recharge_process, tv_group;

        public DealHolder() {
            view = View.inflate(mContext, R.layout.item_deal_log, null);
        }
    }
}

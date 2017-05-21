package com.haolyy.compliance.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.custom.SpringProgressView;
import com.haolyy.compliance.entity.TestProduct;

import java.util.List;

/**
 * Created by wangyin on 2017/5/18.
 */

public class HomeProductAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private Context mContext;
    private List<TestProduct> products;
    public HomeProductAdapter(Context mContext, List<TestProduct> products) {
        this.mContext = mContext;
        this.products = products;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TestProduct product = products.get(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_home_product, parent,false);
            viewHolder.num = (TextView) convertView.findViewById(R.id.tv_num);
            viewHolder.tv_borrowType_str = (TextView) convertView.findViewById(R.id.tv_borrowType_str);
            viewHolder.pro_deadline = (TextView) convertView.findViewById(R.id.pro_deadline);
            viewHolder.yield1 = (TextView) convertView.findViewById(R.id.pro_yield1);
            viewHolder.pro_amount = (TextView) convertView.findViewById(R.id.pro_amount);
            viewHolder.springProgressView = (SpringProgressView) convertView.findViewById(R.id.progressBar);

            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.num.setText(product.getNum()+"");
        viewHolder.tv_borrowType_str.setText(product.getTotal()+"");
        viewHolder.yield1.setText(product.getRate()+"");
        viewHolder.pro_amount.setText(product.getTotal()+"");
        viewHolder.pro_deadline.setText(product.getDeline()+"周");
        viewHolder.springProgressView.setMaxCount(1000);
        viewHolder.springProgressView.setCurrentCount(500);

        return convertView;
    }

    private static class ViewHolder {
        TextView num;
        TextView tv_borrowType_str;
        TextView yield1;
        TextView pro_deadline;
        TextView pro_amount;
        SpringProgressView springProgressView;
    }
}

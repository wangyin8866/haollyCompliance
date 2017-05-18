package com.haolyy.compliance.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.custom.CircleView;
import com.haolyy.compliance.entity.TestProduct;

import java.util.List;

/**
 * Created by wangyin on 2017/5/18.
 */

public class ProductFirstAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private Context mContext;
    private List<TestProduct> products;

    public ProductFirstAdapter(Context mContext, List<TestProduct> products) {
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
            convertView = inflater.inflate(R.layout.product_first_item, null);
            viewHolder.num = (TextView) convertView.findViewById(R.id.tv_num);
            viewHolder.total = (TextView) convertView.findViewById(R.id.tv_total);
            viewHolder.pro_deadline = (TextView) convertView.findViewById(R.id.pro_deadline);
            viewHolder.yield1 = (TextView) convertView.findViewById(R.id.pro_yield1);
            viewHolder.circleView = (CircleView) convertView.findViewById(R.id.product_circle);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.num.setText(product.getNum()+"");
        viewHolder.total.setText(product.getTotal()+"");
        viewHolder.yield1.setText(product.getRate()+"");
        viewHolder.pro_deadline.setText(product.getDeline()+"周");
        viewHolder.circleView.setData(1000,1000);
        viewHolder.circleView.setmCircleText((product.getData()/product.getTotal()*100)+"%");
        return convertView;
    }

    private static class ViewHolder {
        TextView num;
        TextView total;
        TextView yield1;
        TextView pro_deadline;
        CircleView circleView;
    }
}

package com.haolyy.compliance.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.custom.SpringProgressView;
import com.haolyy.compliance.entity.TestProduct;

import java.util.List;

/**
 * Created by wangyin on 2017/5/19.
 */

public class HomeNewPagerAdapter extends PagerAdapter {
    private List<TestProduct> products;
    private Context mContext;
    private LayoutInflater inflate;
    private TestProduct testProduct;

    public HomeNewPagerAdapter(List<TestProduct> products, Context context) {
        mContext = context;
        this.products = products;
        inflate = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        testProduct = products.get(position);
        ViewHolder viewHolder = new ViewHolder();
        View view = inflate.inflate(R.layout.home_new_pager_item, container, false);
        viewHolder.yield1= ((TextView) view.findViewById(R.id.pro_yield1));
        viewHolder.yield2=((TextView) view.findViewById(R.id.pro_yield2));
        viewHolder.pro_deadline=((TextView) view.findViewById(R.id.pro_deadline));
        viewHolder.total=((TextView) view.findViewById(R.id.tv_borrowType_str));
        viewHolder.progressView = (SpringProgressView) view.findViewById(R.id.progressBar);


        viewHolder.yield1.setText(testProduct.getRate() + "");
        viewHolder.yield2.setText(testProduct.getRate() + "");
        viewHolder.pro_deadline.setText(testProduct.getDeline() + "天");
        viewHolder.total.setText(testProduct.getTotal() + "元");
        viewHolder.progressView.setCurrentCount(500);
        viewHolder.progressView.setMaxCount(800);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    static class ViewHolder {
        TextView total;
        TextView yield1;
        TextView yield2;
        TextView pro_deadline;
        SpringProgressView progressView;
    }
}

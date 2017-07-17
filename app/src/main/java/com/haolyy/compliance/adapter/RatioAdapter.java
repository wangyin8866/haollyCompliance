package com.haolyy.compliance.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.entity.my.ProductRatioBean;
import com.haolyy.compliance.utils.UIUtils;

import java.util.List;

/**
 * Created by wangyin on 2017/5/22.
 */

public class RatioAdapter extends WyBaseAdapter {
    private List<ProductRatioBean.ModelBeanX.ModelBean.HoldProductListBean> list;

    public RatioAdapter(List<ProductRatioBean.ModelBeanX.ModelBean.HoldProductListBean> list, Context context) {
        super(list, context);
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RatioHolder ratioHolder = null;
        if (null == convertView) {
            ratioHolder = new RatioHolder();
            convertView = ratioHolder.view;
            ratioHolder.tv_left = (TextView) convertView.findViewById(R.id.tv_ratio_left);
            ratioHolder.tv_center = (TextView) convertView.findViewById(R.id.tv_ratio_center);
            ratioHolder.tv_right = (TextView) convertView.findViewById(R.id.tv_ratio_right);
            convertView.setTag(ratioHolder);
        } else {
            ratioHolder = (RatioHolder) convertView.getTag();
        }
        ratioHolder.tv_center.setText(list.get(position).getHold_count());
        ratioHolder.tv_right.setText(list.get(position).getHold_amount());
        ratioHolder.tv_left.setCompoundDrawablePadding(UIUtils.dip2px(9));
        switch (list.get(position).getId()) {
            case "1":
                ratioHolder.tv_left.setText("短期赢");
                Drawable drawable = UIUtils.getDrawable(R.mipmap.point_short_win);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ratioHolder.tv_left.setCompoundDrawables(drawable, null, null, null);
                break;
            case "2":
                ratioHolder.tv_left.setText("赢计划");
                Drawable drawable2 = UIUtils.getDrawable(R.mipmap.point_yellow);
                drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                ratioHolder.tv_left.setCompoundDrawables(drawable2, null, null, null);
                break;
            case "3":
                ratioHolder.tv_left.setText("周周赢");
                Drawable drawable3 = UIUtils.getDrawable(R.mipmap.point_green);
                drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                ratioHolder.tv_left.setCompoundDrawables(drawable3, null, null, null);
                break;
            case "4":
                ratioHolder.tv_left.setText("消费贷");
                Drawable drawable4 = UIUtils.getDrawable(R.mipmap.point_blue);
                drawable4.setBounds(0, 0, drawable4.getMinimumWidth(), drawable4.getMinimumHeight());
                ratioHolder.tv_left.setCompoundDrawables(drawable4, null, null, null);
                break;
            case "5":
                ratioHolder.tv_left.setText("闪车贷");
                Drawable drawable5 = UIUtils.getDrawable(R.mipmap.point_purple);
                drawable5.setBounds(0, 0, drawable5.getMinimumWidth(), drawable5.getMinimumHeight());
                ratioHolder.tv_left.setCompoundDrawables(drawable5, null, null, null);
                break;
            case "6":
                ratioHolder.tv_left.setText("票据贷");
                Drawable drawable6 = UIUtils.getDrawable(R.mipmap.point_pink);
                drawable6.setBounds(0, 0, drawable6.getMinimumWidth(), drawable6.getMinimumHeight());
                ratioHolder.tv_left.setCompoundDrawables(drawable6, null, null, null);
                break;
            case "7":
                ratioHolder.tv_left.setText("可用金额");
                Drawable drawable7 = UIUtils.getDrawable(R.mipmap.point_unuseful);
                drawable7.setBounds(0, 0, drawable7.getMinimumWidth(), drawable7.getMinimumHeight());
                ratioHolder.tv_left.setCompoundDrawables(drawable7, null, null, null);
                break;
            case "8":
                ratioHolder.tv_left.setText("冻结金额");
                Drawable drawable8 = UIUtils.getDrawable(R.mipmap.point_useful);
                drawable8.setBounds(0, 0, drawable8.getMinimumWidth(), drawable8.getMinimumHeight());
                ratioHolder.tv_left.setCompoundDrawables(drawable8, null, null, null);
                break;
        }
        list.get(position);

        return convertView;
    }

    public class RatioHolder {
        View view;
        TextView tv_left, tv_center, tv_right;

        public RatioHolder() {
            view = View.inflate(mContext, R.layout.item_ratio, null);
        }
    }
}

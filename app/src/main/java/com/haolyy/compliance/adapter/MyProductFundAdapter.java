package com.haolyy.compliance.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.View;
import android.view.ViewGroup;

import com.haolyy.compliance.R;
import com.haolyy.compliance.databinding.ProductFundBinding;
import com.haolyy.compliance.entity.my.ProductFund;

import java.util.List;

/**
 * Created by wangyin on 2017/5/18.
 */

public class MyProductFundAdapter extends WyBaseAdapter {

    private ProductFundBinding binding;

    public MyProductFundAdapter(List list, Context context) {
        super(list, context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ProductFund.ModelBeanX.ModelBean.ProductFundsBean product = (ProductFund.ModelBeanX.ModelBean.ProductFundsBean) list.get(position);
        binding = DataBindingUtil.inflate(inflater, R.layout.item_my_product_fund, parent, false);
        switchIcon(product.getFirstCategory());

        binding.setProductFund(product);
        return binding.getRoot();
    }

    private void switchIcon(String firstCategory) {
        switch (firstCategory) {
            case "DQY":
                binding.productName.setCompoundDrawablesWithIntrinsicBounds(mContext.getResources().getDrawable(R.mipmap.point_pink), null, null, null);
                break;
            case "YJH":
                binding.productName.setCompoundDrawablesWithIntrinsicBounds(mContext.getResources().getDrawable(R.mipmap.point_blue), null, null, null);
                break;
            case "YXJH":
                binding.productName.setCompoundDrawablesWithIntrinsicBounds(mContext.getResources().getDrawable(R.mipmap.point_green), null, null, null);
                break;
            default:
                binding.productName.setCompoundDrawablesWithIntrinsicBounds(mContext.getResources().getDrawable(R.mipmap.point_purple), null, null, null);
                break;
        }
    }

}

package com.haolyy.compliance.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.View;
import android.view.ViewGroup;

import com.haolyy.compliance.R;
import com.haolyy.compliance.databinding.ProductFundListBinding;
import com.haolyy.compliance.entity.my.ProductFundList;

import java.util.List;

/**
 * Created by wangyin on 2017/5/18.
 */

public class ProductFundListAdapter extends WyBaseAdapter {
    private ProductFundListBinding binding;

    public ProductFundListAdapter(List list, Context context) {
        super(list, context);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       ProductFundList.ModelBeanX.ModelBean.AssetManagementListBean product = ( ProductFundList.ModelBeanX.ModelBean.AssetManagementListBean) list.get(position);
        binding = DataBindingUtil.inflate(inflater, R.layout.item_product_fund_list, parent, false);
        binding.setProduct(product);

        binding.productName.setText(product.getProjectName());
        binding.productBuyMoney.setText(product.getAmount());
        binding.productInvestDate.setText(product.getOrderDate());
        return binding.getRoot();
    }





}

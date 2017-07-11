package com.haolyy.compliance.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.View;
import android.view.ViewGroup;

import com.haolyy.compliance.R;
import com.haolyy.compliance.databinding.HomeBinding;
import com.haolyy.compliance.entity.home.HomeProduct;
import com.haolyy.compliance.utils.WYUtils;

import java.util.List;

/**
 * Created by wangyin on 2017/5/18.
 */

public class HomeProductAdapter extends WyBaseAdapter {

    private HomeBinding binding;

    public HomeProductAdapter(List list, Context context) {
        super(list, context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HomeProduct.ModelBeanX.ModelBean product = (HomeProduct.ModelBeanX.ModelBean) list.get(position);

        binding = DataBindingUtil.inflate(inflater, R.layout.item_home_product, parent, false);
        binding.setProduct(product);

        binding.tvNum.setText(product.getProductName());
        binding.tvBorrowTypeStr.setText(product.getContractAmount()+"元");
        binding.proYield1.setText(product.getAnnualizedRate());
        WYUtils.setVisibility(binding.rateAdd, binding.proYield2, binding.extraRatePercent, product.getAppendRate());
        binding.proYield2.setText(product.getAppendRate());
        binding.proAmount.setText(product.getAppendRate());
        binding.proDeadline.setText(product.getPeriodLength() + WYUtils.getInvestDeadline(product.getPeriodUnit()));
        WYUtils.selectIcon(product.getProductName(),binding.ivDuan);
        binding.progressBar.setMaxCount(WYUtils.processAmount(product.getContractAmount()));
        binding.progressBar.setCurrentCount(WYUtils.processAmount(product.getContractAmount())*WYUtils.processAmount(product.getAmountScale()));
        binding.tvProgress.setText(product.getAmountScale()+"%");
        return binding.getRoot();
    }


}

package com.haolyy.compliance.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.View;
import android.view.ViewGroup;

import com.haolyy.compliance.R;
import com.haolyy.compliance.databinding.HomeBinding;
import com.haolyy.compliance.entity.TestProduct;
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
        TestProduct product = (TestProduct) list.get(position);
        binding = DataBindingUtil.inflate(inflater, R.layout.item_home_product, parent, false);
        binding.setProduct(product);
        binding.tvNum.setText(product.getNum()+"");
        binding.tvBorrowTypeStr.setText(product.getTotal()+"");
        binding.proYield1.setText(product.getRate()+"");
        binding.proAmount.setText(product.getTotal()+"");
        binding.proDeadline.setText(product.getDeline()+"周");
        binding.progressBar.setMaxCount(1000);
        binding.progressBar.setCurrentCount(500);
        WYUtils.selectIcon(product.getNum()+"",binding.ivDuan);
        return binding.getRoot();
    }

}

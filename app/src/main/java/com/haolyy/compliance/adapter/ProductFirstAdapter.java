package com.haolyy.compliance.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.View;
import android.view.ViewGroup;

import com.haolyy.compliance.R;
import com.haolyy.compliance.databinding.ProductFirstBinding;
import com.haolyy.compliance.entity.TestProduct;

import java.util.List;

/**
 * Created by wangyin on 2017/5/18.
 */

public class ProductFirstAdapter extends WyBaseAdapter {
    private ProductFirstBinding binding;
    public ProductFirstAdapter(List list, Context context) {
        super(list, context);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TestProduct product = (TestProduct) list.get(position);
        binding = DataBindingUtil.inflate(inflater, R.layout.item_product_first, parent, false);
        binding.setProductFirst(product);


        binding.tvNum.setText(product.getNum()+"");
        binding.tvTotal.setText(product.getTotal()+"");
        binding.proYield1.setText(product.getRate()+"");
        binding.proDeadline.setText(product.getDeline()+"周");
        binding.productCircle.setData(800,1000);
        binding.productCircle.setmCircleText("60%");
        return binding.getRoot();
    }


}

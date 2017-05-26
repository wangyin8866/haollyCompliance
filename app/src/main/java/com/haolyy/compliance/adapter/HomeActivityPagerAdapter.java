package com.haolyy.compliance.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.ViewGroup;

import com.haolyy.compliance.R;
import com.haolyy.compliance.databinding.HomeActivityBinding;
import com.haolyy.compliance.entity.TestProduct;

import java.util.List;

/**
 * Created by wangyin on 2017/5/19.
 */

public class HomeActivityPagerAdapter extends WyBasePagerAdapter {

    private TestProduct testProduct;
    private HomeActivityBinding binding;

    public HomeActivityPagerAdapter(List list, Context mContext) {
        super(list, mContext);
    }





    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        testProduct = (TestProduct) list.get(position);
        binding = DataBindingUtil.inflate(inflate, R.layout.item_home_activity_pager, container, false);
        binding.setHomeActivity(testProduct);
        binding.proYield1.setText(testProduct.getRate() + "");
        binding.proYield2.setText(testProduct.getRate() + "");
        binding.proDeadline.setText(testProduct.getDeline() + "天");
        binding.tvBorrowTypeStr.setText(testProduct.getTotal() + "元");
        container.addView( binding.getRoot());
        return binding.getRoot();
    }



}

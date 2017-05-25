package com.haolyy.compliance.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.ViewGroup;

import com.haolyy.compliance.R;
import com.haolyy.compliance.databinding.HomeNewBinding;
import com.haolyy.compliance.entity.TestProduct;

import java.util.List;

/**
 * Created by wangyin on 2017/5/19.
 */

public class HomeNewPagerAdapter extends WyBasePagerAdapter {

    private TestProduct testProduct;
    private HomeNewBinding binding;

    public HomeNewPagerAdapter(List list, Context mContext) {
        super(list, mContext);
    }



    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        testProduct = (TestProduct) list.get(position);
        binding = DataBindingUtil.inflate(inflate, R.layout.item_home_new_pager, container, false);
        binding.setHomeNew(testProduct);


        binding.proYield1.setText(testProduct.getRate() + "");
        binding.proYield2.setText(testProduct.getRate() + "");
        binding.proDeadline.setText(testProduct.getDeline() + "天");
        binding.tvBorrowTypeStr.setText(testProduct.getTotal() + "元");
        binding.progressBar.setCurrentCount(500);
        binding.progressBar.setMaxCount(800);

        container.addView(binding.getRoot());
        return binding.getRoot();
    }




}

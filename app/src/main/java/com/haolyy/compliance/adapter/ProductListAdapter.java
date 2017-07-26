package com.haolyy.compliance.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;

import com.haolyy.compliance.R;
import com.haolyy.compliance.databinding.ProductFirstBinding;
import com.haolyy.compliance.entity.product.ProductList;
import com.haolyy.compliance.utils.WYUtils;

import java.util.List;

/**
 * Created by wangyin on 2017/5/18.
 */

public class ProductListAdapter extends WyBaseAdapter {
    private ProductFirstBinding binding;

    public ProductListAdapter(List list, Context context) {
        super(list, context);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ProductList.ModelBeanX.ModelBean.DataListBean product = (ProductList.ModelBeanX.ModelBean.DataListBean) list.get(position);
        binding = DataBindingUtil.inflate(inflater, R.layout.item_product_first, parent, false);
        binding.setProduct(product);
        binding.setAdapter(this);

        double scale =  WYUtils.processAmount(product.getAmountScale()) / 100;
        binding.tvNum.setText(product.getProjectName());
        binding.tvAmount.setText(product.getContractAmount()+"万");
        WYUtils.selectIcon(product.getProjectName(),binding.ivDuan);
        binding.productCircle.setData(WYUtils.processAmount(product.getContractAmount()) * scale, WYUtils.processAmount(product.getContractAmount()));
        if (product.getAmountScale().contains("100")) {
            binding.productCircle.setmCircleText("已售罄");
            binding.productCircle.setmOutColorEnd(Color.parseColor("#cccccc"));
            binding.productCircle.setmOutColorStart(Color.parseColor("#cccccc"));
            binding.productCircle.setmCircleTextColor(Color.parseColor("#cccccc"));

        } else {
        binding.productCircle.setmCircleText(product.getAmountScale() + "%");
        }

        return binding.getRoot();
    }



    /**
     * 显示投资期限
     *
     * @param terTime
     * @param timeType
     * @return
     */
    public String showDeadline(int terTime, int timeType) {

        return terTime + WYUtils.getInvestDeadline(timeType);
    }

}

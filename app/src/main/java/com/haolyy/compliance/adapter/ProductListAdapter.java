package com.haolyy.compliance.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.View;
import android.view.ViewGroup;

import com.haolyy.compliance.R;
import com.haolyy.compliance.databinding.ProductFirstBinding;
import com.haolyy.compliance.entity.product.ProductList;
import com.haolyy.compliance.utils.WyUtils;

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
        ProductList.DataBeanX.DataBean.DataListBean product = (ProductList.DataBeanX.DataBean.DataListBean) list.get(position);
        binding = DataBindingUtil.inflate(inflater, R.layout.item_product_first, parent, false);
        binding.setProduct(product);
        binding.setAdapter(this);
        Double amount = Double.valueOf(product.getContract_amount().replace(",", ""));
        double scale = Double.valueOf(product.getAmount_scale()) / 100;
        binding.tvNum.setText(product.getProject_name());
        binding.tvAmount.setText(product.getContract_amount()+"万");
        selectIcon(product.getProject_name());
        binding.productCircle.setData(amount * scale, amount);
        binding.productCircle.setmCircleText(product.getAmount_scale() + "%");
        return binding.getRoot();
    }

    private void selectIcon(String name) {
        if (name.contains("短期赢")) {
            binding.ivDuan.setBackgroundResource(R.mipmap.duan);
        } else if (name.contains("赢计划")) {
            binding.ivDuan.setBackgroundResource(R.mipmap.icon_ying);
        }else if (name.contains("周周赢")) {
            binding.ivDuan.setBackgroundResource(R.mipmap.icon_zhou);
        }else if (name.contains("消费贷")) {
            binding.ivDuan.setBackgroundResource(R.mipmap.icon_xiao);
        }else if (name.contains("闪车贷")) {
            binding.ivDuan.setBackgroundResource(R.mipmap.icon_che);
        }else if (name.contains("票据贷")) {
            binding.ivDuan.setBackgroundResource(R.mipmap.icon_piao);
        }

    }

    /**
     * 显示投资期限
     *
     * @param terTime
     * @param timeType
     * @return
     */
    public String showDeadline(int terTime, int timeType) {

        return terTime + WyUtils.getInvestDeadline(timeType);
    }

}

package com.haolyy.compliance.adapter;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.view.View;
import android.view.ViewGroup;

import com.haolyy.compliance.R;
import com.haolyy.compliance.databinding.HomeNewBinding;
import com.haolyy.compliance.entity.home.HomeActivity;
import com.haolyy.compliance.ui.product.ProductDetailActivity;
import com.haolyy.compliance.utils.WYUtils;

import java.util.List;

/**
 * Created by wangyin on 2017/5/19.
 */

public class HomeNewPagerAdapter extends WyBasePagerAdapter {

    private HomeActivity.ModelBeanX.ModelBean.RecommendNewBean recommendNewBean;
    private HomeNewBinding binding;

    public HomeNewPagerAdapter(List list, Context mContext) {
        super(list, mContext);
    }


    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        recommendNewBean = (HomeActivity.ModelBeanX.ModelBean.RecommendNewBean) list.get(position);
        binding = DataBindingUtil.inflate(inflate, R.layout.item_home_new_pager, container, false);
        binding.setHomeNew(recommendNewBean);
        binding.proYield1.setText(recommendNewBean.getAnnualizedRate() + "");
        WYUtils.setVisibility(binding.rateAdd, binding.proYield2, binding.extraRatePercent, recommendNewBean.getAppendRate());
        binding.proYield2.setText(recommendNewBean.getAppendRate() + "");
        binding.proDeadline.setText(recommendNewBean.getPeriodLength() + WYUtils.getInvestDeadline(recommendNewBean.getPeriodUnit()));
        binding.tvBorrowTypeStr.setText(recommendNewBean.getAmountWait() + "元");
        binding.progressBar.setMaxCount(WYUtils.processAmount(recommendNewBean.getAmountWait()) + WYUtils.processAmount(recommendNewBean.getAmountYes()));
        binding.progressBar.setCurrentCount((WYUtils.processAmount(recommendNewBean.getAmountWait()) + WYUtils.processAmount(recommendNewBean.getAmountYes())) * WYUtils.processAmount(recommendNewBean.getAmountScale()) / 100);
        binding.tvProgress.setText(recommendNewBean.getAmountScale() + "%");
        binding.llAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ProductDetailActivity.class);
                intent.putExtra("projectNo", recommendNewBean.getProjectNo());
                intent.putExtra("productName", recommendNewBean.getProjectTitle());
                intent.putExtra("project_type", recommendNewBean.getProjectType());
                intent.putExtra("product_no", recommendNewBean.getProductNo());
                mContext.startActivity(intent);
            }
        });


        container.addView(binding.getRoot());
        return binding.getRoot();
    }


}

package com.haolyy.compliance.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.ViewGroup;

import com.haolyy.compliance.R;
import com.haolyy.compliance.databinding.HomeActivityBinding;
import com.haolyy.compliance.entity.home.HomeActivity;
import com.haolyy.compliance.utils.WYUtils;

import java.util.List;

/**
 * Created by wangyin on 2017/5/19.
 */

public class HomeActivityPagerAdapter extends WyBasePagerAdapter {

    private HomeActivity.ModelBeanX.ModelBean.RecommendBean recommendBean;
    private HomeActivityBinding binding;

    public HomeActivityPagerAdapter(List list, Context mContext) {
        super(list, mContext);
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        recommendBean = (HomeActivity.ModelBeanX.ModelBean.RecommendBean) list.get(position);
        binding = DataBindingUtil.inflate(inflate, R.layout.item_home_activity_pager, container, false);
        binding.setHomeActivity(recommendBean);
        binding.proYield1.setText(recommendBean.getAnnualizedRate() + "");
        WYUtils.setVisibility(binding.rateAdd, binding.proYield2, binding.extraRatePercent, recommendBean.getAppendRate());
        binding.proYield2.setText(recommendBean.getAppendRate() + "");
        binding.proDeadline.setText(recommendBean.getPeriodLength() + WYUtils.getInvestDeadline(recommendBean.getPeriodUnit()));
        binding.tvBorrowTypeStr.setText(recommendBean.getAppendRate() + "元");
        container.addView(binding.getRoot());
        return binding.getRoot();
    }


}

package com.haolyy.compliance.ui.product;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.haolyy.compliance.R;
import com.haolyy.compliance.adapter.TabAdapter;
import com.haolyy.compliance.base.BaseFragment;
import com.haolyy.compliance.ui.product.presenter.ProductBottomPresenter;
import com.haolyy.compliance.ui.product.view.ProductBottomView;
import com.haolyy.compliance.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 产品详情下部页面
 * Created by wangyin on 2017/5/16.
 */

public class ProductFragmentBottom extends BaseFragment<ProductBottomPresenter, ProductBottomView> implements ProductBottomView {

    @BindView(R.id.tablayout_bottom)
    TabLayout tablayoutBottom;
    @BindView(R.id.vp_join_record)
    ViewPager vpJoinRecord;
    Unbinder unbinder;
    private View view;
    private List<String> titles = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();

    FragmentBottomProductDetail bottomProductDetail;
    FragmentBottomInvestLog bottomInvestLog;
    FragmentBottomCreditorInfo bottomCreditorInfo;
    FragmentBottomBorrowDetail bottomBorrowDetail;
    FragmentBottomRepaymentPlan bottomRepaymentPlan;
    private String product_no;
    @Override
    protected ProductBottomPresenter createPresenter() {
        return new ProductBottomPresenter(mContext);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_product_bottom, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        bottomProductDetail = new FragmentBottomProductDetail();
        bottomInvestLog = new FragmentBottomInvestLog();
        bottomCreditorInfo = new FragmentBottomCreditorInfo();
        bottomBorrowDetail = new FragmentBottomBorrowDetail();
        bottomRepaymentPlan = new FragmentBottomRepaymentPlan();
        product_no = getActivity().getIntent().getStringExtra("product_no");
        LogUtils.e("ProductFragmentBottom_product_no", product_no);
        if (product_no.contains("YJH")||product_no.contains("DQY")||product_no.contains("XSB")) {//赢计划,短期赢,新手标
            titles.add("产品详情");
            fragments.add(bottomProductDetail);
            titles.add("投资记录");
            fragments.add(bottomInvestLog);
        } else if (product_no.contains("XFD")||product_no.contains("SCD")) {//消费贷,闪车贷
            titles.add("借款明细");
            fragments.add(bottomBorrowDetail);
            titles.add("投资记录");
            fragments.add(bottomInvestLog);
            titles.add("还款计划");
            fragments.add(bottomRepaymentPlan);
        } else if (product_no.contains("PJD")) {//票据贷
            titles.add("借款明细");
            fragments.add(bottomBorrowDetail);
            titles.add("投资记录");
            fragments.add(bottomInvestLog);
        } else if (product_no.contains("ZZY")) {//周周赢
            titles.add("产品详情");
            fragments.add(bottomProductDetail);
            titles.add("债权信息");
            fragments.add(bottomCreditorInfo);
            titles.add("投资记录");
            fragments.add(bottomInvestLog);
        }
        vpJoinRecord.setAdapter(new TabAdapter(getFragmentManager(),fragments,titles));
        vpJoinRecord.setOffscreenPageLimit(3);

        tablayoutBottom.setupWithViewPager(vpJoinRecord);

    }

    @Override
    public void showSuccessToast(String msg) {

    }

    @Override
    public void showErrorToast(String msg) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}

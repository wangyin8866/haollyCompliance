package com.haolyy.compliance.ui.product;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseFragment;
import com.haolyy.compliance.ui.product.presenter.ProductBottomPresenter;
import com.haolyy.compliance.ui.product.view.ProductBottomView;

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

    @Override
    protected ProductBottomPresenter createPresenter() {
        return new ProductBottomPresenter(mContext);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_product_bottom, container, false);
        unbinder = ButterKnife.bind(this, view);
        initview();
        return view;
    }

    private void initview() {
        Bundle arguments = getArguments();
        titles.add("产品详情");
        titles.add("加入记录");
        FragmentBottomLeft fragmentBottomLeft = new FragmentBottomLeft();
        FragmentBottomRight fragmentBottomRight = new FragmentBottomRight();
        fragments.add(fragmentBottomLeft);
        //如果有债权信息显示中间的tab
        if (arguments.getBoolean("center")) {
            titles.add("债权信息");
            FragmentBottomCenter fragmentBottomCenter = new FragmentBottomCenter();
            fragments.add(fragmentBottomCenter);
        }
        fragments.add(fragmentBottomRight);
        vpJoinRecord.setAdapter(new TabAdapter(getFragmentManager()));
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

    public class TabAdapter extends FragmentPagerAdapter {

        public TabAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }


        //配置标题的方法
        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }

}

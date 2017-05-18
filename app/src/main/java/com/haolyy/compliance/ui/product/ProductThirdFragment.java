package com.haolyy.compliance.ui.product;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.custom.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by wangyin on 2017/5/18.
 */

public class ProductThirdFragment extends Fragment implements View.OnClickListener {
    @BindView(R.id.third_tv1)
    TextView thirdTv1;
    @BindView(R.id.third_tv2)
    TextView thirdTv2;
    @BindView(R.id.third_tv3)
    TextView thirdTv3;
    @BindView(R.id.third_tv4)
    TextView thirdTv4;
    @BindView(R.id.third_tv5)
    TextView thirdTv5;
    @BindView(R.id.product_third_viewPager)
    NoScrollViewPager productThirdViewPager;
    Unbinder unbinder;
    private View view;
    private ProductThirdTab1Fragment tab1Fragment;
    private ProductThirdTab2Fragment tab2Fragment;
    private ProductThirdTab3Fragment tab3Fragment;
    private ProductThirdTab4Fragment tab4Fragment;
    private ProductThirdTab5Fragment tab5Fragment;
    private List<Fragment> mDatas;
    private FragmentPagerAdapter mdAdapter;
    private int currentPage = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.product_third_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        init();
        setTabSelection(currentPage);
        return view;
    }

    private void init() {
        mDatas = new ArrayList<>();
        tab1Fragment = new ProductThirdTab1Fragment();
        tab2Fragment = new ProductThirdTab2Fragment();
        tab3Fragment = new ProductThirdTab3Fragment();
        tab4Fragment = new ProductThirdTab4Fragment();
        tab5Fragment = new ProductThirdTab5Fragment();
        mDatas.add(tab1Fragment);
        mDatas.add(tab2Fragment);
        mDatas.add(tab3Fragment);
        mDatas.add(tab4Fragment);
        mDatas.add(tab5Fragment);
        mdAdapter = new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mDatas.get(position);
            }

            @Override
            public int getCount() {
                return mDatas.size();
            }
        };
        productThirdViewPager.setAdapter(mdAdapter);
        thirdTv1.setOnClickListener(this);
        thirdTv2.setOnClickListener(this);
        thirdTv3.setOnClickListener(this);
        thirdTv4.setOnClickListener(this);
        thirdTv5.setOnClickListener(this);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.third_tv1:
                currentPage = 0;
                setTabSelection(currentPage);
                break;
            case R.id.third_tv2:
                currentPage = 1;
                setTabSelection(currentPage);
                break;
            case R.id.third_tv3:
                currentPage = 2;
                setTabSelection(currentPage);
                break;
            case R.id.third_tv4:
                currentPage = 3;
                setTabSelection(currentPage);
                break;
            case R.id.third_tv5:
                currentPage = 4;
                setTabSelection(currentPage);
                break;

        }
    }

    private void setTabSelection(int currentPage) {
        //选中前清除状态
        restView();
        switch (currentPage) {
            case 0:
                thirdTv1.setTextColor(Color.parseColor("#FF9933"));
                switchPager(currentPage);
                break;
            case 1:
                thirdTv2.setTextColor(Color.parseColor("#FF9933"));
                switchPager(currentPage);
                break;
            case 2:
                thirdTv3.setTextColor(Color.parseColor("#FF9933"));
                switchPager(currentPage);
                break;
            case 3:
                thirdTv4.setTextColor(Color.parseColor("#FF9933"));
                switchPager(currentPage);
                break;
            case 4:
                thirdTv5.setTextColor(Color.parseColor("#FF9933"));
                switchPager(currentPage);
                break;
        }
    }

    private void switchPager(int currentPage) {
        productThirdViewPager.setCurrentItem(currentPage, false);
    }
    private void restView() {
        thirdTv1.setTextColor(Color.parseColor("#4A4A4A"));
        thirdTv2.setTextColor(Color.parseColor("#4A4A4A"));
        thirdTv3.setTextColor(Color.parseColor("#4A4A4A"));
        thirdTv4.setTextColor(Color.parseColor("#4A4A4A"));
        thirdTv5.setTextColor(Color.parseColor("#4A4A4A"));
    }
}

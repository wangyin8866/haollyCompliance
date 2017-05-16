package com.haolyy.compliance.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.custom.NoScrollViewPager;
import com.haolyy.compliance.ui.find.FindFragment;
import com.haolyy.compliance.ui.home.HomeFragment;
import com.haolyy.compliance.ui.my.MyFragment;
import com.haolyy.compliance.ui.product.ProductFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wangyin on 2017/5/16.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.id_tab_ll_01)
    LinearLayout idTabLl01;
    @BindView(R.id.id_tab_ll_02)
    LinearLayout idTabLl02;
    @BindView(R.id.id_tab_ll_03)
    LinearLayout idTabLl03;
    @BindView(R.id.id_tab_ll_04)
    LinearLayout idTabLl04;
    @BindView(R.id.id_main_viewPager)
    NoScrollViewPager idMainViewPager;
    @BindView(R.id.id_tab_iv_01)
    ImageView idTabIv01;
    @BindView(R.id.id_tab_tv_01)
    TextView idTabTv01;
    @BindView(R.id.id_tab_iv_02)
    ImageView idTabIv02;
    @BindView(R.id.id_tab_tv_02)
    TextView idTabTv02;
    @BindView(R.id.id_tab_iv_03)
    ImageView idTabIv03;
    @BindView(R.id.id_tab_tv_03)
    TextView idTabTv03;
    @BindView(R.id.id_tab_iv_04)
    ImageView idTabIv04;
    @BindView(R.id.id_tab_tv_04)
    TextView idTabTv04;
    private HomeFragment homeFragment;
    private ProductFragment productFragment;
    private FindFragment findFragment;
    private MyFragment myFragment;
    private List<Fragment> fragments;
    private int currentPage=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
        idMainViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        //第一次默认选中tab01
        setTabSelection(currentPage);
    }

    private void init() {
        homeFragment = new HomeFragment();
        productFragment = new ProductFragment();
        findFragment = new FindFragment();
        myFragment = new MyFragment();
        fragments = new ArrayList<>();
        fragments.add(homeFragment);
        fragments.add(productFragment);
        fragments.add(findFragment);
        fragments.add(myFragment);
        idTabLl01.setOnClickListener(this);
        idTabLl02.setOnClickListener(this);
        idTabLl03.setOnClickListener(this);
        idTabLl04.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_tab_ll_01:
                currentPage = 0;
                setTabSelection(currentPage);
                break;
            case R.id.id_tab_ll_02:
                currentPage = 1;
                setTabSelection(currentPage);
                break;
            case R.id.id_tab_ll_03:
                currentPage = 2;
                setTabSelection(currentPage);
                break;
            case R.id.id_tab_ll_04:
                currentPage = 3;
                setTabSelection(currentPage);
                break;
        }
    }

    private void setTabSelection(int currentPage) {
        //选中前清除状态
        restView();
        switch (currentPage) {
            case 0:
                idTabIv01.setImageResource(R.mipmap.ic_home_checked);
                idTabTv01.setTextColor(getResources().getColor(R.color.tv_navigate_checked));
                switchPager(currentPage);
                break;
            case 1:
                idTabIv02.setImageResource(R.mipmap.ic_product_checked);
                idTabTv02.setTextColor(getResources().getColor(R.color.tv_navigate_checked));
                switchPager(currentPage);
                break;
            case 2:
                idTabIv03.setImageResource(R.mipmap.ic_find_checked);
                idTabTv03.setTextColor(getResources().getColor(R.color.tv_navigate_checked));
                switchPager(currentPage);
                break;
            case 3:
                idTabIv04.setImageResource(R.mipmap.ic_my_checked);
                idTabTv04.setTextColor(getResources().getColor(R.color.tv_navigate_checked));
                switchPager(currentPage);
                break;
        }
    }

    private void switchPager(int currentPage) {
        idMainViewPager.setCurrentItem(currentPage,false);
    }
    /**
     * 重置所有状态
     */
    private void restView() {
        idTabIv01.setImageResource(R.mipmap.ic_home);
        idTabIv02.setImageResource(R.mipmap.ic_product);
        idTabIv03.setImageResource(R.mipmap.ic_find);
        idTabIv04.setImageResource(R.mipmap.ic_my);

        idTabTv01.setTextColor(getResources().getColor(R.color.tv_navigate));
        idTabTv02.setTextColor(getResources().getColor(R.color.tv_navigate));
        idTabTv03.setTextColor(getResources().getColor(R.color.tv_navigate));
        idTabTv04.setTextColor(getResources().getColor(R.color.tv_navigate));
    }
}

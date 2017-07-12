package com.haolyy.compliance.ui.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseActivity;
import com.haolyy.compliance.custom.TopBar;
import com.haolyy.compliance.ui.my.presenter.FundStatisticsPresenter;
import com.haolyy.compliance.ui.my.view.FundStatictisView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FundStatisticsActivity extends AppCompatActivity{

    @BindView(R.id.tab_fund)
    TabLayout tabFund;
    @BindView(R.id.vp_fund)
    ViewPager vpFund;
    @BindView(R.id.top_fund)
    TopBar topFund;

    private List<String> titles = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fund_statistics);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {
        titles.add("资产占比");
        titles.add("收益情况");
        AssetsRatioFragment assetsRatioFragment = new AssetsRatioFragment();
        IncomeFragment incomeFragment = new IncomeFragment();
        fragments.add(assetsRatioFragment);
        fragments.add(incomeFragment);
        vpFund.setAdapter(new FundTabAdapter(getSupportFragmentManager()));
        tabFund.setupWithViewPager(vpFund);
        topFund.setOnItemClickListener(new TopBar.OnItemClickListener() {
            @Override
            public void OnLeftButtonClicked() {
                finish();
            }

            @Override
            public void OnRightButtonClicked() {
                startActivity(new Intent(FundStatisticsActivity.this, DealLogActivity.class));
            }
        });
    }


    public class FundTabAdapter extends FragmentPagerAdapter {

        public FundTabAdapter(FragmentManager fm) {
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

package com.haolyy.compliance.ui.my;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.utils.SystemBarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class FundStatisticsActivity extends AppCompatActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_joining)
    TextView tvJoining;
    @BindView(R.id.view_line)
    View viewLine;
    @BindView(R.id.tab_fund)
    TabLayout tabFund;
    @BindView(R.id.vp_fund)
    ViewPager vpFund;
    @BindView(R.id.iv_finish)
    ImageView ivFinish;
    @BindView(R.id.iv_service)
    ImageView ivService;
    @BindView(R.id.titleBar)
    RelativeLayout titleBar;
    private List<String> titles = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fund_statistics);
        ButterKnife.bind(this);
        SystemBarUtil.setSystemBar(this, R.color.white);
        initView();

    }

    private void initView() {
        tvJoining.setVisibility(View.INVISIBLE);
        tvTitle.setText("资金统计");
        titles.add("资产占比");
        titles.add("收益情况");
        AssetsRatioFragment assetsRatioFragment = new AssetsRatioFragment();
        IncomeFragment incomeFragment = new IncomeFragment();
        fragments.add(assetsRatioFragment);
        fragments.add(incomeFragment);
        vpFund.setAdapter(new FundTabAdapter(getSupportFragmentManager()));
        tabFund.setupWithViewPager(vpFund);
    }

    @OnClick({R.id.iv_finish, R.id.iv_service})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_finish:
                finish();
                break;
            case R.id.iv_service:
                break;
        }
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

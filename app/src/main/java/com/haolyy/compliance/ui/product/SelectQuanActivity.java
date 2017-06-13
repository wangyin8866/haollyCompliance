package com.haolyy.compliance.ui.product;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseActivity;
import com.haolyy.compliance.ui.product.presenter.SelectQuanPresenter;
import com.haolyy.compliance.ui.product.view.SelectQuanView;
import com.haolyy.compliance.utils.SystemBarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by niudeyang on 2017/5/18.
 */

public class SelectQuanActivity extends BaseActivity<SelectQuanPresenter, SelectQuanView> {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_joining)
    TextView tvJoining;
    @BindView(R.id.view_line)
    View viewLine;
    @BindView(R.id.titleBar)
    RelativeLayout titleBar;
    @BindView(R.id.tablayout_quan)
    TabLayout tablayoutQuan;
    @BindView(R.id.vp_quan)
    ViewPager vpQuan;
    @BindView(R.id.iv_finish)
    ImageView ivFinish;
    private List<String> titles = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected SelectQuanPresenter createPresenter() {
        return new SelectQuanPresenter(mContext);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_quan);
        ButterKnife.bind(this);
        SystemBarUtil.setSystemBar(this, Color.TRANSPARENT);
        tvJoining.setVisibility(View.GONE);
        titles.add("可用卡券");
        titles.add("不可用卡券");
        FragmentUsefulQuan fragmentUsefulQuan = new FragmentUsefulQuan();
        FragmentUnusefulQuan fragmentUnusefulQuan = new FragmentUnusefulQuan();
        fragments.add(fragmentUsefulQuan);
        fragments.add(fragmentUnusefulQuan);
        vpQuan.setAdapter(new TabQuanAdapter(getSupportFragmentManager()));
        tablayoutQuan.setupWithViewPager(vpQuan);
    }

    @Override
    protected void handleMessage(Integer s) {

    }

    @OnClick(R.id.iv_finish)
    public void onViewClicked() {
        finish();
    }

    public class TabQuanAdapter extends FragmentPagerAdapter {

        public TabQuanAdapter(FragmentManager fm) {
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

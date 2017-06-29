package com.haolyy.compliance.ui.find;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.haolyy.compliance.R;
import com.haolyy.compliance.custom.TopBar;
import com.haolyy.compliance.utils.SystemBarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wangyin on 2017/6/9.
 */

public class ShopCardActivity extends AppCompatActivity {

    @BindView(R.id.top_bar)
    TopBar topBar;
    @BindView(R.id.tablayout_card)
    TabLayout tablayoutCard;
    @BindView(R.id.vp_card)
    ViewPager vpCard;
    private FragmentInvalid fragmentInvalid;
    private FragmentUnused fragmentUnused;
    private FragmentUsed fragmentUsed;
    private List<String> titles;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_card);
        SystemBarUtil.setSystemBar(this, Color.TRANSPARENT);
        ButterKnife.bind(this);
        topBar.setOnItemClickListener(new TopBar.OnItemClickListener() {
            @Override
            public void OnLeftButtonClicked() {
                finish();
            }

            @Override
            public void OnRightButtonClicked() {

            }
        });
        init();


    }

    private void init() {
        SystemBarUtil.setSystemBar(this, Color.TRANSPARENT);
        titles = new ArrayList<>();
        fragments = new ArrayList<>();
        titles.add("未使用");
        titles.add("已使用");
        titles.add("已过期");
        fragmentUnused = new FragmentUnused();
        fragmentUsed = new FragmentUsed();
        fragmentInvalid = new FragmentInvalid();
        fragments.add(fragmentUnused);
        fragments.add(fragmentUsed);
        fragments.add(fragmentInvalid);

        vpCard.setAdapter(new TabQuanAdapter(getSupportFragmentManager()));
        tablayoutCard.setupWithViewPager(vpCard);
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

package com.haolyy.compliance.ui.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.haolyy.compliance.R;
import com.haolyy.compliance.adapter.TabAdapter;
import com.haolyy.compliance.custom.TopBar;
import com.haolyy.compliance.utils.WYUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wangyin on 2017/7/15.
 */

public class ProductFundActivity extends AppCompatActivity {

    @BindView(R.id.top_bar)
    TopBar topBar;
    @BindView(R.id.product_title)
    TabLayout productTitle;
    @BindView(R.id.vp_product_list)
    ViewPager vpProductList;
    private String productName;
    private List<String> parentTitles;//一级菜单的title
    private List<String> parentNodeNo;//一级菜单的no
    private ArrayList<String> childTitle;//二级菜单的title
    private ArrayList<String> childNodeNo;//二级菜单的no
    private ProductFundListFragment productListFragment;
    private List<Fragment> mDatas;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_product_fund_list);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        mDatas = new ArrayList<>();
        parentTitles = getIntent().getStringArrayListExtra("parentTitle");
        parentNodeNo = getIntent().getStringArrayListExtra("parentNodeNo");
        productName = getIntent().getStringExtra("productName");


        topBar.setTitle(productName);
        topBar.setOnItemClickListener(new TopBar.OnItemClickListener() {
            @Override
            public void OnLeftButtonClicked() {
                finish();
            }

            @Override
            public void OnRightButtonClicked() {

            }
        });
        for (int i = 0; i < parentTitles.size(); i++) {
            childTitle = new ArrayList<>();
            childTitle.add("等待计息中");
            childTitle.add("计息中");
            childTitle.add("推出中");
            childTitle.add("已退出");
            childTitle.add("转让中");
            childNodeNo = new ArrayList<>();
            childNodeNo.add("ZZJ");
            childNodeNo.add("XFD");
            childNodeNo.add("SCD");
            childNodeNo.add("PJD");
            childNodeNo.add("PJD");
            productListFragment = ProductFundListFragment.newInstance(childTitle, parentNodeNo.get(i), childNodeNo);
            mDatas.add(productListFragment);
        }
        vpProductList.setAdapter(new TabAdapter(getSupportFragmentManager(), mDatas, parentTitles));
        vpProductList.setOffscreenPageLimit(parentTitles.size());
        productTitle.setupWithViewPager(vpProductList);

        WYUtils.setIndicator(this, productTitle, 5, 5);

    }

}

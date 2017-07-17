package com.haolyy.compliance.ui.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.haolyy.compliance.R;
import com.haolyy.compliance.adapter.ProductFundListAdapter;
import com.haolyy.compliance.adapter.TabAdapter;
import com.haolyy.compliance.base.BaseActivity;
import com.haolyy.compliance.base.BaseApplication;
import com.haolyy.compliance.config.Config;
import com.haolyy.compliance.custom.TopBar;
import com.haolyy.compliance.custom.XListView;
import com.haolyy.compliance.entity.my.ProductFundList;
import com.haolyy.compliance.entity.product.ProductTitle;
import com.haolyy.compliance.ui.my.presenter.ProductFundPresenter;
import com.haolyy.compliance.ui.my.view.ProductFundView;
import com.haolyy.compliance.utils.WYUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wangyin on 2017/7/15.
 */

public class ProductFundActivity extends BaseActivity<ProductFundPresenter, ProductFundView> implements ProductFundView {

    @BindView(R.id.top_bar)
    TopBar topBar;
    @BindView(R.id.product_title)
    TabLayout tabLayout;
    @BindView(R.id.vp_product_list)
    ViewPager vpProductList;
    @BindView(R.id.xlv_product_fund)
    XListView xlvProductFund;
    private String productName;//一级菜单的title
    private String firstCategoryId;//一级菜单的Id
    private List<String> secondCategoryTitle;//二级菜单的title
    private List<String> secondCategoryId;//二级菜单的no
    private ArrayList<String> thirdTitle;//三级菜单的title
    private ArrayList<String> orderStatus;//三级菜单的状态
    private ProductFundListFragment productListFragment;
    private List<Fragment> mDatas;
    private int position;

    @Override
    protected ProductFundPresenter createPresenter() {
        return new ProductFundPresenter(mContext);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_product_fund_list);
        ButterKnife.bind(this);
        init();
    }

    @Override
    protected void handleMessage(Integer s) {

    }

    private void init() {

        productName = getIntent().getStringExtra("productName");
        firstCategoryId = getIntent().getStringExtra("firstCategory");
        position = getIntent().getIntExtra("position", 0);
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

        mPresenter.getTitle();


    }

    @Override
    public void getTitle(ProductTitle productTitle) {
        if (position == productTitle.getModel().getModel().getTitleList().size()) {
            tabLayout.setVisibility(View.VISIBLE);
            vpProductList.setVisibility(View.VISIBLE);
            xlvProductFund.setVisibility(View.GONE);
            mDatas = new ArrayList<>();
            secondCategoryTitle = new ArrayList<>();
            secondCategoryId = new ArrayList<>();
            for (int i = 1; i < productTitle.getModel().getModel().getTitleList().get(productTitle.getModel().getModel().getTitleList().size() - 1).size(); i++) {
                secondCategoryTitle.add(productTitle.getModel().getModel().getTitleList().get(productTitle.getModel().getModel().getTitleList().size() - 1).get(i).getCategoryName());
                secondCategoryId.add(productTitle.getModel().getModel().getTitleList().get(productTitle.getModel().getModel().getTitleList().size() - 1).get(i).getNodeNo());
            }

            for (int i = 0; i < secondCategoryTitle.size(); i++) {
                thirdTitle = new ArrayList<>();
                thirdTitle.add("等待计息中");
                thirdTitle.add("计息中");
                thirdTitle.add("退出中");
                thirdTitle.add("已退出");
                thirdTitle.add("转让中");
                orderStatus = new ArrayList<>();
                orderStatus.add("1");
                orderStatus.add("2");
                orderStatus.add("3");
                orderStatus.add("4");
                orderStatus.add("5");
                productListFragment = ProductFundListFragment.newInstance(thirdTitle, firstCategoryId,secondCategoryId.get(i), orderStatus);
                mDatas.add(productListFragment);
            }


            vpProductList.setAdapter(new TabAdapter(getSupportFragmentManager(), mDatas, secondCategoryTitle));
            vpProductList.setOffscreenPageLimit(secondCategoryTitle.size());
            tabLayout.setupWithViewPager(vpProductList);

            WYUtils.setIndicator(this, tabLayout, 5, 5);
        } else {
            xlvProductFund.setVisibility(View.VISIBLE);
            tabLayout.setVisibility(View.GONE);
            vpProductList.setVisibility(View.GONE);
            mPresenter.getAssetManagementList(false,BaseApplication.userId+"",Config.platform,Config.client,firstCategoryId,"","1","0");
        }
    }

    @Override
    public void showData(ProductFundList productFundList) {

        xlvProductFund.setAdapter(new ProductFundListAdapter(productFundList.getModel().getModel().getAssetManagementList(), this));

    }

    @Override
    public void showGetMoreData(ProductFundList productFundList) {

    }
}

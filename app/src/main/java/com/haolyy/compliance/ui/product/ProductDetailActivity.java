package com.haolyy.compliance.ui.product;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseActivity;
import com.haolyy.compliance.base.BaseFragment;
import com.haolyy.compliance.custom.VerticalViewPager;
import com.haolyy.compliance.ui.product.presenter.ProductDetailPresenter;
import com.haolyy.compliance.ui.product.view.ProductDetailView;
import com.haolyy.compliance.utils.SystemBarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by niudeyang on 2017/5/17.
 */

public class ProductDetailActivity extends BaseActivity<ProductDetailPresenter, ProductDetailView> {

    @BindView(R.id.iv_finish)
    ImageView ivFinish;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.view_line)
    View viewLine;
    @BindView(R.id.titleBar)
    RelativeLayout titleBar;
    @BindView(R.id.tv_product_join)
    TextView tvProductJoin;
    @BindView(R.id.vp_product)
    VerticalViewPager vpProduct;

    private ProductFragmentTop productFragmentTop;
    private ProductFragmentBottom productFragmentBottom;
    private List<BaseFragment> fragmentList = new ArrayList<>();

    /**
     *
     * @param context
     * @param type
     * @return
     */
    public static Intent getReturnIntent(Context context, int type) {
        Intent intent = new Intent(context, ProductDetailActivity.class);
        intent.putExtra("borrowType", type);
        return intent;
    }

    @Override
    protected ProductDetailPresenter createPresenter() {

        return new ProductDetailPresenter(mContext);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        ButterKnife.bind(this);
        SystemBarUtil.setSystemBar(mContext, R.color.white);
        productFragmentTop = new ProductFragmentTop();
        productFragmentBottom = new ProductFragmentBottom();

        tabLayoutState();

        fragmentList.add(productFragmentTop);
        fragmentList.add(productFragmentBottom);
        vpProduct.setAdapter(new DummyAdapter(getSupportFragmentManager()));
        viewLine.setVisibility(View.VISIBLE);

        tvProductJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProductDetailActivity.this, ProductSureInvest.class));
            }
        });
    }

    /**
     * 详情页tab显示
     */
    private void tabLayoutState() {
        Bundle bundle=new Bundle();
        bundle.putBoolean("center",true);
        productFragmentBottom.setArguments(bundle);
    }

    @Override
    protected void handleMessage(Integer s) {

    }

    @OnClick(R.id.iv_finish)
    public void onViewClicked() {
        finish();
    }


    public class DummyAdapter extends FragmentPagerAdapter {

        public DummyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList == null ? null : fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return 2;
        }

    }

    public void pull() {
        vpProduct.setCurrentItem(1);
    }

}
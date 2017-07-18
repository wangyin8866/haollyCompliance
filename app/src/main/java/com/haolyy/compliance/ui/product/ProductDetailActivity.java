package com.haolyy.compliance.ui.product;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseFragment;
import com.haolyy.compliance.custom.TopBar;
import com.haolyy.compliance.custom.VerticalViewPager;
import com.haolyy.compliance.entity.product.ProductBaseDetail;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ProductDetailActivity extends AppCompatActivity implements ProductFragmentTop.CallBackProductDetail {
    @BindView(R.id.tv_product_join)
    TextView tvProductJoin;
    @BindView(R.id.vp_product)
    VerticalViewPager vpProduct;
    @BindView(R.id.top_bar)
    TopBar topBar;
    private ProductFragmentTop productFragmentTop;
    private ProductFragmentBottom productFragmentBottom;
    private List<BaseFragment> fragmentList = new ArrayList<>();
    private ProductBaseDetail.ModelBeanX.ModelBean.InfoBean infoBean;
    private Double income;
    String amount;
    private String projectNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        ButterKnife.bind(this);
        init();
        tvProductJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductDetailActivity.this, ProductSureInvest.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("productDetail",infoBean);
                bundle.putDouble("income", income);
                bundle.putString("amount", amount);
                bundle.putString("projectNo", projectNo);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        topBar.setOnItemClickListener(new TopBar.OnItemClickListener() {
            @Override
            public void OnLeftButtonClicked() {
                finish();
            }

            @Override
            public void OnRightButtonClicked() {

            }
        });
        productFragmentTop.setCallBackProductDetail(this);
    }

    private void init() {
        projectNo =getIntent().getStringExtra("projectNo");
        productFragmentTop = new ProductFragmentTop();
        productFragmentBottom = new ProductFragmentBottom();
        fragmentList.add(productFragmentTop);
        fragmentList.add(productFragmentBottom);
        vpProduct.setAdapter(new DummyAdapter(getSupportFragmentManager()));
        topBar.setTitle(getIntent().getStringExtra("productName"));
    }

    @Override
    public void callBack(ProductBaseDetail.ModelBeanX.ModelBean.InfoBean infoBean,Double aDouble,String amount) {
        this.infoBean = infoBean;
        income = aDouble;
        this.amount = amount;
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


}

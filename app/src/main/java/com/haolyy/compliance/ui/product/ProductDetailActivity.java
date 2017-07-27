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
import com.haolyy.compliance.base.ActivityCollector;
import com.haolyy.compliance.base.BaseFragment;
import com.haolyy.compliance.custom.TopBar;
import com.haolyy.compliance.custom.VerticalViewPager;
import com.haolyy.compliance.custom.dialog.DialogBank;
import com.haolyy.compliance.entity.product.ProductBaseDetail;
import com.haolyy.compliance.ui.bank.CheckBankActivity;
import com.haolyy.compliance.utils.AppToast;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.haolyy.compliance.base.BaseApplication.mLoginState;


public class ProductDetailActivity extends AppCompatActivity implements ProductFragmentTop.CallBackProductDetail {
    @BindView(R.id.tv_product_join)
    TextView tvProductJoin;
    @BindView(R.id.vp_product)
    VerticalViewPager vpProduct;
    @BindView(R.id.top_bar)
    TopBar topBar;
    private ProductFragmentTop productFragmentTop;
    private ProductFragmentBottom productFragmentBottom;
    private List<BaseFragment> fragmentList;
    private ProductBaseDetail.ModelBeanX.ModelBean.InfoBean infoBean;
    private BigDecimal income;
    private double  amount;
    private String projectNo;
    private int state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        ButterKnife.bind(this);
        init();
        tvProductJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mLoginState) {
                    AppToast.showShortText(ProductDetailActivity.this, "你还没有登录!");
                } else if (state != 1) {//chongzhi
                    showDialog();
                } else {
                    if (amount == 0) {
                        AppToast.showShortText(ProductDetailActivity.this, "投资金额不能为空!");
                    } else {
                        if (amount % 100 == 0) {
                            Intent intent = new Intent(ProductDetailActivity.this, ProductSureInvest.class);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("productDetail", infoBean);
                            bundle.putString("income", income.toString());
                            bundle.putDouble("amount", amount);
                            bundle.putString("projectNo", projectNo);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        } else {
                            AppToast.showShortText(ProductDetailActivity.this, "起投金额必须为100的整数倍!");
                        }
                    }
                }


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
        ActivityCollector.addActivity(this);
        if (fragmentList != null) {
            fragmentList.clear();
        }
        fragmentList = new ArrayList<>();
        projectNo =getIntent().getStringExtra("projectNo");
        productFragmentTop = new ProductFragmentTop();
        productFragmentBottom = new ProductFragmentBottom();
        fragmentList.add(productFragmentTop);
        fragmentList.add(productFragmentBottom);
        vpProduct.setAdapter(new DummyAdapter(getSupportFragmentManager()));
        topBar.setTitle(getIntent().getStringExtra("productName"));
    }


    @Override
    public void callBackInfo(ProductBaseDetail.ModelBeanX.ModelBean.InfoBean infoBean) {
        this.infoBean = infoBean;
    }

    @Override
    public void callBackAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public void callBackIncome(BigDecimal income) {
        this.income = income;
    }

    @Override
    public void callBackState(int state) {
        this.state = state;
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
            return fragmentList.size();
        }

    }

    public void showDialog() {
        DialogBank dialogBank=new DialogBank(this);
        dialogBank.setOnDoubleClickListener(new DialogBank.OnDoubleClickListener() {
            @Override
            public void excuteLeft() {

            }

            @Override
            public void excuteRight() {
                startActivity(new Intent(ProductDetailActivity.this, CheckBankActivity.class));
            }
        }).show();
    }
}

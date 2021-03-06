package com.haolyy.compliance.ui.product;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.ActivityCollector;
import com.haolyy.compliance.base.BaseActivity;
import com.haolyy.compliance.base.BaseApplication;
import com.haolyy.compliance.base.BaseFragment;
import com.haolyy.compliance.custom.TopBar;
import com.haolyy.compliance.custom.VerticalViewPager;
import com.haolyy.compliance.custom.dialog.DialogBank;
import com.haolyy.compliance.entity.login.FindUserStatusBean;
import com.haolyy.compliance.entity.product.ProductBaseDetail;
import com.haolyy.compliance.ui.bank.CheckBankActivity;
import com.haolyy.compliance.ui.login.LoginActivity;
import com.haolyy.compliance.ui.product.presenter.ProductDetailPresenter;
import com.haolyy.compliance.ui.product.view.ProductDetailView;
import com.haolyy.compliance.utils.AccountUtil;
import com.haolyy.compliance.utils.AppToast;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.haolyy.compliance.base.BaseApplication.mLoginState;


public class ProductDetailActivity extends BaseActivity<ProductDetailPresenter, ProductDetailView> implements ProductFragmentTop.CallBackProductDetail, ProductDetailView {
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
    private BigDecimal earning;
    private double amount;
    private String projectNo;
    private String ordId;
    private int state;
    private long amountwait;

    @Override
    protected ProductDetailPresenter createPresenter() {
        return new ProductDetailPresenter(mContext);
    }

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
                    startActivity(new Intent(ProductDetailActivity.this, LoginActivity.class));
                } else if (amount == 0) {
                    AppToast.showShortText(ProductDetailActivity.this, "投资金额不能为空!");
                } else if (amount % 100 != 0) {
                    AppToast.showShortText(ProductDetailActivity.this, "起投金额必须为100的整数倍!");
                } else if (amount > balance) {
                    AppToast.showShortText(ProductDetailActivity.this, "您的余额不足，请充值!");
                } else if (amount > amountwait) {
                    AppToast.showShortText(ProductDetailActivity.this, "标的剩余额度不足!");
                } else {
                    if (!TextUtils.isEmpty(BaseApplication.mUserName)) {
                        mPresenter.selectUserState(0);
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

    @Override
    protected void handleMessage(Integer s) {

    }

    private void init() {
        ActivityCollector.addActivity(this);

        if (fragmentList != null) {
            fragmentList.clear();
        }
        fragmentList = new ArrayList<>();
        projectNo = getIntent().getStringExtra("projectNo");
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
        amountwait = AccountUtil.MoneyTolong(infoBean.getAmountWait());
    }

    @Override
    public void callBackAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public void callBackIncome(BigDecimal income, BigDecimal earning) {
        this.income = income;
        this.earning = earning;
    }

    private double balance;

    @Override
    public void callBackUseful(double usefulAmount) {
        this.balance = usefulAmount;
    }

    @Override
    public void showSuccessToast(String msg) {

    }

    @Override
    public void showErrorToast(String msg) {

    }

    @Override
    public void getUserState(FindUserStatusBean baseResponseBean) {
        state = baseResponseBean.getModel().getModel().getIs_open_account();
        if (state == 1) {
            Intent intent = new Intent(ProductDetailActivity.this, ProductSureInvest.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("productDetail", infoBean);
            bundle.putString("income", income.toString());
            bundle.putString("earning", earning.toString());
            bundle.putDouble("amount", amount);
            bundle.putString("projectNo", projectNo);
            intent.putExtras(bundle);
            startActivity(intent);
        } else {//没有开户
            showDialog();
        }
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
        DialogBank dialogBank = new DialogBank(this);
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

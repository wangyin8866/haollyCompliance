package com.haolyy.compliance.ui.my;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseActivity;
import com.haolyy.compliance.custom.TopBar;
import com.haolyy.compliance.databinding.ProjectManageBinding;
import com.haolyy.compliance.entity.home.UserInfoBean;
import com.haolyy.compliance.entity.login.FindUserStatusBean;
import com.haolyy.compliance.entity.my.ProductFundList;
import com.haolyy.compliance.entity.product.Earnings;
import com.haolyy.compliance.entity.product.ProductBaseDetail;
import com.haolyy.compliance.ui.product.presenter.ProductTopPresenter;
import com.haolyy.compliance.ui.product.view.ProductTopView;
import com.haolyy.compliance.utils.DateUtil;
import com.haolyy.compliance.utils.LogUtils;
import com.haolyy.compliance.utils.WYUtils;

import static com.haolyy.compliance.base.BaseApplication.juid;

/**
 * Created by wangyin on 2017/7/17.
 */

public class ProductManageDetail extends BaseActivity<ProductTopPresenter, ProductTopView> implements ProductTopView,View.OnClickListener{

    private ProjectManageBinding binding;
    private String product_no;

    private String projectNo;
    private int project_type;
    ProductBaseDetail productBaseDetail;
    private ProductFundList.ModelBeanX.ModelBean.AssetManagementListBean assetManagementListBean;
    @Override
    protected ProductTopPresenter createPresenter() {
        return new ProductTopPresenter(mContext);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_project_manage);
        init();
        binding.topBar.setOnItemClickListener(new TopBar.OnItemClickListener() {
            @Override
            public void OnLeftButtonClicked() {
                finish();
            }

            @Override
            public void OnRightButtonClicked() {

            }
        });
        binding.rlSkip.setOnClickListener(this);
    }

    private void init() {
        assetManagementListBean = (ProductFundList.ModelBeanX.ModelBean.AssetManagementListBean) getIntent().getSerializableExtra("productFund");
        //金额
        binding.tvBuyMoney.setText(assetManagementListBean.getAmount());
        //实际收益
        binding.tvIncome.setText(Double.valueOf(assetManagementListBean.getIncome()) +Double.valueOf(assetManagementListBean.getAppendIncome())+"");
        //汇款总额
        binding.tvTotalAmount.setText(WYUtils.processAmount(assetManagementListBean.getAmount()) + Float.valueOf(assetManagementListBean.getIncome()) + Float.valueOf(assetManagementListBean.getAppendIncome()) + "元");
        //产品介绍
        binding.tvProductName.setText(assetManagementListBean.getProjectName());
        //购买日期
        binding.tvBuyDate.setText(assetManagementListBean.getOrderDate());
        //预期年化收益率
        binding.tvRate.setText(assetManagementListBean.getAnnualizedRate()+"%+"+assetManagementListBean.getAppendRate()+"%");
        //预期收益
        binding.tvPlanIncome.setText(Double.valueOf(assetManagementListBean.getIncome()) +Double.valueOf(assetManagementListBean.getAppendIncome())+"元");
        product_no = assetManagementListBean.getProductNo();

        projectNo = assetManagementListBean.getProjectNo();
        LogUtils.e("projectNo",projectNo);
        project_type = assetManagementListBean.getProjectType();

        mPresenter.getBaseDetail(projectNo + "", juid);
    }

    @Override
    protected void handleMessage(Integer s) {

    }

    @Override
    public void showSuccessToast(String msg) {

    }

    @Override
    public void showErrorToast(String msg) {

    }

    @Override
    public void showData(ProductBaseDetail productBaseDetail) {
        this.productBaseDetail = productBaseDetail;
        ProductBaseDetail.ModelBeanX.ModelBean.InfoBean infoBean=  productBaseDetail.getModel().getModel().getInfo();
        //计息日期
        binding.tvStartDate.setText(DateUtil.getTimeyyyymmdd(infoBean.getInterestStartDate()));
        //锁定期限
        binding.tvLockDate.setText(infoBean.getLockPeriod()+ "天");
        //到期时间
        binding.tvEndDate.setText(DateUtil.getTimeyyyymmdd(infoBean.getInterestEndDate()));
        //汇款方式
        binding.tvProfitPlan.setText(WYUtils.getProfitPlan(infoBean.getProfitPlan()));

    }

    @Override
    public void getUserState(FindUserStatusBean baseResponseBean) {

    }

    @Override
    public void getEarnings(Earnings earnings) {

    }

    @Override
    public void showUserInfoData(UserInfoBean userInfoBean) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_skip:
                Intent intent = new Intent(ProductManageDetail.this,ProductFundDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("productBaseDetail",productBaseDetail);
                LogUtils.e("productBaseDetail",productBaseDetail.toString());
                bundle.putString("product_no", product_no);
                bundle.putString("projectNo", projectNo);
                bundle.putInt("project_type", project_type);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
        }
    }
}

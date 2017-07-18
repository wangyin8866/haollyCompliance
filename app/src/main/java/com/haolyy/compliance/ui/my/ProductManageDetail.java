package com.haolyy.compliance.ui.my;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseActivity;
import com.haolyy.compliance.custom.TopBar;
import com.haolyy.compliance.databinding.ProjectManageBinding;
import com.haolyy.compliance.entity.login.FindUserStatusBean;
import com.haolyy.compliance.entity.my.ProductFundList;
import com.haolyy.compliance.entity.product.Earnings;
import com.haolyy.compliance.entity.product.ProductBaseDetail;
import com.haolyy.compliance.ui.product.presenter.ProductTopPresenter;
import com.haolyy.compliance.ui.product.view.ProductTopView;
import com.haolyy.compliance.utils.LogUtils;

import static com.haolyy.compliance.base.BaseApplication.juid;

/**
 * Created by wangyin on 2017/7/17.
 */

public class ProductManageDetail extends BaseActivity<ProductTopPresenter, ProductTopView> implements ProductTopView{

    private ProjectManageBinding binding;
    private String product_no;

    private String projectNo;
    private int project_type;
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
    }

    private void init() {
        assetManagementListBean = (ProductFundList.ModelBeanX.ModelBean.AssetManagementListBean) getIntent().getSerializableExtra("productFund");
        LogUtils.e("assetManagementListBean",assetManagementListBean.toString());
        product_no = assetManagementListBean.getProductNo();

        projectNo = assetManagementListBean.getProjectNo();
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
        ProductBaseDetail.ModelBeanX.ModelBean.InfoBean infoBean=  productBaseDetail.getModel().getModel().getInfo();

    }

    @Override
    public void getUserState(FindUserStatusBean baseResponseBean) {

    }

    @Override
    public void getEarnings(Earnings earnings) {

    }
}

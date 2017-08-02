package com.haolyy.compliance.ui.product;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseActivity;
import com.haolyy.compliance.base.BaseApplication;
import com.haolyy.compliance.config.Config;
import com.haolyy.compliance.custom.TopBar;
import com.haolyy.compliance.databinding.InvestBinding;
import com.haolyy.compliance.entity.home.UserInfoBean;
import com.haolyy.compliance.entity.product.ProductBaseDetail;
import com.haolyy.compliance.ui.product.presenter.ProductSureInvestPresenter;
import com.haolyy.compliance.ui.product.view.ProductSureInvestView;
import com.haolyy.compliance.utils.AppToast;
import com.haolyy.compliance.utils.DateUtil;
import com.haolyy.compliance.utils.LogUtils;
import com.haolyy.compliance.utils.WYUtils;
import com.jakewharton.rxbinding.widget.RxCompoundButton;

import rx.functions.Action1;

/**
 * Created by wangyin on 2017/5/23.
 */

public class ProductSureInvest extends BaseActivity<ProductSureInvestPresenter,ProductSureInvestView> implements View.OnClickListener,ProductSureInvestView {

    private ProductBaseDetail.ModelBeanX.ModelBean.InfoBean infoBean;
    private InvestBinding binding;
    private String income;
    private String earning;
    private double amount;
    private String projectNo;
    private int project_type;

    @Override
    protected ProductSureInvestPresenter createPresenter() {
        return new ProductSureInvestPresenter(mContext);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sure_invest);
        init();
        binding.topSureInvest.setOnItemClickListener(new TopBar.OnItemClickListener() {
            @Override
            public void OnLeftButtonClicked() {
                finish();

            }

            @Override
            public void OnRightButtonClicked() {

            }
        });
        RxCompoundButton.checkedChanges(binding.cbSureCheck).subscribe(new Action1<Boolean>() {
            @Override
            public void call(Boolean aBoolean) {

                if (aBoolean) {
                    binding.tvInvestSure.setEnabled(true);
                } else {
                    binding.tvInvestSure.setEnabled(false);
                }
            }
        });
        binding.ivReferralCode.setOnClickListener(this);
        binding.tvInvestSure.setOnClickListener(this);
    }

    @Override
    protected void handleMessage(Integer s) {

    }

    private void init() {
        infoBean = (ProductBaseDetail.ModelBeanX.ModelBean.InfoBean) getIntent().getSerializableExtra("productDetail");

        LogUtils.e("infoBean",infoBean.toString());

        project_type = infoBean.getProjectType();
        income = getIntent().getStringExtra("income");
        earning = getIntent().getStringExtra("earning");
        amount = getIntent().getDoubleExtra("amount",0);
        projectNo = getIntent().getStringExtra("projectNo");
        mPresenter.requestUserInfoDetail();

        if (project_type==1) {//散标
            binding.tvLockDate.setVisibility(View.GONE);
            binding.tvInvestLockDate.setVisibility(View.GONE);
        }

        /**
         * 显示数据
         */
        binding.tvInvestProductName.setText(infoBean.getProjectName());
        binding.tvInvestRate.setText(Float.valueOf(infoBean.getAnnualizedRate())+Float.valueOf(infoBean.getAppendRate())+"%");
        //投资期限
        binding.tvInvestDeadline.setText(infoBean.getPeriodLength() + WYUtils.getInvestDeadline(infoBean.getPeriodUnit()));
        //计息日期
        binding.tvInvestStartDate.setText(DateUtil.getTimeyyyymmdd(infoBean.getInterestStartDate()));
        //退出日期
        binding.tvInvestEndDate.setText(DateUtil.getTimeyyyymmdd(infoBean.getInterestEndDate()));
        //汇款方式
        binding.tvProfitPlan.setText(WYUtils.getProfitPlan(infoBean.getProfitPlan()));
        //锁定期
        binding.tvInvestLockDate.setText(infoBean.getLockPeriod() + "天");
        //投资金额
        binding.tvInvestMoney.setText(amount+"元");
        //预期收益
        binding.tvInvestEarnings.setText(earning+"元");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_referral_code:
                if (binding.edReferralCode.getVisibility() == View.VISIBLE) {
                    binding.edReferralCode.setVisibility(View.GONE);
                } else {
                    binding.edReferralCode.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.tv_invest_sure:


                mPresenter.invest(projectNo, BaseApplication.userId+"", amount+"", income, Config.returl);

                break;
        }
    }

    @Override
    public void showData(UserInfoBean userInfoBean) {
        //可用余额
        binding.tvInvestBalance.setText(userInfoBean.getModel().getModel().getAvailable_credit());
    }

    @Override
    public void pushActivity(String baseResponseBean) {

        Intent intent = new Intent(mContext, InvestWebActivity.class);
        intent.setAction(baseResponseBean);
        startActivity(intent);
    }


    @Override
    public void showSuccessToast(String msg) {
        AppToast.showShortText(mContext, msg);
    }

    @Override
    public void showErrorToast(String msg) {
        AppToast.showShortText(mContext, msg);
    }
}

package com.haolyy.compliance.ui.product;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseFragment;
import com.haolyy.compliance.custom.ViewInvestTimeProgress;
import com.haolyy.compliance.ui.product.presenter.ProductTopPresenter;
import com.haolyy.compliance.ui.product.view.ProductTopView;
import com.haolyy.compliance.utils.UIUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 产品详情顶部页面
 * Created by wangyin on 2017/5/16.
 */

public class ProductFragmentTop extends BaseFragment<ProductTopPresenter, ProductTopView> implements ProductTopView {


    Unbinder unbinder;
    @BindView(R.id.tv_product_rate)
    TextView tvProductRate;
    @BindView(R.id.tv_mirror_plan)
    TextView tvMirrorPlan;
    @BindView(R.id.tv_pull)
    TextView tvPull;
    @BindView(R.id.tv_use_quan)
    TextView tvUseQuan;
    @BindView(R.id.vt_progress)
    ViewInvestTimeProgress vtProgress;

    @Override
    protected ProductTopPresenter createPresenter() {
        return new ProductTopPresenter(mContext);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_top, container, false);
        unbinder = ButterKnife.bind(this, view);
        SpannableString textSpan = new SpannableString("7.0%+1.0%");
        textSpan.setSpan(new AbsoluteSizeSpan(UIUtils.dip2px(36)), 0, 3, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        textSpan.setSpan(new AbsoluteSizeSpan(UIUtils.dip2px(14)), 3, 9, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        tvProductRate.setText(textSpan);
        vtProgress.setDateText("2017-00-00\n开始加入","2017-00-00\n投标结束","2017-00-00\n锁定到期","2017-00-00\n计划到期");
        return view;
    }

    @Override
    public void showSuccessToast(String msg) {

    }

    @Override
    public void showErrorToast(String msg) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick({R.id.tv_mirror_plan, R.id.tv_pull, R.id.tv_use_quan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_mirror_plan:

                break;
            case R.id.tv_pull:
                ((ProductDetailActivity) getActivity()).pull();
                break;
            case R.id.tv_use_quan:
                startActivityForResult(new Intent(mContext, SelectQuanActivity.class), 0x00);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}

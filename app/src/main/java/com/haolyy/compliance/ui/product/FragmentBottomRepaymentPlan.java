package com.haolyy.compliance.ui.product;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.adapter.ProductListAdapter;
import com.haolyy.compliance.adapter.RepaymentAdapter;
import com.haolyy.compliance.base.BaseFragment;
import com.haolyy.compliance.custom.XListView;
import com.haolyy.compliance.entity.product.RepaymentPlan;
import com.haolyy.compliance.ui.product.presenter.RepaymentPlanPresenter;
import com.haolyy.compliance.ui.product.view.RepaymentPlanView;
import com.haolyy.compliance.utils.UIUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 还款计划
 * Created by niudeyang on 2017/5/17.
 */

public class FragmentBottomRepaymentPlan extends BaseFragment<RepaymentPlanPresenter, RepaymentPlanView> implements XListView.IXListViewListener, RepaymentPlanView {


    Unbinder unbinder;
    @BindView(R.id.repayment_xlv)
    XListView repaymentXlv;
    @BindView(R.id.iv_empty)
    ImageView ivEmpty;
    private RepaymentPlan repaymentPlan;
    private int pageNum=1;
    private String projectNo;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottom_repayment_plan, container, false);
        unbinder = ButterKnife.bind(this, view);

        projectNo = getActivity().getIntent().getStringExtra("projectNo");
        mPresenter.getProductReturnPlan(false, projectNo, pageNum+"", "1", "1");
        repaymentXlv.setPullRefreshEnable(false);
        repaymentXlv.setXListViewListener(this);


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onRefresh() {
        pageNum = 1;
        mPresenter.getProductReturnPlan(false, projectNo, pageNum+"", "1", "1");
    }

    @Override
    public void onLoadMore() {
        pageNum += 1;
        mPresenter.getProductReturnPlan(true, projectNo, pageNum+"", "1", "1");
    }


    @Override
    protected RepaymentPlanPresenter createPresenter() {
        return new RepaymentPlanPresenter(mContext);
    }

    @Override
    public void showSuccessToast(String msg) {

    }

    @Override
    public void showErrorToast(String msg) {

    }

    @Override
    public void showData(RepaymentPlan repaymentPlan) {
        this.repaymentPlan = repaymentPlan;
        if (repaymentPlan.getData().getData().getData_list().size() ==0) {
            repaymentXlv.setPullLoadEnable(false);
            ivEmpty.setVisibility(View.VISIBLE);
        } else {
            if (repaymentPlan.getData().getData().getData_list().size() < 10) {
                repaymentXlv.setPullLoadEnable(false);
            } else {
                repaymentXlv.setPullLoadEnable(true);
            }
            ivEmpty.setVisibility(View.GONE);
        }
        repaymentXlv.setAdapter(new RepaymentAdapter(repaymentPlan.getData().getData().getData_list(), getActivity()));
    }

    @Override
    public void showGetMoreData(RepaymentPlan repaymentPlan) {
        this.repaymentPlan.getData().getData().getData_list().addAll(repaymentPlan.getData().getData().getData_list());
        if (repaymentPlan.getData().getData().getData_list().size() == 0) {
            pageNum = 1;
            UIUtils.showToastCommon(mContext, "没有更多数据了！");
            repaymentXlv.setPullLoadEnable(false);
        } else {
            repaymentXlv.setPullLoadEnable(true);
            repaymentXlv.setAdapter(new ProductListAdapter(this.repaymentPlan.getData().getData().getData_list(), getActivity()));
            repaymentXlv.setSelection(this.repaymentPlan.getData().getData().getData_list().size() - repaymentPlan.getData().getData().getData_list().size());//定位
        }
    }
}

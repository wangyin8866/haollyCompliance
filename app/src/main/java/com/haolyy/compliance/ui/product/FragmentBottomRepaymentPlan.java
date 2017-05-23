package com.haolyy.compliance.ui.product;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.haolyy.compliance.R;
import com.haolyy.compliance.adapter.RepaymentAdapter;
import com.haolyy.compliance.custom.XListView;
import com.haolyy.compliance.entity.Repayment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 还款计划
 * Created by niudeyang on 2017/5/17.
 */

public class FragmentBottomRepaymentPlan extends Fragment implements XListView.IXListViewListener {


    Unbinder unbinder;
    @BindView(R.id.repayment_xlv)
    XListView repaymentXlv;
    private List<Repayment> repayments;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottom_repayment_plan, container, false);
        unbinder = ButterKnife.bind(this, view);

        repaymentXlv.setPullRefreshEnable(false);
        repaymentXlv.setXListViewListener(this);
        repayments = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            Repayment repayment = new Repayment(i + "期", i * 10 + "元", i * 100 + "元", i * 10 + "元");
            repayments.add(repayment);
        }
        repaymentXlv.setAdapter(new RepaymentAdapter(repayments, getActivity()));
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {
    }
}

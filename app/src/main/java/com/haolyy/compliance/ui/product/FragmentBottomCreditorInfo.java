package com.haolyy.compliance.ui.product;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.haolyy.compliance.R;
import com.haolyy.compliance.adapter.CreditorInfoAdapter;
import com.haolyy.compliance.custom.XListView;
import com.haolyy.compliance.entity.CreditorInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 债权信息
 * Created by niudeyang on 2017/5/17.
 */

public class FragmentBottomCreditorInfo extends Fragment implements XListView.IXListViewListener {


    @BindView(R.id.first_xlv)
    XListView firstXlv;
    Unbinder unbinder;
    private List<CreditorInfo> creditorInfos;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottom_creditor_info, container, false);
        unbinder = ButterKnife.bind(this, view);
        firstXlv.setXListViewListener(this);
        creditorInfos = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            CreditorInfo creditorInfo = new CreditorInfo("浙江省嘉兴市" + i, "浦先生嘉宝贷" + i, 1000 * i + "", i + "个月", i + "%");
            creditorInfos.add(creditorInfo);
        }
        firstXlv.setAdapter(new CreditorInfoAdapter(creditorInfos,getActivity()));
        firstXlv.setPullRefreshEnable(false);
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

package com.haolyy.compliance.ui.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.custom.VeticalDoubleTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by wangyin on 2017/5/16.
 */

public class MyFragment extends Fragment {
    @BindView(R.id.iv_setting)
    ImageView ivSetting;
    @BindView(R.id.iv_head_icon)
    ImageView ivHeadIcon;
    @BindView(R.id.iv_gold)
    ImageView ivGold;
    @BindView(R.id.tv_gold_phone)
    TextView tvGoldPhone;
    @BindView(R.id.vd_total_asset)
    VeticalDoubleTextView vdTotalAsset;
    Unbinder unbinder;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.my_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.iv_setting, R.id.iv_head_icon, R.id.iv_gold, R.id.tv_gold_phone, R.id.vd_total_asset})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_setting:
                break;
            case R.id.iv_head_icon:
                break;
            case R.id.iv_gold:
                break;
            case R.id.tv_gold_phone:
                break;
            case R.id.vd_total_asset:
                //进入饼图界面
                startActivity(new Intent(getActivity(),FundStatisticsActivity.class));
                break;
        }
    }
}

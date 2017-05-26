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
import com.haolyy.compliance.base.BaseFragment;
import com.haolyy.compliance.custom.VeticalDoubleTextView;
import com.haolyy.compliance.custom.dialog.DialogBank;
import com.haolyy.compliance.ui.bank.BankBindActivity;
import com.haolyy.compliance.ui.bank.CheckBankActivity;
import com.haolyy.compliance.ui.my.presenter.MyFragmentPresenter;
import com.haolyy.compliance.ui.my.view.MyFragmentView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by wangyin on 2017/5/16.
 */

public class MyFragment extends BaseFragment<MyFragmentPresenter,MyFragmentView> {
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
    @BindView(R.id.tv_withdraw)
    TextView tvWithdraw;
    @BindView(R.id.tv_recharge)
    TextView tvRecharge;
    private View view;
    private DialogBank dialogBank;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.my_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        dialogBank = new DialogBank(mContext);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.iv_setting, R.id.iv_head_icon, R.id.iv_gold, R.id.tv_gold_phone, R.id.vd_total_asset,R.id.tv_withdraw,R.id.tv_recharge})
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
                startActivity(new Intent(getActivity(), FundStatisticsActivity.class));
                break;
            case R.id.tv_withdraw:
                dialogBank.setOnDoubleClickListener(new DialogBank.OnDoubleClickListener() {
                    @Override
                    public void excuteLeft() {

                    }

                    @Override
                    public void excuteRight() {
                         //startActivity(new Intent(mContext, CheckBankActivity.class));
                        startActivity(new Intent(mContext, BankBindActivity.class));
                    }
                }).show();
                break;
            case R.id.tv_recharge:
                dialogBank.show();
                break;
        }
    }

    @Override
    protected MyFragmentPresenter createPresenter() {
        return new MyFragmentPresenter(mContext);
    }
}

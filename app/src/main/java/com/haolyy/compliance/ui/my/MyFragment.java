package com.haolyy.compliance.ui.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseFragment;
import com.haolyy.compliance.config.Config;
import com.haolyy.compliance.config.ConstantKey;
import com.haolyy.compliance.custom.VeticalDoubleTextView;
import com.haolyy.compliance.custom.dialog.DialogBank;
import com.haolyy.compliance.custom.dialog.DialogInvestGuides;
import com.haolyy.compliance.entity.home.UserInfoBean;
import com.haolyy.compliance.entity.home.UserProductBean;
import com.haolyy.compliance.ui.bank.BankBindActivity;
import com.haolyy.compliance.ui.bank.CheckBankActivity;
import com.haolyy.compliance.ui.bank.RechargeActivity;
import com.haolyy.compliance.ui.bank.WithDrawActivity;
import com.haolyy.compliance.ui.find.ShoppingActivity;
import com.haolyy.compliance.ui.my.presenter.MyFragmentPresenter;
import com.haolyy.compliance.ui.my.view.MyFragmentView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by wangyin on 2017/5/16.
 */

public class MyFragment extends BaseFragment<MyFragmentPresenter, MyFragmentView> implements MyFragmentView {
    @BindView(R.id.iv_setting)
    ImageView ivSetting;
    @BindView(R.id.iv_gold)
    ImageView iv_gold;
    @BindView(R.id.iv_head_icon)
    ImageView ivHeadIcon;
    @BindView(R.id.tv_gold_phone)
    TextView tvGoldPhone;
    @BindView(R.id.vd_total_asset)
    VeticalDoubleTextView vdTotalAsset;
    Unbinder unbinder;
    @BindView(R.id.tv_withdraw)
    TextView tvWithdraw;
    @BindView(R.id.tv_recharge)
    TextView tvRecharge;
    @BindView(R.id.account_manage)
    TextView account_manage;
    @BindView(R.id.v_invite_friend)
    View vInviteFriend;
    @BindView(R.id.message_center)
    ImageView messageCenter;
    @BindView(R.id.coupon)
    VeticalDoubleTextView coupon;
    @BindView(R.id.vd_mission)
    VeticalDoubleTextView vdMission;
    @BindView(R.id.score)
    VeticalDoubleTextView score;

    @BindView(R.id.available_amount)
    VeticalDoubleTextView available_amount;
    @BindView(R.id.frezon_amount)
    VeticalDoubleTextView frezon_amount;

    @BindView(R.id.short_win_plan)
    TextView short_win_plan;
    @BindView(R.id.win_plan)
    TextView win_plan;
    @BindView(R.id.optimize_win_plan)
    TextView optimize_win_plan;


    private View view;
    private DialogBank dialogBank;
    private DialogInvestGuides dialogInvestGuides;
    private UserInfoBean userInfoBean;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.my_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        dialogBank = new DialogBank(mContext);

        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            mPresenter.requestUserInfoDetail("HLW","2");
            mPresenter.requestUserProductInfo("HLW","2");
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.iv_setting, R.id.iv_head_icon, R.id.score,R.id.iv_gold, R.id.tv_gold_phone, R.id.account_manage, R.id.vd_total_asset, R.id.tv_withdraw, R.id.tv_recharge, R.id.v_invite_friend, R.id.message_center, R.id.vd_mission})
    public void onViewClicked(View view) {
        Bundle bundle = null;
        switch (view.getId()) {
            case R.id.iv_setting:
                startActivity(new Intent(mContext,SettingActivity.class));
                break;
            case R.id.iv_head_icon:
                break;
            case R.id.iv_gold:
                startActivity(new Intent(mContext,MemberActivity.class));
                break;
            case R.id.tv_gold_phone:
                break;
            case R.id.vd_total_asset:
                //进入饼图界面
                startActivity(new Intent(getActivity(), FundStatisticsActivity.class));
                break;
            case R.id.tv_withdraw:
                mPresenter.selectUserState(Config.status_with_draw);
                //开户
              /* dialogBank.setOnDoubleClickListener(new DialogBank.OnDoubleClickListener() {
                   @Override
                   public void excuteLeft() {

                   }

                   @Override
                   public void excuteRight() {
                      startActivity(new Intent(mContext,CheckBankActivity.class));
                   }
               }).show();*/
              /*  dialogInvestGuides = new DialogInvestGuides(mContext, DialogInvestGuides.INTELLIGENCE);
                dialogInvestGuides.setOnDoubleClickListener(new DialogInvestGuides.OnDoubleClickListener() {
                    @Override
                    public void excuteLeft() {

                    }

                    @Override
                    public void excuteRight() {

                    }
                }).show();*/
               // startActivity(new Intent(mContext, WithDrawActivity.class));
                //startActivity(new Intent(mContext, CheckBankActivity.class));
                //mPresenter.findUserStatus();
                break;
            case R.id.tv_recharge:
                mPresenter.selectUserState(Config.staus_recharge);
                //startActivity(new Intent(mContext, RechargeActivity.class));
                break;
            case R.id.v_invite_friend:
                startActivity(new Intent(mContext, InviteFriendActivity.class));
                break;
            case R.id.message_center:
                startActivity(new Intent(mContext, MessageActivity.class));
                break;
            case R.id.account_manage:
                startActivity(new Intent(mContext, AccountSecurityActivity.class));
                break;
            case R.id.vd_mission:
                startActivity(new Intent(mContext, MissionActivity.class));
                break;
            case R.id.score:
                startActivity(new Intent(mContext, ShoppingActivity.class));
                break;
        }
    }

    @Override
    protected MyFragmentPresenter createPresenter() {
        return new MyFragmentPresenter(mContext);
    }


    @Override
    public void showData(UserInfoBean userInfoBean) {
        this.userInfoBean = userInfoBean;
        available_amount.setTextBottom(userInfoBean.getModel().getModel().getAvailable_credit());
        frezon_amount.setTextBottom(userInfoBean.getModel().getModel().getFrozen_amount());
        vdTotalAsset.setTextBottom(userInfoBean.getModel().getModel().getTotal_amount());
        coupon.setTextTop(userInfoBean.getModel().getModel().getCoupon());
        vdMission.setTextTop(userInfoBean.getModel().getModel().getTask());
        score.setTextTop(userInfoBean.getModel().getModel().getPoint());
        if ("0".equals(userInfoBean.getModel().getModel().getVip_level())) {
            iv_gold.setImageResource(R.mipmap.account_set_vip_level0);
        } else if ("1".equals(userInfoBean.getModel().getModel().getVip_level())) {
            iv_gold.setImageResource(R.mipmap.account_set_vip_level1);
        } else if ("2".equals(userInfoBean.getModel().getModel().getVip_level())) {
            iv_gold.setImageResource(R.mipmap.account_set_vip_level2);
        } else if ("3".equals(userInfoBean.getModel().getModel().getVip_level())) {
            iv_gold.setImageResource(R.mipmap.account_set_vip_level3);
        } else {
            iv_gold.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void showProductData(UserProductBean userProductBean) {
//         short_win_plan.setText(userProductBean.getModel().getModel().);
    }

    @Override
    public void showSuccessToast(String msg) {

    }

    @Override
    public void showErrorToast(String msg) {

    }
}

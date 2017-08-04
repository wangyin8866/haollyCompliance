package com.haolyy.compliance.ui.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.haolyy.compliance.R;
import com.haolyy.compliance.adapter.MyProductFundAdapter;
import com.haolyy.compliance.base.BaseFragment;
import com.haolyy.compliance.config.Config;
import com.haolyy.compliance.custom.InnerScrollListView;
import com.haolyy.compliance.custom.VeticalDoubleTextView;
import com.haolyy.compliance.custom.dialog.DialogBank;
import com.haolyy.compliance.entity.home.UserInfoBean;
import com.haolyy.compliance.entity.my.ProductFund;
import com.haolyy.compliance.ui.bank.CheckBankActivity;
import com.haolyy.compliance.ui.find.ShoppingActivity;
import com.haolyy.compliance.ui.my.presenter.MyFragmentPresenter;
import com.haolyy.compliance.ui.my.view.MyFragmentView;
import com.haolyy.compliance.utils.LogUtils;
import com.haolyy.compliance.utils.SPUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.haolyy.compliance.R.id.iv_gold;
import static com.haolyy.compliance.base.BaseApplication.userId;

/**
 * Created by wangyin on 2017/5/16.
 */

public class MyFragment extends BaseFragment<MyFragmentPresenter, MyFragmentView> implements MyFragmentView {
    Unbinder unbinder;
    @BindView(R.id.message_center)
    ImageView messageCenter;
    @BindView(R.id.iv_setting)
    ImageView ivSetting;
    @BindView(R.id.iv_head_icon)
    ImageView ivHeadIcon;
    @BindView(R.id.iv_gold)
    ImageView ivGold;
    @BindView(R.id.tv_gold_phone)
    TextView tvGoldPhone;
    @BindView(R.id.account_manage)
    TextView accountManage;
    @BindView(R.id.available_amount)
    VeticalDoubleTextView availableAmount;
    @BindView(R.id.frezon_amount)
    VeticalDoubleTextView frezonAmount;
    @BindView(R.id.vd_total_asset)
    VeticalDoubleTextView vdTotalAsset;
    @BindView(R.id.tv_withdraw)
    TextView tvWithdraw;
    @BindView(R.id.tv_recharge)
    TextView tvRecharge;
    @BindView(R.id.coupon)
    VeticalDoubleTextView coupon;
    @BindView(R.id.vd_mission)
    VeticalDoubleTextView vdMission;
    @BindView(R.id.score)
    VeticalDoubleTextView score;
    @BindView(R.id.isl_product_fund)
    InnerScrollListView islProductFund;
    @BindView(R.id.v_invite_friend)
    View vInviteFriend;
    @BindView(R.id.iv_bill)
    ImageView ivBill;

    private View view;
    private DialogBank dialogBank;
    private ProductFund productFund;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.my_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        dialogBank = new DialogBank(mContext);


        islProductFund.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ProductFundActivity.class);
                intent.putExtra("productName", productFund.getModel().getModel().getProductFunds().get(position).getProjectName());
                intent.putExtra("firstCategory", productFund.getModel().getModel().getProductFunds().get(position).getFirstCategory());
                intent.putExtra("position", position + 1);
                startActivity(intent);
            }
        });
        mPresenter.getProductFunds(Config.platform, userId + "");
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtils.e(tag,"onresume");
        //需要刷新余额
        if(userId==-1){
            SPUtils.loginOut(getActivity());
            return;
        }
        mPresenter.requestUserInfoDetail();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            LogUtils.e(tag,"isVisibleToUser");
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.iv_bill,R.id.iv_setting, R.id.iv_head_icon, R.id.score, iv_gold, R.id.tv_gold_phone, R.id.account_manage, R.id.vd_total_asset, R.id.tv_withdraw, R.id.tv_recharge, R.id.v_invite_friend, R.id.message_center, R.id.vd_mission})
    public void onViewClicked(View view) {
        Bundle bundle = null;
        switch (view.getId()) {
            case R.id.iv_bill:
                startActivity(new Intent(getActivity(), BillActivity.class));
                break;
            case R.id.iv_setting:
                startActivity(new Intent(mContext, SettingActivity.class));
                break;
            case R.id.iv_head_icon:
                break;
            case iv_gold:
                startActivity(new Intent(mContext, MemberActivity.class));
                break;
            case R.id.tv_gold_phone:
                break;
            case R.id.vd_total_asset:
                //进入饼图界面
                startActivity(new Intent(getActivity(), FundStatisticsActivity.class));
                break;
            case R.id.tv_withdraw:
                mPresenter.selectUserState(Config.status_with_draw);
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
        Glide.with(mContext).load(userInfoBean.getModel().getModel().getUser_head_photo()).into(ivHeadIcon);
        tvGoldPhone.setText(userInfoBean.getModel().getModel().getMobile());
        availableAmount.setTextBottom(userInfoBean.getModel().getModel().getAvailable_credit());
        frezonAmount.setTextBottom(userInfoBean.getModel().getModel().getFrozen_amount());
        vdTotalAsset.setTextBottom(userInfoBean.getModel().getModel().getTotal_amount());
        coupon.setTextTop(userInfoBean.getModel().getModel().getCoupon());
        vdMission.setTextTop(userInfoBean.getModel().getModel().getTask());
        score.setTextTop(userInfoBean.getModel().getModel().getPoint());

        if (userInfoBean.getModel().getModel().getMessage() == 0) {
            messageCenter.setImageResource(R.mipmap.no_message);
        } else {
            messageCenter.setImageResource(R.mipmap.messages);
        }
        if ("0".equals(userInfoBean.getModel().getModel().getVip_level())) {
            ivGold.setImageResource(R.mipmap.account_set_vip_level0);
        } else if ("1".equals(userInfoBean.getModel().getModel().getVip_level())) {
            ivGold.setImageResource(R.mipmap.account_set_vip_level1);
        } else if ("2".equals(userInfoBean.getModel().getModel().getVip_level())) {
            ivGold.setImageResource(R.mipmap.account_set_vip_level2);
        } else if ("3".equals(userInfoBean.getModel().getModel().getVip_level())) {
            ivGold.setImageResource(R.mipmap.account_set_vip_level3);
        } else {
            ivGold.setVisibility(View.INVISIBLE);
        }

        if (userInfoBean.getModel().getModel().getIs_open_account() == 0) {
            showRegisterDialog();
        }
    }

    @Override
    public void getProductFunds(ProductFund productFund) {
        this.productFund = productFund;
        islProductFund.setAdapter(new MyProductFundAdapter(productFund.getModel().getModel().getProductFunds(), mContext));
    }

    /**
     * 提示开户
     */
    @Override
    public void showRegisterDialog() {
        //开户
        dialogBank.setOnDoubleClickListener(new DialogBank.OnDoubleClickListener() {
            @Override
            public void excuteLeft() {

            }

            @Override
            public void excuteRight() {
                startActivity(new Intent(mContext, CheckBankActivity.class));
            }
        }).show();
    }

    @Override
    public void showSuccessToast(String msg) {

    }

    @Override
    public void showErrorToast(String msg) {

    }

}

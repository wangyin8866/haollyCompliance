package com.haolyy.compliance.ui.product;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.custom.TopBar;
import com.jakewharton.rxbinding.widget.RxCompoundButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.functions.Action1;

/**
 * Created by wangyin on 2017/5/23.
 */

public class ProductSureInvest extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.top_sure_invest)
    TopBar topSureInvest;
    @BindView(R.id.iv_referral_code)
    ImageView ivReferralCode;
    @BindView(R.id.ed_referral_code)
    EditText edReferralCode;
    @BindView(R.id.tv_invest_sure)
    TextView tvInvestSure;
    @BindView(R.id.cb_sure_check)
    CheckBox cbSureCheck;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sure_invest);
        ButterKnife.bind(this);
        topSureInvest.setOnItemClickListener(new TopBar.OnItemClickListener() {
            @Override
            public void OnLeftButtonClicked() {
                finish();
            }

            @Override
            public void OnRightButtonClicked() {

            }
        });
        RxCompoundButton.checkedChanges(cbSureCheck).subscribe(new Action1<Boolean>() {
            @Override
            public void call(Boolean aBoolean) {

                if (aBoolean) {
                    tvInvestSure.setEnabled(true);
                } else {
                    tvInvestSure.setEnabled(false);
                }
            }
        });
        ivReferralCode.setOnClickListener(this);
        tvInvestSure.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_referral_code:
                if (edReferralCode.getVisibility() == View.VISIBLE) {
                    edReferralCode.setVisibility(View.GONE);
                } else {
                    edReferralCode.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.tv_invest_sure:
                startActivity(new Intent(ProductSureInvest.this, InvestSucceed.class));
                break;
        }
    }
}

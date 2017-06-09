package com.haolyy.compliance.ui.bank;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.haolyy.compliance.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class RechargeActivity extends AppCompatActivity {

    @BindView(R.id.iv_finish)
    ImageView ivFinish;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_joining)
    TextView tvJoining;
    @BindView(R.id.tv_bank_name)
    TextView tvBankName;
    @BindView(R.id.tv_card_type)
    TextView tvCardType;
    @BindView(R.id.tv_card_no)
    TextView tvCardNo;
    @BindView(R.id.tv_limit_account)
    TextView tvLimitAccount;
    @BindView(R.id.btn_recharge)
    TextView btnRecharge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tvTitle.setText("充值");
        tvLimitAccount.setText(Html.fromHtml("<font color='#b9b9b9'>招商银行 单笔限额</font><font color='#ff9933'>5万元</font><font color='#b9b9b9'>每日限额</font><font color='#ff9933'>5万元</font>"));
    }

    @OnClick({R.id.iv_finish, R.id.btn_recharge})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_finish:
                finish();
                break;
            case R.id.btn_recharge:
                break;
        }
    }
}

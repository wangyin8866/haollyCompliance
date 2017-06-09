package com.haolyy.compliance.ui.bank;

import android.content.Intent;
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


public class WithDrawActivity extends AppCompatActivity {

    @BindView(R.id.iv_finish)
    ImageView ivFinish;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_bank_name)
    TextView tvBankName;
    @BindView(R.id.tv_card_type)
    TextView tvCardType;
    @BindView(R.id.tv_card_no)
    TextView tvCardNo;
    @BindView(R.id.btn_withdraw)
    TextView btnWithdraw;
    @BindView(R.id.tv_total_withdraw)
    TextView tvTotalWithdraw;
    @BindView(R.id.tv_withdraw_quan)
    TextView tvWithdrawQuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_draw);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tvTitle.setText("提现");
        tvWithdrawQuan.setText(Html.fromHtml("<font color='#4a4a4a'>未使用</font><font color='#ff9933'>(1)</font>"));
    }

    @OnClick({R.id.iv_finish, R.id.btn_withdraw,R.id.tv_withdraw_quan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_finish:
                finish();
                break;
            case R.id.btn_withdraw:
                break;
            case R.id.tv_withdraw_quan:
                  startActivity(new Intent(WithDrawActivity.this,WithDrawQuanActivity.class));
                break;
        }
    }
}

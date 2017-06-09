package com.haolyy.compliance.ui.bank;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.adapter.WithDrawQuanAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class WithDrawQuanActivity extends AppCompatActivity {

    @BindView(R.id.iv_finish)
    ImageView ivFinish;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.lv_withdraw_quan)
    ListView lvWithdrawQuan;
    private List<Integer> quans = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_draw_quan);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tvTitle.setText("提现券");
        //券的item item_withdarw_quan
        for (int i = 0; i < 10; i++) {
            quans.add(i);
        }
        WithDrawQuanAdapter withDrawQuanAdapter = new WithDrawQuanAdapter(this, quans, 0);
        lvWithdrawQuan.setAdapter(withDrawQuanAdapter);
    }

    @OnClick(R.id.iv_finish)
    public void onViewClicked() {
        finish();
    }
}

package com.haolyy.compliance.ui.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.haolyy.compliance.R;
import com.haolyy.compliance.custom.TopBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wangyin on 2017/7/15.
 */

public class ProductFundListActivity extends AppCompatActivity {
    @BindView(R.id.top_bar)
    TopBar topBar;
    private String productName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_product_fund_list);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        productName = getIntent().getStringExtra("productName");
        topBar.setTitle(productName);
        topBar.setOnItemClickListener(new TopBar.OnItemClickListener() {
            @Override
            public void OnLeftButtonClicked() {
                finish();
            }

            @Override
            public void OnRightButtonClicked() {

            }
        });
    }
}

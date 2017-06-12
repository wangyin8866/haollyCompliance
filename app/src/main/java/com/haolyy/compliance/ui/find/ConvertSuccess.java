package com.haolyy.compliance.ui.find;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.custom.TopBar;
import com.haolyy.compliance.utils.SystemBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wangyin on 2017/6/9.
 */

public class ConvertSuccess extends AppCompatActivity {
    @BindView(R.id.top_bar)
    TopBar topBar;
    @BindView(R.id.look_shop)
    TextView lookShop;
    @BindView(R.id.convert_go)
    Button convertGo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.convert_success);
        ButterKnife.bind(this);
        SystemBarUtil.setSystemBar(this, Color.TRANSPARENT);
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

    @OnClick({R.id.look_shop, R.id.convert_go})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.look_shop:
                startActivity(new Intent(ConvertSuccess.this,ShopCardActivity.class));
                break;
            case R.id.convert_go:
                break;
        }
    }
}

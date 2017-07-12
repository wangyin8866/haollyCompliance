package com.haolyy.compliance.ui.product;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.custom.TopBar;
import com.haolyy.compliance.utils.WYUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wangyin on 2017/5/23.
 */

public class InvestErrorRest extends AppCompatActivity {
    @BindView(R.id.top_sure_invest)
    TopBar topSureInvest;
    @BindView(R.id.tv_call_service)
    TextView tvCallService;
    @BindView(R.id.error_rest)
    Button errorRest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invest_error_rest);

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
    }

    @OnClick({R.id.tv_call_service, R.id.error_rest})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_call_service:
                break;
            case R.id.error_rest:
                WYUtils.skipMainActivity(InvestErrorRest.this,1);
                break;
        }
    }


}

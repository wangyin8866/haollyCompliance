package com.haolyy.compliance.ui.product;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.custom.TopBar;
import com.haolyy.compliance.custom.dialog.DialogInvest;
import com.haolyy.compliance.utils.SystemBarUtil;
import com.haolyy.compliance.utils.WYUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wangyin on 2017/5/23.
 */

public class InvestSucceed extends AppCompatActivity {
    @BindView(R.id.top_bar)
    TopBar topBar;
    @BindView(R.id.look_invest_log)
    TextView lookInvestLog;
    @BindView(R.id.btn_continue)
    Button btnContinue;
    @BindView(R.id.cb_invest_success)
    CheckBox cbInvestSuccess;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invest_succeed);
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

    @OnClick({R.id.look_invest_log, R.id.btn_continue,R.id.cb_invest_success})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.look_invest_log:
                break;
            case R.id.btn_continue:
                WYUtils.skipMainActivity(InvestSucceed.this, 1);
                break;
            case R.id.cb_invest_success:
                if (cbInvestSuccess.isChecked()) {
                    final DialogInvest dialogConversionIntegralTips = new DialogInvest(this);
                    dialogConversionIntegralTips.setContent1("确认现在开启自动续投功能吗？").setContent2("(您还可以在资产管理列表中更改开\n" +
                            "启或关闭状态。)").setLeftText("再想想").setRightText("确定").setConverIntegral(new DialogInvest.ConversionIntegral() {
                        @Override
                        public void leftClick() {
                            dialogConversionIntegralTips.dismiss();
                            cbInvestSuccess.setChecked(false);
                        }

                        @Override
                        public void rightClick() {
                            dialogConversionIntegralTips.dismiss();
                        }
                    });
                    dialogConversionIntegralTips.show();
                    break;
                }
        }
    }
}

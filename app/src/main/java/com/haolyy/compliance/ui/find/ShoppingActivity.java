package com.haolyy.compliance.ui.find;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.custom.TopBar;
import com.haolyy.compliance.custom.dialog.DialogConversionIntegralTips;
import com.haolyy.compliance.custom.dialog.DialogSignInTips;
import com.haolyy.compliance.utils.SystemBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wangyin on 2017/6/9.
 */

public class ShoppingActivity extends AppCompatActivity {
    @BindView(R.id.top_security_update_phone)
    TopBar topSecurityUpdatePhone;
    @BindView(R.id.sign_in)
    TextView signIn;
    @BindView(R.id.shopping_detail)
    TextView shoppingDetail;
    @BindView(R.id.shopping_log)
    TextView shoppingLog;
    @BindView(R.id.iv_conversion1)
    ImageView ivConversion1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_shopping_main);
        ButterKnife.bind(this);
        SystemBarUtil.setSystemBar(this, Color.TRANSPARENT);
        topSecurityUpdatePhone.setOnItemClickListener(new TopBar.OnItemClickListener() {
            @Override
            public void OnLeftButtonClicked() {
                finish();
            }

            @Override
            public void OnRightButtonClicked() {

            }
        });
    }

    @OnClick({R.id.sign_in, R.id.shopping_detail, R.id.shopping_log, R.id.iv_conversion1})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sign_in:
                new DialogSignInTips(this).show();
                break;
            case R.id.shopping_detail:
                break;
            case R.id.shopping_log:


                break;
            case R.id.iv_conversion1:
                final DialogConversionIntegralTips dialogConversionIntegralTips = new DialogConversionIntegralTips(this);
                dialogConversionIntegralTips.setConverIntegral(new DialogConversionIntegralTips.ConversionIntegral() {
                    @Override
                    public void conversion() {
                        dialogConversionIntegralTips.dismiss();
                        startActivity(new Intent(ShoppingActivity.this, ConvertSuccess.class));

                    }
                });
                dialogConversionIntegralTips.show();
                break;
        }
    }


}

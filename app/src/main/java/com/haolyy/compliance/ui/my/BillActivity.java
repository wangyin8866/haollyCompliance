package com.haolyy.compliance.ui.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseApplication;
import com.haolyy.compliance.config.Config;
import com.haolyy.compliance.custom.TopBar;
import com.haolyy.compliance.utils.WYUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wangyin on 2017/8/1.
 */

public class BillActivity extends AppCompatActivity {
    @BindView(R.id.agreement_webview)
    WebView agreementWebview;
    @BindView(R.id.agreement_progressBar)
    ProgressBar agreementProgressBar;
    @BindView(R.id.top_bar)
    TopBar topBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_bill);
        ButterKnife.bind(this);
        topBar.setOnItemClickListener(new TopBar.OnItemClickListener() {
            @Override
            public void OnLeftButtonClicked() {
                finish();
            }

            @Override
            public void OnRightButtonClicked() {

            }
        });
        WYUtils.loadHtml(Config.bill + "?userId=" + BaseApplication.userId + "&platform=" + Config.platform+"&type=1", agreementWebview, agreementProgressBar);
    }
}

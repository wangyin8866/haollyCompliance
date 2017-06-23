package com.haolyy.compliance.ui.bank;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.haolyy.compliance.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class RechargeWebActivity extends AppCompatActivity {

    @BindView(R.id.iv_finish)
    ImageView ivFinish;
    @BindView(R.id.iv_share)
    ImageView ivShare;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.titleBar)
    RelativeLayout titleBar;
    @BindView(R.id.web_recharge)
    WebView webRecharge;
    @BindView(R.id.progressBar2)
    ProgressBar progressBar2;
    @BindView(R.id.view_line)
    View viewLine;
    @BindView(R.id.tv_try_again)
    TextView tvTryAgain;
    @BindView(R.id.tv_back_account)
    TextView tvBackAccount;
    @BindView(R.id.ll_recharge_error)
    LinearLayout llRechargeError;
    @BindView(R.id.tv_go_invest)
    TextView tvGoInvest;
    @BindView(R.id.tv_go_account)
    TextView tvGoAccount;
    @BindView(R.id.ll_recharge_success)
    LinearLayout llRechargeSuccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge_web);
        ButterKnife.bind(this);
        webRecharge.loadUrl("https://www.haolyy.com/");
       // webRecharge.loadData("text/html; charset=UTF-8", null);
        webRecharge.getSettings().setJavaScriptEnabled(true);
        webRecharge.setWebChromeClient(new WebChromeClient() {//监听网页加载
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    // 网页加载完成
                    progressBar2.setVisibility(View.GONE);
                } else {
                    // 加载中
                    progressBar2.setProgress(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }
        });
        webRecharge.setWebViewClient(new MyWebViewClient());
    }

    @OnClick({R.id.tv_try_again, R.id.tv_back_account, R.id.tv_go_invest, R.id.tv_go_account, R.id.iv_finish})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_try_again:
                break;
            case R.id.tv_back_account:
                break;
            case R.id.tv_go_invest:
                break;
            case R.id.tv_go_account:
                break;
            case R.id.iv_finish:
                if (webRecharge.canGoBack()) {
                    webRecharge.goBack();
                } else {
                    finish();
                }
                break;
        }
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            super.shouldOverrideUrlLoading(view, url);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }

    }
}

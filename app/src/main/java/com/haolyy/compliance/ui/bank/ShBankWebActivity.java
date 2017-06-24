package com.haolyy.compliance.ui.bank;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.haolyy.compliance.R;
import com.haolyy.compliance.utils.LogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ShBankWebActivity extends AppCompatActivity {

    @BindView(R.id.web_sh_register)
    WebView webviewRecharge;
    String urldata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sh_bank_web);
        ButterKnife.bind(this);
        urldata=getIntent().getAction();
        LogUtils.e("urldata",urldata);
        WebViewClient webViewClient = new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.e("ndyGoUrl", url);
                webviewRecharge.loadData(urldata, "text/html; charset=UTF-8", null);

                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);

            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed(); // 接受所有证书
            }

        };
        webviewRecharge.getSettings().setJavaScriptEnabled(true);
        webviewRecharge.getSettings().setDomStorageEnabled(true);//支持所有标签
        webviewRecharge.setWebViewClient(webViewClient);
        webviewRecharge.loadData(urldata, "text/html; charset=UTF-8", null);

    }
}

package com.haolyy.compliance.ui.bank;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.haolyy.compliance.R;
import com.haolyy.compliance.utils.LogUtils;
import com.haolyy.compliance.utils.UIUtils;

import org.json.JSONObject;

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
        urldata = getIntent().getAction();
        LogUtils.e("shwebActivity",urldata);
        WebViewClient webViewClient = new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                LogUtils.e("ndyGoUrl", url);
                if (url.equals("https://www.baidu.com/")) {
                    finish();
                    UIUtils.showToastCommon(getApplication(), "成功");
                }
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
        webviewRecharge.getSettings().setSupportZoom(true);
        webviewRecharge.setWebViewClient(webViewClient);
        webviewRecharge.setWebChromeClient(new WebChromeClient());
        //webviewRecharge.loadData(urldata, "text/html; charset=UTF-8", null);
        webviewRecharge.loadUrl("file:///android_asset/register.html");
        webviewRecharge.addJavascriptInterface(new JavaScriptInterface(ShBankWebActivity.this), "Android");//MyBrowserAPI:自定义的js函数名

    }

    public class JavaScriptInterface {
        Context mContext;

        JavaScriptInterface(Context c) {
            mContext = c;
        }

        /**采用此方法
         * 传递字符串网页里解析成对象
         * @param message
         * @return
         */
        @JavascriptInterface
        public String show(String message) {
            LogUtils.e("shbankwebActivity", message);
            return urldata;
        }

        /**
         * 直接传json网页上里解析不成功
         * @return
         */
        @JavascriptInterface
        public JSONObject sendJson() {
            return null;
        }
    }
}

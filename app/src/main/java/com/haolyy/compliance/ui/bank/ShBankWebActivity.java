package com.haolyy.compliance.ui.bank;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.haolyy.compliance.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ShBankWebActivity extends AppCompatActivity {

    @BindView(R.id.web_sh_register)
    WebView webShRegister;
    String urldata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sh_bank_web);
        ButterKnife.bind(this);
        urldata=getIntent().getAction();
        webShRegister.loadData(urldata, "text/html; charset=UTF-8", null);
    }
}

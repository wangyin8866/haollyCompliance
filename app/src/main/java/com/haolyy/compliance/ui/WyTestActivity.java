package com.haolyy.compliance.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.custom.ClearEditText;
import com.haolyy.compliance.utils.LogUtils;
import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxCompoundButton;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.functions.Action1;

/**
 * Created by wangyin on 2017/6/21.
 */

public class WyTestActivity extends AppCompatActivity {
    @BindView(R.id.et_phone)
    ClearEditText etPhone;
    @BindView(R.id.textView3)
    TextView textView3;
    @BindView(R.id.cb_register)
    CheckBox cbRegister;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        RxCompoundButton.checkedChanges(cbRegister).subscribe(new Action1<Boolean>() {
            @Override
            public void call(Boolean aBoolean) {
                LogUtils.e(aBoolean+"");
                if (aBoolean) {
                    textView3.setEnabled(true);
                } else {
                    textView3.setEnabled(false);
                }
            }
        });
        RxView.clicks(textView3).throttleFirst(2, TimeUnit.SECONDS).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                LogUtils.e("aaaa");
            }
        });
    }
}

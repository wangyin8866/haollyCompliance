package com.haolyy.compliance.ui.find;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.haolyy.compliance.R;
import com.haolyy.compliance.utils.SystemBarUtil;

/**
 * Created by wangyin on 2017/6/9.
 */

public class ConvertError extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert_error_rest);
        SystemBarUtil.setSystemBar(this, Color.TRANSPARENT);
    }
}

package com.haolyy.compliance.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.haolyy.compliance.R;
import com.haolyy.compliance.custom.TopBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wangyin on 2017/7/27.
 */

public class ActivityActivity extends AppCompatActivity {
    @BindView(R.id.top_bar)
    TopBar topBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity);
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
    }
}

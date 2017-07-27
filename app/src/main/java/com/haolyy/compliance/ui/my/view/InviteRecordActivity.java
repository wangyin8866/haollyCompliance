package com.haolyy.compliance.ui.my.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.haolyy.compliance.R;
import com.haolyy.compliance.custom.TopBar;

import butterknife.BindView;
import butterknife.ButterKnife;


public class InviteRecordActivity extends AppCompatActivity {

    @BindView(R.id.top_bar)
    TopBar topBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_record);
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

package com.haolyy.compliance.ui.my;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.custom.ShapeLocker;
import com.haolyy.compliance.custom.TopBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by User on 2017/6/9.
 */

public class GestureSettingActivity extends AppCompatActivity {
    @BindView(R.id.sl)
    ShapeLocker sl;
    @BindView(R.id.tips)
    TextView tips;
    @BindView(R.id.top_bar)
    TopBar top_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_setting);
        ButterKnife.bind(this);
        top_bar.setOnItemClickListener(new TopBar.OnItemClickListener() {
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

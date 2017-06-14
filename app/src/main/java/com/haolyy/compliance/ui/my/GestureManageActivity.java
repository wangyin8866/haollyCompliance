package com.haolyy.compliance.ui.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;

import com.haolyy.compliance.R;
import com.haolyy.compliance.config.ConstantKey;
import com.haolyy.compliance.custom.SwitchButton;
import com.haolyy.compliance.custom.TopBar;
import com.haolyy.compliance.utils.SPUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by User on 2017/6/9.
 */

public class GestureManageActivity extends AppCompatActivity {
    @BindView(R.id.top_bar)
    TopBar top_bar;
    @BindView(R.id.modify_gesture)
    RelativeLayout modify_gesture;
    @BindView(R.id.gesture_state)
    SwitchButton gesture_state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_manage);
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
        gesture_state.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                SPUtils.saveBoolean(GestureManageActivity.this, ConstantKey.GESTURE_STATE_KEY,b);
            }
        });
    }

    @OnClick(R.id.modify_gesture)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.modify_gesture:
                startActivity(new Intent(GestureManageActivity.this, GestureSettingActivity.class));
                break;
        }
    }

}

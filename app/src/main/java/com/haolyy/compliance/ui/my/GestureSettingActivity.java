package com.haolyy.compliance.ui.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.config.ConstantKey;
import com.haolyy.compliance.custom.ShapeLocker;
import com.haolyy.compliance.custom.TopBar;
import com.haolyy.compliance.utils.SPUtils;
import com.haolyy.compliance.utils.ShapeLockerUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    @BindView(R.id.setting_layout)
    LinearLayout setting_layout;

    @BindView(R.id.jump_btn)
    Button jump_btn;


    @BindView(R.id.success_layout)
    View success_layout;

    private int selectIndex = 1;
    private String firstPattern ;
    private String secondPattern;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_setting);
        ButterKnife.bind(this);
        top_bar.setOnItemClickListener(new TopBar.OnItemClickListener() {
            @Override
            public void OnLeftButtonClicked() {
                finish();
                setResult(101);
            }

            @Override
            public void OnRightButtonClicked() {

            }
        });
        sl.setOnPatternListener(new ShapeLocker.OnPatternListener() {
            @Override
            public void onPatternStart() {
                tips.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onPatternCleared() {
            }

            @Override
            public void onPatternCellAdded(List<ShapeLocker.Cell> pattern) {
            }

            @Override
            public void onPatternDetected(List<ShapeLocker.Cell> pattern) {
                if(selectIndex == 1) {
                    if(pattern.size() < 4) {
                        tips.setVisibility(View.VISIBLE);
                        tips.setText("请至少连接4个点");
                    }else {
                        firstPattern =  ShapeLockerUtils.patternToString(pattern);
                        selectIndex = 2;
                        sl.clearPattern();
                        tips.setVisibility(View.INVISIBLE);
                    }

                }else if(selectIndex == 2) {
                    secondPattern =  ShapeLockerUtils.patternToString(pattern);
                    if(secondPattern.equals(firstPattern)) {
                        SPUtils.saveString(GestureSettingActivity.this, ConstantKey.GESTURE_KEY,secondPattern);
                        setting_layout.setVisibility(View.GONE);
                        success_layout.setVisibility(View.VISIBLE);
                    }else {
                        tips.setVisibility(View.VISIBLE);
                        tips.setText("两次绘制不一样，请重新绘制");
                        selectIndex = 1;
                        sl.clearPattern();
                    }
                }
            }


        });


    }



    @OnClick({R.id.jump_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.jump_btn:
                Intent intent = new Intent(this,AccountSecurityActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        setResult(101);
    }
}

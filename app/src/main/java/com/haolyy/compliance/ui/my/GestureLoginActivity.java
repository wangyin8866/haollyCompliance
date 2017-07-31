package com.haolyy.compliance.ui.my;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.ActivityCollector;
import com.haolyy.compliance.config.ConstantKey;
import com.haolyy.compliance.custom.ShapeLocker;
import com.haolyy.compliance.custom.TopBar;
import com.haolyy.compliance.ui.MainActivity;
import com.haolyy.compliance.utils.SPUtils;
import com.haolyy.compliance.utils.ShapeLockerUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by User on 2017/6/9.
 */

public class GestureLoginActivity extends AppCompatActivity {
    @BindView(R.id.sl)
    ShapeLocker sl;
    @BindView(R.id.tips)
    TextView tips;
    @BindView(R.id.top_bar)
    TopBar top_bar;
    @BindView(R.id.setting_layout)
    LinearLayout setting_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_login);
        ButterKnife.bind(this);
        ActivityCollector.addActivity(this);
        init();
        top_bar.setOnItemClickListener(new TopBar.OnItemClickListener() {
            @Override
            public void OnLeftButtonClicked() {
                finish();
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

                if (SPUtils.getString(GestureLoginActivity.this, ConstantKey.GESTURE_KEY, "").equals(ShapeLockerUtils.patternToString(pattern))) {
                    tips.setVisibility(View.VISIBLE);
                    tips.setText("登录成功!");
                    startActivity(new Intent(GestureLoginActivity.this, MainActivity.class));

                } else {
                    tips.setVisibility(View.VISIBLE);
                    tips.setText("验证失败，请重新绘制!");
                    sl.clearPattern();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (TextUtils.isEmpty(SPUtils.getString(GestureLoginActivity.this, ConstantKey.GESTURE_KEY, ""))) {
            startActivity(new Intent(GestureLoginActivity.this, MainActivity.class));
            finish();
        }
    }

    private void init() {
        boolean isPath = SPUtils.getBoolean(GestureLoginActivity.this, ConstantKey.GESTURE_STATE_KEY,true);
        if (!isPath) {
            setNoPath();
        }
    }

    /**
     * 没有路径
     */
    private void setNoPath() {
        ShapeLocker.mBitmapCircleGreen = BitmapFactory.decodeResource(getResources(), R.mipmap.btn_code_lock_default);
        ShapeLocker.mBitmapCircleRed = BitmapFactory.decodeResource(getResources(), R.mipmap.btn_code_lock_default);
        sl.setColor_line(Color.parseColor("#FFFFFF"));
    }





}

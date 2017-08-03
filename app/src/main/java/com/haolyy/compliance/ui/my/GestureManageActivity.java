package com.haolyy.compliance.ui.my;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseActivity;
import com.haolyy.compliance.base.BaseApplication;
import com.haolyy.compliance.config.ConstantKey;
import com.haolyy.compliance.custom.SwitchButton;
import com.haolyy.compliance.custom.TopBar;
import com.haolyy.compliance.custom.dialog.DialogLoginPassword;
import com.haolyy.compliance.ui.my.presenter.GesturePresenter;
import com.haolyy.compliance.ui.my.view.GestureView;
import com.haolyy.compliance.utils.SPUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by User on 2017/6/9.
 */

public class GestureManageActivity extends BaseActivity<GesturePresenter, GestureView> implements GestureView {
    @BindView(R.id.top_bar)
    TopBar top_bar;
    @BindView(R.id.modify_gesture)
    RelativeLayout modify_gesture;
    @BindView(R.id.gesture_state)
    SwitchButton gesture_state;
    @BindView(R.id.tv_gesture)
    TextView tvGesture;
    private boolean isPath;
    private boolean flag;//是否设置手势密码


    @Override
    protected GesturePresenter createPresenter() {
        return new GesturePresenter(mContext);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_manage);
        ButterKnife.bind(this);
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
        gesture_state.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                isPath = b;
                SPUtils.saveBoolean(GestureManageActivity.this, ConstantKey.GESTURE_STATE_KEY, isPath);
            }
        });
    }

    @Override
    protected void handleMessage(Integer s) {

    }

    private void init() {
        flag = getIntent().getBooleanExtra("flag", false);
        if (flag) {
            top_bar.setTitle("修改手势密码");
            tvGesture.setText("修改手势密码");


        } else {
            top_bar.setTitle("设置手势密码");
            tvGesture.setText("设置手势密码");
        }
        isPath = SPUtils.getBoolean(GestureManageActivity.this, ConstantKey.GESTURE_STATE_KEY, true);
        gesture_state.setChecked(isPath);

    }

    @OnClick(R.id.modify_gesture)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.modify_gesture:


                if (flag) {
                    final DialogLoginPassword dialogLoginPassword = new DialogLoginPassword(GestureManageActivity.this);

                    dialogLoginPassword.setOnDoubleClickListener(new DialogLoginPassword.OnDoubleClickListener() {
                        @Override
                        public void executeLeft() {
                            dialogLoginPassword.dismiss();
                        }

                        @Override
                        public void executeRight(String password, TextView tips) {
                            mPresenter.checkPassword(BaseApplication.mUserName, password, tips, dialogLoginPassword);
                        }
                    });

                    dialogLoginPassword.show();
                } else {

                    Intent intent = new Intent(GestureManageActivity.this, GestureSettingActivity.class);
                    intent.putExtra("flag", flag);
                    startActivity(intent);
                }

                break;
        }
    }


    @Override
    public void showSuccessToast(String msg) {

    }

    @Override
    public void showErrorToast(String msg) {

    }
}

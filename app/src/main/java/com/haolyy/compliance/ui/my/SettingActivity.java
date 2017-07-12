package com.haolyy.compliance.ui.my;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.custom.SwitchButton;
import com.haolyy.compliance.custom.dialog.DialogNoTitleDoubleButton;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SettingActivity extends AppCompatActivity {

    @BindView(R.id.iv_finish)
    ImageView ivFinish;
    TextView tvTitle;
    @BindView(R.id.view_line)
    View viewLine;
    @BindView(R.id.switch1)
    SwitchButton switch1;
    @BindView(R.id.tv_clear_cache)
    TextView tvClearCache;
    @BindView(R.id.tv_version)
    TextView tvVersion;
    @BindView(R.id.tv_about)
    TextView tvAbout;
    @BindView(R.id.tv_contact_us)
    TextView tvContactUs;
    @BindView(R.id.tv_feedback)
    TextView tvFeedback;
    private DialogNoTitleDoubleButton dialogNoTitleDoubleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        dialogNoTitleDoubleButton = new DialogNoTitleDoubleButton(SettingActivity.this);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    dialogNoTitleDoubleButton.setContent("您现在无法收到消息通知。请到“设置-好利网-通知”中，开启允 许通知选项。").setOnDoubleClickListener(new DialogNoTitleDoubleButton.OnDoubleClickListener() {
                        @Override
                        public void excuteLeft() {

                        }

                        @Override
                        public void excuteRight() {

                        }
                    });
                }
            }
        });
    }
}

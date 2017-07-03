package com.haolyy.compliance.ui.my;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.custom.ViewMission;
import com.haolyy.compliance.utils.UIUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MissionActivity extends AppCompatActivity {

    @BindView(R.id.iv_finish)
    ImageView ivFinish;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_lock_recharge1)
    TextView tvLockRecharge1;
    @BindView(R.id.vm_invest2)
    ViewMission vmInvest2;
    @BindView(R.id.tv_lock_invest)
    TextView tvLockInvest;
    @BindView(R.id.vm_recharge2)
    ViewMission vmRecharge2;
    @BindView(R.id.vm_invite)
    ViewMission vmInvite;
    @BindView(R.id.tv_lock_invite)
    TextView tvLockInvite;
    @BindView(R.id.view_line)
    View viewLine;
    @BindView(R.id.titleBar)
    RelativeLayout titleBar;
    @BindView(R.id.tv_close)
    TextView tvClose;
    @BindView(R.id.mission_dialog_bottom)
    TextView missionDialogBottom;
    @BindView(R.id.ll_mission_dialog)
    LinearLayout llMissionDialog;
    @BindView(R.id.vm_recharge1)
    ViewMission vmRecharge1;
    @BindView(R.id.vm_register)
    ViewMission vmRegister;
    @BindView(R.id.vm_open)
    ViewMission vmOpen;
    @BindView(R.id.vm_invest1)
    ViewMission vmInvest1;
    @BindView(R.id.vm_recharge3)
    ViewMission vmRecharge3;
    @BindView(R.id.tv_lock_recharge)
    TextView tvLockRecharge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tvTitle.setText("任务");
    }


    @OnClick({R.id.iv_finish, R.id.tv_lock_recharge, R.id.vm_invest2, R.id.tv_lock_invest, R.id.vm_recharge2, R.id.vm_invite, R.id.tv_lock_invite, R.id.tv_close, R.id.vm_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.vm_register:
                llMissionDialog.setVisibility(View.VISIBLE);
                break;
            case R.id.tv_lock_recharge:
                break;
            case R.id.vm_invest2:
                break;
            case R.id.tv_lock_invest:
                break;
            case R.id.vm_recharge2:
                UIUtils.showToastCommon(MissionActivity.this, "充值");
                break;
            case R.id.vm_invite:
                break;
            case R.id.tv_lock_invite:
                break;
            case R.id.iv_finish:
                break;
            case R.id.tv_close:
                //关闭dialog
                llMissionDialog.setVisibility(View.GONE);
                break;

        }
    }


}

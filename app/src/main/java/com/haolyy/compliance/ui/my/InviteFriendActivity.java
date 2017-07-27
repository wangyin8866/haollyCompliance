package com.haolyy.compliance.ui.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.custom.TopBar;
import com.haolyy.compliance.ui.my.view.InviteRecordActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class InviteFriendActivity extends AppCompatActivity {
    @BindView(R.id.top_invite_friend)
    TopBar topInviteFriend;
    @BindView(R.id.iv_invite_banner)
    ImageView ivInviteBanner;
    @BindView(R.id.ll_invite_reward)
    LinearLayout llInviteReward;
    @BindView(R.id.btn_invite_friend)
    TextView btnInviteFriend;
    @BindView(R.id.tv_activity_rule)
    TextView tvActivityRule;
    @BindView(R.id.tv_close)
    TextView tvClose;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.ll_rule)
    LinearLayout llRule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_friend);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {

        topInviteFriend.setOnItemClickListener(new TopBar.OnItemClickListener() {
            @Override
            public void OnLeftButtonClicked() {
                finish();
            }

            @Override
            public void OnRightButtonClicked() {
                //TODO到邀请记录页面
                startActivity(new Intent(InviteFriendActivity.this, InviteRecordActivity.class));
            }
        });
    }

    @OnClick({R.id.tv_activity_rule, R.id.tv_close})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_activity_rule:
                llRule.setVisibility(View.VISIBLE);
                break;
            case R.id.tv_close:
                llRule.setVisibility(View.GONE);
                break;
        }
    }
}

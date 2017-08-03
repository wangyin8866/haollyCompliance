package com.haolyy.compliance.ui.my;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.haolyy.compliance.R;
import com.haolyy.compliance.custom.TopBar;
import com.haolyy.compliance.databinding.MessageBinding;
import com.haolyy.compliance.entity.my.MessageBean;

/**
 * Created by wangyin on 2017/6/7.
 */

public class MessageDetail extends AppCompatActivity {
    private MessageBinding messageBinding;
    private MessageBean.ModelBeanX.ModelBean.AccountMessagesBean accountMessagesBean;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        messageBinding = DataBindingUtil.setContentView(this, R.layout.activity_message_detail);
        init();
        messageBinding.setAccountMessagesBean(accountMessagesBean);
        messageBinding.topMessageDetail.setOnItemClickListener(new TopBar.OnItemClickListener() {
            @Override
            public void OnLeftButtonClicked() {
                finish();
            }

            @Override
            public void OnRightButtonClicked() {

            }
        });
    }

    private void init() {
        accountMessagesBean = (MessageBean.ModelBeanX.ModelBean.AccountMessagesBean) getIntent().getSerializableExtra("message");
    }
}

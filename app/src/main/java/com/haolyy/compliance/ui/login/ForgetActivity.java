package com.haolyy.compliance.ui.login;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseActivity;
import com.haolyy.compliance.ui.forget.presenter.ForgetPresenter;
import com.haolyy.compliance.ui.forget.view.ForgetView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 忘记密码
 * 作者：User on 2017/4/28 16:11
 */
public class ForgetActivity extends BaseActivity<ForgetPresenter, ForgetView> implements ForgetView {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.view_line)
    View viewLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        viewLine.setVisibility(View.VISIBLE);
        tvTitle.setText("忘记密码");
    }

    @Override
    protected ForgetPresenter createPresenter() {
        return new ForgetPresenter(mContext);
    }

    @Override
    protected void handleMessage(Integer s) {

    }

    @Override
    public void refresh() {

    }
}

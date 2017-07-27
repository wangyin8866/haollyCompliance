package com.haolyy.compliance.ui.product;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseApplication;
import com.haolyy.compliance.config.Config;
import com.haolyy.compliance.ui.login.LoginActivity;
import com.haolyy.compliance.ui.login.RegisterActivity;
import com.haolyy.compliance.utils.WYUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 产品详情h5
 * Created by niudeyang on 2017/5/17.
 */

public class FragmentBottomH5Detail extends Fragment {
    Unbinder unbinder;
    @BindView(R.id.agreement_webview)
    WebView agreementWebview;
    @BindView(R.id.agreement_progressBar)
    ProgressBar agreementProgressBar;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    @BindView(R.id.ll_content)
    LinearLayout llContent;

    private int project_type;
    private String product_no;
    private String projectNo;
    private int id;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottom_product_detail, container, false);
        unbinder = ButterKnife.bind(this, view);
        init();
        if (BaseApplication.mLoginState) {
            agreementWebview.setVisibility(View.VISIBLE);
            agreementProgressBar.setVisibility(View.VISIBLE);
            llContent.setVisibility(View.GONE);
            WYUtils.loadHtml(Config.borrow_detail + "?id=" + id + "&juid=" + BaseApplication.mUserName + "&projectType=" + project_type + "&productKind=" + product_no + "&projectNo=" + projectNo, agreementWebview, agreementProgressBar);
        } else {
            agreementWebview.setVisibility(View.GONE);
            agreementProgressBar.setVisibility(View.GONE);
            llContent.setVisibility(View.VISIBLE);
        }
        return view;
    }

    private void init() {
        projectNo = getActivity().getIntent().getStringExtra("projectNo");
        product_no = getActivity().getIntent().getStringExtra("product_no");
        project_type = getActivity().getIntent().getIntExtra("project_type", 0);
        id = getActivity().getIntent().getIntExtra("product_id", 0);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.tv_register, R.id.tv_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_register:
                startActivity(new Intent(getActivity(), RegisterActivity.class));
                break;
            case R.id.tv_login:
                startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
        }
    }
}

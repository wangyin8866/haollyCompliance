package com.haolyy.compliance.ui.product;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.haolyy.compliance.R;
import com.haolyy.compliance.utils.WYUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 借款详情
 * Created by niudeyang on 2017/5/17.
 */

public class FragmentBottomBorrowDetail extends Fragment {


    @BindView(R.id.agreement_webview)
    WebView agreementWebview;

    Unbinder unbinder;
    @BindView(R.id.agreement_progressBar)
    ProgressBar agreementProgressBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottom_borrow_detail, container, false);
        unbinder = ButterKnife.bind(this, view);
        WYUtils.loadHtml("http://www.chinazyjr.com/", agreementWebview,agreementProgressBar);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

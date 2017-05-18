package com.haolyy.compliance.ui.product;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.haolyy.compliance.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 产品详情h5
 * Created by niudeyang on 2017/5/17.
 */

public class FragmentUnusefulQuan extends Fragment {
    @BindView(R.id.web_product)
    WebView webProduct;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottom_left, container, false);
        unbinder = ButterKnife.bind(this, view);
        webProduct.loadUrl("https://www.haolyy.com/win-0/bowi20170517041005492619D2");
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

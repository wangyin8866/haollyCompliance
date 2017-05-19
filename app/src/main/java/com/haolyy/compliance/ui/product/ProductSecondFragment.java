package com.haolyy.compliance.ui.product;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.haolyy.compliance.R;
import com.haolyy.compliance.custom.SpringProgressView;

/**
 * Created by wangyin on 2017/5/18.
 */

public class ProductSecondFragment extends Fragment {
    private View view;
    private SpringProgressView springProgressView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.product_second_main, container, false);
        springProgressView = (SpringProgressView) view.findViewById(R.id.progressBar);
        springProgressView.setCurrentCount(0);
        springProgressView.setMaxCount(0);

        return view;
    }
}

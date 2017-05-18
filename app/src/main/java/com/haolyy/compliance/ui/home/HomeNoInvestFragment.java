package com.haolyy.compliance.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.haolyy.compliance.R;

/**
 * Created by wangyin on 2017/5/16.
 *
 * 未投资登录
 */

public class HomeNoInvestFragment extends Fragment{
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_no_invest_login_main, container, false);
        return view;
    }
}

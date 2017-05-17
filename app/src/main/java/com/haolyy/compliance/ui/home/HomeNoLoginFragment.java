package com.haolyy.compliance.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.haolyy.compliance.R;
import com.haolyy.compliance.custom.CircleView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by wangyin on 2017/5/16.
 * <p>
 * 未登录
 */

public class HomeNoLoginFragment extends Fragment {
    @BindView(R.id.id_circle)
    CircleView idCircle;
    Unbinder unbinder;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_no_login_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        idCircle.setData(1000,1000);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

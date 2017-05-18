package com.haolyy.compliance.ui.product;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.adapter.QuansAdapter;
import com.haolyy.compliance.base.BaseApplication;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 产品详情h5
 * Created by niudeyang on 2017/5/17.
 */

public class FragmentUsefulQuan extends Fragment {
    @BindView(R.id.lv_useful)
    ListView lvUseful;
    Unbinder unbinder;
    private List<Integer> quans=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_useful_quan, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {

        for(int i=0;i<10;i++){
            quans.add(i);
        }

        lvUseful.setAdapter(new QuansAdapter(getContext(),quans,0));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    }


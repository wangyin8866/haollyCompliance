package com.haolyy.compliance.ui.find;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.adapter.QuansAdapter;
import com.haolyy.compliance.entity.Repayment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 未使用的卡券
 */
public class FragmentUnused extends Fragment {
    @BindView(R.id.lv_useful)
    ListView lvUseful;
    Unbinder unbinder;
    private List<Integer> quans=new ArrayList<>();
    private List<Repayment> repayments;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find_crad_unused, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {

//        for(int i=0;i<10;i++){
//            quans.add(i);
//        }
        repayments = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            Repayment repayment = new Repayment(i + "期", i * 10 + "元", i * 100 + "元", i * 10 + "元");
            repayments.add(repayment);
        }
        lvUseful.setAdapter(new QuansAdapter(getContext(),repayments,0));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    }


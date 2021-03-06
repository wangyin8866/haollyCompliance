package com.haolyy.compliance.ui.find;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.haolyy.compliance.R;
import com.haolyy.compliance.custom.LocalImageHolderView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by wangyin on 2017/5/16.
 */

public class FindFragment extends Fragment {
    @BindView(R.id.find_banner)
    ConvenientBanner findBanner;
    Unbinder unbinder;
    @BindView(R.id.find_more)
    TextView findMore;
    @BindView(R.id.find_iv_weixin)
    ImageView findIvWeixin;
    @BindView(R.id.find_iv_call_service)
    ImageView findIvCallService;
    private View view;
    private ArrayList<String> images ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.find_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        images = new ArrayList<String>();
        images.add("http://pic2.ooopic.com/10/56/19/67b1OOOPIC12.jpg");
        images.add("http://pic2.ooopic.com/10/55/95/20b1OOOPICfa.jpg");
        images.add("http://pic2.ooopic.com/12/80/79/89b1OOOPICd2.jpg");
        findBanner.startTurning(2000);

        findBanner.setPages(new CBViewHolderCreator() {
            @Override
            public Object createHolder() {
                return new LocalImageHolderView();
            }
        }, images).setPageIndicator(new int[]{R.mipmap.banner_point, R.mipmap.banner_checked});
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.find_more, R.id.find_iv_weixin, R.id.find_iv_call_service})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.find_more:
                startActivity(new Intent(getActivity(),ShoppingActivity.class));
                break;
            case R.id.find_iv_weixin:
                break;
            case R.id.find_iv_call_service:
                break;
        }
    }
}

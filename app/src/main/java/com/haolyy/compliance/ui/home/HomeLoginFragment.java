package com.haolyy.compliance.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.haolyy.compliance.R;
import com.haolyy.compliance.custom.LocalImageHolderView;
import com.haolyy.compliance.custom.MarqueeTextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by wangyin on 2017/5/16.
 * <p>
 * 投资过登录
 */

public class HomeLoginFragment extends Fragment {
    @BindView(R.id.tv_marquee)
    MarqueeTextView tvMarquee;
    Unbinder unbinder;
    @BindView(R.id.banner)
    ConvenientBanner banner;
    private View view;
    private ArrayList<String> images = new ArrayList<String>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_yes_login_main, container, false);
        unbinder = ButterKnife.bind(this, view);

        tvMarquee.setText("5月11日好利网已经全面升级");

        images.add("http://pic2.ooopic.com/10/56/19/67b1OOOPIC12.jpg");
        images.add("http://pic2.ooopic.com/10/55/95/20b1OOOPICfa.jpg");
        images.add("http://pic2.ooopic.com/12/80/79/89b1OOOPICd2.jpg");
        banner.startTurning(2000);

        banner.setPages(new CBViewHolderCreator() {
            @Override
            public Object createHolder() {
                return new LocalImageHolderView();
            }
        }, images).setPageIndicator(new int[]{R.mipmap.ic_page_indicator, R.mipmap.ic_page_indicator_focused});
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

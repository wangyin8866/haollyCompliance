package com.haolyy.compliance.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseFragment;
import com.haolyy.compliance.ui.home.presenter.HomeNoLoginPresenter;
import com.haolyy.compliance.ui.home.view.HomeNoLoginView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by wangyin on 2017/5/16.
 * <p>
 * 未登录
 */

public class HomeNoLoginFragment extends BaseFragment<HomeNoLoginPresenter,HomeNoLoginView>implements HomeNoLoginView {

    @BindView(R.id.banner)
    ConvenientBanner banner;
    Unbinder unbinder;
    private View view;
    private ArrayList<String> images = new ArrayList<String>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_no_login_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        images.add("http://pic2.ooopic.com/10/56/19/67b1OOOPIC12.jpg");
        images.add("http://pic2.ooopic.com/10/55/95/20b1OOOPICfa.jpg");
        images.add("http://pic2.ooopic.com/12/80/79/89b1OOOPICd2.jpg");
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

    @Override
    protected HomeNoLoginPresenter createPresenter() {
        return new HomeNoLoginPresenter(mContext);
    }

    public class LocalImageHolderView implements Holder<String> {
        private ImageView imageView;

        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, String data) {
            Glide.with(context).load(data).into(imageView);
        }
    }
}

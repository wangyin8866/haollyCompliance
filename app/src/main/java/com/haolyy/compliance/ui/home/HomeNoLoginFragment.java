package com.haolyy.compliance.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.haolyy.compliance.R;
import com.haolyy.compliance.adapter.HomeActivityPagerAdapter;
import com.haolyy.compliance.adapter.HomeNewPagerAdapter;
import com.haolyy.compliance.base.BaseFragment;
import com.haolyy.compliance.custom.LocalImageHolderView;
import com.haolyy.compliance.entity.TestProduct;
import com.haolyy.compliance.ui.home.presenter.HomeNoLoginPresenter;
import com.haolyy.compliance.ui.home.view.HomeNoLoginView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by wangyin on 2017/5/16.
 * <p>
 * 未登录
 */

public class HomeNoLoginFragment extends BaseFragment<HomeNoLoginPresenter, HomeNoLoginView> implements HomeNoLoginView {

    @BindView(R.id.banner)
    ConvenientBanner banner;
    Unbinder unbinder;
    @BindView(R.id.home_newPager)
    ViewPager homeNewPager;
    @BindView(R.id.home_activity_pager)
    ViewPager homeActivityPager;
    private View view;
    private ArrayList<String> images = new ArrayList<String>();
    private List<TestProduct> testProducts;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_no_login_main, container, false);
        unbinder = ButterKnife.bind(this, view);

        Log.e("onCreateView", "onCreateView");
        Log.e("images", images.size()+"aa");
        if (images.size()==0) {

        images.add("http://pic2.ooopic.com/10/56/19/67b1OOOPIC12.jpg");
        images.add("http://pic2.ooopic.com/10/55/95/20b1OOOPICfa.jpg");
        images.add("http://pic2.ooopic.com/12/80/79/89b1OOOPICd2.jpg");
        }
        banner.startTurning(2000);

        banner.setPages(new CBViewHolderCreator() {
            @Override
            public Object createHolder() {
                return new LocalImageHolderView();
            }
        }, images).setPageIndicator(new int[]{R.mipmap.banner_point, R.mipmap.banner_checked});


        testProducts = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            TestProduct testProduct = new TestProduct(1 + i, 10 + i, i, 100 * i, 1000 * i);
            testProducts.add(testProduct);
        }
        homeNewPager.setAdapter(new HomeNewPagerAdapter(testProducts, mContext));
        homeActivityPager.setAdapter(new HomeActivityPagerAdapter(testProducts, mContext));
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

}

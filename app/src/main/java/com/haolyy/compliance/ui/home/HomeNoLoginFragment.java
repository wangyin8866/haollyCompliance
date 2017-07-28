package com.haolyy.compliance.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.haolyy.compliance.R;
import com.haolyy.compliance.adapter.HomeActivityPagerAdapter;
import com.haolyy.compliance.adapter.HomeNewPagerAdapter;
import com.haolyy.compliance.base.BaseApplication;
import com.haolyy.compliance.base.BaseFragment;
import com.haolyy.compliance.custom.LocalImageHolderViewNative;
import com.haolyy.compliance.custom.MyPointView;
import com.haolyy.compliance.entity.home.Banner;
import com.haolyy.compliance.entity.home.HomeActivity;
import com.haolyy.compliance.ui.home.presenter.HomeNoLoginPresenter;
import com.haolyy.compliance.ui.home.view.HomeNoLoginView;
import com.haolyy.compliance.ui.login.LoginActivity;
import com.haolyy.compliance.ui.login.RegisterActivity;
import com.haolyy.compliance.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by wangyin on 2017/5/16.
 * <p>
 * 未登录
 */

public class HomeNoLoginFragment extends BaseFragment<HomeNoLoginPresenter, HomeNoLoginView> implements HomeNoLoginView {

    Unbinder unbinder;
    @BindView(R.id.banner)
    ConvenientBanner banner;
    @BindView(R.id.home_login)
    ImageView homeLogin;
    @BindView(R.id.home_newPager)
    ViewPager homeNewPager;
    @BindView(R.id.point_view1)
    MyPointView pointView1;
    @BindView(R.id.home_activity_pager)
    ViewPager homeActivityPager;
    @BindView(R.id.home_ll_visibility)
    LinearLayout homeLlVisibility;
    @BindView(R.id.home_iv_new)
    ImageView homeIvNew;
    @BindView(R.id.home_text)
    TextView homeText;
    @BindView(R.id.iv_cunguan)
    ImageView ivCunguan;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.ll_text)
    LinearLayout llText;
    @BindView(R.id.iv_cunguan1)
    ImageView ivCunguan1;
    @BindView(R.id.ll_text1)
    LinearLayout llText1;
    @BindView(R.id.iv3)
    ImageView iv3;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.btn_tab1)
    Button btnTab1;
    @BindView(R.id.btn_tab2)
    Button btnTab2;
    private View view;
    private ArrayList<String> images;

    private List<Banner.ModelBeanX.ModelBean> modelBeen;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_no_login_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        //拉去数据  1
        mPresenter.getBanner("1");
        return view;
    }

    @OnClick({R.id.home_login, R.id.tv_register, R.id.btn_tab1, R.id.btn_tab2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_login:
                startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
            case R.id.tv_register:
                startActivity(new Intent(getActivity(), RegisterActivity.class));
                break;
            case R.id.btn_tab1:
                startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
            case R.id.btn_tab2:
                startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
        }
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

    @Override
    public void showBannerData(Banner banner) {
        if (images != null) {
            images.clear();
        }
        images = new ArrayList<String>();

        modelBeen = banner.getModel().getModel();
        for (int i = 0; i < modelBeen.size(); i++) {
            images.add(modelBeen.get(i).getImageUrl());
        }
        //本地图片
        ArrayList<Integer> imgs = new ArrayList<>();
        imgs.add(R.mipmap.banner1);
        imgs.add(R.mipmap.banner2);
        imgs.add(R.mipmap.banner3);
        this.banner.setPages(new CBViewHolderCreator() {
            @Override
            public Object createHolder() {
                return new LocalImageHolderViewNative();
            }
        }, imgs).setPageIndicator(new int[]{R.mipmap.ic_page_indicator, R.mipmap.ic_page_indicator_focused});

//        this.banner.setPages(new CBViewHolderCreator() {
//            @Override
//            public Object createHolder() {
//                return new LocalImageHolderView();
//            }
//        }, images).setPageIndicator(new int[]{R.mipmap.ic_page_indicator, R.mipmap.ic_page_indicator_focused});
        this.banner.startTurning(2000);

        mPresenter.getRecommend(BaseApplication.userId + "");//首页新闻 2
    }

    @Override
    public void showHomeActivityData(HomeActivity homeActivity) {

        //新手标
        pointView1.init(homeActivity.getModel().getModel().getRecommendNew());
        homeNewPager.setAdapter(new HomeNewPagerAdapter(homeActivity.getModel().getModel().getRecommendNew(), mContext));
        homeNewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                pointView1.selectView(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        homeNewPager.setPageMargin(UIUtils.dip2px(20));

        //活动标
        homeActivityPager.setAdapter(new HomeActivityPagerAdapter(homeActivity.getModel().getModel().getRecommend(), mContext));

        homeActivityPager.setPageMargin(UIUtils.dip2px(10));
        homeActivityPager.setOffscreenPageLimit(3);
    }

}

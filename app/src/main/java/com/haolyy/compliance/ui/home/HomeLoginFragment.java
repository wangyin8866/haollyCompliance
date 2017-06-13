package com.haolyy.compliance.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.haolyy.compliance.R;
import com.haolyy.compliance.adapter.HomeActivityPagerAdapter;
import com.haolyy.compliance.adapter.HomeNewPagerAdapter;
import com.haolyy.compliance.adapter.HomeProductAdapter;
import com.haolyy.compliance.base.BaseFragment;
import com.haolyy.compliance.custom.AutoVerticalScrollTextView;
import com.haolyy.compliance.custom.InnerScrollListView;
import com.haolyy.compliance.custom.LocalImageHolderView;
import com.haolyy.compliance.entity.TestProduct;
import com.haolyy.compliance.ui.home.presenter.HomeLoginPresenter;
import com.haolyy.compliance.ui.home.view.HomeLoginView;
import com.haolyy.compliance.ui.my.InviteFriendActivity;
import com.haolyy.compliance.ui.product.ProductDetailActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by wangyin on 2017/5/16.
 * <p>
 * 投资过登录
 */

public class HomeLoginFragment extends BaseFragment<HomeLoginPresenter, HomeLoginView> implements HomeLoginView {

    Unbinder unbinder;
    @BindView(R.id.banner)
    ConvenientBanner banner;
    @BindView(R.id.iv_zhang_dan)
    ImageView ivZhangDan;
    @BindView(R.id.home_newPager)
    ViewPager homeNewPager;
    @BindView(R.id.home_activity_pager)
    ViewPager homeActivityPager;
    @BindView(R.id.home_xlv)
    InnerScrollListView homeXlv;
    @BindView(R.id.home_ll_visibility)
    LinearLayout homeLlVisibility;
    @BindView(R.id.textview_auto_roll)
    AutoVerticalScrollTextView textviewAutoRoll;
    @BindView(R.id.rl_activity)
    RelativeLayout rlActivity;
    @BindView(R.id.rl_invite_friend)
    RelativeLayout rlInviteFriend;
    private View view;
    private ArrayList<String> images = new ArrayList<String>();
    private List<TestProduct> testProducts;
    private boolean isInvest;
    private String[] auto_roll_strings = {"asdasd", "bbbbb", "cccccccccc"};

    private boolean isAutoRollRunning = false;
    private int autoRollIndex;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_yes_login_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();

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



        testProducts = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            TestProduct testProduct = new TestProduct(1 + i, 10 + i, i, 100 * i, 1000 * i);
            testProducts.add(testProduct);
        }
        homeNewPager.setAdapter(new HomeNewPagerAdapter(testProducts, mContext));
        homeActivityPager.setAdapter(new HomeActivityPagerAdapter(testProducts, mContext));

        homeXlv.setAdapter(new HomeProductAdapter(testProducts, getActivity()));
        return view;
    }

    private void initView() {
        isInvest = false;
        if (isInvest) {
            homeLlVisibility.setVisibility(View.GONE);
        } else {
            homeLlVisibility.setVisibility(View.VISIBLE);
        }
        showAutoRollStrings();
    }

    private void showAutoRollStrings() {
        textviewAutoRoll.setText(auto_roll_strings[0]);
        isAutoRollRunning = true;
        handler.sendEmptyMessage(199);
//        executor.execute(new Runnable() {
//            @Override
//            public void run() {
//                while (isAutoRollRunning){
//                    SystemClock.sleep(3000);
//                    handler.sendEmptyMessage(199);
//                }
//            }
//        });
    }


    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == 199) {
                textviewAutoRoll.next();
                autoRollIndex++;
                textviewAutoRoll.setText(auto_roll_strings[autoRollIndex % auto_roll_strings.length]);
                handler.sendEmptyMessageDelayed(199, 3000);
            }
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        handler.removeCallbacksAndMessages(null);
        unbinder.unbind();
    }

    @Override
    protected HomeLoginPresenter createPresenter() {
        return new HomeLoginPresenter(mContext);
    }

    @OnClick({R.id.rl_activity, R.id.rl_invite_friend,R.id.iv_zhang_dan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_zhang_dan:
                startActivity(new Intent(getActivity(), ProductDetailActivity.class));
                break;
            case R.id.rl_activity:
                break;
            case R.id.rl_invite_friend:
                startActivity(new Intent(getActivity(), InviteFriendActivity.class));
                break;
        }
    }
}

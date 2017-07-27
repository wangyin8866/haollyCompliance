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
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.haolyy.compliance.R;
import com.haolyy.compliance.adapter.HomeActivityPagerAdapter;
import com.haolyy.compliance.adapter.HomeNewPagerAdapter;
import com.haolyy.compliance.adapter.HomeProductAdapter;
import com.haolyy.compliance.base.BaseFragment;
import com.haolyy.compliance.custom.AutoVerticalScrollTextView;
import com.haolyy.compliance.custom.InnerScrollListView;
import com.haolyy.compliance.custom.LocalImageHolderViewNative;
import com.haolyy.compliance.custom.MyPointView;
import com.haolyy.compliance.entity.home.Banner;
import com.haolyy.compliance.entity.home.HomeActivity;
import com.haolyy.compliance.entity.home.HomeArticle;
import com.haolyy.compliance.entity.home.HomeProduct;
import com.haolyy.compliance.entity.home.UserInfoBean;
import com.haolyy.compliance.ui.home.presenter.HomeLoginPresenter;
import com.haolyy.compliance.ui.home.view.HomeLoginView;
import com.haolyy.compliance.ui.my.InviteFriendActivity;
import com.haolyy.compliance.ui.product.ProductDetailActivity;
import com.haolyy.compliance.utils.LogUtils;
import com.haolyy.compliance.utils.SPUtils;
import com.haolyy.compliance.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.haolyy.compliance.R.id.home_iv_eye;
import static com.haolyy.compliance.base.BaseApplication.userId;

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
    @BindView(R.id.point_view1)
    MyPointView pointView1;
    @BindView(R.id.tv_data_auto_roll)
    AutoVerticalScrollTextView tvDataAutoRoll;
    @BindView(R.id.tv_total_amount)
    TextView tvTotalAmount;
    @BindView(R.id.tv_available_credit)
    TextView tvAvailableCredit;
    @BindView(R.id.tv_cumulative_income)
    TextView tvCumulativeIncome;
    @BindView(R.id.tv_yesterday_income)
    TextView tvYesterdayIncome;
    @BindView(home_iv_eye)
    ImageView homeIvEye;
    @BindView(R.id.iv_home_icon_1)
    ImageView ivHomeIcon1;
    @BindView(R.id.iv_home_icon_2)
    ImageView ivHomeIcon2;

    private View view;
    private ArrayList<String> images ;
    private List<String> auto_roll_strings;
    private List<String> auto_roll_data;
    private boolean isAutoRollRunning;
    private int autoRollIndex;
    private List<Banner.ModelBeanX.ModelBean> modelBeen;
    private boolean isShowMoney;
    private String availableCredit;
    private String cumulativeIncome;
    private String totalAmount;
    private String yesterdayIncome;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_yes_login_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        mPresenter.getUserInfo();

        return view;
    }




    private void showAutoRollStrings() {
        textviewAutoRoll.setText(auto_roll_strings.get(0));
        tvDataAutoRoll.setTText(auto_roll_data.get(0));

        isAutoRollRunning = true;
        handler.sendEmptyMessage(199);

    }


    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == 199) {
                textviewAutoRoll.next();
                tvDataAutoRoll.next();
                autoRollIndex++;
                textviewAutoRoll.setText(auto_roll_strings.get(autoRollIndex % auto_roll_strings.size()));
                tvDataAutoRoll.setTText(auto_roll_data.get(autoRollIndex % auto_roll_data.size()));
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

    @OnClick({R.id.rl_activity, R.id.rl_invite_friend, R.id.iv_zhang_dan, R.id.home_iv_eye})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_zhang_dan:
                break;
            case R.id.rl_activity:
                break;
            case R.id.rl_invite_friend:
                startActivity(new Intent(getActivity(), InviteFriendActivity.class));
                break;
            case R.id.home_iv_eye:
                LogUtils.e("isShowMoney", isShowMoney + "");
                isShowMoney = !isShowMoney;
                moneyIsVisibility(isShowMoney);
                SPUtils.saveBoolean(mContext, "isShowMoney", isShowMoney);
                break;
        }
    }

    /**
     * 账户显示隐藏
     *
     * @param isShowMoney
     */
    private void moneyIsVisibility(boolean isShowMoney) {
        LogUtils.e("isShowMoney2", isShowMoney + "");
        if (isShowMoney) {
            homeIvEye.setImageResource(R.mipmap.home_yanjing);
            tvAvailableCredit.setText(availableCredit);
            tvCumulativeIncome.setText(cumulativeIncome);
            tvTotalAmount.setText(totalAmount);
            tvYesterdayIncome.setText(yesterdayIncome);
        } else {
            homeIvEye.setImageResource(R.mipmap.home_yanjing2);
            tvAvailableCredit.setText("****");
            tvCumulativeIncome.setText("****");
            tvTotalAmount.setText("****");
            tvYesterdayIncome.setText("****");
        }
    }

    @Override
    public void showBannerData(Banner banner) {

        if (images != null) {
            images.clear();
        }
        images = new ArrayList<String>();
        mPresenter.getHomeArticle();//首页新闻 2
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

    }

    @Override
    public void showHomeActivityData(HomeActivity homeActivity) {
        mPresenter.getHomeProduct();//首页产品 4

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
    }

    @Override
    public void showHomeArticleData(HomeArticle homeArticle) {

        mPresenter.getRecommend(userId + "");//首页活动 3
        auto_roll_strings = new ArrayList<>();
        auto_roll_data = new ArrayList<>();
        for (int i = 0; i < homeArticle.getModel().getModel().getAnnouncementList().size(); i++) {
            auto_roll_strings.add(homeArticle.getModel().getModel().getAnnouncementList().get(i).getDescription());
            auto_roll_data.add(homeArticle.getModel().getModel().getAnnouncementList().get(i).getCreateTime().substring(0, 10));
        }
        showAutoRollStrings();
    }

    @Override
    public void showHomeProductData(HomeProduct homeProduct) {
        final List<HomeProduct.ModelBeanX.ModelBean> list= homeProduct.getModel().getModel();
        homeXlv.setAdapter(new HomeProductAdapter(list, getActivity()));
        homeXlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(mContext, ProductDetailActivity.class);
                intent.putExtra("projectNo", list.get(position).getProjectNo());
                intent.putExtra("productName", list.get(position).getProductName());
                intent.putExtra("project_type", list.get(position).getProjectType());
                intent.putExtra("product_no", list.get(position).getProductNo());
                intent.putExtra("flag", "home");
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public void showUserInfoData(UserInfoBean userInfoBean) {
        //拉去数据  1
        mPresenter.getBanner("2");
        UserInfoBean.ModelBeanX.ModelBean modelBean = userInfoBean.getModel().getModel();
        totalAmount = modelBean.getTotal_amount();
        availableCredit = modelBean.getAvailable_credit();
        cumulativeIncome = modelBean.getCumulative_income();
        yesterdayIncome = modelBean.getYesterday_income();

        isShowMoney = SPUtils.getBoolean(mContext, "isShowMoney", true);
        LogUtils.e("isShowMoney1", isShowMoney + "");
        moneyIsVisibility(isShowMoney);
        if (modelBean.getInvest_status().equals("1")) {//投资
            homeLlVisibility.setVisibility(View.GONE);
        } else {
            homeLlVisibility.setVisibility(View.VISIBLE);
        }
    }
}

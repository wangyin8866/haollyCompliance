package com.haolyy.compliance.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.haolyy.compliance.R;
import com.haolyy.compliance.base.ActivityCollector;
import com.haolyy.compliance.custom.NoScrollViewPager;
import com.haolyy.compliance.ui.find.FindNewFragment;
import com.haolyy.compliance.ui.home.HomeLoginFragment;
import com.haolyy.compliance.ui.home.HomeNoLoginFragment;
import com.haolyy.compliance.ui.login.LoginActivity;
import com.haolyy.compliance.ui.my.MyFragment;
import com.haolyy.compliance.ui.product.ProductFragment;
import com.haolyy.compliance.utils.LogUtils;
import com.haolyy.compliance.utils.WYUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.haolyy.compliance.base.BaseApplication.mLoginState;

/**
 * Created by wangyin on 2017/5/16.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.id_tab_ll_01)
    LinearLayout idTabLl01;
    @BindView(R.id.id_tab_ll_02)
    LinearLayout idTabLl02;
    @BindView(R.id.id_tab_ll_03)
    LinearLayout idTabLl03;
    @BindView(R.id.id_tab_ll_04)
    LinearLayout idTabLl04;
    @BindView(R.id.id_main_viewPager)
    NoScrollViewPager idMainViewPager;
    @BindView(R.id.id_tab_iv_01)
    ImageView idTabIv01;
    @BindView(R.id.id_tab_tv_01)
    TextView idTabTv01;
    @BindView(R.id.id_tab_iv_02)
    ImageView idTabIv02;
    @BindView(R.id.id_tab_tv_02)
    TextView idTabTv02;
    @BindView(R.id.id_tab_iv_03)
    ImageView idTabIv03;
    @BindView(R.id.id_tab_tv_03)
    TextView idTabTv03;
    @BindView(R.id.id_tab_iv_04)
    ImageView idTabIv04;
    @BindView(R.id.id_tab_tv_04)
    TextView idTabTv04;
    private HomeNoLoginFragment homeNoLoginFragment;
    private HomeLoginFragment homeInvestFragment;
    private ProductFragment productFragment;
//    private FindFragment findFragment;
    private MyFragment myFragment;
    private FindNewFragment findNewFragment;
    private List<Fragment> fragments;
    public static int currentPage;
    private static final String TAG = "MainActivity";
    private ImmersionBar mImmersionBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
//        idMainViewPager.setOffscreenPageLimit(5);
        idMainViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        switchStateHome(mLoginState);

    }

    /**
     * 判断是否登录
     *
     * @param isLogin
     */
    private void switchStateHome(boolean isLogin) {
        LogUtils.e("cu", currentPage + "");
        if (isLogin) {
            if (currentPage == 0) {
                currentPage = 4;
            }
        } else if (currentPage == 4 || currentPage == 3) {
            currentPage = 0;
        }
        setTabSelection(currentPage);
    }

    private void switchClickStateHome(boolean mLoginState) {
        if (mLoginState) {
            currentPage = 4;
        } else {
            currentPage = 0;
        }
        setTabSelection(currentPage);
    }

    private void init() {
        mImmersionBar=ImmersionBar.with(this);
        mImmersionBar.statusBarDarkFont(true).init();
        ActivityCollector.addActivity(this);
        homeNoLoginFragment = new HomeNoLoginFragment();
        homeInvestFragment = new HomeLoginFragment();

        productFragment = new ProductFragment();
//        findFragment = new FindFragment();
        findNewFragment = new FindNewFragment();
        myFragment = new MyFragment();
        fragments = new ArrayList<>();
        fragments.add(homeNoLoginFragment);
        fragments.add(productFragment);
        fragments.add(findNewFragment);
        fragments.add(myFragment);
        fragments.add(homeInvestFragment);

        idTabLl01.setOnClickListener(this);
        idTabLl02.setOnClickListener(this);
        idTabLl03.setOnClickListener(this);
        idTabLl04.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_tab_ll_01:
                switchClickStateHome(mLoginState);
                break;
            case R.id.id_tab_ll_02:
                currentPage = 1;
                setTabSelection(currentPage);
                break;
            case R.id.id_tab_ll_03:
                currentPage = 2;
                setTabSelection(currentPage);
                break;
            case R.id.id_tab_ll_04:
                if (mLoginState) {
                    currentPage = 3;
                    setTabSelection(currentPage);
                } else {
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                }
                break;
        }
    }


    private void setTabSelection(int currentPage) {

        //选中前清除状态
        restView();
        switch (currentPage) {
            case 0://未登录
                idTabIv01.setImageResource(R.mipmap.ic_home_checked);
                idTabTv01.setTextColor(getResources().getColor(R.color.tv_navigate_checked));
                switchPager(currentPage);
                break;
            case 1:
                idTabIv02.setImageResource(R.mipmap.ic_product_checked);
                idTabTv02.setTextColor(getResources().getColor(R.color.tv_navigate_checked));
                switchPager(currentPage);
                break;
            case 2:
                idTabIv03.setImageResource(R.mipmap.ic_find_checked);
                idTabTv03.setTextColor(getResources().getColor(R.color.tv_navigate_checked));
                switchPager(currentPage);
                break;
            case 3:
                idTabIv04.setImageResource(R.mipmap.ic_my_checked);
                idTabTv04.setTextColor(getResources().getColor(R.color.tv_navigate_checked));
                switchPager(currentPage);
                break;
            case 4://登录
                idTabIv01.setImageResource(R.mipmap.ic_home_checked);
                idTabTv01.setTextColor(getResources().getColor(R.color.tv_navigate_checked));
                switchPager(currentPage);
                break;

        }
    }

    private void switchPager(int currentPage) {
        LogUtils.e("currentPage", currentPage + "");
        idMainViewPager.setCurrentItem(currentPage, false);
    }

    /**
     * 重置所有状态
     */
    private void restView() {
        idTabIv01.setImageResource(R.mipmap.ic_home);
        idTabIv02.setImageResource(R.mipmap.ic_product);
        idTabIv03.setImageResource(R.mipmap.ic_find);
        idTabIv04.setImageResource(R.mipmap.ic_my);

        idTabTv01.setTextColor(getResources().getColor(R.color.tv_navigate));
        idTabTv02.setTextColor(getResources().getColor(R.color.tv_navigate));
        idTabTv03.setTextColor(getResources().getColor(R.color.tv_navigate));
        idTabTv04.setTextColor(getResources().getColor(R.color.tv_navigate));

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(TAG, currentPage);
        LogUtils.e("onSaveInstanceState","onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        currentPage = savedInstanceState.getInt(TAG);
        LogUtils.e("onRestoreInstanceState","onRestoreInstanceState");
    }
    /**
     * 跳转到主页的方法
     * @param context
     * @param page
     * @return
     */
    public static Intent getMainIntent(Context context, int page) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("currentpage", page);
        return intent;

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        int cp = getIntent().getIntExtra("currentpage", -1);
        if(cp!=-1){
            LogUtils.e("ndy","cp"+cp);
            currentPage=cp;
            switchPager(cp);
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        WYUtils.clickBack(keyCode, event, MainActivity.this);
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mImmersionBar.destroy();
    }
}

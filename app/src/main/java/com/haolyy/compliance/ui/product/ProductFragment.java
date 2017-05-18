package com.haolyy.compliance.ui.product;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.haolyy.compliance.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by wangyin on 2017/5/16.
 */

public class ProductFragment extends Fragment implements View.OnClickListener {
    @BindView(R.id.id_firstTextVIew)
    TextView idFirstTextVIew;
    @BindView(R.id.id_ll_top)
    LinearLayout idLlTop;
    @BindView(R.id.id_secondTextView)
    TextView idSecondTextView;
    @BindView(R.id.id_thirdTextView)
    TextView idThirdTextView;
    @BindView(R.id.id_iv_tabLine)
    ImageView idIvTabLine;
    @BindView(R.id.product_viewPager)
    ViewPager productViewPager;
    Unbinder unbinder;
    private View view;
    private List<Fragment> mDatas;
    private FragmentPagerAdapter mdAdapter;
    private int mScreen1_3;
    private int mCurrentPageIndex;
    private ProductFirstFragment firstFragment;
    private ProductSecondFragment secondFragment;
    private ProductThirdFragment thirdFragment;
    private int lineMargin;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.product_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        getScreen();
        idFirstTextVIew.setOnClickListener(this);
        idSecondTextView.setOnClickListener(this);
        idThirdTextView.setOnClickListener(this);
        return view;
    }

    //获取屏幕尺寸
    private void getScreen() {
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);
        mScreen1_3 = outMetrics.widthPixels / 3;
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) idIvTabLine.getLayoutParams();
        layoutParams.width = mScreen1_3 - layoutParams.leftMargin*2;
        idIvTabLine.setLayoutParams(layoutParams);
        lineMargin = layoutParams.leftMargin;
    }

    private void initView() {
        mDatas = new ArrayList<>();
        firstFragment = new ProductFirstFragment();
        secondFragment = new ProductSecondFragment();
        thirdFragment = new ProductThirdFragment();
        mDatas.add(firstFragment);
        mDatas.add(secondFragment);
        mDatas.add(thirdFragment);
        mdAdapter = new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mDatas.get(position);
            }

            @Override
            public int getCount() {
                return mDatas.size();
            }
        };
        productViewPager.setAdapter(mdAdapter);
        productViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.e("tag", position + "," + positionOffset + "," + positionOffsetPixels + "," + mCurrentPageIndex);
                //设置tabLine的滑动效果
                LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) idIvTabLine.getLayoutParams();
                if (mCurrentPageIndex == 0 && position == 0) {//0->1
                    lp.leftMargin = (int) (mCurrentPageIndex * mScreen1_3 + positionOffset * mScreen1_3)+lineMargin;
                } else if (mCurrentPageIndex == 1 && position == 0) {//1->0
                    lp.leftMargin = (int) (mCurrentPageIndex * mScreen1_3 + (positionOffset - 1) * mScreen1_3+lineMargin);
                } else if (mCurrentPageIndex == 1 && position == 1) {//1->2
                    lp.leftMargin = (int) (mCurrentPageIndex * mScreen1_3 + positionOffset * mScreen1_3+lineMargin);
                } else if (mCurrentPageIndex == 2 && position == 1) {//2->1
                    lp.leftMargin = (int) (mCurrentPageIndex * mScreen1_3 + (positionOffset - 1) * mScreen1_3+lineMargin);
                } else if (mCurrentPageIndex == 2 && position == 2) {//2
                    lp.leftMargin = (int) (mCurrentPageIndex * mScreen1_3 + (positionOffset) * mScreen1_3+lineMargin);
                }
                idIvTabLine.setLayoutParams(lp);
            }

            @Override
            public void onPageSelected(int position) {
                //重置颜色
                resetTextView();
                switch (position) {
                    case 0:
                        idFirstTextVIew.setTextColor(Color.parseColor("#FF9933"));
                        break;
                    case 1:
                        idSecondTextView.setTextColor(Color.parseColor("#FF9933"));
                        break;
                    case 2:
                        idThirdTextView.setTextColor(Color.parseColor("#FF9933"));
                        break;
                }
                mCurrentPageIndex = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void resetTextView() {
        idFirstTextVIew.setTextColor(Color.parseColor("#4A4A4A"));
        idSecondTextView.setTextColor(Color.parseColor("#4A4A4A"));
        idThirdTextView.setTextColor(Color.parseColor("#4A4A4A"));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_firstTextVIew:
                //设置当前页面的位置
                productViewPager.setCurrentItem(0, false);
                break;
            case R.id.id_secondTextView:
                productViewPager.setCurrentItem(1, false);
                break;
            case R.id.id_thirdTextView:
                productViewPager.setCurrentItem(2, false);
                break;

        }
    }
}

package com.haolyy.compliance.ui.product;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.base.BaseFragment;
import com.haolyy.compliance.custom.BottomScrollView;
import com.haolyy.compliance.custom.CircleProgressView;
import com.haolyy.compliance.ui.product.presenter.ProductTopPresenter;
import com.haolyy.compliance.ui.product.view.ProductTopView;
import com.haolyy.compliance.utils.UIUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 产品详情顶部页面
 * Created by wangyin on 2017/5/16.
 */

public class ProductFragmentTop extends BaseFragment<ProductTopPresenter, ProductTopView> implements ProductTopView {
    Unbinder unbinder;
    @BindView(R.id.tv_product_rate)
    TextView tvProductRate;
    @BindView(R.id.tv_mirror_plan)
    TextView tvMirrorPlan;
    @BindView(R.id.tv_pull)
    TextView tvPull;
    @BindView(R.id.tv_use_quan)
    TextView tvUseQuan;
    @BindView(R.id.arc_progress_view)
    CircleProgressView arcProgressView;
    @BindView(R.id.bottom_scroll)
    BottomScrollView bottomScroll;
    @BindView(R.id.join_image_circle4)
    ImageView joinImageCircle4;
    @BindView(R.id.tv_time1)
    TextView tvTime1;
    @BindView(R.id.tv_time_data1)
    TextView tvTimeData1;
    @BindView(R.id.tv_time2)
    TextView tvTime2;
    @BindView(R.id.tv_time_data2)
    TextView tvTimeData2;
    @BindView(R.id.tv_time3)
    TextView tvTime3;
    @BindView(R.id.et_invest_account)
    EditText etInvestAccount;
    @BindView(R.id.join_image_circle3)
    ImageView joinImageCircle3;
    @BindView(R.id.join_line3)
    View joinLine3;
    @BindView(R.id.invest_scrollview)
    ScrollView investScrollview;

    @Override
    protected ProductTopPresenter createPresenter() {
        return new ProductTopPresenter(mContext);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_top, container, false);
        unbinder = ButterKnife.bind(this, view);
        SpannableString textSpan = new SpannableString("7.0%+1.0%");
        textSpan.setSpan(new AbsoluteSizeSpan(UIUtils.dip2px(36)), 0, 3, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        textSpan.setSpan(new AbsoluteSizeSpan(UIUtils.dip2px(14)), 3, 9, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        tvProductRate.setText(textSpan);
        arcProgressView.setData(800, 1000);
        bottomScroll.setOnScrollToBottomLintener(new BottomScrollView.OnScrollToBottomListener() {
            @Override
            public void onScrollBottomListener(boolean isBottom) {
                if (isBottom) {
                    bottomScroll.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            switch (event.getAction()) {
                                case MotionEvent.ACTION_MOVE:
                                    bottomScroll.getParent().requestDisallowInterceptTouchEvent(false);
                                    break;
                            }
                            return false;
                        }
                    });
                }
            }
        });
        etInvestAccount.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                changeScrollView();
                return false;
            }
        });
        return view;
    }

    void changeScrollView() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                investScrollview.scrollTo(0, investScrollview.getHeight());
            }
        }, 100);
    }

    @Override
    public void showSuccessToast(String msg) {

    }

    @Override
    public void showErrorToast(String msg) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick({R.id.tv_mirror_plan, R.id.tv_pull, R.id.tv_use_quan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_mirror_plan:
                break;
            case R.id.tv_pull:
                ((ProductDetailActivity) getActivity()).pull();
                break;
            case R.id.tv_use_quan:
                startActivityForResult(new Intent(mContext, SelectQuanActivity.class), 0x00);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}

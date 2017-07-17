package com.haolyy.compliance.ui.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.haolyy.compliance.R;
import com.haolyy.compliance.adapter.ProductFundListAdapter;
import com.haolyy.compliance.adapter.ProductListAdapter;
import com.haolyy.compliance.base.BaseApplication;
import com.haolyy.compliance.base.BaseFragment;
import com.haolyy.compliance.config.Config;
import com.haolyy.compliance.custom.XListView;
import com.haolyy.compliance.entity.my.ProductFundList;
import com.haolyy.compliance.entity.product.ProductTitle;
import com.haolyy.compliance.ui.my.presenter.ProductFundPresenter;
import com.haolyy.compliance.ui.my.view.ProductFundView;
import com.haolyy.compliance.utils.LogUtils;
import com.haolyy.compliance.utils.UIUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by wangyin on 2017/5/18.
 */

public class ProductFundListFragment extends BaseFragment<ProductFundPresenter, ProductFundView> implements ProductFundView {
    @BindView(R.id.rg_title)
    RadioGroup group;
    Unbinder unbinder;
    @BindView(R.id.xlv_product_third)
    XListView xlvProductThird;

    @BindView(R.id.pro_list_top)
    LinearLayout proListTop;
    @BindView(R.id.iv_empty)
    ImageView ivEmpty;
    private View view;
    private ArrayList<String> thirdTitle;
    private ArrayList<String> orderStatus;
    private String secondCategoryId;
    private String firstCategoryId;
    private ProductFundList productFundList;
    private String projectNo;
    private String productName;
    private int pageNum = 1;
    private int pageSize;
    private int project_type;// 标的类型
    private String product_no;// 产品类型
    private String state;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        savedInstanceState = getArguments();
        thirdTitle = savedInstanceState.getStringArrayList("thirdTitle");
        orderStatus = savedInstanceState.getStringArrayList("orderStatus");
        secondCategoryId = savedInstanceState.getString("secondCategoryId");
        firstCategoryId = savedInstanceState.getString("firstCategoryId");
        LogUtils.e("thirdTitle", thirdTitle.toString());
        LogUtils.e("orderStatus", orderStatus.toString());
        LogUtils.e("secondCategoryId", secondCategoryId);
    }

    @Override
    protected ProductFundPresenter createPresenter() {
        return new ProductFundPresenter(mContext);
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.product_fund_list_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        init();

        xlvProductThird.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                projectNo = productList.getModel().getModel().getDataList().get(position - 1).getProjectNo();
//                productName = productList.getModel().getModel().getDataList().get(position - 1).getProjectName();
//                project_type = productList.getModel().getModel().getDataList().get(position - 1).getProjectType();
//                product_no = productList.getModel().getModel().getDataList().get(position - 1).getProductNo();
//                Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
//                intent.putExtra("projectNo", projectNo);
//                intent.putExtra("productName", productName);
//                intent.putExtra("project_type", project_type);
//                intent.putExtra("product_no", product_no);
//                intent.putExtra("flag", "product");
//                startActivity(intent);
            }
        });
        return view;
    }


    public static ProductFundListFragment newInstance(ArrayList<String> thirdTitle, String firstCategoryId,String secondCategoryId, ArrayList<String> orderStatus) {
        ProductFundListFragment contentFragment = new ProductFundListFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("thirdTitle", thirdTitle);
        bundle.putString("firstCategoryId", firstCategoryId);
        bundle.putString("secondCategoryId", secondCategoryId);
        bundle.putStringArrayList("orderStatus", orderStatus);
        contentFragment.setArguments(bundle);
        return contentFragment;
    }

    private void init() {
        if (thirdTitle.size() == 0) {
            proListTop.setVisibility(View.GONE);
        } else {
            //动态创建菜单
            for (int i = 0; i < thirdTitle.size(); i++) {
//                RadioButton tempButton = new RadioButton(mContext);

                RadioButton tempButton = (RadioButton) getActivity().getLayoutInflater().inflate(R.layout.radio_button, null);
//                Bitmap a = null;
//                tempButton.setButtonDrawable(new BitmapDrawable(a));
//                tempButton.setButtonDrawable(getResources().getDrawable(android.R.color.transparent));
//                tempButton.setPadding(UIUtils.dip2px(20), 0, 0, 0);                 // 设置文字距离按钮四周的距离
                tempButton.setText(thirdTitle.get(i));
                tempButton.setTextColor(getResources().getColorStateList(R.color.color_tv_selector_fund));
                group.addView(tempButton, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);

                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tempButton.getLayoutParams();
                layoutParams.leftMargin = UIUtils.dip2px(20);
                tempButton.setLayoutParams(layoutParams);
            }
            group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    pageNum = 1;
                    RadioButton tempButton = (RadioButton) group.findViewById(checkedId); // 通过RadioGroup的findViewById方法，找到ID为checkedID的RadioButton
                    // 以下就可以对这个RadioButton进行处理了

                    for (int i = 0; i < thirdTitle.size(); i++) {
                        if (tempButton.getText().toString().equals(thirdTitle.get(i))) {
                            state = orderStatus.get(i);
                            mPresenter.getAssetManagementList(false, BaseApplication.userId+"", Config.platform,Config.client,firstCategoryId,secondCategoryId,pageNum+"",state);
                        }
                    }


                }
            });

        }
        xlvProductThird.setXListViewListener(new MyListView());
        //获取一级菜单的数据
        mPresenter.getAssetManagementList(false, BaseApplication.userId+"", Config.platform,Config.client,firstCategoryId,secondCategoryId,pageNum+"","0");


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }




    @Override
    public void showGetMoreData(ProductFundList productFundList) {
        if (productFundList.getModel().getModel().getAssetManagementList().size() == 0) {
            pageNum = 1;
            UIUtils.showToastCommon(mContext, "没有更多数据了！");
            xlvProductThird.setPullLoadEnable(false);
        } else {
            this.productFundList.getModel().getModel().getAssetManagementList().addAll(productFundList.getModel().getModel().getAssetManagementList());
            xlvProductThird.setPullLoadEnable(true);
            xlvProductThird.setAdapter(new ProductListAdapter(this.productFundList.getModel().getModel().getAssetManagementList(), getActivity()));
            xlvProductThird.setSelection(this.productFundList.getModel().getModel().getAssetManagementList().size() - productFundList.getModel().getModel().getAssetManagementList().size());//定位
        }
    }

    @Override
    public void getTitle(ProductTitle productTitle) {

    }

    @Override
    public void showData(ProductFundList productFundList) {
        pageSize = productFundList.getModel().getModel().getAssetManagementList().size();

        LogUtils.e("pageSize",pageSize+"");
        this.productFundList = productFundList;
        if (pageSize == 0) {
            xlvProductThird.setPullLoadEnable(false);
            ivEmpty.setVisibility(View.VISIBLE);
            xlvProductThird.setVisibility(View.GONE);
        } else {
            if (pageSize < 10) {
                xlvProductThird.setPullLoadEnable(false);
            } else {
                xlvProductThird.setPullLoadEnable(true);
            }
            ivEmpty.setVisibility(View.GONE);
            xlvProductThird.setVisibility(View.VISIBLE);
            xlvProductThird.setAdapter(new ProductFundListAdapter(this.productFundList.getModel().getModel().getAssetManagementList(), getActivity()));
        }
    }

    private class MyListView implements XListView.IXListViewListener {
        @Override
        public void onRefresh() {
            pageNum = 1;
            mPresenter.getAssetManagementList(false, BaseApplication.userId+"", Config.platform,Config.client,firstCategoryId,secondCategoryId,pageNum+"",state);
        }

        @Override
        public void onLoadMore() {
            pageNum += 1;
            mPresenter.getAssetManagementList(true, BaseApplication.userId+"", Config.platform,Config.client,firstCategoryId,secondCategoryId,pageNum+"",state);
        }
    }
}

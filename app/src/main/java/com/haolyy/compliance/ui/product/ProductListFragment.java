package com.haolyy.compliance.ui.product;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.haolyy.compliance.R;
import com.haolyy.compliance.adapter.ProductListAdapter;
import com.haolyy.compliance.base.BaseFragment;
import com.haolyy.compliance.custom.XListView;
import com.haolyy.compliance.entity.product.ProductList;
import com.haolyy.compliance.ui.product.presenter.ProductListPresenter;
import com.haolyy.compliance.ui.product.view.ProductListView;
import com.haolyy.compliance.utils.LogUtils;
import com.haolyy.compliance.utils.UIUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by wangyin on 2017/5/18.
 */

public class ProductListFragment extends BaseFragment<ProductListPresenter, ProductListView> implements ProductListView {
    @BindView(R.id.rg_title)
    RadioGroup group;
    Unbinder unbinder;
    @BindView(R.id.xlv_product_third)
    XListView xlvProductThird;
    @BindView(R.id.rb_all)
    RadioButton rbAll;
    @BindView(R.id.pro_list_top)
    LinearLayout proListTop;
    private View view;
    private ArrayList<String> childTitle;
    private ArrayList<String> childNodeNo;//二级菜单的no
    private String parentNodeNo;
    private String flag;
    private ProductList productList;
    private int productId;
    private String productName;
    private int pageNum = 1;
    private int pageSize;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        savedInstanceState = getArguments();
        childTitle = savedInstanceState.getStringArrayList("childTitle");
        childNodeNo = savedInstanceState.getStringArrayList("childNodeNo");
        parentNodeNo = savedInstanceState.getString("parentNodeNo");
        LogUtils.e("childTitle", childTitle.toString());
        LogUtils.e("childNodeNo", childNodeNo.toString());
        LogUtils.e("parentNodeNo", parentNodeNo);
    }

    @Override
    protected ProductListPresenter createPresenter() {
        return new ProductListPresenter(mContext);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.product_list_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        init();

        xlvProductThird.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                productId = productList.getData().getData().getData_list().get(position - 1).getId();
                productName = productList.getData().getData().getData_list().get(position - 1).getProject_name();
                Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
                intent.putExtra("productId", productId);
                intent.putExtra("productName", productName);
                startActivity(intent);
            }
        });
        return view;
    }


    public static ProductListFragment newInstance(ArrayList<String> childTitle, String node_no, ArrayList<String> childNodeNo) {
        ProductListFragment contentFragment = new ProductListFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("childTitle", childTitle);
        bundle.putString("parentNodeNo", node_no);
        bundle.putStringArrayList("childNodeNo", childNodeNo);
        contentFragment.setArguments(bundle);
        return contentFragment;
    }

    private void init() {
        if (childTitle.size() == 0) {
            proListTop.setVisibility(View.GONE);
        } else {
            //动态创建菜单
            for (int i = 0; i < childTitle.size(); i++) {
                RadioButton tempButton = new RadioButton(mContext);
                Bitmap a = null;
                tempButton.setButtonDrawable(new BitmapDrawable(a));
                tempButton.setPadding(UIUtils.dip2px(20), 0, 0, 0);                 // 设置文字距离按钮四周的距离
                tempButton.setText(childTitle.get(i));
                tempButton.setTextColor(getResources().getColorStateList(R.color.color_tv_selector));
                group.addView(tempButton, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
            }
            group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {

                    RadioButton tempButton = (RadioButton) group.findViewById(checkedId); // 通过RadioGroup的findViewById方法，找到ID为checkedID的RadioButton
                    // 以下就可以对这个RadioButton进行处理了
                    if (tempButton.getText().toString().equals("全部")) {
                        flag = parentNodeNo;
                        mPresenter.getProductList(false, flag, pageNum + "");
                    }
                    for (int i = 0; i < childTitle.size(); i++) {
                        if (tempButton.getText().toString().equals(childTitle.get(i))) {
                            flag = childNodeNo.get(i);
                            mPresenter.getProductList(false, flag, pageNum + "");
                        }
                    }


                }
            });

        }
        xlvProductThird.setXListViewListener(new MyListView());
        //获取一级菜单的数据
        flag = parentNodeNo;
        mPresenter.getProductList(false, flag, pageNum + "");


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @Override
    public void showSuccessToast(String msg) {

    }

    @Override
    public void showErrorToast(String msg) {

    }

    @Override
    public void showData(ProductList productList) {
        pageSize = productList.getData().getData().getData_list().size();
        this.productList = productList;
        if (productList.getData().getData().getData_list().size() == 0) {
            xlvProductThird.setPullLoadEnable(false);
        } else {
            if (pageSize <= 10) {
                xlvProductThird.setPullLoadEnable(false);
            }
            xlvProductThird.setPullLoadEnable(true);
        }
        xlvProductThird.setAdapter(new ProductListAdapter(this.productList.getData().getData().getData_list(), getActivity()));
    }

    @Override
    public void showGetMoreData(ProductList productList) {
        this.productList.getData().getData().getData_list().addAll(productList.getData().getData().getData_list());
        if (productList.getData().getData().getData_list().size() == 0) {
            UIUtils.showToastCommon(mContext, "没有更多数据了！");
            xlvProductThird.setPullLoadEnable(false);
        } else {
            xlvProductThird.setPullLoadEnable(true);
            xlvProductThird.setAdapter(new ProductListAdapter(this.productList.getData().getData().getData_list(), getActivity()));
            xlvProductThird.setSelection(this.productList.getData().getData().getData_list().size() - productList.getData().getData().getData_list().size());//定位
        }
    }

    private class MyListView implements XListView.IXListViewListener {
        @Override
        public void onRefresh() {
            LogUtils.e("flag", flag);
            pageNum = 1;
            mPresenter.getProductList(false, flag, pageNum + "");
        }

        @Override
        public void onLoadMore() {
            pageNum += 1;
            mPresenter.getProductList(true, flag, pageNum + "");
            LogUtils.e("pageNum", productList.getData().getData().getData_list().size() + "");

        }
    }
}

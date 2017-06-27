package com.haolyy.compliance.ui.product;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.haolyy.compliance.R;
import com.haolyy.compliance.adapter.ProductListAdapter;
import com.haolyy.compliance.base.BaseFragment;
import com.haolyy.compliance.custom.XListView;
import com.haolyy.compliance.entity.ProductList;
import com.haolyy.compliance.entity.TestProduct;
import com.haolyy.compliance.ui.product.presenter.ProductPresenter;
import com.haolyy.compliance.ui.product.view.ProductView;
import com.haolyy.compliance.utils.LogUtils;
import com.haolyy.compliance.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by wangyin on 2017/5/18.
 */

public class ProductListFragment extends BaseFragment<ProductPresenter, ProductView> implements ProductView {


    @BindView(R.id.rg_title)
    RadioGroup group;
    Unbinder unbinder;
    @BindView(R.id.xlv_product_third)
    XListView xlvProductThird;
    @BindView(R.id.rb_all)
    RadioButton rbAll;

    private View view;

    private List<TestProduct> testProducts;
    private ProductListAdapter productListAdapter;
    private ArrayList<String> mArgument;
    private String node_no;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        savedInstanceState = getArguments();
        mArgument = savedInstanceState.getStringArrayList("argument");
        node_no = savedInstanceState.getString("node_no");
        LogUtils.e("argument", mArgument.toString());
        LogUtils.e("node_no", node_no);
    }

    @Override
    protected ProductPresenter createPresenter() {
        return new ProductPresenter(mContext);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.product_list_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        init();
        return view;
    }


    public static ProductListFragment newInstance(ArrayList<String> argument,String node_no) {
        ProductListFragment contentFragment = new ProductListFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("argument", argument);
        bundle.putString("node_no",node_no);
        contentFragment.setArguments(bundle);
        return contentFragment;
    }

    private void init() {

        for (int i = 0; i < mArgument.size(); i++) {
            RadioButton tempButton = new RadioButton(mContext);
            Bitmap a = null;
            tempButton.setButtonDrawable(new BitmapDrawable(a));
            tempButton.setPadding(UIUtils.dip2px(20), 0, 0, 0);                 // 设置文字距离按钮四周的距离
            tempButton.setText(mArgument.get(i));
            tempButton.setTextColor(getResources().getColorStateList(R.color.color_tv_selector));
            group.addView(tempButton, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
        }
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton tempButton = (RadioButton) group.findViewById(checkedId); // 通过RadioGroup的findViewById方法，找到ID为checkedID的RadioButton
                // 以下就可以对这个RadioButton进行处理了
                Toast.makeText(mContext, tempButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });


        xlvProductThird.setXListViewListener(new MyListView());
        testProducts = new ArrayList<>();
        mPresenter.getProductList(node_no, "", "", "", "1", "1");



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
            LogUtils.e("ProductListFragment",productList.getData().getData().getData_list().toString());

//        for (int i = 1; i < 10; i++) {
//            TestProduct testProduct = new TestProduct(1 + i, 10 + i, i, 100 * i, 1000 * i);
//            testProducts.add(testProduct);
//        }
        productListAdapter = new ProductListAdapter(productList.getData().getData().getData_list(), getActivity());
        xlvProductThird.setAdapter(productListAdapter);
    }

    private class MyListView implements XListView.IXListViewListener {
        @Override
        public void onRefresh() {
            productListAdapter.notifyDataSetChanged();

        }

        @Override
        public void onLoadMore() {


        }
    }
}

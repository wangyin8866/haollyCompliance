package com.haolyy.compliance.ui.product;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.haolyy.compliance.R;
import com.haolyy.compliance.adapter.ProductFirstAdapter;
import com.haolyy.compliance.custom.XListView;
import com.haolyy.compliance.entity.TestProduct;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by wangyin on 2017/5/18.
 */

public class ProductThirdFragment extends Fragment implements View.OnClickListener {
    @BindView(R.id.third_tv1)
    TextView thirdTv1;
    @BindView(R.id.third_tv2)
    TextView thirdTv2;
    @BindView(R.id.third_tv3)
    TextView thirdTv3;
    @BindView(R.id.third_tv4)
    TextView thirdTv4;
    @BindView(R.id.third_tv5)
    TextView thirdTv5;

    Unbinder unbinder;
    @BindView(R.id.xlv_product_third)
    XListView xlvProductThird;
    private View view;

    private int currentPage = 0;
    private List<TestProduct> testProducts;
    private ProductFirstAdapter productFirstAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.product_third_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        init();
        setTabSelection(currentPage);
        return view;
    }

    private void init() {
        Bundle bundle=getArguments();
        thirdTv2.setText(bundle.getString("suanbiao1"));
        thirdTv3.setText(bundle.getString("suanbiao2"));
        thirdTv4.setText(bundle.getString("suanbiao3"));
        thirdTv5.setText(bundle.getString("suanbiao4"));
        thirdTv1.setOnClickListener(this);
        thirdTv2.setOnClickListener(this);
        thirdTv3.setOnClickListener(this);
        thirdTv4.setOnClickListener(this);
        thirdTv5.setOnClickListener(this);
        xlvProductThird.setXListViewListener(new MyListView());
        testProducts = new ArrayList<>();

        for (int i=1;i<10;i++) {
            TestProduct testProduct = new TestProduct(1 + i, 10 + i, i, 100 * i, 1000 * i);
            testProducts.add(testProduct);
        }
        productFirstAdapter=new ProductFirstAdapter(testProducts,getActivity());
        xlvProductThird.setAdapter(productFirstAdapter);



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.third_tv1:
                currentPage = 0;
                setTabSelection(currentPage);
                break;
            case R.id.third_tv2:
                currentPage = 1;
                setTabSelection(currentPage);
                break;
            case R.id.third_tv3:
                currentPage = 2;
                setTabSelection(currentPage);
                break;
            case R.id.third_tv4:
                currentPage = 3;
                setTabSelection(currentPage);
                break;
            case R.id.third_tv5:
                currentPage = 4;
                setTabSelection(currentPage);
                break;

        }
    }

    private void setTabSelection(int currentPage) {
        //选中前清除状态
        restView();
        switch (currentPage) {
            case 0:
                thirdTv1.setTextColor(Color.parseColor("#FF9933"));
                break;
            case 1:
                thirdTv2.setTextColor(Color.parseColor("#FF9933"));
                break;
            case 2:
                thirdTv3.setTextColor(Color.parseColor("#FF9933"));
                break;
            case 3:
                thirdTv4.setTextColor(Color.parseColor("#FF9933"));
                break;
            case 4:
                thirdTv5.setTextColor(Color.parseColor("#FF9933"));
                break;
        }
    }

    private void restView() {
        thirdTv1.setTextColor(Color.parseColor("#4A4A4A"));
        thirdTv2.setTextColor(Color.parseColor("#4A4A4A"));
        thirdTv3.setTextColor(Color.parseColor("#4A4A4A"));
        thirdTv4.setTextColor(Color.parseColor("#4A4A4A"));
        thirdTv5.setTextColor(Color.parseColor("#4A4A4A"));
    }
    private class MyListView implements XListView.IXListViewListener {
        @Override
        public void onRefresh() {
            productFirstAdapter.notifyDataSetChanged();

        }

        @Override
        public void onLoadMore() {


        }
    }
}

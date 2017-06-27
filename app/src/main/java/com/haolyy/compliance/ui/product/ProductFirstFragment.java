package com.haolyy.compliance.ui.product;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.haolyy.compliance.R;
import com.haolyy.compliance.adapter.ProductListAdapter;
import com.haolyy.compliance.base.BaseFragment;
import com.haolyy.compliance.custom.XListView;
import com.haolyy.compliance.entity.ProductList;
import com.haolyy.compliance.entity.TestProduct;
import com.haolyy.compliance.ui.product.presenter.ProductPresenter;
import com.haolyy.compliance.ui.product.view.ProductView;
import com.haolyy.compliance.utils.AppToast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangyin on 2017/5/18.
 */

public class ProductFirstFragment extends BaseFragment<ProductPresenter, ProductView> implements ProductView {
    private XListView firstXlv;
    private View view;
    private List<TestProduct> testProducts;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.product_first_main, container, false);
        firstXlv = (XListView) view.findViewById(R.id.first_xlv);
        firstXlv.setPullLoadEnable(true);
        firstXlv.setXListViewListener(new MyListView());

        testProducts = new ArrayList<>();
        for (int i=1;i<10;i++) {
            TestProduct testProduct = new TestProduct(1 + i, 10 + i, i, 100 * i, 1000 * i);
            testProducts.add(testProduct);
        }

        firstXlv.setAdapter(new ProductListAdapter(testProducts,getActivity()));


        return view;
    }

    @Override
    protected ProductPresenter createPresenter() {
        return new ProductPresenter(mContext);
    }

    @Override
    public void showSuccessToast(String msg) {

    }

    @Override
    public void showErrorToast(String msg) {
        AppToast.showShortText(mContext, msg);
    }


    @Override
    public void showData(ProductList productList) {

    }

    private class MyListView implements XListView.IXListViewListener {
        @Override
        public void onRefresh() {


        }

        @Override
        public void onLoadMore() {


        }
    }

}

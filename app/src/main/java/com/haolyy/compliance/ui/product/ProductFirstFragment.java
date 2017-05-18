package com.haolyy.compliance.ui.product;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.haolyy.compliance.R;
import com.haolyy.compliance.adapter.ProductFirstAdapter;
import com.haolyy.compliance.base.BaseFragment;
import com.haolyy.compliance.custom.XListView;
import com.haolyy.compliance.entity.TestProduct;
import com.haolyy.compliance.ui.product.presenter.ProductFirstPresenter;
import com.haolyy.compliance.ui.product.view.ProductFirstView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by wangyin on 2017/5/18.
 */

public class ProductFirstFragment extends BaseFragment<ProductFirstPresenter, ProductFirstView> implements ProductFirstView {
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

        firstXlv.setAdapter(new ProductFirstAdapter(getActivity(),testProducts));


        return view;
    }

    @Override
    public void showData() {

    }

    @Override
    protected ProductFirstPresenter createPresenter() {
        return new ProductFirstPresenter(mContext);
    }
    private class MyListView implements XListView.IXListViewListener {
        @Override
        public void onRefresh() {

            onLoad();
        }

        @Override
        public void onLoadMore() {

            onLoad();
        }
    }
    private void onLoad() {
        firstXlv.stopRefresh();
        firstXlv.stopLoadMore();
        firstXlv.setRefreshTime(new SimpleDateFormat("HH:mm:ss", Locale.CHINA).format(new Date()));
    }
}

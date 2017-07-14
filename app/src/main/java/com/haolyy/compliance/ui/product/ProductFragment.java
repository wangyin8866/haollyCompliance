package com.haolyy.compliance.ui.product;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.haolyy.compliance.R;
import com.haolyy.compliance.adapter.TabAdapter;
import com.haolyy.compliance.base.BaseFragment;
import com.haolyy.compliance.entity.product.ProductTitle;
import com.haolyy.compliance.ui.product.presenter.ProductPresenter;
import com.haolyy.compliance.ui.product.view.ProductView;
import com.haolyy.compliance.utils.WYUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by wangyin on 2017/5/16.
 */

public class ProductFragment extends BaseFragment<ProductPresenter, ProductView> implements ProductView {
    @BindView(R.id.product_title)
    TabLayout productTitle;
    @BindView(R.id.vp_product_list)
    ViewPager vpProductList;
    Unbinder unbinder;
    private View view;
    private List<Fragment> mDatas;
    private ProductListFragment thirdFragment;
    private List<String> parentTitles;//一级菜单的title
    private String parentNodeNo;//一级菜单的no
    private ArrayList<String> childTitle;//二级菜单的title
    private ArrayList<String> childNodeNo;//二级菜单的no

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.product_main, container, false);
        unbinder = ButterKnife.bind(this, view);


        return view;
    }


    /**
     * 懒加载
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            //获取菜单列表
            mPresenter.getTitle();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @Override
    protected ProductPresenter createPresenter() {
        return new ProductPresenter(mContext);
    }

    @Override
    public void showData(ProductTitle productList) {
        mDatas = new ArrayList<>();
        parentTitles = new ArrayList<>();
        for (int i = 0; i < productList.getModel().getModel().getTitle_list().size(); i++) {
            parentTitles.add(productList.getModel().getModel().getTitle_list().get(i).get(0).getCategory_name());
            parentNodeNo=productList.getModel().getModel().getTitle_list().get(i).get(0).getNode_no();
            childTitle = new ArrayList<>();
            childNodeNo = new ArrayList<>();
            for (int j = 1; j < productList.getModel().getModel().getTitle_list().get(i).size(); j++) {

                childTitle.add(productList.getModel().getModel().getTitle_list().get(i).get(j).getCategory_name());
                childNodeNo.add(productList.getModel().getModel().getTitle_list().get(i).get(j).getNode_no());
            }
            thirdFragment = ProductListFragment.newInstance(childTitle, parentNodeNo, childNodeNo);
            mDatas.add(thirdFragment);
        }
        vpProductList.setAdapter(new TabAdapter(getFragmentManager(), mDatas, parentTitles));
        vpProductList.setOffscreenPageLimit(productList.getModel().getModel().getTitle_list().size());
        productTitle.setupWithViewPager(vpProductList);

        WYUtils.setIndicator(mContext, productTitle, 10, 10);

    }




    @Override
    public void showSuccessToast(String msg) {

    }

    @Override
    public void showErrorToast(String msg) {

    }


}

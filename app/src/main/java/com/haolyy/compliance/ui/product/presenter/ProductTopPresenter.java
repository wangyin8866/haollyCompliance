package com.haolyy.compliance.ui.product.presenter;

import android.content.Context;

import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.entity.product.ProductBaseDetail;
import com.haolyy.compliance.model.ProductModel;
import com.haolyy.compliance.model.UserModel;
import com.haolyy.compliance.ui.product.view.ProductTopView;
import com.xfqz.xjd.mylibrary.ProgressSubscriber;
import com.xfqz.xjd.mylibrary.SubscriberOnNextListener;

/**
 * Created by wangyin on 2017/6/28.
 */

public class ProductTopPresenter extends BasePresenter<ProductTopView>{

    public ProductTopPresenter(Context context) {
        super(context);
    }
    public void getBaseDetail(String project_no, String juid){
        invoke(ProductModel.getInstance().getBaseDetail(project_no,juid),new ProgressSubscriber<ProductBaseDetail>(new SubscriberOnNextListener<ProductBaseDetail>() {
            @Override
            public void onNext(ProductBaseDetail s) {
                if (s.getStatus().equals("200")) {
                    if (s.getData().getStatus().equals("200")) {
                            getView().showData(s);
                    } else {
                        getView().showErrorToast(s.getData().getMsg());
                    }
                } else {
                    getView().showErrorToast(s.getMsg());
                }
            }

            @Override
            public void onError(Throwable e) {

            }
        },mContext));
    }

    /**
     * 查询用户状态
     */
    public void selectUserState(String mobile,String platform){
        invoke(UserModel.getInstance().selectUserState(mobile,platform),new ProgressSubscriber<String >(new SubscriberOnNextListener<String>() {
            @Override
            public void onNext(String s) {

            }
            @Override
            public void onError(Throwable e) {

            }
        },mContext));
    }
}

package com.haolyy.compliance.ui.product.presenter;

import android.content.Context;

import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.entity.BaseResponseBean;
import com.haolyy.compliance.entity.product.ProductBaseDetail;
import com.haolyy.compliance.model.ProductModel;
import com.haolyy.compliance.model.UserModel;
import com.haolyy.compliance.ui.product.view.ProductTopView;
import com.haolyy.compliance.utils.LogUtils;
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
    public void selectUserState(){
        invoke(UserModel.getInstance().findUserStatus(),new ProgressSubscriber<BaseResponseBean>(new SubscriberOnNextListener<BaseResponseBean>() {
            @Override
            public void onNext(BaseResponseBean baseResponseBean) {
                LogUtils.e("selectUserState", baseResponseBean.toString());
            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e("selectUserState", e.getMessage());
            }
        },mContext));
    }
}

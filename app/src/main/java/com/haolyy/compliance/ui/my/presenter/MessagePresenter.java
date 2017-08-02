package com.haolyy.compliance.ui.my.presenter;

import android.content.Context;

import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.entity.my.MessageBean;
import com.haolyy.compliance.model.MyModel;
import com.haolyy.compliance.ui.my.view.MessageView;
import com.haolyy.compliance.utils.UIUtils;
import com.xfqz.xjd.mylibrary.ProgressSubscriber;
import com.xfqz.xjd.mylibrary.SubscriberOnNextListener;

/**
 * Created by wangyin on 2017/8/2.
 */

public class MessagePresenter extends BasePresenter<MessageView>{
    public MessagePresenter(Context context) {
        super(context);
    }
    public void getMessage(String page_index){
        invoke(MyModel.getInstance().getMessage(page_index),new ProgressSubscriber<MessageBean>(new SubscriberOnNextListener<MessageBean>() {
            @Override
            public void onNext(MessageBean messageBean) {
                if (messageBean.getCode().equals("200")) {
                    if (messageBean.getModel().getCode().equals("200")) {
                            getView().showData(messageBean);
                    } else {
                        UIUtils.showToastCommon(mContext,messageBean.getModel().getMsg());
                    }
                } else {
                    UIUtils.showToastCommon(mContext,messageBean.getMsg());
                }
            }

            @Override
            public void onError(Throwable e) {

            }
        },mContext));
    }
}

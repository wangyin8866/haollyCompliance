package com.haolyy.compliance.ui.my.presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.haolyy.compliance.base.BaseBean;
import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.entity.my.MessageBean;
import com.haolyy.compliance.model.MyModel;
import com.haolyy.compliance.swipe.SwipeMenuAdapter;
import com.haolyy.compliance.ui.my.MessageDetail;
import com.haolyy.compliance.ui.my.view.MessageView;
import com.haolyy.compliance.utils.UIUtils;
import com.xfqz.xjd.mylibrary.ProgressSubscriber;
import com.xfqz.xjd.mylibrary.SubscriberOnNextListener;

import rx.Subscriber;

/**
 * Created by wangyin on 2017/8/2.
 */

public class MessagePresenter extends BasePresenter<MessageView> {
    public MessagePresenter(Context context) {
        super(context);
    }

    public void getMessage(String page_index , final boolean isLoadMore) {
        invoke(MyModel.getInstance().getMessage(page_index), new ProgressSubscriber<MessageBean>(new SubscriberOnNextListener<MessageBean>() {
            @Override
            public void onNext(MessageBean messageBean) {
                if (messageBean.getCode().equals("200")) {
                    if (messageBean.getModel().getCode().equals("200")) {
                        if (isLoadMore) {
                            getView().showGetMoreData(messageBean);
                        } else {
                        getView().showData(messageBean);
                        }
                    } else {
                        UIUtils.showToastCommon(mContext, messageBean.getModel().getMsg());
                    }
                } else {
                    UIUtils.showToastCommon(mContext, messageBean.getMsg());
                }
            }

            @Override
            public void onError(Throwable e) {

            }
        }, mContext));
    }

    /**
     * 设置已读
     *
     * @param id
     * @param status
     * @param accountMessagesBean
     */
    public void modificationStatus(int id, int status, final MessageBean.ModelBeanX.ModelBean.AccountMessagesBean accountMessagesBean) {
        invoke(MyModel.getInstance().modificationStatus(id, status), new Subscriber<BaseBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseBean baseBean) {
                if (baseBean.getCode().equals("200")) {
                    Intent intent = new Intent(mContext, MessageDetail.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("message", accountMessagesBean);
                    intent.putExtras(bundle);
                    mContext.startActivity(intent);
                }
            }
        });
    }

    /**
     * 删除
     *
     * @param status
     */
    public void deleteMessage(final int pos, int id, int status, final SwipeMenuAdapter mDataAdapter) {
        invoke(MyModel.getInstance().modificationStatus(id, status), new Subscriber<BaseBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseBean baseBean) {
                if (baseBean.getCode().equals("200")) {
                    //RecyclerView关于notifyItemRemoved的那点小事 参考：http://blog.csdn.net/jdsjlzx/article/details/52131528
                    mDataAdapter.getDataList().remove(pos);
                    mDataAdapter.notifyItemRemoved(pos);//推荐用这个

                    if (pos != (mDataAdapter.getDataList().size())) { // 如果移除的是最后一个，忽略 注意：这里的mDataAdapter.getDataList()不需要-1，因为上面已经-1了
                        mDataAdapter.notifyItemRangeChanged(pos, mDataAdapter.getDataList().size() - pos);
                    }
                }
            }
        });
    }
}

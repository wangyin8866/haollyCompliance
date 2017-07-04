package com.haolyy.compliance.base;

import android.content.Context;

import com.haolyy.compliance.entity.BaseResponseBean;
import com.haolyy.compliance.model.BaseModel;
import com.haolyy.compliance.model.UserModel;
import com.haolyy.compliance.utils.LogUtils;
import com.xfqz.xjd.mylibrary.ProgressSubscriber;
import com.xfqz.xjd.mylibrary.SubscriberOnNextListener;

import java.lang.ref.WeakReference;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by wy on 2016/9/2.
 */
public abstract class BasePresenter<T> {

    //弱引用,有效防止view内存泄漏
    private WeakReference<T> mViewRef;
    protected Context mContext;
    public String tag = this.getClass().getSimpleName();
    public LifeSubscription lifeSubscription;
    public void setLifeSubscription(LifeSubscription lifeSubscription) {
        this.lifeSubscription = lifeSubscription;
    }
    protected <T> void invoke(Observable<T> observable, Subscriber<T> subscriber) {
        BaseModel.invoke(lifeSubscription, observable, subscriber);
    }
    public BasePresenter() {
        super();
    }

    public BasePresenter(Context context) {
        this.mContext = context;
    }

    //关联
    void attach(T view) {
        mViewRef = new WeakReference<T>(view);

    }

    //解除关联
    void detach() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }
    public T getView() {
        return mViewRef.get();
    }



    /**
     * 查询用户状态
     */
    public void selectUserState(){

        invoke(UserModel.getInstance().findUserStatus(),new ProgressSubscriber<BaseResponseBean>(new SubscriberOnNextListener<BaseResponseBean>() {
            @Override
            public void onNext(BaseResponseBean baseResponseBean) {
                LogUtils.e("selectUserState", baseResponseBean.toString());
                overwriteSelectUserState(baseResponseBean);
            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e("selectUserState", e.getMessage());
            }
        },mContext));
    }

    public void overwriteSelectUserState(BaseResponseBean baseResponseBean){

    }
}

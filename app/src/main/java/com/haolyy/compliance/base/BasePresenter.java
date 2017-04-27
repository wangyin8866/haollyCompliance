package com.haolyy.compliance.base;

import android.content.Context;
import android.util.Log;


import java.lang.ref.WeakReference;

/**
 * Created by wy on 2016/9/2.
 */
public abstract class BasePresenter<T>  {

    //弱引用,有效防止view内存泄漏
    private WeakReference<T> mViewRef;
    protected Context mContext;
    public String tag = this.getClass().getSimpleName();


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

    public void getToken(final int type){
        Log.e(tag,"发送了了1001");
        RxBus.getInstance().post(1001);
      /* UserModel.getInstance().getToken(BaseApplication.userId+"", new Subscriber<TokenResponseBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(TokenResponseBean tokenResponseBean) {
                //失败退出登录
                //成功通知重新发起请求
                RxBus.getInstance().post(type);
            }
        });*/

    }
}

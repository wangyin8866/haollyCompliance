package com.haolyy.compliance.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;


public abstract class BaseFragment<T extends BasePresenter<V>, V> extends Fragment{
    protected T mPresenter;
    protected String tag;
    protected Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
        mPresenter = createPresenter();
        mPresenter.attach((V) this);
        tag = getClass().getSimpleName();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detach();
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    protected abstract T createPresenter();

}


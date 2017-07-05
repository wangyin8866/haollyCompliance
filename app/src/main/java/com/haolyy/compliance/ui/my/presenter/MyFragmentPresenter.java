package com.haolyy.compliance.ui.my.presenter;

import android.content.Context;

import com.haolyy.compliance.base.BasePresenter;
import com.haolyy.compliance.entity.BaseResponseBean;
import com.haolyy.compliance.model.UserModel;
import com.haolyy.compliance.ui.my.view.MyFragmentView;
import com.haolyy.compliance.utils.LogUtils;
import com.xfqz.xjd.mylibrary.ProgressSubscriber;
import com.xfqz.xjd.mylibrary.SubscriberOnNextListener;

/**
 * Created by niudeyang on 2017/5/24.
 */

public class MyFragmentPresenter extends BasePresenter<MyFragmentView> {
    public MyFragmentPresenter(Context context) {
        super(context);
    }

    @Override
    public void selectUserState() {
        super.selectUserState();
    }

    @Override
    public void overwriteSelectUserState(BaseResponseBean baseResponseBean) {
        super.overwriteSelectUserState(baseResponseBean);
        LogUtils.e(tag,"调用复写的方法");
    }
}

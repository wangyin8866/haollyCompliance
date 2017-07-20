package com.haolyy.compliance.utils;

import android.text.TextUtils;
import android.util.Log;

import com.haolyy.compliance.base.BaseApplication;
import com.haolyy.compliance.entity.LoginOutBean;

import java.io.IOException;
import java.util.Locale;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.ResponseBody;

/**
 * 采集okhttp3client的日志
 * Created by NIUDEYANG on 2016/11/18.
 */

public class LogInterceptor implements Interceptor {
    String TAG = "ndy";
    private String content;

    @Override
    public okhttp3.Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Log.e(TAG, "request:" + request.toString());
        long t1 = System.nanoTime();
        okhttp3.Response response = chain.proceed(chain.request());
        long t2 = System.nanoTime();
        //LogUtils.v(TAG, String.format(Locale.getDefault(), "Received response for %s in %.1fms%n%s", response.request().url(), (t2 - t1) / 1e6d, response.headers()));
        okhttp3.MediaType mediaType = response.body().contentType();
        ResponseBody originalBody = response.body();
        if (null != originalBody) {
            content = originalBody.string();
        }
        LogUtils.e(TAG, "response body:" + content);
        LoginOutBean loginOutBean = JsonUtils.toObject(content, LoginOutBean.class);
        if (null != loginOutBean.getModel()) {
            String code = loginOutBean.getModel().getCode();
            if (!TextUtils.isEmpty(code) && code.equals("2002")) {
                SPUtils.loginOut();
            }
        }
        return response.newBuilder()
                .body(okhttp3.ResponseBody.create(mediaType, content))
                .build();
    }
}
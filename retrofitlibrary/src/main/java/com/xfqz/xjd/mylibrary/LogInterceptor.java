package com.xfqz.xjd.mylibrary;

import android.util.Log;

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
        Log.v(TAG, String.format(Locale.getDefault(), "Received response for %s in %.1fms%n%s",
                response.request().url(), (t2 - t1) / 1e6d, response.headers()));
        okhttp3.MediaType mediaType = response.body().contentType();
        //String content = response.body().string();
        /**
         * 在调用了response.body().string()方法之后，response中的流会被关闭，
         * 我们需要创建出一个新的response给应用层处理通过response.peekBody()方法复制了一个ResponseBody，
         * 使用这个临时的ResponseBody来打印body的内容，而不是直接使用response.body().string()
         原文链接：http://www.jianshu.com/p/d836271b1ae4
         参考http://blog.csdn.net/it_talk/article/details/51734507
         著作权归作者所有，转载请联系作者获得授权，并标注“简书作者”。*/
        ResponseBody originalBody = response.body();
        // ResponseBody body = response.peekBody(originalBody.contentLength());
        if (null != originalBody) {
            content = originalBody.string();
        }
        Log.e(TAG, "response body:" + content);
        return response.newBuilder()
                .body(okhttp3.ResponseBody.create(mediaType, content))
                .build();
    }
}
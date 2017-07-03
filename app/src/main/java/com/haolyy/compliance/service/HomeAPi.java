package com.haolyy.compliance.service;

import com.haolyy.compliance.config.NetConstantValues;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by wangyin on 2017/6/29.
 */

public interface HomeAPi {
    @GET(NetConstantValues.HOME_BANNER)
    Observable<String> getBanner(@QueryMap Map<String,String> params);
    @FormUrlEncoded
    @POST(NetConstantValues.HOME_PRODUCT)
    Observable<String> getProduct(@FieldMap Map<String, String> params);
    @FormUrlEncoded
    @POST(NetConstantValues.HOME_ARTICLE)
    Observable<String> getArticle(@FieldMap Map<String, String> params);
    @FormUrlEncoded
    @POST(NetConstantValues.HOME_RECOMMEND)
    Observable<String> getRecommend(@FieldMap Map<String, String> params);
}

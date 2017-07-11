package com.haolyy.compliance.service;

import com.haolyy.compliance.config.NetConstantValues;
import com.haolyy.compliance.entity.home.Banner;
import com.haolyy.compliance.entity.home.HomeActivity;
import com.haolyy.compliance.entity.home.HomeArticle;
import com.haolyy.compliance.entity.home.HomeProduct;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by wangyin on 2017/6/29.
 */

public interface HomeAPi {
    @FormUrlEncoded
    @POST(NetConstantValues.HOME_BANNER)
    Observable<Banner> getBanner(@FieldMap Map<String, String> params);
    @FormUrlEncoded
    @POST(NetConstantValues.HOME_PRODUCT)
    Observable<HomeProduct> getProduct(@FieldMap Map<String, String> params);
    @FormUrlEncoded
    @POST(NetConstantValues.HOME_ARTICLE)
    Observable<HomeArticle> getArticle(@FieldMap Map<String, String> params);
    @FormUrlEncoded
    @POST(NetConstantValues.HOME_RECOMMEND)
    Observable<HomeActivity> getRecommend(@FieldMap Map<String, String> params);
}

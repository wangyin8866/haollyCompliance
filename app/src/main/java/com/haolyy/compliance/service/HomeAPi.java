package com.haolyy.compliance.service;

import com.haolyy.compliance.config.NetConstantValues;
import com.haolyy.compliance.entity.home.Banner;
import com.haolyy.compliance.entity.home.HomeActivity;
import com.haolyy.compliance.entity.home.HomeArticle;
import com.haolyy.compliance.entity.home.HomeProduct;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by wangyin on 2017/6/29.
 */

public interface HomeAPi {
    @GET(NetConstantValues.HOME_BANNER)
    Observable<Banner> getBanner(@QueryMap Map<String,String> params);

    @GET(NetConstantValues.HOME_PRODUCT)
    Observable<HomeProduct> getProduct();

    @GET(NetConstantValues.HOME_ARTICLE)
    Observable<HomeArticle> getArticle(@Query("platform") String platform);

    @GET(NetConstantValues.HOME_RECOMMEND)
    Observable<HomeActivity> getRecommend(@QueryMap Map<String, String> params);
}

package com.haolyy.compliance.service;

import com.haolyy.compliance.config.NetConstantValues;
import com.haolyy.compliance.entity.ProductList;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by wangyin on 2017/6/26.
 */

public interface ProductApi {
    @FormUrlEncoded
    @POST(NetConstantValues.PRODUCT_LIST)
    Observable<ProductList> getProductList(@FieldMap Map<String, String> params);
    @FormUrlEncoded
    @POST(NetConstantValues.PRODUCT_BASE_DETAIL)
    Observable<String > getBaseDetail(@FieldMap Map<String, String> params);
    @FormUrlEncoded
    @POST(NetConstantValues.PRODUCT_DETAIL)
    Observable<String > getDetail(@FieldMap Map<String, String> params);
}

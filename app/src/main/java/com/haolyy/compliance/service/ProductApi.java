package com.haolyy.compliance.service;

import com.haolyy.compliance.config.NetConstantValues;
import com.haolyy.compliance.entity.product.ProductBaseDetail;
import com.haolyy.compliance.entity.product.ProductList;
import com.haolyy.compliance.entity.product.ProductTitle;

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
    @POST(NetConstantValues.PRODUCT_TITLE_LIST)
    Observable<ProductTitle> getTitleList(@FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST(NetConstantValues.PRODUCT_LIST)
    Observable<ProductList> getProductList(@FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST(NetConstantValues.PRODUCT_BASE_DETAIL)
    Observable<ProductBaseDetail> getBaseDetail(@FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST(NetConstantValues.PRODUCT_DETAIL)
    Observable<String > getDetail(@FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST(NetConstantValues.INVESTMENT_RECORD)
    Observable<String > getInvestmentRecord(@FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST(NetConstantValues.PRODUCT_RETURN_PLAN)
    Observable<String > getProductReturnPlan(@FieldMap Map<String, String> params);
}

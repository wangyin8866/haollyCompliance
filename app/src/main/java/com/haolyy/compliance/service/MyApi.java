package com.haolyy.compliance.service;

import com.haolyy.compliance.config.NetConstantValues;
import com.haolyy.compliance.entity.my.MessageBean;
import com.haolyy.compliance.entity.my.ProductFund;
import com.haolyy.compliance.entity.my.ProductFundList;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by wangyin on 2017/7/15.
 */

public interface MyApi {
    @FormUrlEncoded
    @POST(NetConstantValues.PRODUCT_FUNDS)
    Observable<ProductFund> getProductFunds(@FieldMap Map<String, String> params);
    @FormUrlEncoded
    @POST(NetConstantValues.ASSET_MANAGMENT_LIST)
    Observable<ProductFundList> assetManagementList(@FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST(NetConstantValues.MESSAGE_LIST)
    Observable<MessageBean> getMessage(@FieldMap Map<String, String> params);
}

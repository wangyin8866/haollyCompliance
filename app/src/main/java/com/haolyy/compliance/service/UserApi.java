package com.haolyy.compliance.service;


import com.haolyy.compliance.config.NetConstantValues;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by DELL on 2017/1/6.
 */

public interface UserApi {

    @FormUrlEncoded
    @POST(NetConstantValues.user_login)
    Observable<String> login(@FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST(NetConstantValues.user_register)
    Observable<String> register(@FieldMap Map<String, String> params);

    //@Query("pageSize") int pageSize,
   // @Query("curPage") int curPage

    @GET(NetConstantValues.user_login)
    Observable<String> loginget(@Query("mobile") String mobile,
     @Query("passWord") String passWord);

    @FormUrlEncoded
    @POST(NetConstantValues.SMS_SENDSMSCODE)
    Observable<String> sendSms(@FieldMap Map<String, String> params);
}

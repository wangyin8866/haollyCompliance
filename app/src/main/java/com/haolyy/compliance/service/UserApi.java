package com.haolyy.compliance.service;


import com.haolyy.compliance.config.NetConstantValues;
import com.haolyy.compliance.entity.BaseResponseBean;
import com.haolyy.compliance.entity.login.CheckImageCode;
import com.haolyy.compliance.entity.login.LoginResponseBean;
import com.haolyy.compliance.entity.login.RegisterBean;
import com.haolyy.compliance.entity.login.SmsBean;

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
    Observable<LoginResponseBean> login(@FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST(NetConstantValues.user_register)
    Observable<RegisterBean> register(@FieldMap Map<String, String> params);

    @GET(NetConstantValues.user_login)
    Observable<String> loginget(@Query("mobile") String mobile,
     @Query("passWord") String passWord);

    @FormUrlEncoded
    @POST(NetConstantValues.SMS_SENDSMSCODE)
    Observable<SmsBean> sendSms(@FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST(NetConstantValues.IMAGE_CHECK)
    Observable<CheckImageCode> checkImage(@FieldMap Map<String, String> params);

}

package com.haolyy.compliance.service;


import com.haolyy.compliance.config.NetConstantValues;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by DELL on 2017/1/6.
 */

public interface UserApi {

    @FormUrlEncoded
    @POST(NetConstantValues.user_login)
    Observable<String> login(@FieldMap Map<String, String> params);
}

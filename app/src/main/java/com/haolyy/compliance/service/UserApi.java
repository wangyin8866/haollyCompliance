package com.haolyy.compliance.service;




import com.haolyy.compliance.config.NetConstantValues;
import com.haolyy.compliance.entity.login.UserInfoLogin;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by DELL on 2017/1/6.
 */

public interface UserApi {
    //绑卡
    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST(NetConstantValues.user_login)
    Observable<Object> login(@Body RequestBody requestBody);
}

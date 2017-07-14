package com.haolyy.compliance.service;


import com.haolyy.compliance.base.BaseBean;
import com.haolyy.compliance.config.NetConstantValues;
import com.haolyy.compliance.entity.TokenResponseBean;
import com.haolyy.compliance.entity.home.AccountSecurityBean;
import com.haolyy.compliance.entity.home.FundStatictisIncomeBean;
import com.haolyy.compliance.entity.home.UserInfoBean;
import com.haolyy.compliance.entity.login.CheckImageCode;
import com.haolyy.compliance.entity.login.FindUserStatusBean;
import com.haolyy.compliance.entity.login.LoginResponseBean;
import com.haolyy.compliance.ui.my.Bean.AssetRatioBean;
import com.haolyy.compliance.ui.my.Bean.DealRecordBean;

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
    Observable<BaseBean> register(@FieldMap Map<String, String> params);


    @FormUrlEncoded
    @POST(NetConstantValues.REQUEST_VALIDATE_CODE)
    Observable<BaseBean> requestValidateCode(@FieldMap Map<String, String> params);


    @GET(NetConstantValues.IMAGE_CHECK)
    Observable<CheckImageCode> sendTextSms(@Query("phone_num") String phone_num);

    @POST(NetConstantValues.GET_TOKEN)
    Observable<TokenResponseBean> getToken();




    @FormUrlEncoded
    @POST(NetConstantValues.USER_FORGETPWD)
    Observable<BaseBean> forgetPassWord(@FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST(NetConstantValues.USER_FINDSTATUS)
    Observable<FindUserStatusBean> findStatus(@FieldMap Map<String, String> map);


    @FormUrlEncoded
    @POST(NetConstantValues.USER_INFO)
    Observable<UserInfoBean> getUserInfo(@FieldMap Map<String, String> map);



    @FormUrlEncoded
    @POST(NetConstantValues.ACCOUNT_SECURITY_INFO)
    Observable<AccountSecurityBean>  getUserSecurityInfo(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST(NetConstantValues.ACCOUNT_INCOME_INFO)
    Observable<FundStatictisIncomeBean>  getUserIncomeInfo(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST(NetConstantValues.DEAL_RECORD_INFO)
    Observable<DealRecordBean>  getDealRecord(@FieldMap Map<String, String> map);




}

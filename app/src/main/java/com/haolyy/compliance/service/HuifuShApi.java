package com.haolyy.compliance.service;

import com.haolyy.compliance.config.NetConstantValues;
import com.haolyy.compliance.entity.BaseResponseBean;
import com.haolyy.compliance.entity.login.HuifuSmsBean;
import com.haolyy.compliance.entity.login.LoginResponseBean;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by niudeyang on 2017/6/21.
 */

public interface HuifuShApi {
    @FormUrlEncoded
    @POST(NetConstantValues.HUIFU_SMS_HUIFU)
    Observable<HuifuSmsBean> sendSms(@FieldMap Map<String, String> params);
    @FormUrlEncoded
    @POST(NetConstantValues.HUIFU_QUIK_BIND)
    Observable<BaseResponseBean> quikBind(@FieldMap Map<String, String> params);
    @FormUrlEncoded
    @POST(NetConstantValues.HUIFU_CORP_REGISTER)
    Observable<BaseResponseBean> corpRegister(@FieldMap Map<String, String> params);
    @FormUrlEncoded
    @POST(NetConstantValues.HUIFU_REGISTER)
    Observable<String> register(@FieldMap Map<String, String> params);
    @FormUrlEncoded
    @POST(NetConstantValues.HUIFU_RECHARGE)
    Observable<BaseResponseBean> recharge(@FieldMap Map<String, String> params);
}

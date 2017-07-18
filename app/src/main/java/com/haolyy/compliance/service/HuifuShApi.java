package com.haolyy.compliance.service;

import com.haolyy.compliance.config.NetConstantValues;
import com.haolyy.compliance.entity.BaseResponseBean;
import com.haolyy.compliance.entity.bank.ActivateBean;
import com.haolyy.compliance.entity.bank.IsActivateBean;
import com.haolyy.compliance.entity.bank.OldUserBean;
import com.haolyy.compliance.entity.bank.RechargeBean;
import com.haolyy.compliance.entity.bank.ToRegisterBean;
import com.haolyy.compliance.entity.bank.WithDrawBean;
import com.haolyy.compliance.entity.bank.WithDrawFee;
import com.haolyy.compliance.entity.login.HuifuSmsBean;
import com.haolyy.compliance.entity.login.UserBaseInfoBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by niudeyang on 2017/6/21.
 */

public interface HuifuShApi {
    /**
     * 短信
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST(NetConstantValues.HUIFU_SMS_HUIFU)
    Observable<HuifuSmsBean> sendSms(@FieldMap Map<String, String> params);

    /**
     * 绑卡
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST(NetConstantValues.HUIFU_QUIK_BIND)
    Observable<BaseResponseBean> quikBind(@FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST(NetConstantValues.HUIFU_CORP_REGISTER)
    Observable<BaseResponseBean> corpRegister(@FieldMap Map<String, String> params);

    /**
     * 开户
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST(NetConstantValues.HUIFU_REGISTER)
    Observable<ToRegisterBean> register(@FieldMap Map<String, String> params);
    /**
     * 激活
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST(NetConstantValues.HUIFU_ACTIVATE)
    Observable<ActivateBean> activate(@FieldMap Map<String, String> params);
    /**
     * 测试
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST(NetConstantValues.HUIFU_REGISTER)
    Observable<String> register2(@FieldMap Map<String, String> params);

    /**
     * 充值
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST(NetConstantValues.HUIFU_RECHARGE)
    Observable<RechargeBean> recharge(@FieldMap Map<String, String> params);
    /**
     * 提现
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST(NetConstantValues.HUIFU_WITHDRAW)
    Observable<WithDrawBean> withDraw(@FieldMap Map<String, String> params);

    /**
     * 判断是否激活
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST(NetConstantValues.P2P_ISBOSACCTACTIVATE)
    Observable<IsActivateBean> isBosAcctActivate(@FieldMap Map<String, String> params);
    /**
     * 其他品台开户，好利load数据
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST(NetConstantValues.P2P_VALIDATEOLDUSER)
    Observable<OldUserBean> validateolduser(@FieldMap Map<String, String> params);

    /**计算提现手续费
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST(NetConstantValues.P2P_CALCULATEFEEAMOUNT)
    Observable<WithDrawFee> calculatefeeamount(@FieldMap Map<String, String> params);

    /**用户银行卡信息以及资金
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST(NetConstantValues.P2P_USERBASEINFO)
    Observable<UserBaseInfoBean> getUserBaseInfo(@FieldMap Map<String, String> params);
}

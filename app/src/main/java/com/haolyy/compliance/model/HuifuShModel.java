package com.haolyy.compliance.model;

import com.haolyy.compliance.base.BaseApplication;
import com.haolyy.compliance.config.NetConstantValues;
import com.haolyy.compliance.entity.BaseResponseBean;
import com.haolyy.compliance.entity.bank.ActivateBean;
import com.haolyy.compliance.entity.bank.IsActivateBean;
import com.haolyy.compliance.entity.bank.RechargeBean;
import com.haolyy.compliance.entity.bank.ToRegisterBean;
import com.haolyy.compliance.entity.login.HuifuSmsBean;
import com.haolyy.compliance.service.HuifuShApi;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by LL on 2017/1/7.
 */

public class HuifuShModel extends BaseModel {
    private HuifuShApi huifuShApi;
    private static HuifuShModel userModel;

    private HuifuShModel() {
        super();
        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(NetConstantValues.HOST_URL4)
                .build();
        huifuShApi = retrofit.create(HuifuShApi.class);
    }

    public static HuifuShModel getInstance() {
        if (userModel == null) {
            synchronized (HuifuShModel.class) {
                if (userModel == null) {
                    userModel = new HuifuShModel();
                }
            }
        }
        return userModel;
    }
    /**
     * @param busi_type_   开户：user_register，充值：recharge，换卡：rebind
     * @param card_number_ 除了业务类型是recharge以外，都必传
     * @param user_cust_id_ 用户账户手机号，开户以外必传
     * @param mer_id_      卓投传1，好利网传2
     * @param mobile_      银行卡号对应的银行预留手机号
     * @param sms_type_    O-原手机号发送短信，N-新手机号。只有busi_type_为rebind时才必输
     * @return
     */
    public Observable<HuifuSmsBean> sendSms(String busi_type_, String card_number_, String user_cust_id_, String mer_id_, String mobile_, String sms_type_,String client_) {
        map.clear();
        map.put("busi_type_", busi_type_);
        map.put("card_number_", card_number_);
        map.put("user_cust_id_", user_cust_id_);
        map.put("mer_id_", mer_id_);
        map.put("mobile_", mobile_);
        map.put("sms_type_", sms_type_);
        map.put("client_", client_);
        return huifuShApi.sendSms(map);
    }
    /**
     * @param mer_id_       商户ID
     * @param user_cust_id_ 用户客户号
     * @param trade_type_   交易类型
     * @param bank_code_    银行简称
     * @param card_number_  银行卡号
     * @param mobile_       新绑定银行卡卡号对应的银行预留手机号
     * @param sms_code_     新绑定银行预留手机号发送的短信验证码
     * @param sms_seq_      新绑定银行预留手机号请求短信验证码接口时，返回的短信序号
     * @param ordsms_ext_   原绑定卡预留手机号发送的短信验证码+短信序号
     * @return
     */
    public Observable<BaseResponseBean> quikBind(String user_cust_id_, String trade_type_, String bank_code_, String card_number_,
                                                 String mobile_, String sms_code_, String sms_seq_, String ordsms_ext_, String mer_id_, String client_, String version_) {
        map.clear();
        map.put("mer_id_", mer_id_);
        map.put("user_cust_id_", user_cust_id_);
        map.put("trade_type_", trade_type_);
        map.put("bank_code_", bank_code_);
        map.put("card_number_", card_number_);
        map.put("mobile_", mobile_);
        map.put("sms_code_", sms_code_);
        map.put("sms_seq_", sms_seq_);
        map.put("ordsms_ext_", ordsms_ext_);
        map.put("client_", client_);
        map.put("version_", BaseApplication.version);
        return huifuShApi.quikBind(map);
    }

    /**
     * @param mer_id_      1：卓投 2：好利网 借款端调用不必传
     * @param moblie_      银行卡预留手机号
     * @param from_mobile_ 平台注册手机号
     * @param id_number_
     * @param user_name_   中文姓名
     * @param card_number_
     * @param bank_id_     银行 如ABC
     * @param sms_code_    用户输入的短信验证码
     * @param sms_seq_     调用发送短信接口返回
     * @param PageType     PageType为空：即自适应风格页面 ，PageType =1：app应用风格页面（无标题）， PageType =2：app应用风格页面（有标题
     * @param ret_url_     完成开户以后本地需要跳转的页面。
     * @param user_type_   客户类型 1：借款账户  2：理财账户
     * @param version_     版本号
     * @param juid      平台用户号
     * @return
     */
    public Observable<ToRegisterBean> register(String user_id, String mer_id_, String moblie_, String from_mobile_, String id_number_, String user_name_, String card_number_, String bank_id_, String sms_code_, String sms_seq_, String PageType, String ret_url_, String user_type_, String version_, String juid, String client) {
        map.clear();
        map.put("mer_id_", mer_id_);
        map.put("moblie_", moblie_);
        map.put("from_mobile_", from_mobile_);
        map.put("id_number_", id_number_);
        map.put("user_name_", user_name_);
        map.put("card_number_", card_number_);
        map.put("bank_id_", bank_id_);
        map.put("sms_code_", sms_code_);
        map.put("sms_seq_", sms_seq_);
        map.put("PageType", PageType);
        map.put("ret_url_", ret_url_);
        map.put("user_type_", user_type_);
        map.put("version_", BaseApplication.version);
        map.put("user_id_", user_id);
        map.put("client_", client);
        map.put("juid",juid);
        return huifuShApi.register(map);
    }

    public Observable<ActivateBean> activate(String user_id_, String UsrCustId, String PageType, String RetUrl, String mer_id_, String client_, String version_){
        map.clear();
        map.put("user_id_",user_id_);
        map.put("UsrCustId",UsrCustId);
        map.put("PageType",PageType);
        map.put("RetUrl",RetUrl);
        map.put("mer_id_",mer_id_);
        map.put("client_",client_);
        map.put("version_",BaseApplication.version);
        return huifuShApi.activate(map);
    }
    /**
     * 充值
     *
     * @param from_mobile_  用户手机号
     * @param gate_busi_id_ 支付网关业务代号
     * @param ret_url_      返回页面
     * @param sms_code_     短信验证码
     * @param sms_seq_      短信序号
     * @param trans_amt_    充值金额
     * @param mer_id_       平台
     * @param client_       客户端
     * @param version_      版本号
     * @param juid          用户平台号
     * @return
     */
    public Observable<RechargeBean> recharge(String from_mobile_, String gate_busi_id_, String ret_url_, String sms_code_, String sms_seq_, String trans_amt_, String bank_id_, String mer_id_, String client_,
                                             String version_, String juid, String UsrCustId) {
        map.clear();
        map.put("from_mobile_", from_mobile_);
        map.put("gate_busi_id_", gate_busi_id_);
        map.put("ret_url_", ret_url_);
        map.put("sms_code_", sms_code_);
        map.put("sms_seq_", sms_seq_);
        map.put("trans_amt_", trans_amt_);
        map.put("mer_id_", mer_id_);
        map.put("client_", client_);
        map.put("version_", BaseApplication.version);
        map.put("juid", juid);
        map.put("UsrCustId", UsrCustId);
        map.put("bank_id_", bank_id_);
        return huifuShApi.recharge(map);
    }

    /**
     * @param cash_serv_fee_ 服务费
     * @param UsrCustId 汇付客户号
     * @param from_mobile_ 用户在我们平台注册的手机号
     * @param ret_url_
     * @param trans_amt_ 金额
     * @param method_  提现方式 1:普通取现 2:即时取现 3:快速取现'
     * @param juid 平台客户号
     * @param mer_id_ 1：好利网
     * @param client_ 4
     * @param version_ 版本号
     * @return
     */
    public Observable<String> withDraw(String cash_serv_fee_, String UsrCustId, String from_mobile_, String ret_url_, String trans_amt_,String method_, String juid,
                                       String mer_id_, String client_, String version_) {
        map.clear();
        map.put("cash_serv_fee_", cash_serv_fee_);
        map.put("UsrCustId", UsrCustId);
        map.put("from_mobile_", from_mobile_);
        map.put("ret_url_", ret_url_);
        map.put("trans_amt_", trans_amt_);
        map.put("juid", juid);
        map.put("mer_id_", mer_id_);
        map.put("client_", client_);
        map.put("version_", BaseApplication.version);
        map.put("method_",method_);

        return huifuShApi.withDraw(map);
    }

    /**
     * 判断是否激活
     * @param user_id
     * @param idno
     * @param realname
     * @param user_type
     * @param mer_id_
     * @param client_
     * @return
     */
    public Observable<IsActivateBean> isBosAcctActivate(String user_id, String idno, String realname, String user_type, String mer_id_, String client_){
    map.clear();
    map.put("user_id",user_id);
    map.put("idno",idno);
    map.put("realname",realname);
    map.put("user_type",user_type);
    map.put("mer_id_",mer_id_);
    map.put("client_",client_);
    return huifuShApi.isBosAcctActivate(map);
}

}

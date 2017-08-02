package com.haolyy.compliance.model;

import com.haolyy.compliance.base.BaseApplication;
import com.haolyy.compliance.config.NetConstantValues;
import com.haolyy.compliance.entity.bank.ActivateBean;
import com.haolyy.compliance.entity.bank.IsActivateBean;
import com.haolyy.compliance.entity.bank.IsWithDrawSuccess;
import com.haolyy.compliance.entity.bank.OldUserBean;
import com.haolyy.compliance.entity.bank.QuikBindBean;
import com.haolyy.compliance.entity.bank.RechargeBean;
import com.haolyy.compliance.entity.bank.ToRegisterBean;
import com.haolyy.compliance.entity.bank.WithDrawBean;
import com.haolyy.compliance.entity.bank.WithDrawFee;
import com.haolyy.compliance.entity.login.HuifuSmsBean;
import com.haolyy.compliance.entity.login.UserBaseInfoBean;
import com.haolyy.compliance.service.HuifuShApi;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

import static com.haolyy.compliance.base.BaseApplication.juid;
import static com.haolyy.compliance.base.BaseApplication.userId;
import static com.haolyy.compliance.base.BaseApplication.version;
import static com.haolyy.compliance.config.Config.PageType;
import static com.haolyy.compliance.config.Config.client;
import static com.haolyy.compliance.config.Config.mer_id;
import static com.haolyy.compliance.config.Config.platform;
import static com.haolyy.compliance.config.Config.returl;

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
                .baseUrl(NetConstantValues.HOST_PAY)
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
     * @param mobile_      银行卡号对应的银行预留手机号
     * @param sms_type_    O-原手机号发送短信，N-新手机号。只有busi_type_为rebind时才必输
     */
    public Observable<HuifuSmsBean> sendSms(String busi_type_, String card_number_, String mobile_, String sms_type_) {
        map.clear();
        map.put("busi_type_", busi_type_);
        map.put("card_number_", card_number_);
        map.put("user_cust_id_", BaseApplication.userCustId);
        map.put("mer_id_", mer_id);
        map.put("mobile_", mobile_);
        map.put("sms_type_", sms_type_);
        map.put("client_", client);
        return huifuShApi.sendSms(map);
    }

    /**
     * @param trade_type_  交易类型
     * @param bank_code_   银行简称
     * @param card_number_ 银行卡号
     * @param mobile_      新绑定银行卡卡号对应的银行预留手机号
     * @param sms_code_    新绑定银行预留手机号发送的短信验证码
     * @param sms_seq_     新绑定银行预留手机号请求短信验证码接口时，返回的短信序号
     * @param ordsms_ext_  原绑定卡预留手机号发送的短信验证码+短信序号
     * @return
     */
    public Observable<QuikBindBean> quikBind(String trade_type_, String bank_code_, String card_number_,
                                             String mobile_, String sms_code_, String sms_seq_, String ordsms_ext_) {
        map.clear();
        map.put("mer_id_", mer_id);
        map.put("user_cust_id_", BaseApplication.userCustId);
        map.put("trade_type_", trade_type_);
        map.put("bank_code_", bank_code_);
        map.put("card_number_", card_number_);
        map.put("mobile_", mobile_);
        map.put("sms_code_", sms_code_);
        map.put("sms_seq_", sms_seq_);
        map.put("ordsms_ext_", ordsms_ext_);
        map.put("client_", client);
        map.put("version_", version);
        map.put("userId", userId+"");
        return huifuShApi.quikBind(map);
    }

    /**
     * @param moblie_      银行卡预留手机号
     * @param from_mobile_ 平台注册手机号
     * @param id_number_
     * @param user_name_   中文姓名
     * @param card_number_
     * @param bank_id_     银行 如ABC
     * @param sms_code_    用户输入的短信验证码
     * @param sms_seq_     调用发送短信接口返回
     * @param PageTyp      PageType为空：即自适应风格页面 ，PageType =1：app应用风格页面（无标题）， PageType =2：app应用风格页面（有标题
     * @param user_type_   客户类型 1：借款账户  2：理财账户
     * @return
     */
    public Observable<ToRegisterBean> register(String moblie_, String from_mobile_, String id_number_, String user_name_, String card_number_, String bank_id_, String sms_code_, String sms_seq_, String PageTyp, String user_type_) {
        map.clear();
        map.put("mer_id_", mer_id);
        map.put("mobile_", moblie_);
        map.put("from_mobile_", from_mobile_);
        map.put("id_number_", id_number_);
        map.put("user_name_", user_name_);
        map.put("card_number_", card_number_);
        map.put("bank_id_", bank_id_);
        map.put("sms_code_", sms_code_);
        map.put("sms_seq_", sms_seq_);
        map.put("PageType", PageType);
        map.put("ret_url_", returl);
        map.put("user_type_", user_type_);
        map.put("version_", version);
        map.put("user_id_", BaseApplication.userId + "");
        map.put("client_", client);
        map.put("juid", juid);
        return huifuShApi.register(map);
    }

    public Observable<ActivateBean> activate(String PageTyp) {
        map.clear();
        map.put("user_id_", BaseApplication.userId + "");
        map.put("UsrCustId", BaseApplication.userCustId);
        map.put("PageType", PageType);
        map.put("RetUrl", returl);
        map.put("mer_id_", mer_id);
        map.put("client_", client);
        map.put("version_", version);
        return huifuShApi.activate(map);
    }

    /**
     * 充值
     *
     * @param from_mobile_  用户手机号
     * @param gate_busi_id_ 支付网关业务代号
     * @param sms_code_     短信验证码
     * @param sms_seq_      短信序号
     * @param trans_amt_    充值金额
     * @return
     */
    public Observable<RechargeBean> recharge(String from_mobile_, String gate_busi_id_, String sms_code_, String sms_seq_, String trans_amt_, String bank_id_) {
        map.clear();
        map.put("user_id_", BaseApplication.userId + "");
        map.put("from_mobile_", from_mobile_);
        map.put("gate_busi_id_", gate_busi_id_);
        map.put("ret_url_", returl);
        map.put("sms_code_", sms_code_);
        map.put("sms_seq_", sms_seq_);
        map.put("trans_amt_", trans_amt_);
        map.put("mer_id_", mer_id);
        map.put("client_", client);
        map.put("version_", version);
        map.put("juid", juid);
        map.put("UsrCustId", BaseApplication.userCustId);
        map.put("bank_id_", bank_id_);
        return huifuShApi.recharge(map);
    }

    /**
     * @param cash_serv_fee_ 服务费
     * @param trans_amt_     金额
     * @param method_        提现方式 1:普通取现 2:即时取现 3:快速取现'
     * @return
     */
    public Observable<WithDrawBean> withDraw(String cash_serv_fee_, String trans_amt_, String method_
    ) {
        map.clear();
        map.put("user_id_", BaseApplication.userId + "");
        map.put("cash_serv_fee_", cash_serv_fee_);
        map.put("UsrCustId", BaseApplication.userCustId);
        map.put("ret_url_", returl);
        map.put("trans_amt_", trans_amt_);
        map.put("juid", juid);
        map.put("mer_id_", mer_id);
        map.put("client_", client);
        map.put("version_", version);
        map.put("method_", method_);
        map.put("PageType", PageType);
        return huifuShApi.withDraw(map);
    }

    /**
     * 判断是否激活
     *
     * @param idno
     * @param realname
     * @param user_type
     * @return
     */
    public Observable<IsActivateBean> isBosAcctActivate(String idno, String realname, String user_type) {
        map.clear();
        map.put("user_id_", BaseApplication.userId + "");
        map.put("id_number_", idno);
        map.put("user_name_", realname);
        map.put("user_type", user_type);
        map.put("mer_id_", mer_id);
        map.put("client_", client);
        return huifuShApi.isBosAcctActivate(map);
    }

    /**
     * 进行当前平台登陆用户数据复制
     */
    public Observable<OldUserBean> validateOldUser(String mobile, String account_platform_no_, String smsCode) {
        map.clear();
        map.put("user_id_", BaseApplication.userId + "");
        map.put("mobile_", mobile);
        map.put("account_platform_no_", account_platform_no_);
        map.put("smsCode_", smsCode);
        map.put("client_", client);
        return huifuShApi.validateolduser(map);
    }

    /**
     * 用户银行卡信息以及资金
     */
    public Observable<UserBaseInfoBean> getUSerBaseInfo() {
        map.clear();
        map.put("user_id_", BaseApplication.userId + "");
        map.put("client_", client);
        return huifuShApi.getUserBaseInfo(map);
    }

    public Observable<WithDrawFee> calculatefeeamount(String type, String amount) {
        map.clear();
        map.put("type_", type);
        map.put("amount_", amount);
        map.put("platform_", platform);
        map.put("client_", client);
        return huifuShApi.calculatefeeamount(map);
    }

    /**
     * 提现是否成功
     *
     * @return
     */
    public Observable<IsWithDrawSuccess> isWithDrawSuccess() {
        map.clear();
        map.put("userId", userId + "");
        return huifuShApi.isWithDraw(map);
    }


}

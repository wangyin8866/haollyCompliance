package com.haolyy.compliance.model;

import com.haolyy.compliance.base.BaseApplication;
import com.haolyy.compliance.entity.BaseResponseBean;
import com.haolyy.compliance.entity.TokenResponseBean;
import com.haolyy.compliance.entity.login.CheckImageCode;
import com.haolyy.compliance.entity.login.HuifuSmsBean;
import com.haolyy.compliance.entity.login.LoginResponseBean;
import com.haolyy.compliance.entity.login.RegisterBean;
import com.haolyy.compliance.service.HuifuShApi;
import com.haolyy.compliance.service.UserApi;

import rx.Observable;

/**
 * Created by LL on 2017/1/7.
 */

public class HuifuShModel extends BaseModel {
    private HuifuShApi huifuShApi;
    private static HuifuShModel userModel;

    private HuifuShModel() {
        super();
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
     * 充值
     *
     * @param from_mobile_  用户手机号
     * @param from_user_id_ 来源用户ID
     * @param gate_busi_id_ 支付网关业务代号
     * @param ret_url_      返回页面
     * @param sms_code_     短信验证码
     * @param sms_seq_      短信序号
     * @param trans_amt_    充值金额
     * @return
     */
    public Observable<BaseResponseBean> recharge(String from_mobile_, String from_user_id_, String gate_busi_id_, String ret_url_, String sms_code_, String sms_seq_, String trans_amt_) {
        map.put("from_mobile_", from_mobile_);
        map.put("from_user_id_", from_user_id_);
        map.put("gate_busi_id_", gate_busi_id_);
        map.put("ret_url_", ret_url_);
        map.put("sms_code_", sms_code_);
        map.put("sms_seq_", sms_seq_);
        map.put("trans_amt_", trans_amt_);
        return huifuShApi.recharge(map);
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
    public Observable<BaseResponseBean> quikBind(String mer_id_, String user_cust_id_, String trade_type_, String bank_code_, String card_number_, String mobile_, String sms_code_, String sms_seq_, String ordsms_ext_) {
        map.put("mer_id_", mer_id_);
        map.put("user_cust_id_", user_cust_id_);
        map.put("trade_type_", trade_type_);
        map.put("bank_code_", bank_code_);
        map.put("card_number_", card_number_);
        map.put("mobile_", mobile_);
        map.put("sms_code_", sms_code_);
        map.put("sms_seq_", sms_seq_);
        map.put("ordsms_ext_", ordsms_ext_);
        return huifuShApi.quikBind(map);
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
    public Observable<HuifuSmsBean> sendSms(String busi_type_, String card_number_, String user_cust_id_, String mer_id_, String mobile_, String sms_type_) {
        map.put("busi_type_", busi_type_);
        map.put("card_number_", card_number_);
        map.put("user_cust_id", user_cust_id_);
        map.put("mer_id_", mer_id_);
        map.put("mobile_", mobile_);
        map.put("sms_type_", sms_type_);
        return huifuShApi.sendSms(map);
    }

    /**
     * @param user_code_  用户号
     * @param user_name_  用户的真实姓名
     * @param busi_code_  营业执照编号
     * @param instu_code_ 组织机构代码
     * @param tax_code_   税务登记号
     * @return
     */
    public Observable<BaseResponseBean> corpRegister(String user_code_, String user_name_, String busi_code_, String instu_code_, String tax_code_) {
        map.put("user_code_", user_code_);
        map.put("user_name_", user_name_);
        map.put("busi_code_", busi_code_);
        map.put("instu_code_", instu_code_);
        map.put("tax_code_", tax_code_);
        return huifuShApi.corpRegister(map);
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
     * @param user_id      平台用户号
     * @return
     */
    public Observable<String> register(String mer_id_, String moblie_, String from_mobile_, String id_number_, String user_name_, String card_number_, String bank_id_, String sms_code_, String sms_seq_, String PageType, String ret_url_, String user_type_, String version_, String user_id,String client) {
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
        map.put("version_", version_);
        map.put("user_id_", user_id);
        map.put("client_",client);
        return huifuShApi.register(map);
    }
}

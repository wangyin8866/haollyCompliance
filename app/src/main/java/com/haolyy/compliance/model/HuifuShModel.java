package com.haolyy.compliance.model;

import com.haolyy.compliance.entity.login.HuifuSmsBean;
import com.haolyy.compliance.service.HuifuShApi;

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
     * @param busi_type_   开户：user_register，充值：recharge，换卡：rebind
     * @param card_number_ 除了业务类型是recharge以外，都必传
     * @param user_cust_id_ 用户账户手机号，开户以外必传
     * @param mer_id_      卓投传1，好利网传2
     * @param mobile_      银行卡号对应的银行预留手机号
     * @param sms_type_    O-原手机号发送短信，N-新手机号。只有busi_type_为rebind时才必输
     * @return
     */
    public Observable<HuifuSmsBean> sendSms(String busi_type_, String card_number_, String user_cust_id_, String mer_id_, String mobile_, String sms_type_,String client_) {
        map.put("busi_type_", busi_type_);
        map.put("card_number_", card_number_);
        map.put("user_cust_id", user_cust_id_);
        map.put("mer_id_", mer_id_);
        map.put("mobile_", mobile_);
        map.put("sms_type_", sms_type_);
        map.put("client_", client_);
        return huifuShApi.sendSms(map);
    }

}

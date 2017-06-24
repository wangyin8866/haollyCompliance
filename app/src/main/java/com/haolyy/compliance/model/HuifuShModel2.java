package com.haolyy.compliance.model;

import com.haolyy.compliance.base.LifeSubscription;
import com.haolyy.compliance.config.NetConstantValues;
import com.haolyy.compliance.entity.BaseResponseBean;
import com.haolyy.compliance.service.HuifuShApi;
import com.haolyy.compliance.utils.LogUtils;
import com.xfqz.xjd.mylibrary.LogInterceptor;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by LL on 2017/1/7.
 */

public class HuifuShModel2 {
    private HuifuShApi huifuShApi;
    private static HuifuShModel2 userModel;
    private static final int DEFAULT_TIMEOUT = 10;
    Retrofit retrofit;
    static Map<String, String> map = new HashMap<>();
    OkHttpClient.Builder httpClientBuilder;

    public HuifuShModel2() {
        //手动创建一个OkHttpClient并设置超时时间
        httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.addInterceptor(new LogInterceptor()).connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(NetConstantValues.HOST_URL)
                .build();
        huifuShApi = retrofit.create(HuifuShApi.class);
    }

    //添加线程订阅
    public static <T> void invoke(LifeSubscription lifeSubscription, Observable<T> observable, Subscriber<T> subscriber) {
        LogUtils.e("ndy_params", map.toString());
        Subscription subscription = observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
        lifeSubscription.bindSubscription(subscription);
    }


    public static HuifuShModel2 getInstance() {
        if (userModel == null) {
            synchronized (HuifuShModel2.class) {
                if (userModel == null) {
                    userModel = new HuifuShModel2();
                }
            }
        }
        return userModel;
    }

    /**
     *
     * @param from_mobile_  用户手机号
     * @param gate_busi_id_ 支付网关业务代号
     * @param ret_url_ 返回页面
     * @param sms_code_ 短信验证码
     * @param sms_seq_ 短信序号
     * @param trans_amt_ 充值金额
     * @param mer_id_ 平台
     * @param client_ 客户端
     * @param version_ 版本号
     * @param juid 用户平台号
     * @return
     */
    public Observable<String> recharge(String from_mobile_, String gate_busi_id_, String ret_url_, String sms_code_, String sms_seq_, String trans_amt_, String mer_id_,String client_,String version_ ,String juid,String UsrCustId ) {
        map.put("from_mobile_", from_mobile_);
        map.put("gate_busi_id_", gate_busi_id_);
        map.put("ret_url_", ret_url_);
        map.put("sms_code_", sms_code_);
        map.put("sms_seq_", sms_seq_);
        map.put("trans_amt_", trans_amt_);
        map.put("mer_id_", mer_id_);
        map.put("client_", client_);
        map.put("version_", version_);
        map.put("juid", juid);
        map.put("UsrCustId", UsrCustId);
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
    public Observable<String> register(String mer_id_, String moblie_, String from_mobile_, String id_number_, String user_name_, String card_number_, String bank_id_, String sms_code_, String sms_seq_, String PageType, String ret_url_, String user_type_, String version_, String user_id, String client) {
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
        map.put("client_", client);
        return huifuShApi.register(map);
    }
}

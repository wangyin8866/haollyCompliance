package com.haolyy.compliance.config;

/**
 * Created by DELL on 2017/1/6.
 */

public interface NetConstantValues {
    //本地
//     String HOST_URL = "http://192.168.11.104:8080/";
//     String HOST_URL2 = "http://192.168.11.104:8081/";
    //服务器
//    String HOST_URL = "http://192.168.7.113:8006/";
//    String HOST_URL2 = "http://192.168.7.113:8018/";
    //杜欣
    String HOST_URL2 = "http://192.168.13.213:8080/";
//    String HOST_URL="http://192.168.13.213:8080/";
    //赵建华
    //String HOST_URL = "http://192.168.10.97:8080/";
    //杨全帅
    String HOST_URL="http://192.168.13.63:8080/";
    String USERMANAGE = "chinazy-user-manage/";
    String BIGTHREE = "chinazy-sms-bigthree/api/";
    String HUIFU_SH = "chinazy-pay-shanghaibank/http/huifush/";

    String user_login = USERMANAGE + "user/login.html";
    String user_register = USERMANAGE + "user/register";
    String USER_FORGETPWD = USERMANAGE + "user/forgetpassword";
    String IMAGE_CHECK = USERMANAGE + "image/checkcode";
    String IMAGE_GET = USERMANAGE + "image/getcode";
    String GET_TOKEN = USERMANAGE + "common/getToken";

    //短信
    String SMS_SENDSMSCODE = BIGTHREE + "sms/sendSmsCode";

    //汇付接口
    String HUIFU_SMS_HUIFU = HUIFU_SH + "toSendSmsCode";//发送验证码
    String HUIFU_QUIK_BIND = HUIFU_SH + "quickBind";//绑卡
    String HUIFU_RECHARGE = HUIFU_SH + "toNetSave";//充值
    String HUIFU_CORP_REGISTER = HUIFU_SH + "toCorpRegister";//企业注册
    String HUIFU_REGISTER = HUIFU_SH + "toRegister";//用户注册
    String HUIFU_ACTIVATE = HUIFU_SH + "toBosAcctActivate";//账户激活
    String HUIFU_TOLOAN = HUIFU_SH + "toLoans";//放款
    String HUIFU_TRANSDETAIL = HUIFU_SH + "toQueryTransDetail";//交易明细
    String HUIFU_USERINFO = HUIFU_SH + "toQueryUsrInfo";//用户信息查询
    String HUIFU_ADDBIDINFO = HUIFU_SH + "addBidInfo";//标的信息录入


}

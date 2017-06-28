package com.haolyy.compliance.config;

/**
 * Created by DELL on 2017/1/6.
 */

public interface NetConstantValues {
    //本地
//     String HOST_URL = "http://192.168.11.104:8080/";
//     String HOST_URL2 = "http://192.168.11.104:8081/";
    //测试服务器
    //String HOST_URL = "http://192.168.7.113:8010/";
    String HOST_URL2 = "http://192.168.7.113:8018/";
    //杜欣
//    String HOST_URL2 = "http://192.168.13.213:8080/";
//    String HOST_URL="http://192.168.13.213:8080/";
    //赵建华
     String HOST_URL = "http://192.168.10.97:8080/";
    //杨全帅
   // String HOST_URL="http://192.168.11.199:8080/";
    //骆丹
    //String HOST_URL2 = "http://192.168.11.179:8080/";
    //String HOST_URL="http://192.168.11.179:8080/";

    String USERMANAGE = "chinazy-user-manage/";
    String BIGTHREE = "chinazy-sms-bigthree/api/";
    String HUIFU_SH = "chinazy-pay-shanghaibank/http/huifush/";
    //productList
//    String HOST_URL= "http://192.168.10.214:8080/";


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
    String HUIFU_WITHDRAW = HUIFU_SH + "toCash";//提现
    String HUIFU_CORP_REGISTER = HUIFU_SH + "toCorpRegister";//企业注册
    String HUIFU_REGISTER = HUIFU_SH + "toRegister";//用户注册
    String HUIFU_ACTIVATE = HUIFU_SH + "toBosAcctActivate";//账户激活
    String HUIFU_TOLOAN = HUIFU_SH + "toLoans";//放款
    String HUIFU_TRANSDETAIL = HUIFU_SH + "toQueryTransDetail";//交易明细
    String HUIFU_USERINFO = HUIFU_SH + "toQueryUsrInfo";//用户信息查询
    String HUIFU_ADDBIDINFO = HUIFU_SH + "addBidInfo";//标的信息录入
    //第二模块接口
    String PRODUCT="chinazy-product-info/product/";
    String PRODUCT_LIST = PRODUCT+"productList";//产品列表
    String PRODUCT_BASE_DETAIL = PRODUCT+"productDetailBase";//产品基础详情信息
    String PRODUCT_DETAIL = PRODUCT+"productDetail";//产品详情信息
}

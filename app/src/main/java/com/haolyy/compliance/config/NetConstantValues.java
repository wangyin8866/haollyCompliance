package com.haolyy.compliance.config;

/**
 * Created by DELL on 2017/1/6.
 */

public interface NetConstantValues {
    //本地
//     String HOST_URL = "http://192.168.11.104:8080/";
//     String HOST_URL2 = "http://192.168.11.104:8081/";
    //测试服务器
    /**
     * //产品接口
     */
    String HOST_URL = "http://192.168.7.113:8010/";
    /**
     * //短信接口
     */
    String HOST_URL2 = "http://192.168.7.113:8018/";
    /**
     * //用户接口
     */
    String HOST_URL3 = "http://192.168.7.113:8006/";
    /**
     * //支付接口
     */
    String HOST_URL4 = "http://192.168.7.113:8014/";

    //杜欣
   //String HOST_URL2 = "http://192.168.13.213:8080/";
   //String HOST_URL="http://192.168.13.213:8080/";
    //赵建华
     //String HOST_URL = "http://192.168.10.97:8080/";
    //杨全帅
     String HOST_URLY="http://192.168.13.63:8080/";
    //骆丹
    //String HOST_URL2 = "http://192.168.11.179:8080/";
    //String HOST_URL="http://192.168.11.179:8080/";
    //李佳
//    String HOST_URL = "http://192.168.9.229:8080/";
    //贺流
   // String HOST_URL= "http://192.168.10.214:8080/";


    String USERMANAGE = "chinazy-user-manage/";
    String BIGTHREE = "chinazy-sms-bigthree/api/";
    String HUIFU_SH = "chinazy-pay-shanghaibank/http/huifush/";
    String P2P = "chinazy-pay-shanghaibank/http/p2p/";



    String user_login = USERMANAGE + "user/login";//登录
    String user_register = USERMANAGE + "user/register";//注册
    String USER_FORGETPWD = USERMANAGE + "user/forgetpassword";//忘记密码
    String USER_FINDSTATUS=USERMANAGE+"userAccount/findUserstatus";
    String IMAGE_CHECK = USERMANAGE + "image/checkcode";//检查图形验证
    String IMAGE_GET = USERMANAGE + "image/getcode";//获取图形验证码
    String GET_TOKEN = USERMANAGE + "common/getToken";//获取token

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
    /**
     *   第二模块接口
     */

    //首页
    String HOME="chinazy-product-info/home/";
    String HOME_PRODUCT=HOME+"getHomeProduct";//首页产品展示
    String HOME_ARTICLE=HOME+"getHomeArticle";//首页新闻
    String HOME_RECOMMEND = HOME + "getrecommend";//首页活动信息
    String HOME_BANNER = HOME + "getbanner";//首页轮播图
    //列表详情页
    String PRODUCT="chinazy-product-info/product/";
    String PRODUCT_TITLE_LIST = PRODUCT+"productTitleList";//菜单列表
    String PRODUCT_LIST = PRODUCT+"productList";//产品列表
    String PRODUCT_BASE_DETAIL = PRODUCT+"productDetailBase";//产品基础详情信息
    String PRODUCT_DETAIL = PRODUCT+"productDetail";//产品详情信息
    String INVESTMENT_RECORD=PRODUCT+"getInvestmentRecord";//投资记录
    String PRODUCT_RETURN_PLAN = PRODUCT + "productReturnPlan";//还款计划

    //p2p
    String P2P_ISBOSACCTACTIVATE = P2P + "isBosAcctActivate";//判断是否是激活用户
    String P2P_CALCULATEFEEAMOUNT=P2P+"/calculateFeeAmount";//计算手续费

}

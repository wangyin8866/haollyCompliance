package com.haolyy.compliance.config;

/**
 * Created by DELL on 2017/1/6.
 */

public interface NetConstantValues {
    String HOST_URL = "http://10.1.20.108:8006/cash/v1/api/";
    String HOST_URL_face = "http://10.1.20.107/";//face++
    String HOST_URL_fadada = "http://juat.001bank.com/";//发大大
    String BANKPAY = "bankPay/";
    //图片验证
    String imageCode = "http://10.1.20.108:8006/cash/v1/api/kaptcha/getKaptcha?phone_num=";
    //实名认证
    String REAL_USER = "realUser/";
    //异步
    String ASYN = "asyn/";
    //用户账户
    String USERACOUNT = "userAcount/";
    //投资
    String INVEST = "invest/";
    //借款进度
    String BORROWING = "borrowing/";
    //个人中心
    String PERSONANL = "personanl/";
    //app配置
    String APPCONFIG = "appConfig/";
    //banner
    String BANNER = "banner/";

    /**
     * 登录/注册/忘记密码/修改密码
     */
    String USER = "user/";
    String user_login = USER + "login";//登录
    String user_register = USER + "register";// 注册
    String user_getstatusByname = USER + "getstatusByname";//手机号获取用户状态接口
    String user_resetPassword = USER + "resetPassword";//忘记密码
    String user_sms = "sms/requestValidateCode";//获取验证码
    String user_selectUserStatus = USER + "selectUserStatus";//id获取用户状态最全接口
    String user_resetPasswordInMore = USER + "resetPasswordInMore";//密码重置
    //借款状态
    String borrow_state = "borrow/getBorrowStatus";
    String user_imageCode = "kaptcha/validateKaptcha";//验证手机号和图形验证码
    /**
     * 列表
     */
    String product_list = "borrow/borrowLists";
    /**
     * 首页
     */
    String product_info = "borrow/selectBorrowOfIndex";
    //标的详情
    String borrow_detail = "borrow/selectBorrowByBorrowNid";
    //banner，导航页，关键字
    String banner_info = "banner/selectIndexbanner";
    //加入记录
    String join_log = "borrow/selectListByBorrowNid";
    //还款计划
    String repayment_log = "recoverPlan/recoverPlanList";
    //实名认证
    String realUser_setRealUser = REAL_USER + "setRealUser";
    //查询用户身份信息
    String realUser_selectRealUserByUserId = REAL_USER + "selectRealUserByUserId";

    //绑卡
    String bankPay_bindCard = BANKPAY + "BindCard";
    //绑卡校验
    String bankPay_bindCard_valid = BANKPAY + "BindCardVaild";
    //充值
    String bankPay_pay = BANKPAY + "pay";
    //提现
    String bankPay_repay = BANKPAY + "repay";
    //根据id获取对应卡号
    String bankPay_selectBankCardByUserId = BANKPAY + "selectBankCardByUserId";
    //查询银行限额
    String bankPay_selectBankList = BANKPAY + "selectBankList";
    //验证银行标示码
    String bankPay_selectBankName = BANKPAY + "selectBankName";
    //支持的银行卡列表
    String bankPay_supportBankList = BANKPAY + "supportBankList";
    //设置交易密码重定向
    String bankpay_setCashPassword = BANKPAY + "setCashPassword";
    //修改交易密码
    String bankpay_updateCashPassword = BANKPAY + "updateCashPassword";

    //地址列表
    String area_selectAreaList = "area/selectAreaList";

    //设置委托
    String asyn_setsinaEntrust = ASYN + "setsinaEntrust";
    //设置委托后的回调
    String asyn_sinaEntrustAsyn = ASYN + "sinaEntrustAsyn";

    //保存基本信息
    String userAcount_basemessage = USERACOUNT + "basemessage";
    //查询用户账户
    String userAcount_selectUserAcoun = USERACOUNT + "selectUserAcount";
    //个人投资记录
    String userAcount_selectTouZiJiLu = USERACOUNT + "touZiJiLu";
    //资金记录
    String userAcount_selectZiJinJiLu = USERACOUNT + "ziJinJiLu";
    //邀请投资记录
    String user_selectInvestUser = USER + "selectInvestUser";
    //邀请记录
    String user_selectInviteUser = USER + "selectInviteUser";

    //invest
    String invest_invest = INVEST + "invest";

    //借款进度
    String borrowingPlan = BORROWING + "borrowingPlan";
    //借款进度
    String borrowingRecoverPlan = BORROWING + "borrowingRecoverPlan";

    //face身份证
    String faceUrl = "ThirdAccess/api/face/card";
    //人脸识别
    String face_pic_url = "ThirdAccess/api/face/picvscard";
    //法大大
    String faDaDa = "ThirdAccess/api/extSign2";

    //资金流水
    String selectAccount = PERSONANL + "selectAccount";
    //交易记录
    String selectTrading = PERSONANL + "selectTrading";
    //交易记录详情
    String selectTradingDetail = PERSONANL + "selectTradingDetail";
    //用户反馈
    String userFeedBack = PERSONANL + "userFeedBack";

    //版本升级
    String checkVersion = APPCONFIG + "checkVersion";

    //版本升级
    String selectIndexbanner = BANNER + "selectIndexbanner";

}

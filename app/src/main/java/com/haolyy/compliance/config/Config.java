package com.haolyy.compliance.config;

/**
 * Created by niudeyang on 2017/4/26.
 */

public interface Config {
    String TIP_ALL="您所输入的账号或密码有误，请重新输入";
    String TIP_MOBILE="手机号码错误";
    String TIP_IMAGE="图片验证码错误";
    String TIP_SMS="短信验证码错误";
    String TIP_PASSS="密码格式错误";
    String TIP_PASSS2="密码不一致";
    String TIP_INVITE="邀请码格式错误";

    String service_phone="400-999-6780";
    int seconds=60000;//倒计时时间
    String platform="HLW";//好利网
    String mer_id="HLW";//平台号 好利网
    String client = "ANDROID";
    String returl="http://www.chinazyjr.com/";
    String PageType="1";//app风格无标题
    int status_with_draw=9001;
    int staus_recharge=9002;
    int status_rebind=9003;

    /**
     * 获取短信验证码 operationType 短信验证码用途:1注册(register) 2修改密码(forget) 3充值(recharge) 4投资(investment) 5修改用户名(changeUserName) image_code 图形验证码
     */
    String SMS_OPERATION_TYPE_REG = "register";//
    String SMS_OPERATION_TYPE_FOR = "forget";
    String SMS_OPERATION_TYPE_REC = "3";
    String SMS_OPERATION_TYPE_INV = "4";
    String SMS_OPERATION_TYPE_MOD = "5";
    String SMS_OPERATION_TYPE_ACTIVATE="bosAcctActivate";
    String SMS_TEMPLATE_CODE_HOLYY = "100";//好利网100
    String LoginOUT="loginOut";

    /**
     * h5页面
     */
    String borrow_detail="http://192.168.6.60/h5/html/second/IAdetailSpecial.html";
    String bill="http://192.168.6.60/h5/html/fourth/monthlyBill.html";
}

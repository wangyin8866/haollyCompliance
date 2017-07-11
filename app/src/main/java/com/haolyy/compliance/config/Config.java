package com.haolyy.compliance.config;

/**
 * Created by niudeyang on 2017/4/26.
 */

public interface Config {
    String TIP_ALL="你所输入的账号或密码有误，请重新输入";
    String TIP_MOBILE="手机号码错误";
    String TIP_IMAGE="图片验证码错误";
    String TIP_SMS="短信验证码错误";
    String TIP_PASSS="密码格式错误";
    String TIP_INVITE="邀请码格式错误";

    int seconds=60000;//倒计时时间
    String platform="1";//好利网
    String mer_id="1";//平台号 好利网
    String platformhaolyy="haolyy";
    String client = "1";
    String returl="http://www.chinazyjr.com/";

    int status_with_draw=9001;
    int staus_recharge=9002;

    /**
     * 获取短信验证码 operationType 短信验证码用途:1注册(register) 2修改密码(forget) 3充值(recharge) 4投资(investment) 5修改用户名(changeUserName) image_code 图形验证码
     */
    String SMS_OPERATION_TYPE_REG = "1";//
    String SMS_OPERATION_TYPE_FOR = "2";
    String SMS_OPERATION_TYPE_REC = "3";
    String SMS_OPERATION_TYPE_INV = "4";
    String SMS_OPERATION_TYPE_MOD = "5";

    String SMS_TEMPLATE_CODE_HOLYY = "100";//好利网100
}

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
    String client = "Android";
    String returl="http://www.chinazyjr.com";
}

package com.haolyy.compliance.config;

/**
 * Created by DELL on 2017/1/6.
 */

public interface NetConstantValues {
    //本地

    /* String HOST_URL = "http://192.168.11.104:8080/";
     String HOST_URL2 = "http://192.168.11.104:8081/";*/
    String HOST_URL = "http://192.168.7.113:8006/";
    String HOST_URL2 = "http://192.168.7.113:8018/";
    String USERMANAGE = "chinazy-user-manage/";
    String BIGTHREE = "chinazy-sms-bigthree/api/";


    String user_login = USERMANAGE + "user/login.html";
    String user_register = USERMANAGE + "user/register";
    String USER_FORGETPWD = USERMANAGE + "user/forgetpassword";
    String IMAGE_CHECK = USERMANAGE + "image/checkcode";
    String IMAGE_GET = USERMANAGE + "image/getcode";
    String GET_TOKEN = USERMANAGE + "common/getToken";
    //短信
    String SMS_SENDSMSCODE = BIGTHREE + "sms/sendSmsCode";
}

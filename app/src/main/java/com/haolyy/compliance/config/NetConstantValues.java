package com.haolyy.compliance.config;

/**
 * Created by DELL on 2017/1/6.
 */

public interface NetConstantValues {
   // String HOST_URL = "http://192.168.9.93:8080/chinazy-user-manage/";
    String HOST_URL = "http://192.168.9.229:8080/";

    String USERMANAGE="chinazy-user-manage/" ;
    String BIGTHREE="chinazy-sms-bigthree/api/";


    String user_login=USERMANAGE+"user/login.html";
    String user_register=USERMANAGE+"user/register";
    String IMAGE_CHECK=USERMANAGE+"image/checkcode";
    String IAMGE_GET=USERMANAGE+"image/getcode";

    String SMS_SENDSMSCODE=BIGTHREE+"sms/sendSmsCode";
}

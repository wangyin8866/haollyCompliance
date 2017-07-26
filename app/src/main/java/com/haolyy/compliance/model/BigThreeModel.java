package com.haolyy.compliance.model;

import com.haolyy.compliance.base.BaseApplication;
import com.haolyy.compliance.base.BaseBean;
import com.haolyy.compliance.config.Config;
import com.haolyy.compliance.entity.login.ValidateCode;
import com.haolyy.compliance.service.UserApi;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;

/**
 * Created by LL on 2017/1/7.
 */

public class BigThreeModel extends BaseModel {
    private UserApi userApi;
    private static BigThreeModel userModel;
    private  Map<String, String> map = new HashMap<>();

    private BigThreeModel() {
        super();

        userApi = retrofit.create(UserApi.class);
    }

    public static BigThreeModel getInstance() {
        if (userModel == null) {
            synchronized (BigThreeModel.class) {
                if (userModel == null) {
                    userModel = new BigThreeModel();
                }
            }
        }
        return userModel;
    }

    /**
     *
     * @param phone_num
     * @param imagecode
     * @param operationType register forget
     * @return
     */
    public Observable<ValidateCode> requestValidateCode(String phone_num, String imagecode, String operationType) {
        map.clear();
        map.put("phone_num", phone_num);
        map.put("token",BaseApplication.token );
        map.put("operationType", operationType);
        map.put("image_code", imagecode);
        map.put("sms_template_code", Config.SMS_TEMPLATE_CODE_HOLYY);
        return userApi.requestValidateCode(map);
    }

}

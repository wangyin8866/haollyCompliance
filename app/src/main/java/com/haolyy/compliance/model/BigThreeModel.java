package com.haolyy.compliance.model;

import com.haolyy.compliance.base.BaseApplication;
import com.haolyy.compliance.base.BaseBean;
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
     * @param sms_template_code
     * @param operationType register forget
     * @return
     */
    public Observable<BaseBean> requestValidateCode(String phone_num, String imagecode, String sms_template_code, String operationType) {
        map.clear();
        map.put("phone_num", phone_num);
        map.put("token",BaseApplication.token );
        map.put("operationType", operationType);
        map.put("image_code", imagecode);
        map.put("sms_template_code", sms_template_code);
        return userApi.requestValidateCode(map);
    }

}

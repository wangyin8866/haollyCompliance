package com.haolyy.compliance.model;

import com.haolyy.compliance.base.BaseApplication;
import com.haolyy.compliance.base.BaseBean;
import com.haolyy.compliance.entity.TokenResponseBean;
import com.haolyy.compliance.entity.bank.BankListBean;
import com.haolyy.compliance.entity.home.AccountSecurityBean;
import com.haolyy.compliance.entity.home.FundStatictisIncomeBean;
import com.haolyy.compliance.entity.home.UserInfoBean;
import com.haolyy.compliance.entity.login.CheckImageCode;
import com.haolyy.compliance.entity.login.FindUserStatusBean;
import com.haolyy.compliance.entity.login.LoginResponseBean;
import com.haolyy.compliance.entity.my.ProductRatioBean;
import com.haolyy.compliance.service.UserApi;
import com.haolyy.compliance.ui.my.Bean.DealRecordBean;

import rx.Observable;

import static com.haolyy.compliance.base.BaseApplication.token;
import static com.haolyy.compliance.base.BaseApplication.userId;
import static com.haolyy.compliance.base.BaseApplication.version;
import static com.haolyy.compliance.config.Config.client;
import static com.haolyy.compliance.config.Config.platform;

/**
 * Created by LL on 2017/1/7.
 */

public class UserModel extends BaseModel {
    private UserApi userApi;
    private static UserModel userModel;

    private UserModel() {
        super();
        userApi = retrofit.create(UserApi.class);
    }

    public static UserModel getInstance() {
        if (userModel == null) {
            synchronized (UserModel.class) {
                if (userModel == null) {
                    userModel = new UserModel();
                }
            }
        }
        return userModel;
    }

    /**
     * 获取token的方法
     */
    public Observable<TokenResponseBean> getToken() {
        return userApi.getToken();
    }


    /**
     * 登录
     */

    public Observable<LoginResponseBean> login(String phone_num, String password) {
        map.clear();
        map.put("phone_num", phone_num);
        map.put("password", password);
        map.put("client",client);
//        map.put("token", BaseApplication.token);
        return userApi.login(map);
    }

    public Observable<BaseBean> register(String phone_num, String password, String smsCode, String imageCode, String channel, String inviteCode) {
        map.clear();
        map.put("phone_num", phone_num);
        map.put("password", password);
        map.put("smsCode", smsCode);
        map.put("validate_code", imageCode);
        map.put("client", client);
        map.put("platform", platform);
        map.put("version", version);
        map.put("channel", channel);
        map.put("inviteCode", inviteCode);
        map.put("token", token);
        return userApi.register(map);
    }

    public Observable<CheckImageCode> sendTextSms(String phone_num) {
        return userApi.sendTextSms(phone_num);
    }

    public Observable<BaseBean> forgetPassWord(String phone_num, String password, String smsCode, String imageCode) {
        map.clear();
        map.put("phone_num", phone_num);
        map.put("password", password);
        map.put("smsCode", smsCode);
        map.put("validate_code", imageCode);
        map.put("client", client);
        map.put("platform", platform);
        map.put("token", token);
        return userApi.forgetPassWord(map);
    }

    /**
     * 查询用户状态
     *
     * @return
     */
    public Observable<FindUserStatusBean> findUserStatus() {
        map.clear();
        map.put("mobile", BaseApplication.mUserName);
        map.put("platform", platform);
        map.put("client",client);
        return userApi.findStatus(map);
    }

    /**
     * 查询用户信息
     *
     * @return
     */
    public Observable<UserInfoBean> getUserInfo() {
        map.clear();
        map.put("user_id", userId + "");
        map.put("platform", platform);
        return userApi.getUserInfo(map);
    }


    public Observable<ProductRatioBean> getUserProductInfo() {
        map.clear();
        map.put("user_id", userId + "");
        map.put("platform", platform);
        return userApi.getUserProductInfo(map);
    }

    public Observable<AccountSecurityBean> getUserSecurityInfo() {
        map.clear();
        map.put("user_id", userId + "");
        map.put("platform", platform);
        return userApi.getUserSecurityInfo(map);
    }

    public Observable<FundStatictisIncomeBean> getUserIncomInfo() {
        map.clear();
        map.put("userId", userId + "");
        map.put("platform", platform);
        return userApi.getUserIncomeInfo(map);
    }

    /**
     * 资金明细
     * @param capitalType
     * @param pageIndex
     * @param dateFlag
     * @return
     */
    public Observable<DealRecordBean> getDealRecord(String capitalType, String pageIndex, String dateFlag) {
        map.clear();
        map.put("userId", userId+"");
        map.put("capitalType", capitalType);
        map.put("pageIndex", pageIndex);
        map.put("dateFlag", dateFlag);
        return userApi.getDealRecord(map);
    }

    /**
     * 获取银行卡列表
     *
     * @return
     */
    public Observable<BankListBean> getBankList() {
        return userApi.getBankList(map);
    }
    /**
     * 身份校验
     */
    public Observable<BaseBean> authentication(String smsCode, String validateCode, String mobile,String token) {
        map.clear();
        map.put("smsCode", smsCode+"");
        map.put("validateCode", validateCode);
        map.put("mobile", mobile);
        map.put("token", token);
        return userApi.authentication(map);
    }
    /**
     * 重置密码啊
     *
     */
    public Observable<BaseBean> resetPasswordInMore(String userId, String password, String newPassword) {
        map.clear();
        map.put("userId", userId+"");
        map.put("password", password);
        map.put("newPassword", newPassword);
        return userApi.resetPasswordInMore(map);
    }
}

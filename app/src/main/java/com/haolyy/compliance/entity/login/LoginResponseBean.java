package com.haolyy.compliance.entity.login;


import com.haolyy.compliance.base.BaseBean;

/**
 * Created by LL on 2017/1/9.
 */

public class LoginResponseBean extends BaseBean {


    /**
     * data : {"data":{"lastLoginIp":"192.168.11.236","lastLoginTime":"2017-07-03 10:49:30","mobile":"13821882946","platform":1,"registTime":"2017-06-20 17:11:40","registerCode":"1236555","status":1,"userCode":"09755328","userId":65},"msg":"业务正常","status":"200"}
     * msg : 系统正常
     * status : 200
     */

    public Model model;

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public static class Model {
        /**
         * data : {"lastLoginIp":"192.168.11.236","lastLoginTime":"2017-07-03 10:49:30","mobile":"13821882946","platform":1,"registTime":"2017-06-20 17:11:40","registerCode":"1236555","status":1,"userCode":"09755328","userId":65}
         * msg : 业务正常
         * status : 200
         */

        private String lastLoginTime;
        private String inviteCode;
        private Integer id;
        private String mobile;
        private Integer userType;
        private String type;
        private String recommendCode;
        private Integer status;

        public String getLastLoginTime() {
            return lastLoginTime;
        }

        public void setLastLoginTime(String lastLoginTime) {
            this.lastLoginTime = lastLoginTime;
        }

        public String getInviteCode() {
            return inviteCode;
        }

        public void setInviteCode(String inviteCode) {
            this.inviteCode = inviteCode;
        }



        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }



        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getRecommendCode() {
            return recommendCode;
        }

        public void setRecommendCode(String recommendCode) {
            this.recommendCode = recommendCode;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getUserType() {
            return userType;
        }

        public void setUserType(Integer userType) {
            this.userType = userType;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }
    }
}

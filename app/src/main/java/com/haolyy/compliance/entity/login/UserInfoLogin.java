package com.haolyy.compliance.entity.login;


import com.haolyy.compliance.entity.BaseResponseBean;

/**
 * Created by LL on 2017/1/7.
 */

public class UserInfoLogin extends BaseResponseBean {
    public Model model;

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public class Model {
        private int id;
        private String mobile;
        private String inviteCode;

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }



        public String getInviteCode() {
            return inviteCode;
        }

    }
}

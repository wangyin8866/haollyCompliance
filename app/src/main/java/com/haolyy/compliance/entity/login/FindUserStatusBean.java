package com.haolyy.compliance.entity.login;

/**
 * Created by niudeyang on 2017/7/5.
 */

public class FindUserStatusBean {


    /**
     * code : 200
     * msg : 成功
     * model : {"code":"200","msg":"成功","model":{"risk_level":0,"is_open_account":0,"pass_word":"200820e3227815ed1756a6b531e7e0d2","mobile":"15001230086","is_password":0,"is_auto_tender":0,"userId":"159","status":1}}
     */

    private String code;
    private String msg;
    private ModelBeanX model;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ModelBeanX getModel() {
        return model;
    }

    public void setModel(ModelBeanX model) {
        this.model = model;
    }

    public static class ModelBeanX {
        /**
         * code : 200
         * msg : 成功
         * model : {"risk_level":0,"is_open_account":0,"pass_word":"200820e3227815ed1756a6b531e7e0d2","mobile":"15001230086","is_password":0,"is_auto_tender":0,"userId":"159","status":1}
         */

        private String code;
        private String msg;
        private ModelBean model;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public ModelBean getModel() {
            return model;
        }

        public void setModel(ModelBean model) {
            this.model = model;
        }

        public static class ModelBean {
            /**
             * risk_level : 0
             * is_open_account : 0
             * pass_word : 200820e3227815ed1756a6b531e7e0d2
             * mobile : 15001230086
             * is_password : 0
             * is_auto_tender : 0
             * userId : 159
             * status : 1
             */

            private int risk_level;
            private String pass_word;
            private String mobile;
            private int is_password;
            private int is_auto_tender;
            private String userId;
            private int status;


            private int is_open_account;
            public String getBank_no() {
                return bank_no;
            }

            public void setBank_no(String bank_no) {
                this.bank_no = bank_no;
            }

            private String bank_no;
            public String getBank_card_no() {
                return bank_card_no;
            }

            public void setBank_card_no(String bank_card_no) {
                this.bank_card_no = bank_card_no;
            }

            private String bank_card_no;
            public String getThird_user_id() {
                return third_user_id;
            }

            public void setThird_user_id(String third_user_id) {
                this.third_user_id = third_user_id;
            }

            private String third_user_id;
            public int getRisk_level() {
                return risk_level;
            }

            public void setRisk_level(int risk_level) {
                this.risk_level = risk_level;
            }

            public int getIs_open_account() {
                return is_open_account;
            }

            public void setIs_open_account(int is_open_account) {
                this.is_open_account = is_open_account;
            }

            public String getPass_word() {
                return pass_word;
            }

            public void setPass_word(String pass_word) {
                this.pass_word = pass_word;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public int getIs_password() {
                return is_password;
            }

            public void setIs_password(int is_password) {
                this.is_password = is_password;
            }

            public int getIs_auto_tender() {
                return is_auto_tender;
            }

            public void setIs_auto_tender(int is_auto_tender) {
                this.is_auto_tender = is_auto_tender;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }
    }
}

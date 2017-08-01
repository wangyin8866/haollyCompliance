package com.haolyy.compliance.entity.home;

/**
 * Created by User on 2017/7/12.
 */

public class AccountSecurityBean {

    /**
     * code : 200
     * msg : 成功
     * model : {"code":"200","msg":"成功","model":{"mobile":"150****1060","is_password":1,"real_name":"季淼","bank_card_no":"6228223211212310250","set_hand_password_flag":"0","bank_no":"101","is_auto_tender":0,"set_login_password_flag":"0","bind_mobile_flag":"1","risk_level":0,"bind_bank_card_flag":"1","is_open_account":1,"status":"1"}}
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
         * model : {"mobile":"150****1060","is_password":1,"real_name":"季淼","bank_card_no":"6228223211212310250","set_hand_password_flag":"0","bank_no":"101","is_auto_tender":0,"set_login_password_flag":"0","bind_mobile_flag":"1","risk_level":0,"bind_bank_card_flag":"1","is_open_account":1,"status":"1"}
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
             * mobile : 150****1060
             * is_password : 1
             * real_name : 季淼
             * bank_card_no : 6228223211212310250
             * set_hand_password_flag : 0
             * bank_no : 101
             * is_auto_tender : 0
             * set_login_password_flag : 0
             * bind_mobile_flag : 1
             * risk_level : 0
             * bind_bank_card_flag : 1
             * is_open_account : 1
             * status : 1
             */

            private String mobile;
            private int is_password;
            private String real_name;
            private String bank_card_no;
            private int set_hand_password_flag;
            private String bank_no;
            private int is_auto_tender;
            private int set_login_password_flag;
            private int bind_mobile_flag;
            private int risk_level;
            private int bind_bank_card_flag;
            private int is_open_account;
            private int status;

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

            public String getReal_name() {
                return real_name;
            }

            public void setReal_name(String real_name) {
                this.real_name = real_name;
            }

            public String getBank_card_no() {
                return bank_card_no;
            }

            public void setBank_card_no(String bank_card_no) {
                this.bank_card_no = bank_card_no;
            }

            public int getSet_hand_password_flag() {
                return set_hand_password_flag;
            }

            public void setSet_hand_password_flag(int set_hand_password_flag) {
                this.set_hand_password_flag = set_hand_password_flag;
            }

            public String getBank_no() {
                return bank_no;
            }

            public void setBank_no(String bank_no) {
                this.bank_no = bank_no;
            }

            public int getIs_auto_tender() {
                return is_auto_tender;
            }

            public void setIs_auto_tender(int is_auto_tender) {
                this.is_auto_tender = is_auto_tender;
            }

            public int getSet_login_password_flag() {
                return set_login_password_flag;
            }

            public void setSet_login_password_flag(int set_login_password_flag) {
                this.set_login_password_flag = set_login_password_flag;
            }

            public int getBind_mobile_flag() {
                return bind_mobile_flag;
            }

            public void setBind_mobile_flag(int bind_mobile_flag) {
                this.bind_mobile_flag = bind_mobile_flag;
            }

            public int getRisk_level() {
                return risk_level;
            }

            public void setRisk_level(int risk_level) {
                this.risk_level = risk_level;
            }

            public int getBind_bank_card_flag() {
                return bind_bank_card_flag;
            }

            public void setBind_bank_card_flag(int bind_bank_card_flag) {
                this.bind_bank_card_flag = bind_bank_card_flag;
            }

            public int getIs_open_account() {
                return is_open_account;
            }

            public void setIs_open_account(int is_open_account) {
                this.is_open_account = is_open_account;
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

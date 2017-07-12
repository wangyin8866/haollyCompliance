package com.haolyy.compliance.entity.home;

/**
 * Created by User on 2017/7/12.
 */

public class AccountSecurityBean {


    /**
     * code : 200
     * msg : 成功
     * model : {"code":"200","msg":"成功","model":{"mobile":"176****0704","is_password":0,"to_bank_name":"CMB","set_hand_password_flag":"0","is_auto_tender":1,"set_login_password_flag":"1","bind_mobile_flag":"1","risk_level":0,"bind_bank_card_flag":"1","to_acc_name":"苏子童","status":"0","to_acc_no":"***************5121","card_mobile":"185****0795"}}
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
         * model : {"mobile":"176****0704","is_password":0,"to_bank_name":"CMB","set_hand_password_flag":"0","is_auto_tender":1,"set_login_password_flag":"1","bind_mobile_flag":"1","risk_level":0,"bind_bank_card_flag":"1","to_acc_name":"苏子童","status":"0","to_acc_no":"***************5121","card_mobile":"185****0795"}
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
             * mobile : 176****0704
             * is_password : 0
             * to_bank_name : CMB
             * set_hand_password_flag : 0
             * is_auto_tender : 1
             * set_login_password_flag : 1
             * bind_mobile_flag : 1
             * risk_level : 0
             * bind_bank_card_flag : 1
             * to_acc_name : 苏子童
             * status : 0
             * to_acc_no : ***************5121
             * card_mobile : 185****0795
             */

            private String mobile;
            private int is_password;
            private String to_bank_name;
            private String set_hand_password_flag;
            private int is_auto_tender;
            private String set_login_password_flag;
            private String bind_mobile_flag;
            private int risk_level;
            private String bind_bank_card_flag;
            private String to_acc_name;
            private String status;
            private String to_acc_no;
            private String card_mobile;

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

            public String getTo_bank_name() {
                return to_bank_name;
            }

            public void setTo_bank_name(String to_bank_name) {
                this.to_bank_name = to_bank_name;
            }

            public String getSet_hand_password_flag() {
                return set_hand_password_flag;
            }

            public void setSet_hand_password_flag(String set_hand_password_flag) {
                this.set_hand_password_flag = set_hand_password_flag;
            }

            public int getIs_auto_tender() {
                return is_auto_tender;
            }

            public void setIs_auto_tender(int is_auto_tender) {
                this.is_auto_tender = is_auto_tender;
            }

            public String getSet_login_password_flag() {
                return set_login_password_flag;
            }

            public void setSet_login_password_flag(String set_login_password_flag) {
                this.set_login_password_flag = set_login_password_flag;
            }

            public String getBind_mobile_flag() {
                return bind_mobile_flag;
            }

            public void setBind_mobile_flag(String bind_mobile_flag) {
                this.bind_mobile_flag = bind_mobile_flag;
            }

            public int getRisk_level() {
                return risk_level;
            }

            public void setRisk_level(int risk_level) {
                this.risk_level = risk_level;
            }

            public String getBind_bank_card_flag() {
                return bind_bank_card_flag;
            }

            public void setBind_bank_card_flag(String bind_bank_card_flag) {
                this.bind_bank_card_flag = bind_bank_card_flag;
            }

            public String getTo_acc_name() {
                return to_acc_name;
            }

            public void setTo_acc_name(String to_acc_name) {
                this.to_acc_name = to_acc_name;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getTo_acc_no() {
                return to_acc_no;
            }

            public void setTo_acc_no(String to_acc_no) {
                this.to_acc_no = to_acc_no;
            }

            public String getCard_mobile() {
                return card_mobile;
            }

            public void setCard_mobile(String card_mobile) {
                this.card_mobile = card_mobile;
            }
        }
    }
}

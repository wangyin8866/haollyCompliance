package com.haolyy.compliance.entity.login;

/**
 * Created by niudeyang on 2017/7/5.
 */

public class FindUserStatusBean {


    /**
     * data : {"data":{"bank_card_no":"6228223211212310079","bank_name":"农业银行","bank_no":"101","bind_bank_card_flag":1,"bind_mobile_flag":2,"limit_day":500000,"limit_single":500000,"mobile":"15001230070","open_account_flag":1,"realname":"雷琦琥","risk_rating_flag":2,"set_auto_buy_bid_flag":2,"set_hand_password_flag":2,"set_login_password_flag":1,"set_password_flag":2,"third_user_id":"6000060007335137","user_code":"e730ca08","user_id":"177"},"msg":"业务正常","status":"200"}
     * msg : 系统正常
     * status : 200
     */

    private DataBeanX data;
    private String msg;
    private String status;

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class DataBeanX {
        /**
         * data : {"bank_card_no":"6228223211212310079","bank_name":"农业银行","bank_no":"101","bind_bank_card_flag":1,"bind_mobile_flag":2,"limit_day":500000,"limit_single":500000,"mobile":"15001230070","open_account_flag":1,"realname":"雷琦琥","risk_rating_flag":2,"set_auto_buy_bid_flag":2,"set_hand_password_flag":2,"set_login_password_flag":1,"set_password_flag":2,"third_user_id":"6000060007335137","user_code":"e730ca08","user_id":"177"}
         * msg : 业务正常
         * status : 200
         */

        private DataBean data;
        private String msg;
        private String status;

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public static class DataBean {
            /**
             * bank_card_no : 6228223211212310079
             * bank_name : 农业银行
             * bank_no : 101
             * bind_bank_card_flag : 1
             * bind_mobile_flag : 2
             * limit_day : 500000.0
             * limit_single : 500000.0
             * mobile : 15001230070
             * open_account_flag : 1
             * realname : 雷琦琥
             * risk_rating_flag : 2
             * set_auto_buy_bid_flag : 2
             * set_hand_password_flag : 2
             * set_login_password_flag : 1
             * set_password_flag : 2
             * third_user_id : 6000060007335137
             * user_code : e730ca08
             * user_id : 177
             */

            private String bank_card_no;
            private String bank_name;
            private String bank_no;
            private int bind_bank_card_flag;
            private int bind_mobile_flag;
            private double limit_day;
            private double limit_single;
            private String mobile;
            private int open_account_flag;
            private String realname;
            private int risk_rating_flag;
            private int set_auto_buy_bid_flag;
            private int set_hand_password_flag;
            private int set_login_password_flag;
            private int set_password_flag;
            private String third_user_id;
            private String user_code;
            private String user_id;

            public String getBank_card_no() {
                return bank_card_no;
            }

            public void setBank_card_no(String bank_card_no) {
                this.bank_card_no = bank_card_no;
            }

            public String getBank_name() {
                return bank_name;
            }

            public void setBank_name(String bank_name) {
                this.bank_name = bank_name;
            }

            public String getBank_no() {
                return bank_no;
            }

            public void setBank_no(String bank_no) {
                this.bank_no = bank_no;
            }

            public int getBind_bank_card_flag() {
                return bind_bank_card_flag;
            }

            public void setBind_bank_card_flag(int bind_bank_card_flag) {
                this.bind_bank_card_flag = bind_bank_card_flag;
            }

            public int getBind_mobile_flag() {
                return bind_mobile_flag;
            }

            public void setBind_mobile_flag(int bind_mobile_flag) {
                this.bind_mobile_flag = bind_mobile_flag;
            }

            public double getLimit_day() {
                return limit_day;
            }

            public void setLimit_day(double limit_day) {
                this.limit_day = limit_day;
            }

            public double getLimit_single() {
                return limit_single;
            }

            public void setLimit_single(double limit_single) {
                this.limit_single = limit_single;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public int getOpen_account_flag() {
                return open_account_flag;
            }

            public void setOpen_account_flag(int open_account_flag) {
                this.open_account_flag = open_account_flag;
            }

            public String getRealname() {
                return realname;
            }

            public void setRealname(String realname) {
                this.realname = realname;
            }

            public int getRisk_rating_flag() {
                return risk_rating_flag;
            }

            public void setRisk_rating_flag(int risk_rating_flag) {
                this.risk_rating_flag = risk_rating_flag;
            }

            public int getSet_auto_buy_bid_flag() {
                return set_auto_buy_bid_flag;
            }

            public void setSet_auto_buy_bid_flag(int set_auto_buy_bid_flag) {
                this.set_auto_buy_bid_flag = set_auto_buy_bid_flag;
            }

            public int getSet_hand_password_flag() {
                return set_hand_password_flag;
            }

            public void setSet_hand_password_flag(int set_hand_password_flag) {
                this.set_hand_password_flag = set_hand_password_flag;
            }

            public int getSet_login_password_flag() {
                return set_login_password_flag;
            }

            public void setSet_login_password_flag(int set_login_password_flag) {
                this.set_login_password_flag = set_login_password_flag;
            }

            public int getSet_password_flag() {
                return set_password_flag;
            }

            public void setSet_password_flag(int set_password_flag) {
                this.set_password_flag = set_password_flag;
            }

            public String getThird_user_id() {
                return third_user_id;
            }

            public void setThird_user_id(String third_user_id) {
                this.third_user_id = third_user_id;
            }

            public String getUser_code() {
                return user_code;
            }

            public void setUser_code(String user_code) {
                this.user_code = user_code;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }
        }
    }
}

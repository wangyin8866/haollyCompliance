package com.haolyy.compliance.entity.home;

import java.io.Serializable;

/**
 * Created by User on 2017/7/12.
 */

public class UserInfoBean  implements Serializable{
    private static final long serialVersionUID = 7247714666080613254L;

    /**
     * code : 200
     * msg : 成功
     * model : {"code":"200","msg":"成功","model":{"cumulative_income":"2,000.00","user_head_photo":"","coupon":"3","mobile":"176****0704","is_password":0,"message":0,"set_hand_password_flag":"0","is_auto_tender":1,"set_login_password_flag":"1","point":"520","cumulative_award":"1,500.00","bind_mobile_flag":"1","yesterday_income":"200.00","risk_level":0,"bind_bank_card_flag":"1","frozen_amount":"0.00","task":"5","total_amount":"0.00","vip_level":"3","available_credit":"0.00","status":"0"}}
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
         * model : {"cumulative_income":"2,000.00","user_head_photo":"","coupon":"3","mobile":"176****0704","is_password":0,"message":0,"set_hand_password_flag":"0","is_auto_tender":1,"set_login_password_flag":"1","point":"520","cumulative_award":"1,500.00","bind_mobile_flag":"1","yesterday_income":"200.00","risk_level":0,"bind_bank_card_flag":"1","frozen_amount":"0.00","task":"5","total_amount":"0.00","vip_level":"3","available_credit":"0.00","status":"0"}
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
             * cumulative_income : 2,000.00
             * user_head_photo :
             * coupon : 3
             * mobile : 176****0704
             * is_password : 0
             * message : 0
             * set_hand_password_flag : 0
             * is_auto_tender : 1
             * set_login_password_flag : 1
             * point : 520
             * cumulative_award : 1,500.00
             * bind_mobile_flag : 1
             * yesterday_income : 200.00
             * risk_level : 0
             * bind_bank_card_flag : 1
             * frozen_amount : 0.00
             * task : 5
             * total_amount : 0.00
             * vip_level : 3
             * available_credit : 0.00
             * status : 0
             */

            private String cumulative_income;
            private String user_head_photo;
            private String coupon;
            private String mobile;
            private int is_password;
            private int message;
            private String set_hand_password_flag;
            private int is_auto_tender;
            private String set_login_password_flag;
            private String point;
            private String cumulative_award;
            private String bind_mobile_flag;
            private String yesterday_income;
            private int risk_level;
            private String bind_bank_card_flag;
            private String frozen_amount;
            private String task;
            private String total_amount;
            private String vip_level;
            private String available_credit;
            private String status;

            public String getCumulative_income() {
                return cumulative_income;
            }

            public void setCumulative_income(String cumulative_income) {
                this.cumulative_income = cumulative_income;
            }

            public String getUser_head_photo() {
                return user_head_photo;
            }

            public void setUser_head_photo(String user_head_photo) {
                this.user_head_photo = user_head_photo;
            }

            public String getCoupon() {
                return coupon;
            }

            public void setCoupon(String coupon) {
                this.coupon = coupon;
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

            public int getMessage() {
                return message;
            }

            public void setMessage(int message) {
                this.message = message;
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

            public String getPoint() {
                return point;
            }

            public void setPoint(String point) {
                this.point = point;
            }

            public String getCumulative_award() {
                return cumulative_award;
            }

            public void setCumulative_award(String cumulative_award) {
                this.cumulative_award = cumulative_award;
            }

            public String getBind_mobile_flag() {
                return bind_mobile_flag;
            }

            public void setBind_mobile_flag(String bind_mobile_flag) {
                this.bind_mobile_flag = bind_mobile_flag;
            }

            public String getYesterday_income() {
                return yesterday_income;
            }

            public void setYesterday_income(String yesterday_income) {
                this.yesterday_income = yesterday_income;
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

            public String getFrozen_amount() {
                return frozen_amount;
            }

            public void setFrozen_amount(String frozen_amount) {
                this.frozen_amount = frozen_amount;
            }

            public String getTask() {
                return task;
            }

            public void setTask(String task) {
                this.task = task;
            }

            public String getTotal_amount() {
                return total_amount;
            }

            public void setTotal_amount(String total_amount) {
                this.total_amount = total_amount;
            }

            public String getVip_level() {
                return vip_level;
            }

            public void setVip_level(String vip_level) {
                this.vip_level = vip_level;
            }

            public String getAvailable_credit() {
                return available_credit;
            }

            public void setAvailable_credit(String available_credit) {
                this.available_credit = available_credit;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }
        }
    }
}

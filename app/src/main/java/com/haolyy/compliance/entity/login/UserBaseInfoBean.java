package com.haolyy.compliance.entity.login;

/**
 * Created by niudeyang on 2017/7/17.
 */

public class UserBaseInfoBean {
    /**
     * code : 200
     * msg : 成功
     * model : {"availableCredit":900,"bankCardNo":"622822*********0250","mobile":"15001231060","limitSingle":"2000000000.00","bankName":"农业银行","limitDay":"2000000000.00","idNo":"131181********5657","frozenAmount":100,"realName":"季淼","totalAmount":1000,"userMobile":"15001231060","bankNo":"101","mapUrl":"http://192.168.7.114/pictures/color/ABC.png"}
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
         * availableCredit : 900.0
         * bankCardNo : 622822*********0250
         * mobile : 15001231060
         * limitSingle : 2000000000.00
         * bankName : 农业银行
         * limitDay : 2000000000.00
         * idNo : 131181********5657
         * frozenAmount : 100.0
         * realName : 季淼
         * totalAmount : 1000.0
         * userMobile : 15001231060
         * bankNo : 101
         * mapUrl : http://192.168.7.114/pictures/color/ABC.png
         */

        private double availableCredit;
        private String bankCardNo;
        private String mobile;
        private String limitSingle;
        private String bankName;
        private String limitDay;
        private String idNo;
        private double frozenAmount;
        private String realName;
        private double totalAmount;
        private String userMobile;
        private String bankNo;
        private String mapUrl;

        public double getAvailableCredit() {
            return availableCredit;
        }

        public void setAvailableCredit(double availableCredit) {
            this.availableCredit = availableCredit;
        }

        public String getBankCardNo() {
            return bankCardNo;
        }

        public void setBankCardNo(String bankCardNo) {
            this.bankCardNo = bankCardNo;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getLimitSingle() {
            return limitSingle;
        }

        public void setLimitSingle(String limitSingle) {
            this.limitSingle = limitSingle;
        }

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        public String getLimitDay() {
            return limitDay;
        }

        public void setLimitDay(String limitDay) {
            this.limitDay = limitDay;
        }

        public String getIdNo() {
            return idNo;
        }

        public void setIdNo(String idNo) {
            this.idNo = idNo;
        }

        public double getFrozenAmount() {
            return frozenAmount;
        }

        public void setFrozenAmount(double frozenAmount) {
            this.frozenAmount = frozenAmount;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public double getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
        }

        public String getUserMobile() {
            return userMobile;
        }

        public void setUserMobile(String userMobile) {
            this.userMobile = userMobile;
        }

        public String getBankNo() {
            return bankNo;
        }

        public void setBankNo(String bankNo) {
            this.bankNo = bankNo;
        }

        public String getMapUrl() {
            return mapUrl;
        }

        public void setMapUrl(String mapUrl) {
            this.mapUrl = mapUrl;
        }
    }
}

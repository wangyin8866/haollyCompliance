package com.haolyy.compliance.entity.bank;

/**
 * Created by niudeyang on 2017/6/30.
 */

public class RechargeBean {

    /**
     * data : {"message":"成功","status":"1"}
     * status : 1
     */

    private DataBean data;
    private String status;

    public String getMessage() {
        return message;
    }

    private String message;
    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class DataBean {
        /**
         * message : 成功
         * status : 1
         */

        private String message;
        private String status;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}

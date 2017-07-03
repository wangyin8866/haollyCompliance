package com.haolyy.compliance.entity.bank;

/**
 * Created by niudeyang on 2017/6/30.
 */

public class IsActivateBean {

    /**
     * data : {"message":"未开户","type":"1"}
     * msg : 系统正常
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
         * message : 未开户
         * type : 1
         */

        private String message;
        private String type;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}

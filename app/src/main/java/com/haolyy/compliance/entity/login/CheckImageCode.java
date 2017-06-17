package com.haolyy.compliance.entity.login;

/**
 * Created by niudeyang on 2017/6/15.
 */

public class CheckImageCode {

    /**
     * data : {"msg":"图形验证码失效","status":"10101"}
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
         * msg : 图形验证码失效
         * status : 10101
         */

        private String msg;
        private String status;

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
    }
}

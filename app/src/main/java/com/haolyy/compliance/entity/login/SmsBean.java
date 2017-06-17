package com.haolyy.compliance.entity.login;

/**
 * Created by niudeyang on 2017/6/15.
 */

public class SmsBean {

    /**
     * msg : 系统正常
     * data : {"msg":"业务正常","data":{"smsCode":"762608","mobile":"13821882946"},"status":"200"}
     * status : 200
     */

    private String msg;
    private DataBeanX data;
    private String status;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class DataBeanX {
        /**
         * msg : 业务正常
         * data : {"smsCode":"762608","mobile":"13821882946"}
         * status : 200
         */

        private String msg;
        private DataBean data;
        private String status;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

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
             * smsCode : 762608
             * mobile : 13821882946
             */

            private String smsCode;
            private String mobile;

            public String getSmsCode() {
                return smsCode;
            }

            public void setSmsCode(String smsCode) {
                this.smsCode = smsCode;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }
        }
    }
}

package com.haolyy.compliance.entity.login;

/**
 * Created by niudeyang on 2017/6/15.
 */

public class SmsBean {

    /**
     * data : {"data":{"mobile":"13821882945","smsCode":"482821"},"msg":"业务正常","status":"200"}
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
         * data : {"mobile":"13821882945","smsCode":"482821"}
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
             * mobile : 13821882945
             * smsCode : 482821
             */

            private String mobile;
            private String smsCode;

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getSmsCode() {
                return smsCode;
            }

            public void setSmsCode(String smsCode) {
                this.smsCode = smsCode;
            }
        }
    }
}

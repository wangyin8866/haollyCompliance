package com.haolyy.compliance.entity.login;

/**
 * Created by niudeyang on 2017/6/15.
 */

public class RegisterBean {

    /**
     * data : {"data":{"platform":"haolyy","userCode":"44c9d89d"},"msg":"业务正常","status":"200"}
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
         * data : {"platform":"haolyy","userCode":"44c9d89d"}
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
             * platform : haolyy
             * userCode : 44c9d89d
             */

            private String platform;
            private String userCode;

            public String getPlatform() {
                return platform;
            }

            public void setPlatform(String platform) {
                this.platform = platform;
            }

            public String getUserCode() {
                return userCode;
            }

            public void setUserCode(String userCode) {
                this.userCode = userCode;
            }
        }
    }
}

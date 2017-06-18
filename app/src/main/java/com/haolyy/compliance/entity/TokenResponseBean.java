package com.haolyy.compliance.entity;


/**
 * Created by William on 2017/1/9.
 */

public class TokenResponseBean  {


    /**
     * data : {"data":{"token":"c8a854f8-9060-4bfe-b6e0-2e66bae1b8f2"},"msg":"token获取成功","status":"401"}
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
         * data : {"token":"c8a854f8-9060-4bfe-b6e0-2e66bae1b8f2"}
         * msg : token获取成功
         * status : 401
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
             * token : c8a854f8-9060-4bfe-b6e0-2e66bae1b8f2
             */

            private String token;

            public String getToken() {
                return token;
            }

            public void setToken(String token) {
                this.token = token;
            }
        }
    }
}

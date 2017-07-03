package com.haolyy.compliance.entity.login;


/**
 * Created by LL on 2017/1/9.
 */

public class LoginResponseBean{


    /**
     * data : {"data":{"lastLoginIp":"192.168.11.236","lastLoginTime":"2017-07-03 10:49:30","mobile":"13821882946","platform":1,"registTime":"2017-06-20 17:11:40","registerCode":"1236555","status":1,"userCode":"09755328","userId":65},"msg":"业务正常","status":"200"}
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
         * data : {"lastLoginIp":"192.168.11.236","lastLoginTime":"2017-07-03 10:49:30","mobile":"13821882946","platform":1,"registTime":"2017-06-20 17:11:40","registerCode":"1236555","status":1,"userCode":"09755328","userId":65}
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
             * lastLoginIp : 192.168.11.236
             * lastLoginTime : 2017-07-03 10:49:30
             * mobile : 13821882946
             * platform : 1
             * registTime : 2017-06-20 17:11:40
             * registerCode : 1236555
             * status : 1
             * userCode : 09755328
             * userId : 65
             */

            private String lastLoginIp;
            private String lastLoginTime;
            private String mobile;
            private int platform;
            private String registTime;
            private String registerCode;
            private int status;
            private String userCode;
            private int userId;

            public String getLastLoginIp() {
                return lastLoginIp;
            }

            public void setLastLoginIp(String lastLoginIp) {
                this.lastLoginIp = lastLoginIp;
            }

            public String getLastLoginTime() {
                return lastLoginTime;
            }

            public void setLastLoginTime(String lastLoginTime) {
                this.lastLoginTime = lastLoginTime;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public int getPlatform() {
                return platform;
            }

            public void setPlatform(int platform) {
                this.platform = platform;
            }

            public String getRegistTime() {
                return registTime;
            }

            public void setRegistTime(String registTime) {
                this.registTime = registTime;
            }

            public String getRegisterCode() {
                return registerCode;
            }

            public void setRegisterCode(String registerCode) {
                this.registerCode = registerCode;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getUserCode() {
                return userCode;
            }

            public void setUserCode(String userCode) {
                this.userCode = userCode;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }
        }
    }
}

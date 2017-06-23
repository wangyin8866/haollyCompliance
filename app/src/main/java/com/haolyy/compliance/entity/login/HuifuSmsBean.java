package com.haolyy.compliance.entity.login;

/**
 * Created by niudeyang on 2017/6/21.
 */

public class HuifuSmsBean {


    /**
     * data : {"data":{"RespCode":"000","RespDesc":"??","SmsSeq":"i4721K7E"},"msg":"??","status":"000"}
     * msg : ????
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
         * data : {"RespCode":"000","RespDesc":"??","SmsSeq":"i4721K7E"}
         * msg : ??
         * status : 000
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
             * RespCode : 000
             * RespDesc : ??
             * SmsSeq : i4721K7E
             */

            private String RespCode;
            private String RespDesc;
            private String SmsSeq;

            public String getRespCode() {
                return RespCode;
            }

            public void setRespCode(String RespCode) {
                this.RespCode = RespCode;
            }

            public String getRespDesc() {
                return RespDesc;
            }

            public void setRespDesc(String RespDesc) {
                this.RespDesc = RespDesc;
            }

            public String getSmsSeq() {
                return SmsSeq;
            }

            public void setSmsSeq(String SmsSeq) {
                this.SmsSeq = SmsSeq;
            }
        }
    }
}

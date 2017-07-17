package com.haolyy.compliance.entity.login;

/**
 * Created by niudeyang on 2017/6/21.
 */

public class HuifuSmsBean {


    /**
     * data : {"data":{"RespCode":"000","RespDesc":"??","SmsSeq":"i4721K7E"},"msg":"??","status":"000"}
     * msg : ????
     * code : 200
     */

    private DataBeanX model;
    private String msg;
    private String code;

    public DataBeanX getModel() {
        return model;
    }

    public void setModel(DataBeanX model) {
        this.model = model;
    }

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


    public static class DataBeanX {

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


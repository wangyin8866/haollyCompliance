package com.haolyy.compliance.entity.bank;

/**
 * Created by niudeyang on 2017/7/25.
 */

public class QuikBindBean {

    /**
     * code : 200
     * msg : 成功
     * model : {"RespCode":"599","RespDesc":"7天内存在快捷充值交易，不满足换绑卡条件"}
     */

    private String code;
    private String msg;
    private ModelBean model;

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

    public ModelBean getModel() {
        return model;
    }

    public void setModel(ModelBean model) {
        this.model = model;
    }

    public static class ModelBean {
        /**
         * RespCode : 599
         * RespDesc : 7天内存在快捷充值交易，不满足换绑卡条件
         */

        private String RespCode;
        private String RespDesc;

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
    }
}

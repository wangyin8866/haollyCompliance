package com.haolyy.compliance.entity.bank;

/**
 * Created by niudeyang on 2017/6/30.
 */

public class RechargeBean {
    /**
     * mode: {"amount_":"1000.00","code":"1","msg":"成功"}
     * msg : 系统正常
     * status : 200
     */

    private DataBean model;
    private String msg;
    private String code;

    public DataBean getModel() {
        return model;
    }

    public void setModel(DataBean model) {
        this.model = model;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static class DataBean {
        /**
         * amount_ : 1000.00
         * code : 1
         * msg : 成功
         */

        private String amount_;
        private String code;
        private String msg;

        public String getAmount_() {
            return amount_;
        }

        public void setAmount_(String amount_) {
            this.amount_ = amount_;
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
    }
}

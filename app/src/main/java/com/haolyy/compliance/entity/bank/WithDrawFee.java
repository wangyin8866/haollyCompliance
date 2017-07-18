package com.haolyy.compliance.entity.bank;

/**
 * Created by niudeyang on 2017/7/5.
 */

public class WithDrawFee {

    /**
     * data : {"fee":3}
     * msg : 系统正常
     * status : 200
     */

    private DataBean model;
    private String msg;
    private String code;


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getModel() {
        return model;
    }

    public void setModel(DataBean model) {
        this.model = model;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static class DataBean {
        /**
         * fee : 3.0
         */

        private double fee;

        public double getFee() {
            return fee;
        }

        public void setFee(double fee) {
            this.fee = fee;
        }
    }
}

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

package com.haolyy.compliance.entity.product;

/**
 * Created by wangyin on 2017/7/18.
 */

public class Earnings  {

    /**
     * code : 200
     * msg : 预收益计算成功
     * model : {"expectedRevenue":100.9}
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
         * expectedRevenue : 100.9
         */

        private double expectedRevenue;

        public double getExpectedRevenue() {
            return expectedRevenue;
        }

        public void setExpectedRevenue(double expectedRevenue) {
            this.expectedRevenue = expectedRevenue;
        }
    }
}

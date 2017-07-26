package com.haolyy.compliance.entity.bank;

/**
 * Created by niudeyang on 2017/7/24.
 */

public class IsWithDrawSuccess {


    /**
     * code : 200
     * msg : 成功
     * model : {"amonut":1000,"msg":"取现成功!","code":"1","createTime":"2017-07-25 19:27:37"}
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
         * amonut : 1000.0
         * msg : 取现成功!
         * code : 1
         * createTime : 2017-07-25 19:27:37
         */

        private double amonut;
        private String msg;
        private String code;
        private String createTime;

        public double getAmonut() {
            return amonut;
        }

        public void setAmonut(double amonut) {
            this.amonut = amonut;
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

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }
    }
}

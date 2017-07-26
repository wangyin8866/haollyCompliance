package com.haolyy.compliance.entity.login;

/**
 * Created by niudeyang on 2017/7/26.
 */

public class ValidateCode {

    /**
     * code : 200
     * msg : 成功
     * model : {"code":"200","msg":"成功","model":"成功"}
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
         * code : 200
         * msg : 成功
         * model : 成功
         */

        private String code;
        private String msg;
        private String model;

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

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }
    }
}

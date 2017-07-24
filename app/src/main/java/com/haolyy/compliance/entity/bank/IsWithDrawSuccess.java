package com.haolyy.compliance.entity.bank;

/**
 * Created by niudeyang on 2017/7/24.
 */

public class IsWithDrawSuccess {

    /**
     * code : 200
     * msg : 成功
     * model : {"msg":"取现失败:今日可取现余额不足","code":"100"}
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
         * msg : 取现失败:今日可取现余额不足
         * code : 100
         */

        private String msg;
        private String code;

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
    }
}

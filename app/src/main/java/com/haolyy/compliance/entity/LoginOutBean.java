package com.haolyy.compliance.entity;


/**
 * Created by William on 2017/1/9.
 */

public class LoginOutBean {

    private Token model;
    private String msg;
    private String code;

    public Token getModel() {
        return model;
    }

    public void setModel(Token model) {
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

    public static class Token {

        private String code;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }
}

package com.haolyy.compliance.entity;


/**
 * Created by William on 2017/1/9.
 */

public class TokenResponseBean  {


    /**
     * data : {"code":"200","msg":"成功","model":{"token":"8b79e3ba45e844f594379afc81c40b96"}}
     * msg : 系统正常
     * status : 200
     */

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
        /**
         * data : {"token":"c8a854f8-9060-4bfe-b6e0-2e66bae1b8f2"}
         * msg : token获取成功
         * status : 401
         */
        private String token;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }


    }
}

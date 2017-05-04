package com.haolyy.compliance.entity;

/**
 * Created by niudeyang on 2017/5/4.
 */

public class ErrorResponse {

    /**
     * error_response : {"code":"err.sys.100","summary":"合规系统错误"}
     */

    private ErrorResponseBean error_response;

    public ErrorResponseBean getError_response() {
        return error_response;
    }


    public static class ErrorResponseBean {
        /**
         * code : err.sys.100
         * summary : 合规系统错误
         */

        private String code;
        private String summary;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }
    }
}

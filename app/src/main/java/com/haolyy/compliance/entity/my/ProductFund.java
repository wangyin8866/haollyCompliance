package com.haolyy.compliance.entity.my;

import java.util.List;

/**
 * Created by wangyin on 2017/7/15.
 */

public class ProductFund {

    /**
     * code : 200
     * msg : 成功
     * model : {"code":"200","msg":"成功","model":{"productFunds":[{"holdAmount":"375,000.00","firstCategory":"DQY","id":"1","projectName":"短期赢"},{"holdAmount":"0.00","firstCategory":"YJH","id":"2","projectName":"赢计划"},{"holdAmount":"279,000.00","firstCategory":"YXJH","id":"3","projectName":"优+计划"}]}}
     */

    private String code;
    private String msg;
    private ModelBeanX model;

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

    public ModelBeanX getModel() {
        return model;
    }

    public void setModel(ModelBeanX model) {
        this.model = model;
    }

    public static class ModelBeanX {
        /**
         * code : 200
         * msg : 成功
         * model : {"productFunds":[{"holdAmount":"375,000.00","firstCategory":"DQY","id":"1","projectName":"短期赢"},{"holdAmount":"0.00","firstCategory":"YJH","id":"2","projectName":"赢计划"},{"holdAmount":"279,000.00","firstCategory":"YXJH","id":"3","projectName":"优+计划"}]}
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
            private List<ProductFundsBean> productFunds;

            public List<ProductFundsBean> getProductFunds() {
                return productFunds;
            }

            public void setProductFunds(List<ProductFundsBean> productFunds) {
                this.productFunds = productFunds;
            }

            public static class ProductFundsBean {
                /**
                 * holdAmount : 375,000.00
                 * firstCategory : DQY
                 * id : 1
                 * projectName : 短期赢
                 */

                private String holdAmount;
                private String firstCategory;
                private String id;
                private String projectName;

                public String getHoldAmount() {
                    return holdAmount;
                }

                public void setHoldAmount(String holdAmount) {
                    this.holdAmount = holdAmount;
                }

                public String getFirstCategory() {
                    return firstCategory;
                }

                public void setFirstCategory(String firstCategory) {
                    this.firstCategory = firstCategory;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getProjectName() {
                    return projectName;
                }

                public void setProjectName(String projectName) {
                    this.projectName = projectName;
                }
            }
        }
    }
}

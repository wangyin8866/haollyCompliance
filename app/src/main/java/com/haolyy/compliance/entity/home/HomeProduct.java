package com.haolyy.compliance.entity.home;

import java.util.List;

/**
 * Created by wangyin on 2017/6/29.
 * 首页产品
 */

public class HomeProduct {
    /**
     * code : 200
     * msg : 成功
     * model : {"code":"200","msg":"成功","model":[{"appendRate":"1.00","amountScale":"0.00","investMinAmount":1000,"amount":"2.00","annualizedRate":"11.00","contractAmount":"50,000.00","periodLength":3,"periodUnit":3,"productName":"www"},{"appendRate":"1.00","amountScale":"0.01","investMinAmount":1000,"amount":"3.00","annualizedRate":"10.00","contractAmount":"50,000.00","periodLength":6,"periodUnit":3,"productName":"表弟222"},{"appendRate":"1.00","amountScale":"0.01","investMinAmount":10000,"amount":"1.00","annualizedRate":"11.00","contractAmount":"10,000.00","periodLength":12,"periodUnit":3,"productName":"短期赢0000030"}]}
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
         * model : [{"appendRate":"1.00","amountScale":"0.00","investMinAmount":1000,"amount":"2.00","annualizedRate":"11.00","contractAmount":"50,000.00","periodLength":3,"periodUnit":3,"productName":"www"},{"appendRate":"1.00","amountScale":"0.01","investMinAmount":1000,"amount":"3.00","annualizedRate":"10.00","contractAmount":"50,000.00","periodLength":6,"periodUnit":3,"productName":"表弟222"},{"appendRate":"1.00","amountScale":"0.01","investMinAmount":10000,"amount":"1.00","annualizedRate":"11.00","contractAmount":"10,000.00","periodLength":12,"periodUnit":3,"productName":"短期赢0000030"}]
         */

        private String code;
        private String msg;
        private List<ModelBean> model;

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

        public List<ModelBean> getModel() {
            return model;
        }

        public void setModel(List<ModelBean> model) {
            this.model = model;
        }

        public static class ModelBean {
            /**
             * appendRate : 1.00
             * amountScale : 0.00
             * investMinAmount : 1000.0
             * amount : 2.00
             * annualizedRate : 11.00
             * contractAmount : 50,000.00
             * periodLength : 3
             * periodUnit : 3
             * productName : www
             */

            private String appendRate;
            private String amountScale;
            private double investMinAmount;
            private String amount;
            private String annualizedRate;
            private String contractAmount;
            private int periodLength;
            private int periodUnit;
            private String productName;

            public String getAppendRate() {
                return appendRate;
            }

            public void setAppendRate(String appendRate) {
                this.appendRate = appendRate;
            }

            public String getAmountScale() {
                return amountScale;
            }

            public void setAmountScale(String amountScale) {
                this.amountScale = amountScale;
            }

            public double getInvestMinAmount() {
                return investMinAmount;
            }

            public void setInvestMinAmount(double investMinAmount) {
                this.investMinAmount = investMinAmount;
            }

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }

            public String getAnnualizedRate() {
                return annualizedRate;
            }

            public void setAnnualizedRate(String annualizedRate) {
                this.annualizedRate = annualizedRate;
            }

            public String getContractAmount() {
                return contractAmount;
            }

            public void setContractAmount(String contractAmount) {
                this.contractAmount = contractAmount;
            }

            public int getPeriodLength() {
                return periodLength;
            }

            public void setPeriodLength(int periodLength) {
                this.periodLength = periodLength;
            }

            public int getPeriodUnit() {
                return periodUnit;
            }

            public void setPeriodUnit(int periodUnit) {
                this.periodUnit = periodUnit;
            }

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }
        }
    }
}

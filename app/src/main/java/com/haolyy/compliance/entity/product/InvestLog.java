package com.haolyy.compliance.entity.product;

import java.util.List;

/**
 * Created by wangyin on 2017/5/22.
 */

public class InvestLog {
    /**
     * code : 200
     * msg : 成功
     * model : {"code":"200","msg":"成功","model":{"pageSum":1,"investmentRecordList":[{"createTime":"2017-07-11 10:27:06","inverstSuccessAmount":"13,000.00","client":"ANDROID","deposit_mobile":"18500002339"}]}}
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
         * model : {"pageSum":1,"investmentRecordList":[{"createTime":"2017-07-11 10:27:06","inverstSuccessAmount":"13,000.00","client":"ANDROID","deposit_mobile":"18500002339"}]}
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
             * pageSum : 1
             * investmentRecordList : [{"createTime":"2017-07-11 10:27:06","inverstSuccessAmount":"13,000.00","client":"ANDROID","deposit_mobile":"18500002339"}]
             */

            private int pageSum;
            private List<InvestmentRecordListBean> investmentRecordList;

            public int getPageSum() {
                return pageSum;
            }

            public void setPageSum(int pageSum) {
                this.pageSum = pageSum;
            }

            public List<InvestmentRecordListBean> getInvestmentRecordList() {
                return investmentRecordList;
            }

            public void setInvestmentRecordList(List<InvestmentRecordListBean> investmentRecordList) {
                this.investmentRecordList = investmentRecordList;
            }

            public static class InvestmentRecordListBean {
                /**
                 * createTime : 2017-07-11 10:27:06
                 * inverstSuccessAmount : 13,000.00
                 * client : ANDROID
                 * deposit_mobile : 18500002339
                 */

                private String createTime;
                private String inverstSuccessAmount;
                private String client;
                private String deposit_mobile;

                public String getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(String createTime) {
                    this.createTime = createTime;
                }

                public String getInverstSuccessAmount() {
                    return inverstSuccessAmount;
                }

                public void setInverstSuccessAmount(String inverstSuccessAmount) {
                    this.inverstSuccessAmount = inverstSuccessAmount;
                }

                public String getClient() {
                    return client;
                }

                public void setClient(String client) {
                    this.client = client;
                }

                public String getDeposit_mobile() {
                    return deposit_mobile;
                }

                public void setDeposit_mobile(String deposit_mobile) {
                    this.deposit_mobile = deposit_mobile;
                }
            }
        }
    }
}

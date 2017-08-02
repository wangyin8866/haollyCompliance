package com.haolyy.compliance.entity.product;

import java.util.List;

/**
 * Created by wangyin on 2017/5/22.
 */

public class InvestLog {
    /**
     * code : 200
     * msg : 成功
     * model : {"code":"200","msg":"成功","model":{"pageSum":2,"investmentRecordList":[{"createTime":"2017-08-01 17:22:26","mobile":"15001231060","inverstSuccessAmount":"100.00","client":"ANDROID"},{"createTime":"2017-08-01 13:55:19","mobile":"18000000001","inverstSuccessAmount":"500.00","client":"PC"},{"createTime":"2017-07-31 19:28:56","mobile":"15001231062","inverstSuccessAmount":"1,000.00","client":"PC"},{"createTime":"2017-07-31 15:05:12","mobile":"17000000005","inverstSuccessAmount":"100.00","client":"WECHAT"},{"createTime":"2017-07-31 15:03:44","mobile":"17000000005","inverstSuccessAmount":"100.00","client":"WECHAT"},{"createTime":"2017-07-31 15:03:41","mobile":"17000000005","inverstSuccessAmount":"100.00","client":"WECHAT"},{"createTime":"2017-07-31 15:03:32","mobile":"17000000005","inverstSuccessAmount":"100.00","client":"WECHAT"},{"createTime":"2017-07-31 10:19:09","mobile":"18221740013","inverstSuccessAmount":"1,000.00","client":"IOS"},{"createTime":"2017-07-28 21:07:00","mobile":"15001234003","inverstSuccessAmount":"100.00","client":"IOS"},{"createTime":"2017-07-28 20:52:55","mobile":"15001234003","inverstSuccessAmount":"100.00","client":"IOS"}]}}
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
         * model : {"pageSum":2,"investmentRecordList":[{"createTime":"2017-08-01 17:22:26","mobile":"15001231060","inverstSuccessAmount":"100.00","client":"ANDROID"},{"createTime":"2017-08-01 13:55:19","mobile":"18000000001","inverstSuccessAmount":"500.00","client":"PC"},{"createTime":"2017-07-31 19:28:56","mobile":"15001231062","inverstSuccessAmount":"1,000.00","client":"PC"},{"createTime":"2017-07-31 15:05:12","mobile":"17000000005","inverstSuccessAmount":"100.00","client":"WECHAT"},{"createTime":"2017-07-31 15:03:44","mobile":"17000000005","inverstSuccessAmount":"100.00","client":"WECHAT"},{"createTime":"2017-07-31 15:03:41","mobile":"17000000005","inverstSuccessAmount":"100.00","client":"WECHAT"},{"createTime":"2017-07-31 15:03:32","mobile":"17000000005","inverstSuccessAmount":"100.00","client":"WECHAT"},{"createTime":"2017-07-31 10:19:09","mobile":"18221740013","inverstSuccessAmount":"1,000.00","client":"IOS"},{"createTime":"2017-07-28 21:07:00","mobile":"15001234003","inverstSuccessAmount":"100.00","client":"IOS"},{"createTime":"2017-07-28 20:52:55","mobile":"15001234003","inverstSuccessAmount":"100.00","client":"IOS"}]}
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
             * pageSum : 2
             * investmentRecordList : [{"createTime":"2017-08-01 17:22:26","mobile":"15001231060","inverstSuccessAmount":"100.00","client":"ANDROID"},{"createTime":"2017-08-01 13:55:19","mobile":"18000000001","inverstSuccessAmount":"500.00","client":"PC"},{"createTime":"2017-07-31 19:28:56","mobile":"15001231062","inverstSuccessAmount":"1,000.00","client":"PC"},{"createTime":"2017-07-31 15:05:12","mobile":"17000000005","inverstSuccessAmount":"100.00","client":"WECHAT"},{"createTime":"2017-07-31 15:03:44","mobile":"17000000005","inverstSuccessAmount":"100.00","client":"WECHAT"},{"createTime":"2017-07-31 15:03:41","mobile":"17000000005","inverstSuccessAmount":"100.00","client":"WECHAT"},{"createTime":"2017-07-31 15:03:32","mobile":"17000000005","inverstSuccessAmount":"100.00","client":"WECHAT"},{"createTime":"2017-07-31 10:19:09","mobile":"18221740013","inverstSuccessAmount":"1,000.00","client":"IOS"},{"createTime":"2017-07-28 21:07:00","mobile":"15001234003","inverstSuccessAmount":"100.00","client":"IOS"},{"createTime":"2017-07-28 20:52:55","mobile":"15001234003","inverstSuccessAmount":"100.00","client":"IOS"}]
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
                 * createTime : 2017-08-01 17:22:26
                 * mobile : 15001231060
                 * inverstSuccessAmount : 100.00
                 * client : ANDROID
                 */

                private String createTime;
                private String mobile;
                private String inverstSuccessAmount;
                private String client;

                public String getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(String createTime) {
                    this.createTime = createTime;
                }

                public String getMobile() {
                    return mobile;
                }

                public void setMobile(String mobile) {
                    this.mobile = mobile;
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
            }
        }
    }
}

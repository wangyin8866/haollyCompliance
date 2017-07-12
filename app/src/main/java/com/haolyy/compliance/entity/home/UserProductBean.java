package com.haolyy.compliance.entity.home;

import java.util.List;

/**
 * Created by User on 2017/7/12.
 */

public class UserProductBean {


    /**
     * code : 200
     * msg : 成功
     * model : {"code":"200","msg":"成功","model":{"holdProductList":[{"proportion":30,"cumulative_profit":"88.00","hold_amount":"10,000.00","hold_count":1,"product_no":"XFD","product_name":"消费贷"},{"proportion":30,"cumulative_profit":"99.00","hold_amount":"10,000.00","hold_count":1,"product_no":"DQYC","product_name":"短期赢C"},{"proportion":40,"cumulative_profit":"112.00","hold_amount":"12,000.00","hold_count":1,"product_no":"YJHD","product_name":"赢计划D"}],"frozen_balance":"","available_balance":""}}
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
         * model : {"holdProductList":[{"proportion":30,"cumulative_profit":"88.00","hold_amount":"10,000.00","hold_count":1,"product_no":"XFD","product_name":"消费贷"},{"proportion":30,"cumulative_profit":"99.00","hold_amount":"10,000.00","hold_count":1,"product_no":"DQYC","product_name":"短期赢C"},{"proportion":40,"cumulative_profit":"112.00","hold_amount":"12,000.00","hold_count":1,"product_no":"YJHD","product_name":"赢计划D"}],"frozen_balance":"","available_balance":""}
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
             * holdProductList : [{"proportion":30,"cumulative_profit":"88.00","hold_amount":"10,000.00","hold_count":1,"product_no":"XFD","product_name":"消费贷"},{"proportion":30,"cumulative_profit":"99.00","hold_amount":"10,000.00","hold_count":1,"product_no":"DQYC","product_name":"短期赢C"},{"proportion":40,"cumulative_profit":"112.00","hold_amount":"12,000.00","hold_count":1,"product_no":"YJHD","product_name":"赢计划D"}]
             * frozen_balance :
             * available_balance :
             */

            private String frozen_balance;
            private String available_balance;
            private List<HoldProductListBean> holdProductList;

            public String getFrozen_balance() {
                return frozen_balance;
            }

            public void setFrozen_balance(String frozen_balance) {
                this.frozen_balance = frozen_balance;
            }

            public String getAvailable_balance() {
                return available_balance;
            }

            public void setAvailable_balance(String available_balance) {
                this.available_balance = available_balance;
            }

            public List<HoldProductListBean> getHoldProductList() {
                return holdProductList;
            }

            public void setHoldProductList(List<HoldProductListBean> holdProductList) {
                this.holdProductList = holdProductList;
            }

            public static class HoldProductListBean {
                /**
                 * proportion : 30.0
                 * cumulative_profit : 88.00
                 * hold_amount : 10,000.00
                 * hold_count : 1
                 * product_no : XFD
                 * product_name : 消费贷
                 */

                private double proportion;
                private String cumulative_profit;
                private String hold_amount;
                private int hold_count;
                private String product_no;
                private String product_name;

                public double getProportion() {
                    return proportion;
                }

                public void setProportion(double proportion) {
                    this.proportion = proportion;
                }

                public String getCumulative_profit() {
                    return cumulative_profit;
                }

                public void setCumulative_profit(String cumulative_profit) {
                    this.cumulative_profit = cumulative_profit;
                }

                public String getHold_amount() {
                    return hold_amount;
                }

                public void setHold_amount(String hold_amount) {
                    this.hold_amount = hold_amount;
                }

                public int getHold_count() {
                    return hold_count;
                }

                public void setHold_count(int hold_count) {
                    this.hold_count = hold_count;
                }

                public String getProduct_no() {
                    return product_no;
                }

                public void setProduct_no(String product_no) {
                    this.product_no = product_no;
                }

                public String getProduct_name() {
                    return product_name;
                }

                public void setProduct_name(String product_name) {
                    this.product_name = product_name;
                }
            }
        }
    }
}

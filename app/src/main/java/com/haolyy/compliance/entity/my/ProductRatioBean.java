package com.haolyy.compliance.entity.my;

import java.util.List;

/**
 * Created by niudeyang on 2017/7/14.
 */

public class ProductRatioBean {

    /**
     * code : 200
     * msg : 成功
     * model : {"code":"200","msg":"成功","model":{"holdProductList":[{"first_category_id":"DQY","proportion":"100","cumulative_profit":90,"hold_amount":"20000","second_category_id":"DQYA","id":"1","hold_count":"1","product_name":"短期赢"},{"proportion":"0","cumulative_profit":"0","hold_amount":"0","id":"6","hold_count":"0","product_name":"票据贷"},{"proportion":"0","cumulative_profit":"0","hold_amount":"0","id":"5","hold_count":"0","product_name":"闪车贷"},{"proportion":"0","cumulative_profit":"0","hold_amount":"0","id":"4","hold_count":"0","product_name":"消费贷"},{"proportion":"0","cumulative_profit":"0","hold_amount":"0","id":"2","hold_count":"0","product_name":"赢计划"},{"proportion":"0","cumulative_profit":"0","hold_amount":"0","id":"3","hold_count":"0","product_name":"周周赢"}],"frozen_balance":"0.00","allHoldAmount":"20,000.00","available_balance":"0.00"}}
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
         * model : {"holdProductList":[{"first_category_id":"DQY","proportion":"100","cumulative_profit":90,"hold_amount":"20000","second_category_id":"DQYA","id":"1","hold_count":"1","product_name":"短期赢"},{"proportion":"0","cumulative_profit":"0","hold_amount":"0","id":"6","hold_count":"0","product_name":"票据贷"},{"proportion":"0","cumulative_profit":"0","hold_amount":"0","id":"5","hold_count":"0","product_name":"闪车贷"},{"proportion":"0","cumulative_profit":"0","hold_amount":"0","id":"4","hold_count":"0","product_name":"消费贷"},{"proportion":"0","cumulative_profit":"0","hold_amount":"0","id":"2","hold_count":"0","product_name":"赢计划"},{"proportion":"0","cumulative_profit":"0","hold_amount":"0","id":"3","hold_count":"0","product_name":"周周赢"}],"frozen_balance":"0.00","allHoldAmount":"20,000.00","available_balance":"0.00"}
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
             * holdProductList : [{"first_category_id":"DQY","proportion":"100","cumulative_profit":90,"hold_amount":"20000","second_category_id":"DQYA","id":"1","hold_count":"1","product_name":"短期赢"},{"proportion":"0","cumulative_profit":"0","hold_amount":"0","id":"6","hold_count":"0","product_name":"票据贷"},{"proportion":"0","cumulative_profit":"0","hold_amount":"0","id":"5","hold_count":"0","product_name":"闪车贷"},{"proportion":"0","cumulative_profit":"0","hold_amount":"0","id":"4","hold_count":"0","product_name":"消费贷"},{"proportion":"0","cumulative_profit":"0","hold_amount":"0","id":"2","hold_count":"0","product_name":"赢计划"},{"proportion":"0","cumulative_profit":"0","hold_amount":"0","id":"3","hold_count":"0","product_name":"周周赢"}]
             * frozen_balance : 0.00
             * allHoldAmount : 20,000.00
             * available_balance : 0.00
             */

            private String frozen_balance;
            private String allHoldAmount;
            private String available_balance;
            private List<HoldProductListBean> holdProductList;

            public String getFrozen_balance() {
                return frozen_balance;
            }

            public void setFrozen_balance(String frozen_balance) {
                this.frozen_balance = frozen_balance;
            }

            public String getAllHoldAmount() {
                return allHoldAmount;
            }

            public void setAllHoldAmount(String allHoldAmount) {
                this.allHoldAmount = allHoldAmount;
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
                 * first_category_id : DQY
                 * proportion : 100
                 * cumulative_profit : 90.0
                 * hold_amount : 20000
                 * second_category_id : DQYA
                 * id : 1
                 * hold_count : 1
                 * product_name : 短期赢
                 */

                private String first_category_id;
                private String proportion;
                private double cumulative_profit;
                private String hold_amount;
                private String second_category_id;
                private String id;
                private String hold_count;
                private String product_name;

                public String getFirst_category_id() {
                    return first_category_id;
                }

                public void setFirst_category_id(String first_category_id) {
                    this.first_category_id = first_category_id;
                }

                public String getProportion() {
                    return proportion;
                }

                public void setProportion(String proportion) {
                    this.proportion = proportion;
                }

                public double getCumulative_profit() {
                    return cumulative_profit;
                }

                public void setCumulative_profit(double cumulative_profit) {
                    this.cumulative_profit = cumulative_profit;
                }

                public String getHold_amount() {
                    return hold_amount;
                }

                public void setHold_amount(String hold_amount) {
                    this.hold_amount = hold_amount;
                }

                public String getSecond_category_id() {
                    return second_category_id;
                }

                public void setSecond_category_id(String second_category_id) {
                    this.second_category_id = second_category_id;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getHold_count() {
                    return hold_count;
                }

                public void setHold_count(String hold_count) {
                    this.hold_count = hold_count;
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

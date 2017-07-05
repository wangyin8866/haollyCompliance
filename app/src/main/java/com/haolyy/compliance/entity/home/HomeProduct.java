package com.haolyy.compliance.entity.home;

import java.util.List;

/**
 * Created by wangyin on 2017/6/29.
 * 首页产品
 */

public class HomeProduct {

    /**
     * data : {"data":{"productlist":[{"amount":"2.00","amount_scale":"0.00","annualized_rate":"11.00","append_rate":"1.00","investMinAmount":1000,"period_length":3,"period_unit":3,"product_name":"www"},{"amount":"3.00","amount_scale":"0.01","annualized_rate":"10.00","append_rate":"1.00","investMinAmount":1000,"period_length":6,"period_unit":3,"product_name":"表弟222"},{"amount":"1.00","amount_scale":"0.01","annualized_rate":"11.00","append_rate":"1.00","investMinAmount":10000,"period_length":12,"period_unit":3,"product_name":"票据贷0000067"},null]},"msg":"业务正常","status":"200"}
     * msg : 业务异常
     * status : 301
     */

    private DataBeanX data;
    private String msg;
    private String status;

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class DataBeanX {
        /**
         * data : {"productlist":[{"amount":"2.00","amount_scale":"0.00","annualized_rate":"11.00","append_rate":"1.00","investMinAmount":1000,"period_length":3,"period_unit":3,"product_name":"www"},{"amount":"3.00","amount_scale":"0.01","annualized_rate":"10.00","append_rate":"1.00","investMinAmount":1000,"period_length":6,"period_unit":3,"product_name":"表弟222"},{"amount":"1.00","amount_scale":"0.01","annualized_rate":"11.00","append_rate":"1.00","investMinAmount":10000,"period_length":12,"period_unit":3,"product_name":"票据贷0000067"},null]}
         * msg : 业务正常
         * status : 200
         */

        private DataBean data;
        private String msg;
        private String status;

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public static class DataBean {
            private List<ProductlistBean> productlist;

            public List<ProductlistBean> getProductlist() {
                return productlist;
            }

            public void setProductlist(List<ProductlistBean> productlist) {
                this.productlist = productlist;
            }

            public static class ProductlistBean {
                /**
                 * amount : 2.00
                 * amount_scale : 0.00
                 * annualized_rate : 11.00
                 * append_rate : 1.00
                 * investMinAmount : 1000.0
                 * period_length : 3
                 * period_unit : 3
                 * product_name : www
                 */

                private String amount;
                private String amount_scale;
                private String annualized_rate;
                private String append_rate;
                private double investMinAmount;
                private int period_length;
                private int period_unit;
                private String product_name;

                public String getAmount() {
                    return amount;
                }

                public void setAmount(String amount) {
                    this.amount = amount;
                }

                public String getAmount_scale() {
                    return amount_scale;
                }

                public void setAmount_scale(String amount_scale) {
                    this.amount_scale = amount_scale;
                }

                public String getAnnualized_rate() {
                    return annualized_rate;
                }

                public void setAnnualized_rate(String annualized_rate) {
                    this.annualized_rate = annualized_rate;
                }

                public String getAppend_rate() {
                    return append_rate;
                }

                public void setAppend_rate(String append_rate) {
                    this.append_rate = append_rate;
                }

                public double getInvestMinAmount() {
                    return investMinAmount;
                }

                public void setInvestMinAmount(double investMinAmount) {
                    this.investMinAmount = investMinAmount;
                }

                public int getPeriod_length() {
                    return period_length;
                }

                public void setPeriod_length(int period_length) {
                    this.period_length = period_length;
                }

                public int getPeriod_unit() {
                    return period_unit;
                }

                public void setPeriod_unit(int period_unit) {
                    this.period_unit = period_unit;
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

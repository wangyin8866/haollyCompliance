package com.haolyy.compliance.entity.product;

/**
 * Created by wangyin on 2017/6/28.
 */

public class ProductBaseDetail {

    /**
     * data : {"data":{"info":{"account_balance":"100.00","amount_scale":"95.75","amount_wait":"38,300.00","annualized_rate":"11.00","append_rate":"1.00","begin_date":1497511119000,"bid_end_date":1499325519000,"contract_amount":"40,000.00","id":6887,"interest_end_date":1506700800000,"interest_start_date":1504540800000,"lock_date":10144454400000,"lock_period":99999,"period_length":28,"period_unit":2,"profit_plan":1,"project_type":2,"status":1}},"msg":"业务正常","status":"200"}
     * msg : 系统正常
     * status : 200
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
         * data : {"info":{"account_balance":"100.00","amount_scale":"95.75","amount_wait":"38,300.00","annualized_rate":"11.00","append_rate":"1.00","begin_date":1497511119000,"bid_end_date":1499325519000,"contract_amount":"40,000.00","id":6887,"interest_end_date":1506700800000,"interest_start_date":1504540800000,"lock_date":10144454400000,"lock_period":99999,"period_length":28,"period_unit":2,"profit_plan":1,"project_type":2,"status":1}}
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
            /**
             * info : {"account_balance":"100.00","amount_scale":"95.75","amount_wait":"38,300.00","annualized_rate":"11.00","append_rate":"1.00","begin_date":1497511119000,"bid_end_date":1499325519000,"contract_amount":"40,000.00","id":6887,"interest_end_date":1506700800000,"interest_start_date":1504540800000,"lock_date":10144454400000,"lock_period":99999,"period_length":28,"period_unit":2,"profit_plan":1,"project_type":2,"status":1}
             */

            private InfoBean info;

            public InfoBean getInfo() {
                return info;
            }

            public void setInfo(InfoBean info) {
                this.info = info;
            }

            public static class InfoBean {
                /**
                 * account_balance : 100.00
                 * amount_scale : 95.75
                 * amount_wait : 38,300.00
                 * annualized_rate : 11.00
                 * append_rate : 1.00
                 * begin_date : 1497511119000
                 * bid_end_date : 1499325519000
                 * contract_amount : 40,000.00
                 * id : 6887
                 * interest_end_date : 1506700800000
                 * interest_start_date : 1504540800000
                 * lock_date : 10144454400000
                 * lock_period : 99999
                 * period_length : 28
                 * period_unit : 2
                 * profit_plan : 1
                 * project_type : 2
                 * status : 1
                 */

                private String account_balance;
                private String amount_scale;
                private String amount_wait;
                private String annualized_rate;
                private String append_rate;
                private long begin_date;
                private long bid_end_date;
                private String contract_amount;
                private int id;
                private long interest_end_date;
                private long interest_start_date;
                private long lock_date;
                private int lock_period;
                private int period_length;
                private int period_unit;
                private int profit_plan;
                private int project_type;
                private int status;

                public String getAccount_balance() {
                    return account_balance;
                }

                public void setAccount_balance(String account_balance) {
                    this.account_balance = account_balance;
                }

                public String getAmount_scale() {
                    return amount_scale;
                }

                public void setAmount_scale(String amount_scale) {
                    this.amount_scale = amount_scale;
                }

                public String getAmount_wait() {
                    return amount_wait;
                }

                public void setAmount_wait(String amount_wait) {
                    this.amount_wait = amount_wait;
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

                public long getBegin_date() {
                    return begin_date;
                }

                public void setBegin_date(long begin_date) {
                    this.begin_date = begin_date;
                }

                public long getBid_end_date() {
                    return bid_end_date;
                }

                public void setBid_end_date(long bid_end_date) {
                    this.bid_end_date = bid_end_date;
                }

                public String getContract_amount() {
                    return contract_amount;
                }

                public void setContract_amount(String contract_amount) {
                    this.contract_amount = contract_amount;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public long getInterest_end_date() {
                    return interest_end_date;
                }

                public void setInterest_end_date(long interest_end_date) {
                    this.interest_end_date = interest_end_date;
                }

                public long getInterest_start_date() {
                    return interest_start_date;
                }

                public void setInterest_start_date(long interest_start_date) {
                    this.interest_start_date = interest_start_date;
                }

                public long getLock_date() {
                    return lock_date;
                }

                public void setLock_date(long lock_date) {
                    this.lock_date = lock_date;
                }

                public int getLock_period() {
                    return lock_period;
                }

                public void setLock_period(int lock_period) {
                    this.lock_period = lock_period;
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

                public int getProfit_plan() {
                    return profit_plan;
                }

                public void setProfit_plan(int profit_plan) {
                    this.profit_plan = profit_plan;
                }

                public int getProject_type() {
                    return project_type;
                }

                public void setProject_type(int project_type) {
                    this.project_type = project_type;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }
            }
        }
    }
}

package com.haolyy.compliance.entity.product;

/**
 * Created by wangyin on 2017/6/28.
 */

public class ProductBaseDetail  {
    /**
     * code : 200
     * msg : 成功
     * model : {"code":"200","msg":"成功","model":{"now":1499757263129,"info":{"id":9929,"project_name":"票据贷0000099","annualized_rate":"11.00","append_rate":"1.00","period_unit":3,"period_length":12,"contract_amount":"10,000.00","amount_wait":"1.00","amount_scale":"0.01","interest_start_date":1501948800000,"interest_end_date":1506700800000,"status":1,"profit_plan":1,"project_type":1,"account_balance":"100.00","begin_date":1496851200000,"bid_end_date":1502035200000,"lock_date":1502208000000,"lock_period":3}}}
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
         * model : {"now":1499757263129,"info":{"id":9929,"project_name":"票据贷0000099","annualized_rate":"11.00","append_rate":"1.00","period_unit":3,"period_length":12,"contract_amount":"10,000.00","amount_wait":"1.00","amount_scale":"0.01","interest_start_date":1501948800000,"interest_end_date":1506700800000,"status":1,"profit_plan":1,"project_type":1,"account_balance":"100.00","begin_date":1496851200000,"bid_end_date":1502035200000,"lock_date":1502208000000,"lock_period":3}}
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
             * now : 1499757263129
             * info : {"id":9929,"project_name":"票据贷0000099","annualized_rate":"11.00","append_rate":"1.00","period_unit":3,"period_length":12,"contract_amount":"10,000.00","amount_wait":"1.00","amount_scale":"0.01","interest_start_date":1501948800000,"interest_end_date":1506700800000,"status":1,"profit_plan":1,"project_type":1,"account_balance":"100.00","begin_date":1496851200000,"bid_end_date":1502035200000,"lock_date":1502208000000,"lock_period":3}
             */

            private long now;
            private InfoBean info;

            public long getNow() {
                return now;
            }

            public void setNow(long now) {
                this.now = now;
            }

            public InfoBean getInfo() {
                return info;
            }

            public void setInfo(InfoBean info) {
                this.info = info;
            }

            public static class InfoBean {
                /**
                 * id : 9929
                 * project_name : 票据贷0000099
                 * annualized_rate : 11.00
                 * append_rate : 1.00
                 * period_unit : 3
                 * period_length : 12
                 * contract_amount : 10,000.00
                 * amount_wait : 1.00
                 * amount_scale : 0.01
                 * interest_start_date : 1501948800000
                 * interest_end_date : 1506700800000
                 * status : 1
                 * profit_plan : 1
                 * project_type : 1
                 * account_balance : 100.00
                 * begin_date : 1496851200000
                 * bid_end_date : 1502035200000
                 * lock_date : 1502208000000
                 * lock_period : 3
                 */

                private int id;
                private String project_name;
                private String annualized_rate;
                private String append_rate;
                private int period_unit;
                private int period_length;
                private String contract_amount;
                private String amount_wait;
                private String amount_scale;
                private long interest_start_date;
                private long interest_end_date;
                private int status;
                private int profit_plan;
                private int project_type;
                private String account_balance;
                private long begin_date;
                private long bid_end_date;
                private long lock_date;
                private int lock_period;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getProject_name() {
                    return project_name;
                }

                public void setProject_name(String project_name) {
                    this.project_name = project_name;
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

                public int getPeriod_unit() {
                    return period_unit;
                }

                public void setPeriod_unit(int period_unit) {
                    this.period_unit = period_unit;
                }

                public int getPeriod_length() {
                    return period_length;
                }

                public void setPeriod_length(int period_length) {
                    this.period_length = period_length;
                }

                public String getContract_amount() {
                    return contract_amount;
                }

                public void setContract_amount(String contract_amount) {
                    this.contract_amount = contract_amount;
                }

                public String getAmount_wait() {
                    return amount_wait;
                }

                public void setAmount_wait(String amount_wait) {
                    this.amount_wait = amount_wait;
                }

                public String getAmount_scale() {
                    return amount_scale;
                }

                public void setAmount_scale(String amount_scale) {
                    this.amount_scale = amount_scale;
                }

                public long getInterest_start_date() {
                    return interest_start_date;
                }

                public void setInterest_start_date(long interest_start_date) {
                    this.interest_start_date = interest_start_date;
                }

                public long getInterest_end_date() {
                    return interest_end_date;
                }

                public void setInterest_end_date(long interest_end_date) {
                    this.interest_end_date = interest_end_date;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
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

                public String getAccount_balance() {
                    return account_balance;
                }

                public void setAccount_balance(String account_balance) {
                    this.account_balance = account_balance;
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
            }
        }
    }
}

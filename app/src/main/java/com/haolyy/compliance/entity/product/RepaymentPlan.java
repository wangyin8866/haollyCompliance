package com.haolyy.compliance.entity.product;

import java.util.List;

/**
 * Created by wangyin on 2017/7/3.
 */

public class RepaymentPlan {

    /**
     * data : {"data":{"counts":6,"data_list":[{"period_no":1,"remain_amount":"0.00","should_amount":"100.00","should_interest":"20.00"},{"period_no":2,"remain_amount":"0.00","should_amount":"100.00","should_interest":"20.00"},{"period_no":3,"remain_amount":"0.00","should_amount":"100.00","should_interest":"20.00"},{"period_no":4,"remain_amount":"0.00","should_amount":"100.00","should_interest":"20.00"},{"period_no":5,"remain_amount":"0.00","should_amount":"100.00","should_interest":"20.00"},{"period_no":6,"remain_amount":"0.00","should_amount":"100.00","should_interest":"20.00"}],"page_size":10},"msg":"业务正常","status":"200"}
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
         * data : {"counts":6,"data_list":[{"period_no":1,"remain_amount":"0.00","should_amount":"100.00","should_interest":"20.00"},{"period_no":2,"remain_amount":"0.00","should_amount":"100.00","should_interest":"20.00"},{"period_no":3,"remain_amount":"0.00","should_amount":"100.00","should_interest":"20.00"},{"period_no":4,"remain_amount":"0.00","should_amount":"100.00","should_interest":"20.00"},{"period_no":5,"remain_amount":"0.00","should_amount":"100.00","should_interest":"20.00"},{"period_no":6,"remain_amount":"0.00","should_amount":"100.00","should_interest":"20.00"}],"page_size":10}
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
             * counts : 6
             * data_list : [{"period_no":1,"remain_amount":"0.00","should_amount":"100.00","should_interest":"20.00"},{"period_no":2,"remain_amount":"0.00","should_amount":"100.00","should_interest":"20.00"},{"period_no":3,"remain_amount":"0.00","should_amount":"100.00","should_interest":"20.00"},{"period_no":4,"remain_amount":"0.00","should_amount":"100.00","should_interest":"20.00"},{"period_no":5,"remain_amount":"0.00","should_amount":"100.00","should_interest":"20.00"},{"period_no":6,"remain_amount":"0.00","should_amount":"100.00","should_interest":"20.00"}]
             * page_size : 10
             */

            private int counts;
            private int page_size;
            private List<DataListBean> data_list;

            public int getCounts() {
                return counts;
            }

            public void setCounts(int counts) {
                this.counts = counts;
            }

            public int getPage_size() {
                return page_size;
            }

            public void setPage_size(int page_size) {
                this.page_size = page_size;
            }

            public List<DataListBean> getData_list() {
                return data_list;
            }

            public void setData_list(List<DataListBean> data_list) {
                this.data_list = data_list;
            }

            public static class DataListBean {
                /**
                 * period_no : 1
                 * remain_amount : 0.00
                 * should_amount : 100.00
                 * should_interest : 20.00
                 */

                private int period_no;
                private String remain_amount;
                private String should_amount;
                private String should_interest;

                public int getPeriod_no() {
                    return period_no;
                }

                public void setPeriod_no(int period_no) {
                    this.period_no = period_no;
                }

                public String getRemain_amount() {
                    return remain_amount;
                }

                public void setRemain_amount(String remain_amount) {
                    this.remain_amount = remain_amount;
                }

                public String getShould_amount() {
                    return should_amount;
                }

                public void setShould_amount(String should_amount) {
                    this.should_amount = should_amount;
                }

                public String getShould_interest() {
                    return should_interest;
                }

                public void setShould_interest(String should_interest) {
                    this.should_interest = should_interest;
                }
            }
        }
    }
}

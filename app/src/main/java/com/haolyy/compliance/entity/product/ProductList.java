package com.haolyy.compliance.entity.product;

import java.util.List;

/**
 * Created by wangyin on 2017/6/26.
 */

public class ProductList {

    /**
     * data : {"data":{"counts":4096,"data_list":[{"amount_scale":"100.00","annualized_rate":"11.00","append_rate":"1.00","contract_amount":"40,000.00","id":6887,"period_length":28,"period_unit":2,"product_no":"","project_name":"短期赢D6887","project_no":"HLWL206887","project_type":2,"status":1},{"amount_scale":"100.00","annualized_rate":"11.00","append_rate":"1.00","contract_amount":"30,000.00","id":6886,"period_length":21,"period_unit":2,"product_no":"","project_name":"短期赢C6886","project_no":"HLWL206886","project_type":2,"status":1},{"amount_scale":"100.00","annualized_rate":"11.00","append_rate":"1.00","contract_amount":"20,000.00","id":6885,"period_length":14,"period_unit":2,"product_no":"","project_name":"短期赢B6885","project_no":"HLWL206885","project_type":2,"status":1},{"amount_scale":"100.00","annualized_rate":"11.00","append_rate":"1.00","contract_amount":"10,000.00","id":6884,"period_length":7,"period_unit":2,"product_no":"","project_name":"短期赢A6884","project_no":"HLWL206884","project_type":2,"status":1},{"amount_scale":"100.00","annualized_rate":"11.00","append_rate":"1.00","contract_amount":"10,000.00","id":6883,"period_length":7,"period_unit":2,"product_no":"","project_name":"短期赢A6883","project_no":"HLWL206883","project_type":2,"status":1},{"amount_scale":"100.00","annualized_rate":"11.00","append_rate":"1.00","contract_amount":"10,000.00","id":6882,"period_length":7,"period_unit":2,"product_no":"","project_name":"短期赢A6882","project_no":"HLWL206882","project_type":2,"status":1},{"amount_scale":"100.00","annualized_rate":"11.00","append_rate":"1.00","contract_amount":"10,000.00","id":6881,"period_length":7,"period_unit":2,"product_no":"","project_name":"短期赢A6881","project_no":"HLWL206881","project_type":2,"status":1},{"amount_scale":"100.00","annualized_rate":"10.00","append_rate":"1.00","contract_amount":"10,000.00","id":6880,"period_length":7,"period_unit":2,"product_no":"","project_name":"短期赢A6880","project_no":"HLWL206880","project_type":2,"status":1},{"amount_scale":"100.00","annualized_rate":"11.00","append_rate":"1.00","contract_amount":"40,000.00","id":6879,"period_length":28,"period_unit":2,"product_no":"","project_name":"短期赢D6879","project_no":"HLWL206879","project_type":2,"status":1},{"amount_scale":"100.00","annualized_rate":"11.00","append_rate":"1.00","contract_amount":"30,000.00","id":6878,"period_length":21,"period_unit":2,"product_no":"","project_name":"短期赢C6878","project_no":"HLWL206878","project_type":2,"status":1}],"page_size":10,"title_list":[[{"category_name":"短期赢","node_no":"DQY","parent_node_no":"0"},{"category_name":"短期赢D","node_no":"DQYD","parent_node_no":"DQY"},{"category_name":"短期赢C","node_no":"DQYC","parent_node_no":"DQY"},{"category_name":"短期赢B","node_no":"DQYB","parent_node_no":"DQY"},{"category_name":"短期赢A","node_no":"DQYA","parent_node_no":"DQY"}],[{"category_name":"赢计划","node_no":"YJH","parent_node_no":"0"},{"category_name":"赢计划D","node_no":"YJHD","parent_node_no":"YJH"},{"category_name":"赢计划C","node_no":"YJHC","parent_node_no":"YJH"},{"category_name":"赢计划B","node_no":"YJHB","parent_node_no":"YJH"},{"category_name":"赢计划A","node_no":"YJHA","parent_node_no":"YJH"}],[{"category_name":"优选计划","node_no":"YXJH","parent_node_no":"0"},{"category_name":"消费贷","node_no":"XFD","parent_node_no":"YXJH"},{"category_name":"闪车贷","node_no":"SCD","parent_node_no":"YXJH"},{"category_name":"票据贷","node_no":"PJD","parent_node_no":"YXJH"}]]},"msg":"业务正常","status":"200"}
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
         * data : {"counts":4096,"data_list":[{"amount_scale":"100.00","annualized_rate":"11.00","append_rate":"1.00","contract_amount":"40,000.00","id":6887,"period_length":28,"period_unit":2,"product_no":"","project_name":"短期赢D6887","project_no":"HLWL206887","project_type":2,"status":1},{"amount_scale":"100.00","annualized_rate":"11.00","append_rate":"1.00","contract_amount":"30,000.00","id":6886,"period_length":21,"period_unit":2,"product_no":"","project_name":"短期赢C6886","project_no":"HLWL206886","project_type":2,"status":1},{"amount_scale":"100.00","annualized_rate":"11.00","append_rate":"1.00","contract_amount":"20,000.00","id":6885,"period_length":14,"period_unit":2,"product_no":"","project_name":"短期赢B6885","project_no":"HLWL206885","project_type":2,"status":1},{"amount_scale":"100.00","annualized_rate":"11.00","append_rate":"1.00","contract_amount":"10,000.00","id":6884,"period_length":7,"period_unit":2,"product_no":"","project_name":"短期赢A6884","project_no":"HLWL206884","project_type":2,"status":1},{"amount_scale":"100.00","annualized_rate":"11.00","append_rate":"1.00","contract_amount":"10,000.00","id":6883,"period_length":7,"period_unit":2,"product_no":"","project_name":"短期赢A6883","project_no":"HLWL206883","project_type":2,"status":1},{"amount_scale":"100.00","annualized_rate":"11.00","append_rate":"1.00","contract_amount":"10,000.00","id":6882,"period_length":7,"period_unit":2,"product_no":"","project_name":"短期赢A6882","project_no":"HLWL206882","project_type":2,"status":1},{"amount_scale":"100.00","annualized_rate":"11.00","append_rate":"1.00","contract_amount":"10,000.00","id":6881,"period_length":7,"period_unit":2,"product_no":"","project_name":"短期赢A6881","project_no":"HLWL206881","project_type":2,"status":1},{"amount_scale":"100.00","annualized_rate":"10.00","append_rate":"1.00","contract_amount":"10,000.00","id":6880,"period_length":7,"period_unit":2,"product_no":"","project_name":"短期赢A6880","project_no":"HLWL206880","project_type":2,"status":1},{"amount_scale":"100.00","annualized_rate":"11.00","append_rate":"1.00","contract_amount":"40,000.00","id":6879,"period_length":28,"period_unit":2,"product_no":"","project_name":"短期赢D6879","project_no":"HLWL206879","project_type":2,"status":1},{"amount_scale":"100.00","annualized_rate":"11.00","append_rate":"1.00","contract_amount":"30,000.00","id":6878,"period_length":21,"period_unit":2,"product_no":"","project_name":"短期赢C6878","project_no":"HLWL206878","project_type":2,"status":1}],"page_size":10,"title_list":[[{"category_name":"短期赢","node_no":"DQY","parent_node_no":"0"},{"category_name":"短期赢D","node_no":"DQYD","parent_node_no":"DQY"},{"category_name":"短期赢C","node_no":"DQYC","parent_node_no":"DQY"},{"category_name":"短期赢B","node_no":"DQYB","parent_node_no":"DQY"},{"category_name":"短期赢A","node_no":"DQYA","parent_node_no":"DQY"}],[{"category_name":"赢计划","node_no":"YJH","parent_node_no":"0"},{"category_name":"赢计划D","node_no":"YJHD","parent_node_no":"YJH"},{"category_name":"赢计划C","node_no":"YJHC","parent_node_no":"YJH"},{"category_name":"赢计划B","node_no":"YJHB","parent_node_no":"YJH"},{"category_name":"赢计划A","node_no":"YJHA","parent_node_no":"YJH"}],[{"category_name":"优选计划","node_no":"YXJH","parent_node_no":"0"},{"category_name":"消费贷","node_no":"XFD","parent_node_no":"YXJH"},{"category_name":"闪车贷","node_no":"SCD","parent_node_no":"YXJH"},{"category_name":"票据贷","node_no":"PJD","parent_node_no":"YXJH"}]]}
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
             * counts : 4096
             * data_list : [{"amount_scale":"100.00","annualized_rate":"11.00","append_rate":"1.00","contract_amount":"40,000.00","id":6887,"period_length":28,"period_unit":2,"product_no":"","project_name":"短期赢D6887","project_no":"HLWL206887","project_type":2,"status":1},{"amount_scale":"100.00","annualized_rate":"11.00","append_rate":"1.00","contract_amount":"30,000.00","id":6886,"period_length":21,"period_unit":2,"product_no":"","project_name":"短期赢C6886","project_no":"HLWL206886","project_type":2,"status":1},{"amount_scale":"100.00","annualized_rate":"11.00","append_rate":"1.00","contract_amount":"20,000.00","id":6885,"period_length":14,"period_unit":2,"product_no":"","project_name":"短期赢B6885","project_no":"HLWL206885","project_type":2,"status":1},{"amount_scale":"100.00","annualized_rate":"11.00","append_rate":"1.00","contract_amount":"10,000.00","id":6884,"period_length":7,"period_unit":2,"product_no":"","project_name":"短期赢A6884","project_no":"HLWL206884","project_type":2,"status":1},{"amount_scale":"100.00","annualized_rate":"11.00","append_rate":"1.00","contract_amount":"10,000.00","id":6883,"period_length":7,"period_unit":2,"product_no":"","project_name":"短期赢A6883","project_no":"HLWL206883","project_type":2,"status":1},{"amount_scale":"100.00","annualized_rate":"11.00","append_rate":"1.00","contract_amount":"10,000.00","id":6882,"period_length":7,"period_unit":2,"product_no":"","project_name":"短期赢A6882","project_no":"HLWL206882","project_type":2,"status":1},{"amount_scale":"100.00","annualized_rate":"11.00","append_rate":"1.00","contract_amount":"10,000.00","id":6881,"period_length":7,"period_unit":2,"product_no":"","project_name":"短期赢A6881","project_no":"HLWL206881","project_type":2,"status":1},{"amount_scale":"100.00","annualized_rate":"10.00","append_rate":"1.00","contract_amount":"10,000.00","id":6880,"period_length":7,"period_unit":2,"product_no":"","project_name":"短期赢A6880","project_no":"HLWL206880","project_type":2,"status":1},{"amount_scale":"100.00","annualized_rate":"11.00","append_rate":"1.00","contract_amount":"40,000.00","id":6879,"period_length":28,"period_unit":2,"product_no":"","project_name":"短期赢D6879","project_no":"HLWL206879","project_type":2,"status":1},{"amount_scale":"100.00","annualized_rate":"11.00","append_rate":"1.00","contract_amount":"30,000.00","id":6878,"period_length":21,"period_unit":2,"product_no":"","project_name":"短期赢C6878","project_no":"HLWL206878","project_type":2,"status":1}]
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
                 * amount_scale : 100.00
                 * annualized_rate : 11.00
                 * append_rate : 1.00
                 * contract_amount : 40,000.00
                 * id : 6887
                 * period_length : 28
                 * period_unit : 2
                 * product_no :
                 * project_name : 短期赢D6887
                 * project_no : HLWL206887
                 * project_type : 2
                 * status : 1
                 */

                private String amount_scale;
                private String annualized_rate;
                private String append_rate;
                private String contract_amount;
                private int id;
                private int period_length;
                private int period_unit;
                private String product_no;
                private String project_name;
                private String project_no;
                private int project_type;
                private int status;

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

                public String getProduct_no() {
                    return product_no;
                }

                public void setProduct_no(String product_no) {
                    this.product_no = product_no;
                }

                public String getProject_name() {
                    return project_name;
                }

                public void setProject_name(String project_name) {
                    this.project_name = project_name;
                }

                public String getProject_no() {
                    return project_no;
                }

                public void setProject_no(String project_no) {
                    this.project_no = project_no;
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

                @Override
                public String toString() {
                    return "DataListBean{" +
                            "amount_scale='" + amount_scale + '\'' +
                            ", annualized_rate='" + annualized_rate + '\'' +
                            ", append_rate='" + append_rate + '\'' +
                            ", contract_amount='" + contract_amount + '\'' +
                            ", id=" + id +
                            ", period_length=" + period_length +
                            ", period_unit=" + period_unit +
                            ", product_no='" + product_no + '\'' +
                            ", project_name='" + project_name + '\'' +
                            ", project_no='" + project_no + '\'' +
                            ", project_type=" + project_type +
                            ", status=" + status +
                            '}';
                }
            }

        }
    }
}

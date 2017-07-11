package com.haolyy.compliance.entity.product;

import java.util.List;

/**
 * Created by wangyin on 2017/6/26.
 */

public class ProductList {
    /**
     * code : 200
     * msg : 成功
     * model : {"code":"200","msg":"成功","model":{"data_list":[{"id":9829,"project_no":"DQY0000099","product_no":"DQYA","project_type":2,"project_name":"短期赢0000099","annualized_rate":"11.00","append_rate":"1.00","period_unit":3,"period_length":12,"contract_amount":"10,000.00","amount_scale":"0.01","status":1},{"id":9828,"project_no":"DQY0000098","product_no":"DQYA","project_type":2,"project_name":"短期赢0000098","annualized_rate":"11.00","append_rate":"1.00","period_unit":3,"period_length":12,"contract_amount":"10,000.00","amount_scale":"0.01","status":1},{"id":9827,"project_no":"DQY0000097","product_no":"DQYA","project_type":2,"project_name":"短期赢0000097","annualized_rate":"11.00","append_rate":"1.00","period_unit":3,"period_length":12,"contract_amount":"10,000.00","amount_scale":"0.01","status":1},{"id":9826,"project_no":"DQY0000096","product_no":"DQYA","project_type":2,"project_name":"短期赢0000096","annualized_rate":"11.00","append_rate":"1.00","period_unit":3,"period_length":12,"contract_amount":"10,000.00","amount_scale":"0.01","status":1},{"id":9825,"project_no":"DQY0000095","product_no":"DQYA","project_type":2,"project_name":"短期赢0000095","annualized_rate":"11.00","append_rate":"1.00","period_unit":3,"period_length":12,"contract_amount":"10,000.00","amount_scale":"0.01","status":1},{"id":9824,"project_no":"DQY0000094","product_no":"DQYA","project_type":2,"project_name":"短期赢0000094","annualized_rate":"11.00","append_rate":"1.00","period_unit":3,"period_length":12,"contract_amount":"10,000.00","amount_scale":"0.01","status":1},{"id":9823,"project_no":"DQY0000093","product_no":"DQYA","project_type":2,"project_name":"短期赢0000093","annualized_rate":"11.00","append_rate":"1.00","period_unit":3,"period_length":12,"contract_amount":"10,000.00","amount_scale":"0.01","status":1},{"id":9822,"project_no":"DQY0000092","product_no":"DQYA","project_type":2,"project_name":"短期赢0000092","annualized_rate":"11.00","append_rate":"1.00","period_unit":3,"period_length":12,"contract_amount":"10,000.00","amount_scale":"0.01","status":1},{"id":9821,"project_no":"DQY0000091","product_no":"DQYA","project_type":2,"project_name":"短期赢0000091","annualized_rate":"11.00","append_rate":"1.00","period_unit":3,"period_length":12,"contract_amount":"10,000.00","amount_scale":"0.01","status":1},{"id":9820,"project_no":"DQY0000090","product_no":"DQYA","project_type":2,"project_name":"短期赢0000090","annualized_rate":"11.00","append_rate":"1.00","period_unit":3,"period_length":12,"contract_amount":"10,000.00","amount_scale":"0.01","status":1}],"counts":4195,"page_size":10}}
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
         * model : {"data_list":[{"id":9829,"project_no":"DQY0000099","product_no":"DQYA","project_type":2,"project_name":"短期赢0000099","annualized_rate":"11.00","append_rate":"1.00","period_unit":3,"period_length":12,"contract_amount":"10,000.00","amount_scale":"0.01","status":1},{"id":9828,"project_no":"DQY0000098","product_no":"DQYA","project_type":2,"project_name":"短期赢0000098","annualized_rate":"11.00","append_rate":"1.00","period_unit":3,"period_length":12,"contract_amount":"10,000.00","amount_scale":"0.01","status":1},{"id":9827,"project_no":"DQY0000097","product_no":"DQYA","project_type":2,"project_name":"短期赢0000097","annualized_rate":"11.00","append_rate":"1.00","period_unit":3,"period_length":12,"contract_amount":"10,000.00","amount_scale":"0.01","status":1},{"id":9826,"project_no":"DQY0000096","product_no":"DQYA","project_type":2,"project_name":"短期赢0000096","annualized_rate":"11.00","append_rate":"1.00","period_unit":3,"period_length":12,"contract_amount":"10,000.00","amount_scale":"0.01","status":1},{"id":9825,"project_no":"DQY0000095","product_no":"DQYA","project_type":2,"project_name":"短期赢0000095","annualized_rate":"11.00","append_rate":"1.00","period_unit":3,"period_length":12,"contract_amount":"10,000.00","amount_scale":"0.01","status":1},{"id":9824,"project_no":"DQY0000094","product_no":"DQYA","project_type":2,"project_name":"短期赢0000094","annualized_rate":"11.00","append_rate":"1.00","period_unit":3,"period_length":12,"contract_amount":"10,000.00","amount_scale":"0.01","status":1},{"id":9823,"project_no":"DQY0000093","product_no":"DQYA","project_type":2,"project_name":"短期赢0000093","annualized_rate":"11.00","append_rate":"1.00","period_unit":3,"period_length":12,"contract_amount":"10,000.00","amount_scale":"0.01","status":1},{"id":9822,"project_no":"DQY0000092","product_no":"DQYA","project_type":2,"project_name":"短期赢0000092","annualized_rate":"11.00","append_rate":"1.00","period_unit":3,"period_length":12,"contract_amount":"10,000.00","amount_scale":"0.01","status":1},{"id":9821,"project_no":"DQY0000091","product_no":"DQYA","project_type":2,"project_name":"短期赢0000091","annualized_rate":"11.00","append_rate":"1.00","period_unit":3,"period_length":12,"contract_amount":"10,000.00","amount_scale":"0.01","status":1},{"id":9820,"project_no":"DQY0000090","product_no":"DQYA","project_type":2,"project_name":"短期赢0000090","annualized_rate":"11.00","append_rate":"1.00","period_unit":3,"period_length":12,"contract_amount":"10,000.00","amount_scale":"0.01","status":1}],"counts":4195,"page_size":10}
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
             * data_list : [{"id":9829,"project_no":"DQY0000099","product_no":"DQYA","project_type":2,"project_name":"短期赢0000099","annualized_rate":"11.00","append_rate":"1.00","period_unit":3,"period_length":12,"contract_amount":"10,000.00","amount_scale":"0.01","status":1},{"id":9828,"project_no":"DQY0000098","product_no":"DQYA","project_type":2,"project_name":"短期赢0000098","annualized_rate":"11.00","append_rate":"1.00","period_unit":3,"period_length":12,"contract_amount":"10,000.00","amount_scale":"0.01","status":1},{"id":9827,"project_no":"DQY0000097","product_no":"DQYA","project_type":2,"project_name":"短期赢0000097","annualized_rate":"11.00","append_rate":"1.00","period_unit":3,"period_length":12,"contract_amount":"10,000.00","amount_scale":"0.01","status":1},{"id":9826,"project_no":"DQY0000096","product_no":"DQYA","project_type":2,"project_name":"短期赢0000096","annualized_rate":"11.00","append_rate":"1.00","period_unit":3,"period_length":12,"contract_amount":"10,000.00","amount_scale":"0.01","status":1},{"id":9825,"project_no":"DQY0000095","product_no":"DQYA","project_type":2,"project_name":"短期赢0000095","annualized_rate":"11.00","append_rate":"1.00","period_unit":3,"period_length":12,"contract_amount":"10,000.00","amount_scale":"0.01","status":1},{"id":9824,"project_no":"DQY0000094","product_no":"DQYA","project_type":2,"project_name":"短期赢0000094","annualized_rate":"11.00","append_rate":"1.00","period_unit":3,"period_length":12,"contract_amount":"10,000.00","amount_scale":"0.01","status":1},{"id":9823,"project_no":"DQY0000093","product_no":"DQYA","project_type":2,"project_name":"短期赢0000093","annualized_rate":"11.00","append_rate":"1.00","period_unit":3,"period_length":12,"contract_amount":"10,000.00","amount_scale":"0.01","status":1},{"id":9822,"project_no":"DQY0000092","product_no":"DQYA","project_type":2,"project_name":"短期赢0000092","annualized_rate":"11.00","append_rate":"1.00","period_unit":3,"period_length":12,"contract_amount":"10,000.00","amount_scale":"0.01","status":1},{"id":9821,"project_no":"DQY0000091","product_no":"DQYA","project_type":2,"project_name":"短期赢0000091","annualized_rate":"11.00","append_rate":"1.00","period_unit":3,"period_length":12,"contract_amount":"10,000.00","amount_scale":"0.01","status":1},{"id":9820,"project_no":"DQY0000090","product_no":"DQYA","project_type":2,"project_name":"短期赢0000090","annualized_rate":"11.00","append_rate":"1.00","period_unit":3,"period_length":12,"contract_amount":"10,000.00","amount_scale":"0.01","status":1}]
             * counts : 4195
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
                 * id : 9829
                 * project_no : DQY0000099
                 * product_no : DQYA
                 * project_type : 2
                 * project_name : 短期赢0000099
                 * annualized_rate : 11.00
                 * append_rate : 1.00
                 * period_unit : 3
                 * period_length : 12
                 * contract_amount : 10,000.00
                 * amount_scale : 0.01
                 * status : 1
                 */

                private int id;
                private String project_no;
                private String product_no;
                private int project_type;
                private String project_name;
                private String annualized_rate;
                private String append_rate;
                private int period_unit;
                private int period_length;
                private String contract_amount;
                private String amount_scale;
                private int status;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getProject_no() {
                    return project_no;
                }

                public void setProject_no(String project_no) {
                    this.project_no = project_no;
                }

                public String getProduct_no() {
                    return product_no;
                }

                public void setProduct_no(String product_no) {
                    this.product_no = product_no;
                }

                public int getProject_type() {
                    return project_type;
                }

                public void setProject_type(int project_type) {
                    this.project_type = project_type;
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

                public String getAmount_scale() {
                    return amount_scale;
                }

                public void setAmount_scale(String amount_scale) {
                    this.amount_scale = amount_scale;
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

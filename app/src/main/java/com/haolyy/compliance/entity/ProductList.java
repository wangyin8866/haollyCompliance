package com.haolyy.compliance.entity;

import java.util.List;

/**
 * Created by wangyin on 2017/6/26.
 */

public class ProductList {

    /**
     * data : {"data":{"counts":0,"data_list":[],"title_list":[{"category_name":"短期赢","node_no":"DQY","parent_node_no":"0"},{"category_name":"赢计划","node_no":"YJH","parent_node_no":"0"},{"category_name":"优选计划","node_no":"YXJH","parent_node_no":"0"},{"category_name":"消费贷","node_no":"XFD","parent_node_no":"YXJH"},{"category_name":"闪车贷","node_no":"SCD","parent_node_no":"YXJH"},{"category_name":"票据贷","node_no":"PJD","parent_node_no":"YXJH"},{"category_name":"短期赢A","node_no":"DQYA","parent_node_no":"DQY"},{"category_name":"短期赢B","node_no":"DQYB","parent_node_no":"DQY"}]},"msg":"业务正常","status":"200"}
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
         * data : {"counts":0,"data_list":[],"title_list":[{"category_name":"短期赢","node_no":"DQY","parent_node_no":"0"},{"category_name":"赢计划","node_no":"YJH","parent_node_no":"0"},{"category_name":"优选计划","node_no":"YXJH","parent_node_no":"0"},{"category_name":"消费贷","node_no":"XFD","parent_node_no":"YXJH"},{"category_name":"闪车贷","node_no":"SCD","parent_node_no":"YXJH"},{"category_name":"票据贷","node_no":"PJD","parent_node_no":"YXJH"},{"category_name":"短期赢A","node_no":"DQYA","parent_node_no":"DQY"},{"category_name":"短期赢B","node_no":"DQYB","parent_node_no":"DQY"}]}
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
             * counts : 0
             * data_list : []
             * title_list : [{"category_name":"短期赢","node_no":"DQY","parent_node_no":"0"},{"category_name":"赢计划","node_no":"YJH","parent_node_no":"0"},{"category_name":"优选计划","node_no":"YXJH","parent_node_no":"0"},{"category_name":"消费贷","node_no":"XFD","parent_node_no":"YXJH"},{"category_name":"闪车贷","node_no":"SCD","parent_node_no":"YXJH"},{"category_name":"票据贷","node_no":"PJD","parent_node_no":"YXJH"},{"category_name":"短期赢A","node_no":"DQYA","parent_node_no":"DQY"},{"category_name":"短期赢B","node_no":"DQYB","parent_node_no":"DQY"}]
             */

            private int counts;
            private List<?> data_list;
            private List<TitleListBean> title_list;

            public int getCounts() {
                return counts;
            }

            public void setCounts(int counts) {
                this.counts = counts;
            }

            public List<?> getData_list() {
                return data_list;
            }

            public void setData_list(List<?> data_list) {
                this.data_list = data_list;
            }

            public List<TitleListBean> getTitle_list() {
                return title_list;
            }

            public void setTitle_list(List<TitleListBean> title_list) {
                this.title_list = title_list;
            }

            public static class TitleListBean {
                /**
                 * category_name : 短期赢
                 * node_no : DQY
                 * parent_node_no : 0
                 */

                private String category_name;
                private String node_no;
                private String parent_node_no;

                public String getCategory_name() {
                    return category_name;
                }

                public void setCategory_name(String category_name) {
                    this.category_name = category_name;
                }

                public String getNode_no() {
                    return node_no;
                }

                public void setNode_no(String node_no) {
                    this.node_no = node_no;
                }

                public String getParent_node_no() {
                    return parent_node_no;
                }

                public void setParent_node_no(String parent_node_no) {
                    this.parent_node_no = parent_node_no;
                }
            }
        }
    }
}

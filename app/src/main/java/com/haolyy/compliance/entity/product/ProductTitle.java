package com.haolyy.compliance.entity.product;

import java.util.List;

/**
 * Created by wangyin on 2017/6/28.
 */

public class ProductTitle {
    /**
     * code : 200
     * msg : 成功
     * model : {"code":"200","msg":"成功","model":{"title_list":[[{"node_no":"DQY","category_name":"短期赢","parent_node_no":"0"},{"node_no":"DQYD","category_name":"短期赢D","parent_node_no":"DQY"},{"node_no":"DQYC","category_name":"短期赢C","parent_node_no":"DQY"},{"node_no":"DQYB","category_name":"短期赢B","parent_node_no":"DQY"},{"node_no":"DQYA","category_name":"短期赢A","parent_node_no":"DQY"}],[{"node_no":"YJH","category_name":"赢计划","parent_node_no":"0"},{"node_no":"YJHD","category_name":"赢计划D","parent_node_no":"YJH"},{"node_no":"YJHC","category_name":"赢计划C","parent_node_no":"YJH"},{"node_no":"YJHB","category_name":"赢计划B","parent_node_no":"YJH"},{"node_no":"YJHA","category_name":"赢计划A","parent_node_no":"YJH"}],[{"node_no":"YXJH","category_name":"优选计划","parent_node_no":"0"},{"node_no":"ZZJ","category_name":"周周赢","parent_node_no":"YXJH"},{"node_no":"XFD","category_name":"消费贷","parent_node_no":"YXJH"},{"node_no":"SCD","category_name":"闪车贷","parent_node_no":"YXJH"},{"node_no":"PJD","category_name":"票据贷","parent_node_no":"YXJH"}]]}}
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
         * model : {"title_list":[[{"node_no":"DQY","category_name":"短期赢","parent_node_no":"0"},{"node_no":"DQYD","category_name":"短期赢D","parent_node_no":"DQY"},{"node_no":"DQYC","category_name":"短期赢C","parent_node_no":"DQY"},{"node_no":"DQYB","category_name":"短期赢B","parent_node_no":"DQY"},{"node_no":"DQYA","category_name":"短期赢A","parent_node_no":"DQY"}],[{"node_no":"YJH","category_name":"赢计划","parent_node_no":"0"},{"node_no":"YJHD","category_name":"赢计划D","parent_node_no":"YJH"},{"node_no":"YJHC","category_name":"赢计划C","parent_node_no":"YJH"},{"node_no":"YJHB","category_name":"赢计划B","parent_node_no":"YJH"},{"node_no":"YJHA","category_name":"赢计划A","parent_node_no":"YJH"}],[{"node_no":"YXJH","category_name":"优选计划","parent_node_no":"0"},{"node_no":"ZZJ","category_name":"周周赢","parent_node_no":"YXJH"},{"node_no":"XFD","category_name":"消费贷","parent_node_no":"YXJH"},{"node_no":"SCD","category_name":"闪车贷","parent_node_no":"YXJH"},{"node_no":"PJD","category_name":"票据贷","parent_node_no":"YXJH"}]]}
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
            private List<List<TitleListBean>> title_list;

            public List<List<TitleListBean>> getTitle_list() {
                return title_list;
            }

            public void setTitle_list(List<List<TitleListBean>> title_list) {
                this.title_list = title_list;
            }

            public static class TitleListBean {
                /**
                 * node_no : DQY
                 * category_name : 短期赢
                 * parent_node_no : 0
                 */

                private String node_no;
                private String category_name;
                private String parent_node_no;

                public String getNode_no() {
                    return node_no;
                }

                public void setNode_no(String node_no) {
                    this.node_no = node_no;
                }

                public String getCategory_name() {
                    return category_name;
                }

                public void setCategory_name(String category_name) {
                    this.category_name = category_name;
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

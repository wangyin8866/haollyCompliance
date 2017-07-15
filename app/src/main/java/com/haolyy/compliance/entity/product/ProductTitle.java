package com.haolyy.compliance.entity.product;

import java.util.List;

/**
 * Created by wangyin on 2017/6/28.
 */

public class ProductTitle {
    /**
     * code : 200
     * msg : 成功
     * model : {"code":"200","msg":"成功","model":{"titleList":[[{"nodeNo":"DQY","categoryName":"短期赢","parentNodeNo":"0"},{"nodeNo":"DQYD","categoryName":"短期赢D","parentNodeNo":"DQY"},{"nodeNo":"DQYC","categoryName":"短期赢C","parentNodeNo":"DQY"},{"nodeNo":"DQYB","categoryName":"短期赢B","parentNodeNo":"DQY"},{"nodeNo":"DQYA","categoryName":"短期赢A","parentNodeNo":"DQY"}],[{"nodeNo":"YJH","categoryName":"赢计划","parentNodeNo":"0"},{"nodeNo":"YJHD","categoryName":"赢计划D","parentNodeNo":"YJH"},{"nodeNo":"YJHC","categoryName":"赢计划C","parentNodeNo":"YJH"},{"nodeNo":"YJHB","categoryName":"赢计划B","parentNodeNo":"YJH"},{"nodeNo":"YJHA","categoryName":"赢计划A","parentNodeNo":"YJH"}],[{"nodeNo":"YXJH","categoryName":"优选计划","parentNodeNo":"0"},{"nodeNo":"ZZJ","categoryName":"周周赢","parentNodeNo":"YXJH"},{"nodeNo":"XFD","categoryName":"消费贷","parentNodeNo":"YXJH"},{"nodeNo":"SCD","categoryName":"闪车贷","parentNodeNo":"YXJH"},{"nodeNo":"PJD","categoryName":"票据贷","parentNodeNo":"YXJH"}]]}}
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
         * model : {"titleList":[[{"nodeNo":"DQY","categoryName":"短期赢","parentNodeNo":"0"},{"nodeNo":"DQYD","categoryName":"短期赢D","parentNodeNo":"DQY"},{"nodeNo":"DQYC","categoryName":"短期赢C","parentNodeNo":"DQY"},{"nodeNo":"DQYB","categoryName":"短期赢B","parentNodeNo":"DQY"},{"nodeNo":"DQYA","categoryName":"短期赢A","parentNodeNo":"DQY"}],[{"nodeNo":"YJH","categoryName":"赢计划","parentNodeNo":"0"},{"nodeNo":"YJHD","categoryName":"赢计划D","parentNodeNo":"YJH"},{"nodeNo":"YJHC","categoryName":"赢计划C","parentNodeNo":"YJH"},{"nodeNo":"YJHB","categoryName":"赢计划B","parentNodeNo":"YJH"},{"nodeNo":"YJHA","categoryName":"赢计划A","parentNodeNo":"YJH"}],[{"nodeNo":"YXJH","categoryName":"优选计划","parentNodeNo":"0"},{"nodeNo":"ZZJ","categoryName":"周周赢","parentNodeNo":"YXJH"},{"nodeNo":"XFD","categoryName":"消费贷","parentNodeNo":"YXJH"},{"nodeNo":"SCD","categoryName":"闪车贷","parentNodeNo":"YXJH"},{"nodeNo":"PJD","categoryName":"票据贷","parentNodeNo":"YXJH"}]]}
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
            private List<List<TitleListBean>> titleList;

            public List<List<TitleListBean>> getTitleList() {
                return titleList;
            }

            public void setTitleList(List<List<TitleListBean>> titleList) {
                this.titleList = titleList;
            }

            public static class TitleListBean {
                /**
                 * nodeNo : DQY
                 * categoryName : 短期赢
                 * parentNodeNo : 0
                 */

                private String nodeNo;
                private String categoryName;
                private String parentNodeNo;

                public String getNodeNo() {
                    return nodeNo;
                }

                public void setNodeNo(String nodeNo) {
                    this.nodeNo = nodeNo;
                }

                public String getCategoryName() {
                    return categoryName;
                }

                public void setCategoryName(String categoryName) {
                    this.categoryName = categoryName;
                }

                public String getParentNodeNo() {
                    return parentNodeNo;
                }

                public void setParentNodeNo(String parentNodeNo) {
                    this.parentNodeNo = parentNodeNo;
                }
            }
        }
    }
}

package com.haolyy.compliance.entity.home;

import java.util.List;

/**
 * Created by wangyin on 2017/6/29.
 */

public class Banner {
    /**
     * code : 200
     * msg : 成功
     * model : {"code":"200","msg":"成功","model":[{"id":18,"imageUrl":"http://img1.imgtn.bdimg.com/it/u=1104086822,117564155&fm=26&gp=0.jpg","sort":0,"linkUrl":"fdgdfg"},{"id":18,"imageUrl":"http://img1.imgtn.bdimg.com/it/u=1104086822,117564155&fm=26&gp=0.jpg","sort":0,"linkUrl":"fdgdfg"}]}
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
         * model : [{"id":18,"imageUrl":"http://img1.imgtn.bdimg.com/it/u=1104086822,117564155&fm=26&gp=0.jpg","sort":0,"linkUrl":"fdgdfg"},{"id":18,"imageUrl":"http://img1.imgtn.bdimg.com/it/u=1104086822,117564155&fm=26&gp=0.jpg","sort":0,"linkUrl":"fdgdfg"}]
         */

        private String code;
        private String msg;
        private List<ModelBean> model;

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

        public List<ModelBean> getModel() {
            return model;
        }

        public void setModel(List<ModelBean> model) {
            this.model = model;
        }

        public static class ModelBean {
            /**
             * id : 18
             * imageUrl : http://img1.imgtn.bdimg.com/it/u=1104086822,117564155&fm=26&gp=0.jpg
             * sort : 0
             * linkUrl : fdgdfg
             */

            private int id;
            private String imageUrl;
            private int sort;
            private String linkUrl;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public String getLinkUrl() {
                return linkUrl;
            }

            public void setLinkUrl(String linkUrl) {
                this.linkUrl = linkUrl;
            }
        }
    }
}

package com.haolyy.compliance.entity.home;

import java.util.List;

/**
 * Created by wangyin on 2017/6/29.
 */

public class Banner {

    /**
     * data : {"data":{"cmsCarouselFigureList":[{"client":1,"createTime":1498147200000,"createUser":1,"id":18,"imageUrl":"/static/cms/uploads/images/201706/f1e1103b0a2cb5a9b47aa784c68a8d8e.jpg","linkUrl":"fdgdfg","platform":1,"sort":0,"status":1,"type":2},{"client":2,"createTime":1498147200000,"createUser":1,"id":18,"imageUrl":"/static/cms/uploads/images/201706/f1e1103b0a2cb5a9b47aa784c68a8d8e.jpg","linkUrl":"fdgdfg","platform":1,"sort":0,"status":1,"type":2},{"client":3,"createTime":1498147200000,"createUser":1,"id":18,"imageUrl":"/static/cms/uploads/images/201706/f1e1103b0a2cb5a9b47aa784c68a8d8e.jpg","linkUrl":"fdgdfg","platform":1,"sort":0,"status":1,"type":2},{"client":1,"createTime":1498147200000,"createUser":1,"id":18,"imageUrl":"/static/cms/uploads/images/201706/f1e1103b0a2cb5a9b47aa784c68a8d8e.jpg","linkUrl":"fdgdfg","platform":1,"sort":0,"status":1,"type":2}]},"msg":"业务正常","status":"200"}
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
         * data : {"cmsCarouselFigureList":[{"client":1,"createTime":1498147200000,"createUser":1,"id":18,"imageUrl":"/static/cms/uploads/images/201706/f1e1103b0a2cb5a9b47aa784c68a8d8e.jpg","linkUrl":"fdgdfg","platform":1,"sort":0,"status":1,"type":2},{"client":2,"createTime":1498147200000,"createUser":1,"id":18,"imageUrl":"/static/cms/uploads/images/201706/f1e1103b0a2cb5a9b47aa784c68a8d8e.jpg","linkUrl":"fdgdfg","platform":1,"sort":0,"status":1,"type":2},{"client":3,"createTime":1498147200000,"createUser":1,"id":18,"imageUrl":"/static/cms/uploads/images/201706/f1e1103b0a2cb5a9b47aa784c68a8d8e.jpg","linkUrl":"fdgdfg","platform":1,"sort":0,"status":1,"type":2},{"client":1,"createTime":1498147200000,"createUser":1,"id":18,"imageUrl":"/static/cms/uploads/images/201706/f1e1103b0a2cb5a9b47aa784c68a8d8e.jpg","linkUrl":"fdgdfg","platform":1,"sort":0,"status":1,"type":2}]}
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
            private List<CmsCarouselFigureListBean> cmsCarouselFigureList;

            public List<CmsCarouselFigureListBean> getCmsCarouselFigureList() {
                return cmsCarouselFigureList;
            }

            public void setCmsCarouselFigureList(List<CmsCarouselFigureListBean> cmsCarouselFigureList) {
                this.cmsCarouselFigureList = cmsCarouselFigureList;
            }

            public static class CmsCarouselFigureListBean {
                /**
                 * client : 1
                 * createTime : 1498147200000
                 * createUser : 1
                 * id : 18
                 * imageUrl : /static/cms/uploads/images/201706/f1e1103b0a2cb5a9b47aa784c68a8d8e.jpg
                 * linkUrl : fdgdfg
                 * platform : 1
                 * sort : 0
                 * status : 1
                 * type : 2
                 */

                private int client;
                private long createTime;
                private int createUser;
                private int id;
                private String imageUrl;
                private String linkUrl;
                private int platform;
                private int sort;
                private int status;
                private int type;

                public int getClient() {
                    return client;
                }

                public void setClient(int client) {
                    this.client = client;
                }

                public long getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(long createTime) {
                    this.createTime = createTime;
                }

                public int getCreateUser() {
                    return createUser;
                }

                public void setCreateUser(int createUser) {
                    this.createUser = createUser;
                }

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

                public String getLinkUrl() {
                    return linkUrl;
                }

                public void setLinkUrl(String linkUrl) {
                    this.linkUrl = linkUrl;
                }

                public int getPlatform() {
                    return platform;
                }

                public void setPlatform(int platform) {
                    this.platform = platform;
                }

                public int getSort() {
                    return sort;
                }

                public void setSort(int sort) {
                    this.sort = sort;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }
            }
        }
    }
}

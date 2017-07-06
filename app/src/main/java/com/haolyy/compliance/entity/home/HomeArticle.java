package com.haolyy.compliance.entity.home;

import java.util.List;

/**
 * Created by wangyin on 2017/7/4.
 * 首页新闻
 */

public class HomeArticle {

    /**
     * data : {"data":{"announcementList":[{"category":1,"client":1,"createTime":1498147200000,"description":"发的多个","modifyTime":1498147200000,"orderId":44,"platform":1,"remark":"得分","title":"vdfg","url":"二分法"},{"category":1,"client":2,"createTime":1498147200000,"description":"发的多个","modifyTime":1498147200000,"orderId":44,"platform":1,"remark":"得分","title":"vdfg","url":"二分法"},{"category":1,"client":3,"createTime":1498147200000,"description":"发的多个","modifyTime":1498147200000,"orderId":44,"platform":1,"remark":"得分","title":"vdfg","url":"二分法"}],"eventList":[{"category":2,"client":1,"createTime":1498147200000,"description":"发的多个","modifyTime":1498147200000,"orderId":2,"platform":1,"remark":"得分","title":"飞飞飞","url":"二分法"},{"category":2,"client":2,"createTime":1498147200000,"description":"发的多个","modifyTime":1498147200000,"orderId":2,"platform":1,"remark":"得分","title":"飞飞飞","url":"二分法"}]},"msg":"业务正常","status":"200"}
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
         * data : {"announcementList":[{"category":1,"client":1,"createTime":1498147200000,"description":"发的多个","modifyTime":1498147200000,"orderId":44,"platform":1,"remark":"得分","title":"vdfg","url":"二分法"},{"category":1,"client":2,"createTime":1498147200000,"description":"发的多个","modifyTime":1498147200000,"orderId":44,"platform":1,"remark":"得分","title":"vdfg","url":"二分法"},{"category":1,"client":3,"createTime":1498147200000,"description":"发的多个","modifyTime":1498147200000,"orderId":44,"platform":1,"remark":"得分","title":"vdfg","url":"二分法"}],"eventList":[{"category":2,"client":1,"createTime":1498147200000,"description":"发的多个","modifyTime":1498147200000,"orderId":2,"platform":1,"remark":"得分","title":"飞飞飞","url":"二分法"},{"category":2,"client":2,"createTime":1498147200000,"description":"发的多个","modifyTime":1498147200000,"orderId":2,"platform":1,"remark":"得分","title":"飞飞飞","url":"二分法"}]}
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
            private List<AnnouncementListBean> announcementList;
            private List<EventListBean> eventList;

            public List<AnnouncementListBean> getAnnouncementList() {
                return announcementList;
            }

            public void setAnnouncementList(List<AnnouncementListBean> announcementList) {
                this.announcementList = announcementList;
            }

            public List<EventListBean> getEventList() {
                return eventList;
            }

            public void setEventList(List<EventListBean> eventList) {
                this.eventList = eventList;
            }

            public static class AnnouncementListBean {
                /**
                 * category : 1
                 * client : 1
                 * createTime : 1498147200000
                 * description : 发的多个
                 * modifyTime : 1498147200000
                 * orderId : 44
                 * platform : 1
                 * remark : 得分
                 * title : vdfg
                 * url : 二分法
                 */

                private int category;
                private int client;
                private long createTime;
                private String description;
                private long modifyTime;
                private int orderId;
                private int platform;
                private String remark;
                private String title;
                private String url;

                public int getCategory() {
                    return category;
                }

                public void setCategory(int category) {
                    this.category = category;
                }

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

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public long getModifyTime() {
                    return modifyTime;
                }

                public void setModifyTime(long modifyTime) {
                    this.modifyTime = modifyTime;
                }

                public int getOrderId() {
                    return orderId;
                }

                public void setOrderId(int orderId) {
                    this.orderId = orderId;
                }

                public int getPlatform() {
                    return platform;
                }

                public void setPlatform(int platform) {
                    this.platform = platform;
                }

                public String getRemark() {
                    return remark;
                }

                public void setRemark(String remark) {
                    this.remark = remark;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }

            public static class EventListBean {
                /**
                 * category : 2
                 * client : 1
                 * createTime : 1498147200000
                 * description : 发的多个
                 * modifyTime : 1498147200000
                 * orderId : 2
                 * platform : 1
                 * remark : 得分
                 * title : 飞飞飞
                 * url : 二分法
                 */

                private int category;
                private int client;
                private long createTime;
                private String description;
                private long modifyTime;
                private int orderId;
                private int platform;
                private String remark;
                private String title;
                private String url;

                public int getCategory() {
                    return category;
                }

                public void setCategory(int category) {
                    this.category = category;
                }

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

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public long getModifyTime() {
                    return modifyTime;
                }

                public void setModifyTime(long modifyTime) {
                    this.modifyTime = modifyTime;
                }

                public int getOrderId() {
                    return orderId;
                }

                public void setOrderId(int orderId) {
                    this.orderId = orderId;
                }

                public int getPlatform() {
                    return platform;
                }

                public void setPlatform(int platform) {
                    this.platform = platform;
                }

                public String getRemark() {
                    return remark;
                }

                public void setRemark(String remark) {
                    this.remark = remark;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }
    }
}

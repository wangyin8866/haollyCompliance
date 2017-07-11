package com.haolyy.compliance.entity.home;

import java.util.List;

/**
 * Created by wangyin on 2017/7/4.
 * 首页新闻
 */

public class HomeArticle {
    /**
     * code : 200
     * msg : 成功
     * model : {"code":"200","msg":"成功","model":{"announcementList":[{"id":2,"title":"vdfg","url":"二分法","description":"发的多个","imageCoverUrl":null,"homePageCoverUrl":null,"content":"冯小刚","createTime":"2017-06-23 17:23:15"},{"id":14,"title":"改编法国和","url":"让他和别人发给","description":"法国华人","imageCoverUrl":null,"homePageCoverUrl":null,"content":"通过不通过和","createTime":"2017-06-26 18:31:28"}],"eventList":[{"id":13,"title":"如同一天b","url":"苟富贵","description":"染头发通过","imageCoverUrl":null,"homePageCoverUrl":null,"content":"让他改变","createTime":"2017-06-26 18:31:08"},{"id":17,"title":"发的帖规划","url":"发给花花提议","description":"突然很不同意","imageCoverUrl":null,"homePageCoverUrl":null,"content":"氧化钙很鳄鱼湖","createTime":"2017-06-26 19:21:38"}]}}
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
         * model : {"announcementList":[{"id":2,"title":"vdfg","url":"二分法","description":"发的多个","imageCoverUrl":null,"homePageCoverUrl":null,"content":"冯小刚","createTime":"2017-06-23 17:23:15"},{"id":14,"title":"改编法国和","url":"让他和别人发给","description":"法国华人","imageCoverUrl":null,"homePageCoverUrl":null,"content":"通过不通过和","createTime":"2017-06-26 18:31:28"}],"eventList":[{"id":13,"title":"如同一天b","url":"苟富贵","description":"染头发通过","imageCoverUrl":null,"homePageCoverUrl":null,"content":"让他改变","createTime":"2017-06-26 18:31:08"},{"id":17,"title":"发的帖规划","url":"发给花花提议","description":"突然很不同意","imageCoverUrl":null,"homePageCoverUrl":null,"content":"氧化钙很鳄鱼湖","createTime":"2017-06-26 19:21:38"}]}
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
                 * id : 2
                 * title : vdfg
                 * url : 二分法
                 * description : 发的多个
                 * imageCoverUrl : null
                 * homePageCoverUrl : null
                 * content : 冯小刚
                 * createTime : 2017-06-23 17:23:15
                 */

                private int id;
                private String title;
                private String url;
                private String description;
                private String imageCoverUrl;
                private String homePageCoverUrl;
                private String content;
                private String createTime;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
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

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getImageCoverUrl() {
                    return imageCoverUrl;
                }

                public void setImageCoverUrl(String imageCoverUrl) {
                    this.imageCoverUrl = imageCoverUrl;
                }

                public String getHomePageCoverUrl() {
                    return homePageCoverUrl;
                }

                public void setHomePageCoverUrl(String homePageCoverUrl) {
                    this.homePageCoverUrl = homePageCoverUrl;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(String createTime) {
                    this.createTime = createTime;
                }
            }

            public static class EventListBean {
                /**
                 * id : 13
                 * title : 如同一天b
                 * url : 苟富贵
                 * description : 染头发通过
                 * imageCoverUrl : null
                 * homePageCoverUrl : null
                 * content : 让他改变
                 * createTime : 2017-06-26 18:31:08
                 */

                private int id;
                private String title;
                private String url;
                private String description;
                private String imageCoverUrl;
                private String homePageCoverUrl;
                private String content;
                private String createTime;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
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

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getImageCoverUrl() {
                    return imageCoverUrl;
                }

                public void setImageCoverUrl(String imageCoverUrl) {
                    this.imageCoverUrl = imageCoverUrl;
                }

                public String getHomePageCoverUrl() {
                    return homePageCoverUrl;
                }

                public void setHomePageCoverUrl(String homePageCoverUrl) {
                    this.homePageCoverUrl = homePageCoverUrl;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(String createTime) {
                    this.createTime = createTime;
                }
            }
        }
    }
}

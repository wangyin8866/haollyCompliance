package com.haolyy.compliance.entity.home;

import java.util.List;

/**
 * Created by wangyin on 2017/7/4.
 * 首页活动
 */

public class HomeActivity {

    /**
     * data : {"data":{"recommend":[{"adsenseName":"首页短期赢","adsenseNo":"SY001","annualisedReturnRate":"11.00","createTime":1498233600000,"firstCategoryId":0,"id":1,"newBidGlag":2,"periodLength":12,"periodUnit":3,"secondCategoryId":1,"showAnnualisedReturnRate":"20.00","showPeriodLength":12,"showPeriodUnit":3,"showTitle":"短期赢"}],"recommendNew":[{"adsenseName":"首页短期赢12月","adsenseNo":"SY006","annualisedReturnRate":"11.00","createTime":1498233600000,"firstCategoryId":0,"id":6,"newBidGlag":1,"periodLength":12,"periodUnit":3,"secondCategoryId":2,"showAnnualisedReturnRate":"20.00","showPeriodLength":12,"showPeriodUnit":3,"showTitle":"短期赢12月"}]},"msg":"业务正常","status":"200"}
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
         * data : {"recommend":[{"adsenseName":"首页短期赢","adsenseNo":"SY001","annualisedReturnRate":"11.00","createTime":1498233600000,"firstCategoryId":0,"id":1,"newBidGlag":2,"periodLength":12,"periodUnit":3,"secondCategoryId":1,"showAnnualisedReturnRate":"20.00","showPeriodLength":12,"showPeriodUnit":3,"showTitle":"短期赢"}],"recommendNew":[{"adsenseName":"首页短期赢12月","adsenseNo":"SY006","annualisedReturnRate":"11.00","createTime":1498233600000,"firstCategoryId":0,"id":6,"newBidGlag":1,"periodLength":12,"periodUnit":3,"secondCategoryId":2,"showAnnualisedReturnRate":"20.00","showPeriodLength":12,"showPeriodUnit":3,"showTitle":"短期赢12月"}]}
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
            private List<RecommendBean> recommend;
            private List<RecommendNewBean> recommendNew;

            public List<RecommendBean> getRecommend() {
                return recommend;
            }

            public void setRecommend(List<RecommendBean> recommend) {
                this.recommend = recommend;
            }

            public List<RecommendNewBean> getRecommendNew() {
                return recommendNew;
            }

            public void setRecommendNew(List<RecommendNewBean> recommendNew) {
                this.recommendNew = recommendNew;
            }

            public static class RecommendBean {
                /**
                 * adsenseName : 首页短期赢
                 * adsenseNo : SY001
                 * annualisedReturnRate : 11.00
                 * createTime : 1498233600000
                 * firstCategoryId : 0
                 * id : 1
                 * newBidGlag : 2
                 * periodLength : 12
                 * periodUnit : 3
                 * secondCategoryId : 1
                 * showAnnualisedReturnRate : 20.00
                 * showPeriodLength : 12
                 * showPeriodUnit : 3
                 * showTitle : 短期赢
                 */

                private String adsenseName;
                private String adsenseNo;
                private String annualisedReturnRate;
                private long createTime;
                private int firstCategoryId;
                private int id;
                private int newBidGlag;
                private int periodLength;
                private int periodUnit;
                private int secondCategoryId;
                private String showAnnualisedReturnRate;
                private int showPeriodLength;
                private int showPeriodUnit;
                private String showTitle;

                public String getAdsenseName() {
                    return adsenseName;
                }

                public void setAdsenseName(String adsenseName) {
                    this.adsenseName = adsenseName;
                }

                public String getAdsenseNo() {
                    return adsenseNo;
                }

                public void setAdsenseNo(String adsenseNo) {
                    this.adsenseNo = adsenseNo;
                }

                public String getAnnualisedReturnRate() {
                    return annualisedReturnRate;
                }

                public void setAnnualisedReturnRate(String annualisedReturnRate) {
                    this.annualisedReturnRate = annualisedReturnRate;
                }

                public long getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(long createTime) {
                    this.createTime = createTime;
                }

                public int getFirstCategoryId() {
                    return firstCategoryId;
                }

                public void setFirstCategoryId(int firstCategoryId) {
                    this.firstCategoryId = firstCategoryId;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getNewBidGlag() {
                    return newBidGlag;
                }

                public void setNewBidGlag(int newBidGlag) {
                    this.newBidGlag = newBidGlag;
                }

                public int getPeriodLength() {
                    return periodLength;
                }

                public void setPeriodLength(int periodLength) {
                    this.periodLength = periodLength;
                }

                public int getPeriodUnit() {
                    return periodUnit;
                }

                public void setPeriodUnit(int periodUnit) {
                    this.periodUnit = periodUnit;
                }

                public int getSecondCategoryId() {
                    return secondCategoryId;
                }

                public void setSecondCategoryId(int secondCategoryId) {
                    this.secondCategoryId = secondCategoryId;
                }

                public String getShowAnnualisedReturnRate() {
                    return showAnnualisedReturnRate;
                }

                public void setShowAnnualisedReturnRate(String showAnnualisedReturnRate) {
                    this.showAnnualisedReturnRate = showAnnualisedReturnRate;
                }

                public int getShowPeriodLength() {
                    return showPeriodLength;
                }

                public void setShowPeriodLength(int showPeriodLength) {
                    this.showPeriodLength = showPeriodLength;
                }

                public int getShowPeriodUnit() {
                    return showPeriodUnit;
                }

                public void setShowPeriodUnit(int showPeriodUnit) {
                    this.showPeriodUnit = showPeriodUnit;
                }

                public String getShowTitle() {
                    return showTitle;
                }

                public void setShowTitle(String showTitle) {
                    this.showTitle = showTitle;
                }
            }

            public static class RecommendNewBean {
                /**
                 * adsenseName : 首页短期赢12月
                 * adsenseNo : SY006
                 * annualisedReturnRate : 11.00
                 * createTime : 1498233600000
                 * firstCategoryId : 0
                 * id : 6
                 * newBidGlag : 1
                 * periodLength : 12
                 * periodUnit : 3
                 * secondCategoryId : 2
                 * showAnnualisedReturnRate : 20.00
                 * showPeriodLength : 12
                 * showPeriodUnit : 3
                 * showTitle : 短期赢12月
                 */

                private String adsenseName;
                private String adsenseNo;
                private String annualisedReturnRate;
                private long createTime;
                private int firstCategoryId;
                private int id;
                private int newBidGlag;
                private int periodLength;
                private int periodUnit;
                private int secondCategoryId;
                private String showAnnualisedReturnRate;
                private int showPeriodLength;
                private int showPeriodUnit;
                private String showTitle;

                public String getAdsenseName() {
                    return adsenseName;
                }

                public void setAdsenseName(String adsenseName) {
                    this.adsenseName = adsenseName;
                }

                public String getAdsenseNo() {
                    return adsenseNo;
                }

                public void setAdsenseNo(String adsenseNo) {
                    this.adsenseNo = adsenseNo;
                }

                public String getAnnualisedReturnRate() {
                    return annualisedReturnRate;
                }

                public void setAnnualisedReturnRate(String annualisedReturnRate) {
                    this.annualisedReturnRate = annualisedReturnRate;
                }

                public long getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(long createTime) {
                    this.createTime = createTime;
                }

                public int getFirstCategoryId() {
                    return firstCategoryId;
                }

                public void setFirstCategoryId(int firstCategoryId) {
                    this.firstCategoryId = firstCategoryId;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getNewBidGlag() {
                    return newBidGlag;
                }

                public void setNewBidGlag(int newBidGlag) {
                    this.newBidGlag = newBidGlag;
                }

                public int getPeriodLength() {
                    return periodLength;
                }

                public void setPeriodLength(int periodLength) {
                    this.periodLength = periodLength;
                }

                public int getPeriodUnit() {
                    return periodUnit;
                }

                public void setPeriodUnit(int periodUnit) {
                    this.periodUnit = periodUnit;
                }

                public int getSecondCategoryId() {
                    return secondCategoryId;
                }

                public void setSecondCategoryId(int secondCategoryId) {
                    this.secondCategoryId = secondCategoryId;
                }

                public String getShowAnnualisedReturnRate() {
                    return showAnnualisedReturnRate;
                }

                public void setShowAnnualisedReturnRate(String showAnnualisedReturnRate) {
                    this.showAnnualisedReturnRate = showAnnualisedReturnRate;
                }

                public int getShowPeriodLength() {
                    return showPeriodLength;
                }

                public void setShowPeriodLength(int showPeriodLength) {
                    this.showPeriodLength = showPeriodLength;
                }

                public int getShowPeriodUnit() {
                    return showPeriodUnit;
                }

                public void setShowPeriodUnit(int showPeriodUnit) {
                    this.showPeriodUnit = showPeriodUnit;
                }

                public String getShowTitle() {
                    return showTitle;
                }

                public void setShowTitle(String showTitle) {
                    this.showTitle = showTitle;
                }
            }
        }
    }
}

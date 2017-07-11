package com.haolyy.compliance.entity.home;

import java.util.List;

/**
 * Created by wangyin on 2017/7/4.
 * 首页活动
 */

public class HomeActivity {
    /**
     * code : 200
     * msg : 成功
     * model : {"code":"200","msg":"成功","model":{"recommendNew":[{"projectNo":null,"projectMarketType":1,"projectTitle":"新手标","annualizedRate":"11.00","appendRate":"1.00","periodUnit":2,"periodLength":28,"amountWait":"2,000.00","amountScale":"80.00","amountYes":"8,000.00"}],"recommend":[{"projectNo":null,"projectMarketType":2,"projectTitle":"活动标","annualizedRate":"11.00","appendRate":"1.00","periodUnit":2,"periodLength":28,"amountWait":"2,000.00","amountScale":"80.00","amountYes":"8,000.00"}]}}
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
         * model : {"recommendNew":[{"projectNo":null,"projectMarketType":1,"projectTitle":"新手标","annualizedRate":"11.00","appendRate":"1.00","periodUnit":2,"periodLength":28,"amountWait":"2,000.00","amountScale":"80.00","amountYes":"8,000.00"}],"recommend":[{"projectNo":null,"projectMarketType":2,"projectTitle":"活动标","annualizedRate":"11.00","appendRate":"1.00","periodUnit":2,"periodLength":28,"amountWait":"2,000.00","amountScale":"80.00","amountYes":"8,000.00"}]}
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
            private List<RecommendNewBean> recommendNew;
            private List<RecommendBean> recommend;

            public List<RecommendNewBean> getRecommendNew() {
                return recommendNew;
            }

            public void setRecommendNew(List<RecommendNewBean> recommendNew) {
                this.recommendNew = recommendNew;
            }

            public List<RecommendBean> getRecommend() {
                return recommend;
            }

            public void setRecommend(List<RecommendBean> recommend) {
                this.recommend = recommend;
            }

            public static class RecommendNewBean {
                /**
                 * projectNo : null
                 * projectMarketType : 1
                 * projectTitle : 新手标
                 * annualizedRate : 11.00
                 * appendRate : 1.00
                 * periodUnit : 2
                 * periodLength : 28
                 * amountWait : 2,000.00
                 * amountScale : 80.00
                 * amountYes : 8,000.00
                 */

                private String projectNo;
                private int projectMarketType;
                private String projectTitle;
                private String annualizedRate;
                private String appendRate;
                private int periodUnit;
                private int periodLength;
                private String amountWait;
                private String amountScale;
                private String amountYes;

                public String getProjectNo() {
                    return projectNo;
                }

                public void setProjectNo(String projectNo) {
                    this.projectNo = projectNo;
                }

                public int getProjectMarketType() {
                    return projectMarketType;
                }

                public void setProjectMarketType(int projectMarketType) {
                    this.projectMarketType = projectMarketType;
                }

                public String getProjectTitle() {
                    return projectTitle;
                }

                public void setProjectTitle(String projectTitle) {
                    this.projectTitle = projectTitle;
                }

                public String getAnnualizedRate() {
                    return annualizedRate;
                }

                public void setAnnualizedRate(String annualizedRate) {
                    this.annualizedRate = annualizedRate;
                }

                public String getAppendRate() {
                    return appendRate;
                }

                public void setAppendRate(String appendRate) {
                    this.appendRate = appendRate;
                }

                public int getPeriodUnit() {
                    return periodUnit;
                }

                public void setPeriodUnit(int periodUnit) {
                    this.periodUnit = periodUnit;
                }

                public int getPeriodLength() {
                    return periodLength;
                }

                public void setPeriodLength(int periodLength) {
                    this.periodLength = periodLength;
                }

                public String getAmountWait() {
                    return amountWait;
                }

                public void setAmountWait(String amountWait) {
                    this.amountWait = amountWait;
                }

                public String getAmountScale() {
                    return amountScale;
                }

                public void setAmountScale(String amountScale) {
                    this.amountScale = amountScale;
                }

                public String getAmountYes() {
                    return amountYes;
                }

                public void setAmountYes(String amountYes) {
                    this.amountYes = amountYes;
                }
            }

            public static class RecommendBean {
                /**
                 * projectNo : null
                 * projectMarketType : 2
                 * projectTitle : 活动标
                 * annualizedRate : 11.00
                 * appendRate : 1.00
                 * periodUnit : 2
                 * periodLength : 28
                 * amountWait : 2,000.00
                 * amountScale : 80.00
                 * amountYes : 8,000.00
                 */

                private String projectNo;
                private int projectMarketType;
                private String projectTitle;
                private String annualizedRate;
                private String appendRate;
                private int periodUnit;
                private int periodLength;
                private String amountWait;
                private String amountScale;
                private String amountYes;

                public String getProjectNo() {
                    return projectNo;
                }

                public void setProjectNo(String projectNo) {
                    this.projectNo = projectNo;
                }

                public int getProjectMarketType() {
                    return projectMarketType;
                }

                public void setProjectMarketType(int projectMarketType) {
                    this.projectMarketType = projectMarketType;
                }

                public String getProjectTitle() {
                    return projectTitle;
                }

                public void setProjectTitle(String projectTitle) {
                    this.projectTitle = projectTitle;
                }

                public String getAnnualizedRate() {
                    return annualizedRate;
                }

                public void setAnnualizedRate(String annualizedRate) {
                    this.annualizedRate = annualizedRate;
                }

                public String getAppendRate() {
                    return appendRate;
                }

                public void setAppendRate(String appendRate) {
                    this.appendRate = appendRate;
                }

                public int getPeriodUnit() {
                    return periodUnit;
                }

                public void setPeriodUnit(int periodUnit) {
                    this.periodUnit = periodUnit;
                }

                public int getPeriodLength() {
                    return periodLength;
                }

                public void setPeriodLength(int periodLength) {
                    this.periodLength = periodLength;
                }

                public String getAmountWait() {
                    return amountWait;
                }

                public void setAmountWait(String amountWait) {
                    this.amountWait = amountWait;
                }

                public String getAmountScale() {
                    return amountScale;
                }

                public void setAmountScale(String amountScale) {
                    this.amountScale = amountScale;
                }

                public String getAmountYes() {
                    return amountYes;
                }

                public void setAmountYes(String amountYes) {
                    this.amountYes = amountYes;
                }
            }
        }
    }
}

package com.haolyy.compliance.ui.my.Bean;

import java.util.List;

/**
 * Created by User on 2017/7/12.
 */

public class DealRecordBean {
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
            private int pageSum;
            private List<FundsRecordListBean> fundsRecordList;
            private List<FrozenDetaisBean> frozenDetais;

            public int getPageSum() {
                return pageSum;
            }

            public void setPageSum(int pageSum) {
                this.pageSum = pageSum;
            }

            public List<FundsRecordListBean> getFundsRecordList() {
                return fundsRecordList;
            }

            public void setFundsRecordList(List<FundsRecordListBean> fundsRecordList) {
                this.fundsRecordList = fundsRecordList;
            }

            public List<FrozenDetaisBean> getFrozenDetais() {
                return frozenDetais;
            }

            public void setFrozenDetais(List<FrozenDetaisBean> frozenDetais) {
                this.frozenDetais = frozenDetais;
            }

            public static class FundsRecordListBean {
                /**
                 * transferDate : 1501660487
                 * transferTime : null
                 * capitalType : 300611
                 * capitalNo : 20170802155416868357359
                 * type : 2
                 * amount : 20000.00
                 * availableAmount : 69810.00
                 * projectName : 消费贷XFD5566
                 * remark : 20170802155416868357359
                 * requestTime : null
                 * finishTime : 2017-08-02 15:54:47
                 */

                private String transferDate;
                private Object transferTime;
                private int capitalType;
                private String capitalNo;
                private int type;
                private String amount;
                private String availableAmount;
                private String projectName;
                private String remark;
                private String requestTime;
                private String finishTime;

                public String getTransferDate() {
                    return transferDate;
                }

                public void setTransferDate(String transferDate) {
                    this.transferDate = transferDate;
                }

                public Object getTransferTime() {
                    return transferTime;
                }

                public void setTransferTime(Object transferTime) {
                    this.transferTime = transferTime;
                }

                public int getCapitalType() {
                    return capitalType;
                }

                public void setCapitalType(int capitalType) {
                    this.capitalType = capitalType;
                }

                public String getCapitalNo() {
                    return capitalNo;
                }

                public void setCapitalNo(String capitalNo) {
                    this.capitalNo = capitalNo;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public String getAmount() {
                    return amount;
                }

                public void setAmount(String amount) {
                    this.amount = amount;
                }

                public String getAvailableAmount() {
                    return availableAmount;
                }

                public void setAvailableAmount(String availableAmount) {
                    this.availableAmount = availableAmount;
                }

                public String getProjectName() {
                    return projectName;
                }

                public void setProjectName(String projectName) {
                    this.projectName = projectName;
                }

                public String getRemark() {
                    return remark;
                }

                public void setRemark(String remark) {
                    this.remark = remark;
                }

                public String getRequestTime() {
                    return requestTime;
                }

                public void setRequestTime(String requestTime) {
                    this.requestTime = requestTime;
                }

                public String getFinishTime() {
                    return finishTime;
                }

                public void setFinishTime(String finishTime) {
                    this.finishTime = finishTime;
                }
            }

            public static class FrozenDetaisBean {
                /**
                 * 计划标 : 0.0
                 * 散标 : 40200.0
                 * 预约标 : 0.0
                 */

                private double 计划标;
                private double 散标;
                private double 预约标;

                public double get计划标() {
                    return 计划标;
                }

                public void set计划标(double 计划标) {
                    this.计划标 = 计划标;
                }

                public double get散标() {
                    return 散标;
                }

                public void set散标(double 散标) {
                    this.散标 = 散标;
                }

                public double get预约标() {
                    return 预约标;
                }

                public void set预约标(double 预约标) {
                    this.预约标 = 预约标;
                }
            }
        }
    }
}

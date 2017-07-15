package com.haolyy.compliance.entity.product;

/**
 * Created by wangyin on 2017/6/28.
 */

public class ProductBaseDetail  {
    /**
     * code : 200
     * msg : 成功
     * model : {"code":"200","msg":"成功","model":{"now":1500095036007,"info":{"id":9193,"projectType":3,"projectName":"周周赢00000100","annualizedRate":"11.00","appendRate":"1.00","periodUnit":3,"periodLength":12,"contractAmount":"10,000.00","amountWait":"1.00","amountScale":"0.01","interestStartDate":1501948800000,"interestEndDate":1506700800000,"status":1,"profitPlan":1,"lockPeriod":3,"beginDate":1496851200000,"bidEndDate":1502035200000,"lockDate":1502208000000,"accountBalance":null}}}
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
         * model : {"now":1500095036007,"info":{"id":9193,"projectType":3,"projectName":"周周赢00000100","annualizedRate":"11.00","appendRate":"1.00","periodUnit":3,"periodLength":12,"contractAmount":"10,000.00","amountWait":"1.00","amountScale":"0.01","interestStartDate":1501948800000,"interestEndDate":1506700800000,"status":1,"profitPlan":1,"lockPeriod":3,"beginDate":1496851200000,"bidEndDate":1502035200000,"lockDate":1502208000000,"accountBalance":null}}
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
            /**
             * now : 1500095036007
             * info : {"id":9193,"projectType":3,"projectName":"周周赢00000100","annualizedRate":"11.00","appendRate":"1.00","periodUnit":3,"periodLength":12,"contractAmount":"10,000.00","amountWait":"1.00","amountScale":"0.01","interestStartDate":1501948800000,"interestEndDate":1506700800000,"status":1,"profitPlan":1,"lockPeriod":3,"beginDate":1496851200000,"bidEndDate":1502035200000,"lockDate":1502208000000,"accountBalance":null}
             */

            private long now;
            private InfoBean info;

            public long getNow() {
                return now;
            }

            public void setNow(long now) {
                this.now = now;
            }

            public InfoBean getInfo() {
                return info;
            }

            public void setInfo(InfoBean info) {
                this.info = info;
            }

            public static class InfoBean {
                /**
                 * id : 9193
                 * projectType : 3
                 * projectName : 周周赢00000100
                 * annualizedRate : 11.00
                 * appendRate : 1.00
                 * periodUnit : 3
                 * periodLength : 12
                 * contractAmount : 10,000.00
                 * amountWait : 1.00
                 * amountScale : 0.01
                 * interestStartDate : 1501948800000
                 * interestEndDate : 1506700800000
                 * status : 1
                 * profitPlan : 1
                 * lockPeriod : 3
                 * beginDate : 1496851200000
                 * bidEndDate : 1502035200000
                 * lockDate : 1502208000000
                 * accountBalance : null
                 */

                private int id;
                private int projectType;
                private String projectName;
                private String annualizedRate;
                private String appendRate;
                private int periodUnit;
                private int periodLength;
                private String contractAmount;
                private String amountWait;
                private String amountScale;
                private long interestStartDate;
                private long interestEndDate;
                private int status;
                private int profitPlan;
                private int lockPeriod;
                private long beginDate;
                private long bidEndDate;
                private long lockDate;
                private String accountBalance;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getProjectType() {
                    return projectType;
                }

                public void setProjectType(int projectType) {
                    this.projectType = projectType;
                }

                public String getProjectName() {
                    return projectName;
                }

                public void setProjectName(String projectName) {
                    this.projectName = projectName;
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

                public String getContractAmount() {
                    return contractAmount;
                }

                public void setContractAmount(String contractAmount) {
                    this.contractAmount = contractAmount;
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

                public long getInterestStartDate() {
                    return interestStartDate;
                }

                public void setInterestStartDate(long interestStartDate) {
                    this.interestStartDate = interestStartDate;
                }

                public long getInterestEndDate() {
                    return interestEndDate;
                }

                public void setInterestEndDate(long interestEndDate) {
                    this.interestEndDate = interestEndDate;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public int getProfitPlan() {
                    return profitPlan;
                }

                public void setProfitPlan(int profitPlan) {
                    this.profitPlan = profitPlan;
                }

                public int getLockPeriod() {
                    return lockPeriod;
                }

                public void setLockPeriod(int lockPeriod) {
                    this.lockPeriod = lockPeriod;
                }

                public long getBeginDate() {
                    return beginDate;
                }

                public void setBeginDate(long beginDate) {
                    this.beginDate = beginDate;
                }

                public long getBidEndDate() {
                    return bidEndDate;
                }

                public void setBidEndDate(long bidEndDate) {
                    this.bidEndDate = bidEndDate;
                }

                public long getLockDate() {
                    return lockDate;
                }

                public void setLockDate(long lockDate) {
                    this.lockDate = lockDate;
                }

                public String getAccountBalance() {
                    return accountBalance;
                }

                public void setAccountBalance(String accountBalance) {
                    this.accountBalance = accountBalance;
                }
            }
        }
    }
}

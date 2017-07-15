package com.haolyy.compliance.entity.product;

import java.util.List;

/**
 * Created by wangyin on 2017/6/26.
 */

public class ProductList {
    /**
     * code : 200
     * msg : 成功
     * model : {"code":"200","msg":"成功","model":{"counts":555,"dataList":[{"id":10031,"projectNo":"yyb149691176052","productNo":"PJD","projectType":1,"projectName":"票据贷A2252","annualizedRate":"11.00","appendRate":"1.00","periodUnit":2,"periodLength":7,"contractAmount":"10,000.00","amountScale":"0.00","status":1},{"id":9929,"projectNo":"PJD0000099","productNo":"PJD","projectType":1,"projectName":"票据贷0000099","annualizedRate":"11.00","appendRate":"1.00","periodUnit":3,"periodLength":12,"contractAmount":"10,000.00","amountScale":"0.01","status":1},{"id":9928,"projectNo":"PJD0000098","productNo":"PJD","projectType":1,"projectName":"票据贷0000098","annualizedRate":"11.00","appendRate":"1.00","periodUnit":3,"periodLength":12,"contractAmount":"10,000.00","amountScale":"0.01","status":1},{"id":9927,"projectNo":"PJD0000097","productNo":"PJD","projectType":1,"projectName":"票据贷0000097","annualizedRate":"11.00","appendRate":"1.00","periodUnit":3,"periodLength":12,"contractAmount":"10,000.00","amountScale":"0.01","status":1},{"id":9926,"projectNo":"PJD0000096","productNo":"PJD","projectType":1,"projectName":"票据贷0000096","annualizedRate":"11.00","appendRate":"1.00","periodUnit":3,"periodLength":12,"contractAmount":"10,000.00","amountScale":"0.01","status":1},{"id":9925,"projectNo":"PJD0000095","productNo":"PJD","projectType":1,"projectName":"票据贷0000095","annualizedRate":"11.00","appendRate":"1.00","periodUnit":3,"periodLength":12,"contractAmount":"10,000.00","amountScale":"0.01","status":1},{"id":9924,"projectNo":"PJD0000094","productNo":"PJD","projectType":1,"projectName":"票据贷0000094","annualizedRate":"11.00","appendRate":"1.00","periodUnit":3,"periodLength":12,"contractAmount":"10,000.00","amountScale":"0.01","status":1},{"id":9923,"projectNo":"PJD0000093","productNo":"PJD","projectType":1,"projectName":"票据贷0000093","annualizedRate":"11.00","appendRate":"1.00","periodUnit":3,"periodLength":12,"contractAmount":"10,000.00","amountScale":"0.01","status":1},{"id":9922,"projectNo":"PJD0000092","productNo":"PJD","projectType":1,"projectName":"票据贷0000092","annualizedRate":"11.00","appendRate":"1.00","periodUnit":3,"periodLength":12,"contractAmount":"10,000.00","amountScale":"0.01","status":1},{"id":9921,"projectNo":"PJD0000091","productNo":"PJD","projectType":1,"projectName":"票据贷0000091","annualizedRate":"11.00","appendRate":"1.00","periodUnit":3,"periodLength":12,"contractAmount":"10,000.00","amountScale":"0.01","status":1}],"pageSize":10}}
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
         * model : {"counts":555,"dataList":[{"id":10031,"projectNo":"yyb149691176052","productNo":"PJD","projectType":1,"projectName":"票据贷A2252","annualizedRate":"11.00","appendRate":"1.00","periodUnit":2,"periodLength":7,"contractAmount":"10,000.00","amountScale":"0.00","status":1},{"id":9929,"projectNo":"PJD0000099","productNo":"PJD","projectType":1,"projectName":"票据贷0000099","annualizedRate":"11.00","appendRate":"1.00","periodUnit":3,"periodLength":12,"contractAmount":"10,000.00","amountScale":"0.01","status":1},{"id":9928,"projectNo":"PJD0000098","productNo":"PJD","projectType":1,"projectName":"票据贷0000098","annualizedRate":"11.00","appendRate":"1.00","periodUnit":3,"periodLength":12,"contractAmount":"10,000.00","amountScale":"0.01","status":1},{"id":9927,"projectNo":"PJD0000097","productNo":"PJD","projectType":1,"projectName":"票据贷0000097","annualizedRate":"11.00","appendRate":"1.00","periodUnit":3,"periodLength":12,"contractAmount":"10,000.00","amountScale":"0.01","status":1},{"id":9926,"projectNo":"PJD0000096","productNo":"PJD","projectType":1,"projectName":"票据贷0000096","annualizedRate":"11.00","appendRate":"1.00","periodUnit":3,"periodLength":12,"contractAmount":"10,000.00","amountScale":"0.01","status":1},{"id":9925,"projectNo":"PJD0000095","productNo":"PJD","projectType":1,"projectName":"票据贷0000095","annualizedRate":"11.00","appendRate":"1.00","periodUnit":3,"periodLength":12,"contractAmount":"10,000.00","amountScale":"0.01","status":1},{"id":9924,"projectNo":"PJD0000094","productNo":"PJD","projectType":1,"projectName":"票据贷0000094","annualizedRate":"11.00","appendRate":"1.00","periodUnit":3,"periodLength":12,"contractAmount":"10,000.00","amountScale":"0.01","status":1},{"id":9923,"projectNo":"PJD0000093","productNo":"PJD","projectType":1,"projectName":"票据贷0000093","annualizedRate":"11.00","appendRate":"1.00","periodUnit":3,"periodLength":12,"contractAmount":"10,000.00","amountScale":"0.01","status":1},{"id":9922,"projectNo":"PJD0000092","productNo":"PJD","projectType":1,"projectName":"票据贷0000092","annualizedRate":"11.00","appendRate":"1.00","periodUnit":3,"periodLength":12,"contractAmount":"10,000.00","amountScale":"0.01","status":1},{"id":9921,"projectNo":"PJD0000091","productNo":"PJD","projectType":1,"projectName":"票据贷0000091","annualizedRate":"11.00","appendRate":"1.00","periodUnit":3,"periodLength":12,"contractAmount":"10,000.00","amountScale":"0.01","status":1}],"pageSize":10}
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
             * counts : 555
             * dataList : [{"id":10031,"projectNo":"yyb149691176052","productNo":"PJD","projectType":1,"projectName":"票据贷A2252","annualizedRate":"11.00","appendRate":"1.00","periodUnit":2,"periodLength":7,"contractAmount":"10,000.00","amountScale":"0.00","status":1},{"id":9929,"projectNo":"PJD0000099","productNo":"PJD","projectType":1,"projectName":"票据贷0000099","annualizedRate":"11.00","appendRate":"1.00","periodUnit":3,"periodLength":12,"contractAmount":"10,000.00","amountScale":"0.01","status":1},{"id":9928,"projectNo":"PJD0000098","productNo":"PJD","projectType":1,"projectName":"票据贷0000098","annualizedRate":"11.00","appendRate":"1.00","periodUnit":3,"periodLength":12,"contractAmount":"10,000.00","amountScale":"0.01","status":1},{"id":9927,"projectNo":"PJD0000097","productNo":"PJD","projectType":1,"projectName":"票据贷0000097","annualizedRate":"11.00","appendRate":"1.00","periodUnit":3,"periodLength":12,"contractAmount":"10,000.00","amountScale":"0.01","status":1},{"id":9926,"projectNo":"PJD0000096","productNo":"PJD","projectType":1,"projectName":"票据贷0000096","annualizedRate":"11.00","appendRate":"1.00","periodUnit":3,"periodLength":12,"contractAmount":"10,000.00","amountScale":"0.01","status":1},{"id":9925,"projectNo":"PJD0000095","productNo":"PJD","projectType":1,"projectName":"票据贷0000095","annualizedRate":"11.00","appendRate":"1.00","periodUnit":3,"periodLength":12,"contractAmount":"10,000.00","amountScale":"0.01","status":1},{"id":9924,"projectNo":"PJD0000094","productNo":"PJD","projectType":1,"projectName":"票据贷0000094","annualizedRate":"11.00","appendRate":"1.00","periodUnit":3,"periodLength":12,"contractAmount":"10,000.00","amountScale":"0.01","status":1},{"id":9923,"projectNo":"PJD0000093","productNo":"PJD","projectType":1,"projectName":"票据贷0000093","annualizedRate":"11.00","appendRate":"1.00","periodUnit":3,"periodLength":12,"contractAmount":"10,000.00","amountScale":"0.01","status":1},{"id":9922,"projectNo":"PJD0000092","productNo":"PJD","projectType":1,"projectName":"票据贷0000092","annualizedRate":"11.00","appendRate":"1.00","periodUnit":3,"periodLength":12,"contractAmount":"10,000.00","amountScale":"0.01","status":1},{"id":9921,"projectNo":"PJD0000091","productNo":"PJD","projectType":1,"projectName":"票据贷0000091","annualizedRate":"11.00","appendRate":"1.00","periodUnit":3,"periodLength":12,"contractAmount":"10,000.00","amountScale":"0.01","status":1}]
             * pageSize : 10
             */

            private int counts;
            private int pageSize;
            private List<DataListBean> dataList;

            public int getCounts() {
                return counts;
            }

            public void setCounts(int counts) {
                this.counts = counts;
            }

            public int getPageSize() {
                return pageSize;
            }

            public void setPageSize(int pageSize) {
                this.pageSize = pageSize;
            }

            public List<DataListBean> getDataList() {
                return dataList;
            }

            public void setDataList(List<DataListBean> dataList) {
                this.dataList = dataList;
            }

            public static class DataListBean {
                /**
                 * id : 10031
                 * projectNo : yyb149691176052
                 * productNo : PJD
                 * projectType : 1
                 * projectName : 票据贷A2252
                 * annualizedRate : 11.00
                 * appendRate : 1.00
                 * periodUnit : 2
                 * periodLength : 7
                 * contractAmount : 10,000.00
                 * amountScale : 0.00
                 * status : 1
                 */

                private int id;
                private String projectNo;
                private String productNo;
                private int projectType;
                private String projectName;
                private String annualizedRate;
                private String appendRate;
                private int periodUnit;
                private int periodLength;
                private String contractAmount;
                private String amountScale;
                private int status;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getProjectNo() {
                    return projectNo;
                }

                public void setProjectNo(String projectNo) {
                    this.projectNo = projectNo;
                }

                public String getProductNo() {
                    return productNo;
                }

                public void setProductNo(String productNo) {
                    this.productNo = productNo;
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

                public String getAmountScale() {
                    return amountScale;
                }

                public void setAmountScale(String amountScale) {
                    this.amountScale = amountScale;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }
            }
        }
    }
}

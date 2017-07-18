package com.haolyy.compliance.entity.my;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wangyin on 2017/7/17.
 */

public class ProductFundList implements Serializable {

    /**
     * code : 200
     * msg : 成功
     * model : {"code":"200","msg":"成功","model":{"assetManagementList":[{"id":2175,"projectName":"短期赢B2175","projectNo":"PJD000124013","productNo":"XFD","projectType":2,"annualizedRate":"1.00","appendRate":"0.00","couponRate":"0.00","amount":"13,000.00","orderDate":"2017-07-11","orderStatus":4,"income":"0.00","appendIncome":"0.00","couponProfit":"0.00","expireDate":1,"interestDay":null},{"id":2168,"projectName":"短期赢C2168","projectNo":"PJD00012406","productNo":"XFD","projectType":2,"annualizedRate":"1.00","appendRate":"0.00","couponRate":"0.00","amount":"13,000.00","orderDate":"2017-07-11","orderStatus":1,"income":"0.00","appendIncome":"0.00","couponProfit":"0.00","expireDate":1,"interestDay":null},{"id":8997,"projectName":"消费贷0000015","projectNo":"XFD0000015","productNo":"XFD","projectType":1,"annualizedRate":"1.00","appendRate":"0.00","couponRate":"0.00","amount":"30,000.00","orderDate":"2017-07-12","orderStatus":5,"income":"0.00","appendIncome":"0.00","couponProfit":"0.00","expireDate":1,"interestDay":null},{"id":2186,"projectName":"短期赢A2186","projectNo":"PJD000124024","productNo":"XFD","projectType":2,"annualizedRate":"1.00","appendRate":"0.00","couponRate":"0.00","amount":"13,000.00","orderDate":"2017-07-11","orderStatus":1,"income":"0.00","appendIncome":"0.00","couponProfit":"0.00","expireDate":1,"interestDay":null},{"id":2179,"projectName":"短期赢A2179","projectNo":"PJD000124017","productNo":"XFD","projectType":2,"annualizedRate":"1.00","appendRate":"0.00","couponRate":"0.00","amount":"13,000.00","orderDate":"2017-07-11","orderStatus":2,"income":"0.00","appendIncome":"0.00","couponProfit":"0.00","expireDate":1,"interestDay":null},{"id":2172,"projectName":"短期赢A2172","projectNo":"PJD000124010","productNo":"XFD","projectType":2,"annualizedRate":"1.00","appendRate":"0.00","couponRate":"0.00","amount":"13,000.00","orderDate":"2017-07-11","orderStatus":2,"income":"0.00","appendIncome":"0.00","couponProfit":"0.00","expireDate":1,"interestDay":null},{"id":2165,"projectName":"短期赢A2165","projectNo":"PJD00012403","productNo":"XFD","projectType":2,"annualizedRate":"1.00","appendRate":"0.00","couponRate":"0.00","amount":"13,000.00","orderDate":"2017-07-11","orderStatus":2,"income":"0.00","appendIncome":"0.00","couponProfit":"0.00","expireDate":1,"interestDay":null},{"id":2190,"projectName":"短期赢A2190","projectNo":"PJD000124028","productNo":"XFD","projectType":2,"annualizedRate":"1.00","appendRate":"0.00","couponRate":"0.00","amount":"13,000.00","orderDate":"2017-07-11","orderStatus":1,"income":"0.00","appendIncome":"0.00","couponProfit":"0.00","expireDate":1,"interestDay":null},{"id":2183,"projectName":"短期赢B2183","projectNo":"PJD000124021","productNo":"XFD","projectType":2,"annualizedRate":"1.00","appendRate":"0.00","couponRate":"0.00","amount":"13,000.00","orderDate":"2017-07-11","orderStatus":2,"income":"0.00","appendIncome":"0.00","couponProfit":"0.00","expireDate":1,"interestDay":null},{"id":2176,"projectName":"短期赢C2176","projectNo":"PJD000124014","productNo":"XFD","projectType":2,"annualizedRate":"1.00","appendRate":"0.00","couponRate":"0.00","amount":"13,000.00","orderDate":"2017-07-11","orderStatus":1,"income":"0.00","appendIncome":"0.00","couponProfit":"0.00","expireDate":1,"interestDay":null}],"pageSum":4}}
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

    public static class ModelBeanX implements Serializable{
        /**
         * code : 200
         * msg : 成功
         * model : {"assetManagementList":[{"id":2175,"projectName":"短期赢B2175","projectNo":"PJD000124013","productNo":"XFD","projectType":2,"annualizedRate":"1.00","appendRate":"0.00","couponRate":"0.00","amount":"13,000.00","orderDate":"2017-07-11","orderStatus":4,"income":"0.00","appendIncome":"0.00","couponProfit":"0.00","expireDate":1,"interestDay":null},{"id":2168,"projectName":"短期赢C2168","projectNo":"PJD00012406","productNo":"XFD","projectType":2,"annualizedRate":"1.00","appendRate":"0.00","couponRate":"0.00","amount":"13,000.00","orderDate":"2017-07-11","orderStatus":1,"income":"0.00","appendIncome":"0.00","couponProfit":"0.00","expireDate":1,"interestDay":null},{"id":8997,"projectName":"消费贷0000015","projectNo":"XFD0000015","productNo":"XFD","projectType":1,"annualizedRate":"1.00","appendRate":"0.00","couponRate":"0.00","amount":"30,000.00","orderDate":"2017-07-12","orderStatus":5,"income":"0.00","appendIncome":"0.00","couponProfit":"0.00","expireDate":1,"interestDay":null},{"id":2186,"projectName":"短期赢A2186","projectNo":"PJD000124024","productNo":"XFD","projectType":2,"annualizedRate":"1.00","appendRate":"0.00","couponRate":"0.00","amount":"13,000.00","orderDate":"2017-07-11","orderStatus":1,"income":"0.00","appendIncome":"0.00","couponProfit":"0.00","expireDate":1,"interestDay":null},{"id":2179,"projectName":"短期赢A2179","projectNo":"PJD000124017","productNo":"XFD","projectType":2,"annualizedRate":"1.00","appendRate":"0.00","couponRate":"0.00","amount":"13,000.00","orderDate":"2017-07-11","orderStatus":2,"income":"0.00","appendIncome":"0.00","couponProfit":"0.00","expireDate":1,"interestDay":null},{"id":2172,"projectName":"短期赢A2172","projectNo":"PJD000124010","productNo":"XFD","projectType":2,"annualizedRate":"1.00","appendRate":"0.00","couponRate":"0.00","amount":"13,000.00","orderDate":"2017-07-11","orderStatus":2,"income":"0.00","appendIncome":"0.00","couponProfit":"0.00","expireDate":1,"interestDay":null},{"id":2165,"projectName":"短期赢A2165","projectNo":"PJD00012403","productNo":"XFD","projectType":2,"annualizedRate":"1.00","appendRate":"0.00","couponRate":"0.00","amount":"13,000.00","orderDate":"2017-07-11","orderStatus":2,"income":"0.00","appendIncome":"0.00","couponProfit":"0.00","expireDate":1,"interestDay":null},{"id":2190,"projectName":"短期赢A2190","projectNo":"PJD000124028","productNo":"XFD","projectType":2,"annualizedRate":"1.00","appendRate":"0.00","couponRate":"0.00","amount":"13,000.00","orderDate":"2017-07-11","orderStatus":1,"income":"0.00","appendIncome":"0.00","couponProfit":"0.00","expireDate":1,"interestDay":null},{"id":2183,"projectName":"短期赢B2183","projectNo":"PJD000124021","productNo":"XFD","projectType":2,"annualizedRate":"1.00","appendRate":"0.00","couponRate":"0.00","amount":"13,000.00","orderDate":"2017-07-11","orderStatus":2,"income":"0.00","appendIncome":"0.00","couponProfit":"0.00","expireDate":1,"interestDay":null},{"id":2176,"projectName":"短期赢C2176","projectNo":"PJD000124014","productNo":"XFD","projectType":2,"annualizedRate":"1.00","appendRate":"0.00","couponRate":"0.00","amount":"13,000.00","orderDate":"2017-07-11","orderStatus":1,"income":"0.00","appendIncome":"0.00","couponProfit":"0.00","expireDate":1,"interestDay":null}],"pageSum":4}
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

        public static class ModelBean implements Serializable{
            /**
             * assetManagementList : [{"id":2175,"projectName":"短期赢B2175","projectNo":"PJD000124013","productNo":"XFD","projectType":2,"annualizedRate":"1.00","appendRate":"0.00","couponRate":"0.00","amount":"13,000.00","orderDate":"2017-07-11","orderStatus":4,"income":"0.00","appendIncome":"0.00","couponProfit":"0.00","expireDate":1,"interestDay":null},{"id":2168,"projectName":"短期赢C2168","projectNo":"PJD00012406","productNo":"XFD","projectType":2,"annualizedRate":"1.00","appendRate":"0.00","couponRate":"0.00","amount":"13,000.00","orderDate":"2017-07-11","orderStatus":1,"income":"0.00","appendIncome":"0.00","couponProfit":"0.00","expireDate":1,"interestDay":null},{"id":8997,"projectName":"消费贷0000015","projectNo":"XFD0000015","productNo":"XFD","projectType":1,"annualizedRate":"1.00","appendRate":"0.00","couponRate":"0.00","amount":"30,000.00","orderDate":"2017-07-12","orderStatus":5,"income":"0.00","appendIncome":"0.00","couponProfit":"0.00","expireDate":1,"interestDay":null},{"id":2186,"projectName":"短期赢A2186","projectNo":"PJD000124024","productNo":"XFD","projectType":2,"annualizedRate":"1.00","appendRate":"0.00","couponRate":"0.00","amount":"13,000.00","orderDate":"2017-07-11","orderStatus":1,"income":"0.00","appendIncome":"0.00","couponProfit":"0.00","expireDate":1,"interestDay":null},{"id":2179,"projectName":"短期赢A2179","projectNo":"PJD000124017","productNo":"XFD","projectType":2,"annualizedRate":"1.00","appendRate":"0.00","couponRate":"0.00","amount":"13,000.00","orderDate":"2017-07-11","orderStatus":2,"income":"0.00","appendIncome":"0.00","couponProfit":"0.00","expireDate":1,"interestDay":null},{"id":2172,"projectName":"短期赢A2172","projectNo":"PJD000124010","productNo":"XFD","projectType":2,"annualizedRate":"1.00","appendRate":"0.00","couponRate":"0.00","amount":"13,000.00","orderDate":"2017-07-11","orderStatus":2,"income":"0.00","appendIncome":"0.00","couponProfit":"0.00","expireDate":1,"interestDay":null},{"id":2165,"projectName":"短期赢A2165","projectNo":"PJD00012403","productNo":"XFD","projectType":2,"annualizedRate":"1.00","appendRate":"0.00","couponRate":"0.00","amount":"13,000.00","orderDate":"2017-07-11","orderStatus":2,"income":"0.00","appendIncome":"0.00","couponProfit":"0.00","expireDate":1,"interestDay":null},{"id":2190,"projectName":"短期赢A2190","projectNo":"PJD000124028","productNo":"XFD","projectType":2,"annualizedRate":"1.00","appendRate":"0.00","couponRate":"0.00","amount":"13,000.00","orderDate":"2017-07-11","orderStatus":1,"income":"0.00","appendIncome":"0.00","couponProfit":"0.00","expireDate":1,"interestDay":null},{"id":2183,"projectName":"短期赢B2183","projectNo":"PJD000124021","productNo":"XFD","projectType":2,"annualizedRate":"1.00","appendRate":"0.00","couponRate":"0.00","amount":"13,000.00","orderDate":"2017-07-11","orderStatus":2,"income":"0.00","appendIncome":"0.00","couponProfit":"0.00","expireDate":1,"interestDay":null},{"id":2176,"projectName":"短期赢C2176","projectNo":"PJD000124014","productNo":"XFD","projectType":2,"annualizedRate":"1.00","appendRate":"0.00","couponRate":"0.00","amount":"13,000.00","orderDate":"2017-07-11","orderStatus":1,"income":"0.00","appendIncome":"0.00","couponProfit":"0.00","expireDate":1,"interestDay":null}]
             * pageSum : 4
             */

            private int pageSum;
            private List<AssetManagementListBean> assetManagementList;

            public int getPageSum() {
                return pageSum;
            }

            public void setPageSum(int pageSum) {
                this.pageSum = pageSum;
            }

            public List<AssetManagementListBean> getAssetManagementList() {
                return assetManagementList;
            }

            public void setAssetManagementList(List<AssetManagementListBean> assetManagementList) {
                this.assetManagementList = assetManagementList;
            }

            public static class AssetManagementListBean implements Serializable{
                /**
                 * id : 2175
                 * projectName : 短期赢B2175
                 * projectNo : PJD000124013
                 * productNo : XFD
                 * projectType : 2
                 * annualizedRate : 1.00
                 * appendRate : 0.00
                 * couponRate : 0.00
                 * amount : 13,000.00
                 * orderDate : 2017-07-11
                 * orderStatus : 4
                 * income : 0.00
                 * appendIncome : 0.00
                 * couponProfit : 0.00
                 * expireDate : 1
                 * interestDay : null
                 */

                private int id;
                private String projectName;
                private String projectNo;
                private String productNo;
                private int projectType;
                private String annualizedRate;
                private String appendRate;
                private String couponRate;
                private String amount;
                private String orderDate;
                private int orderStatus;
                private String income;
                private String appendIncome;
                private String couponProfit;
                private int expireDate;
                private Object interestDay;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getProjectName() {
                    return projectName;
                }

                public void setProjectName(String projectName) {
                    this.projectName = projectName;
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

                public String getCouponRate() {
                    return couponRate;
                }

                public void setCouponRate(String couponRate) {
                    this.couponRate = couponRate;
                }

                public String getAmount() {
                    return amount;
                }

                public void setAmount(String amount) {
                    this.amount = amount;
                }

                public String getOrderDate() {
                    return orderDate;
                }

                public void setOrderDate(String orderDate) {
                    this.orderDate = orderDate;
                }

                public int getOrderStatus() {
                    return orderStatus;
                }

                public void setOrderStatus(int orderStatus) {
                    this.orderStatus = orderStatus;
                }

                public String getIncome() {
                    return income;
                }

                public void setIncome(String income) {
                    this.income = income;
                }

                public String getAppendIncome() {
                    return appendIncome;
                }

                public void setAppendIncome(String appendIncome) {
                    this.appendIncome = appendIncome;
                }

                public String getCouponProfit() {
                    return couponProfit;
                }

                public void setCouponProfit(String couponProfit) {
                    this.couponProfit = couponProfit;
                }

                public int getExpireDate() {
                    return expireDate;
                }

                public void setExpireDate(int expireDate) {
                    this.expireDate = expireDate;
                }

                public Object getInterestDay() {
                    return interestDay;
                }

                public void setInterestDay(Object interestDay) {
                    this.interestDay = interestDay;
                }
            }
        }
    }
}

package com.haolyy.compliance.ui.my.Bean;

import java.util.List;

/**
 * Created by User on 2017/7/12.
 */

public class DealRecordBean {


    /**
     * code : 200
     * msg : 成功
     * model : {"code":"200","msg":"成功","model":{"pageSum":1,"fundsRecordList":[{"transferDate":"2017-07-11 09:57:08.0","transferTime":null,"capitalType":2001,"capitalNo":"123","type":1,"amount":"1256465.00","availableAmount":"1231231233.00"},{"transferDate":"2017-07-11 09:57:08.0","transferTime":null,"capitalType":2001,"capitalNo":"123","type":1,"amount":"1256465.00","availableAmount":"1231231233.00"},{"transferDate":"2017-07-11 09:57:08.0","transferTime":null,"capitalType":2001,"capitalNo":"123","type":1,"amount":"1256465.00","availableAmount":"1231231233.00"},{"transferDate":"2017-07-11 09:57:08.0","transferTime":null,"capitalType":2001,"capitalNo":"123","type":1,"amount":"1256465.00","availableAmount":"1231231233.00"},{"transferDate":"2017-07-11 09:57:08.0","transferTime":null,"capitalType":2001,"capitalNo":"123","type":1,"amount":"1256465.00","availableAmount":"1231231233.00"},{"transferDate":"2017-07-11 09:57:08.0","transferTime":null,"capitalType":2001,"capitalNo":"123","type":1,"amount":"1256465.00","availableAmount":"1231231233.00"},{"transferDate":"2017-07-11 09:57:08.0","transferTime":null,"capitalType":2001,"capitalNo":"123","type":1,"amount":"1256465.00","availableAmount":"1231231233.00"},{"transferDate":"2017-07-11 09:57:08.0","transferTime":null,"capitalType":2001,"capitalNo":"123","type":1,"amount":"1256465.00","availableAmount":"1231231233.00"},{"transferDate":"2017-07-11 09:57:08.0","transferTime":null,"capitalType":2001,"capitalNo":"123","type":1,"amount":"1256465.00","availableAmount":"1231231233.00"}]}}
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
         * model : {"pageSum":1,"fundsRecordList":[{"transferDate":"2017-07-11 09:57:08.0","transferTime":null,"capitalType":2001,"capitalNo":"123","type":1,"amount":"1256465.00","availableAmount":"1231231233.00"},{"transferDate":"2017-07-11 09:57:08.0","transferTime":null,"capitalType":2001,"capitalNo":"123","type":1,"amount":"1256465.00","availableAmount":"1231231233.00"},{"transferDate":"2017-07-11 09:57:08.0","transferTime":null,"capitalType":2001,"capitalNo":"123","type":1,"amount":"1256465.00","availableAmount":"1231231233.00"},{"transferDate":"2017-07-11 09:57:08.0","transferTime":null,"capitalType":2001,"capitalNo":"123","type":1,"amount":"1256465.00","availableAmount":"1231231233.00"},{"transferDate":"2017-07-11 09:57:08.0","transferTime":null,"capitalType":2001,"capitalNo":"123","type":1,"amount":"1256465.00","availableAmount":"1231231233.00"},{"transferDate":"2017-07-11 09:57:08.0","transferTime":null,"capitalType":2001,"capitalNo":"123","type":1,"amount":"1256465.00","availableAmount":"1231231233.00"},{"transferDate":"2017-07-11 09:57:08.0","transferTime":null,"capitalType":2001,"capitalNo":"123","type":1,"amount":"1256465.00","availableAmount":"1231231233.00"},{"transferDate":"2017-07-11 09:57:08.0","transferTime":null,"capitalType":2001,"capitalNo":"123","type":1,"amount":"1256465.00","availableAmount":"1231231233.00"},{"transferDate":"2017-07-11 09:57:08.0","transferTime":null,"capitalType":2001,"capitalNo":"123","type":1,"amount":"1256465.00","availableAmount":"1231231233.00"}]}
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
             * pageSum : 1
             * fundsRecordList : [{"transferDate":"2017-07-11 09:57:08.0","transferTime":null,"capitalType":2001,"capitalNo":"123","type":1,"amount":"1256465.00","availableAmount":"1231231233.00"},{"transferDate":"2017-07-11 09:57:08.0","transferTime":null,"capitalType":2001,"capitalNo":"123","type":1,"amount":"1256465.00","availableAmount":"1231231233.00"},{"transferDate":"2017-07-11 09:57:08.0","transferTime":null,"capitalType":2001,"capitalNo":"123","type":1,"amount":"1256465.00","availableAmount":"1231231233.00"},{"transferDate":"2017-07-11 09:57:08.0","transferTime":null,"capitalType":2001,"capitalNo":"123","type":1,"amount":"1256465.00","availableAmount":"1231231233.00"},{"transferDate":"2017-07-11 09:57:08.0","transferTime":null,"capitalType":2001,"capitalNo":"123","type":1,"amount":"1256465.00","availableAmount":"1231231233.00"},{"transferDate":"2017-07-11 09:57:08.0","transferTime":null,"capitalType":2001,"capitalNo":"123","type":1,"amount":"1256465.00","availableAmount":"1231231233.00"},{"transferDate":"2017-07-11 09:57:08.0","transferTime":null,"capitalType":2001,"capitalNo":"123","type":1,"amount":"1256465.00","availableAmount":"1231231233.00"},{"transferDate":"2017-07-11 09:57:08.0","transferTime":null,"capitalType":2001,"capitalNo":"123","type":1,"amount":"1256465.00","availableAmount":"1231231233.00"},{"transferDate":"2017-07-11 09:57:08.0","transferTime":null,"capitalType":2001,"capitalNo":"123","type":1,"amount":"1256465.00","availableAmount":"1231231233.00"}]
             */

            private int pageSum;
            private List<FundsRecordListBean> fundsRecordList;

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

            public static class FundsRecordListBean {
                /**
                 * transferDate : 2017-07-11 09:57:08.0
                 * transferTime : null
                 * capitalType : 2001
                 * capitalNo : 123
                 * type : 1
                 * amount : 1256465.00
                 * availableAmount : 1231231233.00
                 */

                private String transferDate;
                private Object transferTime;
                private int capitalType;
                private String capitalNo;
                private int type;
                private String amount;
                private String availableAmount;

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
            }
        }
    }
}

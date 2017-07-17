package com.haolyy.compliance.entity.home;

import java.util.List;

/**
 * Created by User on 2017/7/12.
 */

public class FundStatictisIncomeBean {

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
            private List<IncomeList30Bean> incomeList30;
            private List<IncomeList7Bean> incomeList7;

            public List<IncomeList30Bean> getIncomeList30() {
                return incomeList30;
            }

            public void setIncomeList30(List<IncomeList30Bean> incomeList30) {
                this.incomeList30 = incomeList30;
            }

            public List<IncomeList7Bean> getIncomeList7() {
                return incomeList7;
            }

            public void setIncomeList7(List<IncomeList7Bean> incomeList7) {
                this.incomeList7 = incomeList7;
            }

            public static class IncomeList30Bean {
                /**
                 * YXJH : 0
                 * incomeSum : 0
                 * XSB : 0
                 * YJH : 0
                 * incomeDate : 1498320000
                 * userId : 0
                 * DQY : 0
                 */

                private int YXJH;
                private int incomeSum;
                private int XSB;
                private int YJH;
                private int incomeDate;
                private int userId;
                private int DQY;

                public int getYXJH() {
                    return YXJH;
                }

                public void setYXJH(int YXJH) {
                    this.YXJH = YXJH;
                }

                public int getIncomeSum() {
                    return incomeSum;
                }

                public void setIncomeSum(int incomeSum) {
                    this.incomeSum = incomeSum;
                }

                public int getXSB() {
                    return XSB;
                }

                public void setXSB(int XSB) {
                    this.XSB = XSB;
                }

                public int getYJH() {
                    return YJH;
                }

                public void setYJH(int YJH) {
                    this.YJH = YJH;
                }

                public int getIncomeDate() {
                    return incomeDate;
                }

                public void setIncomeDate(int incomeDate) {
                    this.incomeDate = incomeDate;
                }

                public int getUserId() {
                    return userId;
                }

                public void setUserId(int userId) {
                    this.userId = userId;
                }

                public int getDQY() {
                    return DQY;
                }

                public void setDQY(int DQY) {
                    this.DQY = DQY;
                }
            }

            public static class IncomeList7Bean {
                /**
                 * YXJH : 0
                 * incomeSum : 0
                 * XSB : 0
                 * YJH : 0
                 * incomeDate : 1499961600
                 * userId : 0
                 * DQY : 0
                 */

                private int YXJH;
                private double incomeSum;
                private int XSB;
                private int YJH;
                private int incomeDate;
                private int userId;
                private int DQY;

                public int getYXJH() {
                    return YXJH;
                }

                public void setYXJH(int YXJH) {
                    this.YXJH = YXJH;
                }

                public double getIncomeSum() {
                    return incomeSum;
                }

                public void setIncomeSum(double incomeSum) {
                    this.incomeSum = incomeSum;
                }

                public int getXSB() {
                    return XSB;
                }

                public void setXSB(int XSB) {
                    this.XSB = XSB;
                }

                public int getYJH() {
                    return YJH;
                }

                public void setYJH(int YJH) {
                    this.YJH = YJH;
                }

                public int getIncomeDate() {
                    return incomeDate;
                }

                public void setIncomeDate(int incomeDate) {
                    this.incomeDate = incomeDate;
                }

                public int getUserId() {
                    return userId;
                }

                public void setUserId(int userId) {
                    this.userId = userId;
                }

                public int getDQY() {
                    return DQY;
                }

                public void setDQY(int DQY) {
                    this.DQY = DQY;
                }
            }
        }
    }
}

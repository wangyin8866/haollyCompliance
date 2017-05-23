package com.haolyy.compliance.entity;

/**
 * Created by wangyin on 2017/5/22.
 */

public class InvestLog {
    private String phone;
    private String time;
    private String investMoney;

    public InvestLog(String phone, String time, String investMoney) {
        this.phone = phone;
        this.time = time;
        this.investMoney = investMoney;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getInvestMoney() {
        return investMoney;
    }

    public void setInvestMoney(String investMoney) {
        this.investMoney = investMoney;
    }
}

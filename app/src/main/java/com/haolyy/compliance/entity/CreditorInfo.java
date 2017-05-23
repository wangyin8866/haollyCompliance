package com.haolyy.compliance.entity;

/**
 * Created by wangyin on 2017/5/22.
 */

public class CreditorInfo {
    private String addresss;
    private String product;
    private String money;
    private String deadline;
    private String rate;

    public CreditorInfo(String addresss, String product, String money, String deadline, String rate) {
        this.addresss = addresss;
        this.product = product;
        this.money = money;
        this.deadline = deadline;
        this.rate = rate;
    }

    public String getAddresss() {
        return addresss;
    }

    public void setAddresss(String addresss) {
        this.addresss = addresss;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}

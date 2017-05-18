package com.haolyy.compliance.entity;

/**
 * Created by wangyin on 2017/5/18.
 */

public class TestProduct {
    private int num;
    private int rate;
    private int deline;
    private int data;
    private int total;

    public TestProduct(int num, int rate, int deline, int data, int total) {
        this.num = num;
        this.rate = rate;
        this.deline = deline;
        this.data = data;
        this.total = total;
    }

    public int getNum() {
        return num;
    }

    public int getRate() {
        return rate;
    }

    public int getDeline() {
        return deline;
    }

    public int getData() {
        return data;
    }

    public int getTotal() {
        return total;
    }
}

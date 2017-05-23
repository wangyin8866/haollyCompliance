package com.haolyy.compliance.entity;

/**
 * Created by wangyin on 2017/5/23.
 */

public class Repayment  {
    private String periods;
    private String interest;
    private String capital;
    private String residueCapital;

    public Repayment(String periods, String interest, String capital, String residueCapital) {
        this.periods = periods;
        this.interest = interest;
        this.capital = capital;
        this.residueCapital = residueCapital;
    }

    public String getPeriods() {
        return periods;
    }

    public void setPeriods(String periods) {
        this.periods = periods;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getResidueCapital() {
        return residueCapital;
    }

    public void setResidueCapital(String residueCapital) {
        this.residueCapital = residueCapital;
    }
}

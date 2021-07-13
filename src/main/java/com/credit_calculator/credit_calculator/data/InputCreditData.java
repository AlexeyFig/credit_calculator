package com.credit_calculator.credit_calculator.data;

public class InputCreditData {
    private int creditSum;
    private int monthAmount;
    private double percentRate;

    public InputCreditData(int creditSum, int creditTerm, double interestRate) {
        this.creditSum = creditSum;
        this.monthAmount = creditTerm;
        this.percentRate = interestRate;
    }

    public int getCreditSum() {
        return creditSum;
    }

    public void setCreditSum(int creditSum) {
        this.creditSum = creditSum;
    }

    public int getMonthAmount() {
        return monthAmount;
    }

    public void setMonthAmount(int creditTerm) {
        this.monthAmount = creditTerm;
    }

    public double getPercentRate() {
        return percentRate;
    }

    public void setPercentRate(double interestRate) {
        this.percentRate = interestRate;
    }

    @Override
    public String toString() {
        return "InputCreditData{" +
                "creditSum=" + creditSum +
                ", creditTerm=" + monthAmount +
                ", percentRate=" + percentRate +
                '}';
    }
}

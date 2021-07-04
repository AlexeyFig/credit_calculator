package com.credit_calculator.credit_calculator.data;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


public class MonthPaymentData {

    private int numberOfPayment;
    private String paymentDate;
    private double bodyPayment;
    private double percentPayment;
    private double sumOfDept;
    private double monthPayment;

    public MonthPaymentData(int numberOfPayment, String paymentDate, double bodyPayment, double percentPayment, double sumOfDept, double monthPayment) {
        this.numberOfPayment = numberOfPayment;
        this.paymentDate = paymentDate;
        this.bodyPayment = bodyPayment;
        this.percentPayment = percentPayment;
        this.sumOfDept = sumOfDept;
        this.monthPayment = monthPayment;
    }

    public int getNumberOfPayment() {
        return numberOfPayment;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public double getBodyPayment() { return bodyPayment; }

    public double getPercentPayment() {
        return percentPayment;
    }

    public double getMonthPayment() {
        return monthPayment;
    }

    public double getSumOfDept() { return sumOfDept;  }


}

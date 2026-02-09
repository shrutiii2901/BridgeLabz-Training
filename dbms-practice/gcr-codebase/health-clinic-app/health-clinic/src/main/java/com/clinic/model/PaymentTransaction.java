package com.clinic.model;

import java.sql.Timestamp;

public class PaymentTransaction {

    private int transactionId;
    private int billId;
    private Timestamp paymentDate;
    private String paymentMode;

    public PaymentTransaction() {
    }

    public PaymentTransaction(int billId, String paymentMode) {
        this.billId = billId;
        this.paymentMode = paymentMode;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public Timestamp getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Timestamp paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }
}

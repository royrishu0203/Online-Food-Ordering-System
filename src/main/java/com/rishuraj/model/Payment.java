package com.rishuraj.model;

public class Payment {
    private int payment_id;
    private String payment_method;
    private int order_id;
    private double amount;

    public Payment(int payment_id , String payment_method , int order_id , double amount){
        this.payment_id = payment_id;
        this.payment_method = payment_method;
        this.order_id = order_id;
        this.amount = amount;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public int getOrder_id() {
        return order_id;
    }

    public double getAmount() {
        return amount;
    }
}

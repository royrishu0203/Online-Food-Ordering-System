package com.rishuraj.model;
public class Order {

    private int order_id;
    private int user_id;
    private String order_date;
    private double total_amount;
    private String order_status;

    public Order(int order_id, int user_id, String order_date,
                 double total_amount, String order_status) {

        this.order_id = order_id;
        this.user_id = user_id;
        this.order_date = order_date;
        this.total_amount = total_amount;
        this.order_status = order_status;
    }

    public int getOrder_id() {
        return order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getOrder_date() {
        return order_date;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public String getOrder_status() {
        return order_status;
    }
}
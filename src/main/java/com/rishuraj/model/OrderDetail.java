package com.rishuraj.model;

public class OrderDetail {

    private int order_detail_id;
    private int order_id;
    private int food_id;
    private int quantity;

    public OrderDetail(int order_detail_id, int order_id, int food_id, int quantity) {
        this.order_detail_id = order_detail_id;
        this.order_id = order_id;
        this.food_id = food_id;
        this.quantity = quantity;
    }

    public int getOrder_detail_id() {
        return order_detail_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public int getFood_id() {
        return food_id;
    }

    public int getQuantity() {
        return quantity;
    }
}
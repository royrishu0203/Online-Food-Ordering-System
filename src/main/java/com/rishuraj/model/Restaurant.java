package com.rishuraj.model;

public class Restaurant {
    private int restaurant_id;
    private String restaurant_name;
    private String location;
    private long fssai_no;
    private double rating;
    private String opening_time;
    private String closing_time;
    private String status;

    public Restaurant(int restaurant_id, String restaurant_name, String location, long fssai_no, double rating, String opening_time, String closing_time, String status) {
        this.restaurant_id = restaurant_id;
        this.restaurant_name = restaurant_name;
        this.location = location;
        this.fssai_no = fssai_no;
        this.rating = rating;
        this.opening_time = opening_time;
        this.closing_time = closing_time;
        this.status = status;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public String getRestaurant_name() {
        return restaurant_name;
    }

    public String getLocation() {
        return location;
    }

    public long getFssai_no() {
        return fssai_no;
    }

    public double getRating() {
        return rating;
    }

    public String getOpening_time() {
        return opening_time;
    }

    public String getClosing_time() {
        return closing_time;
    }

    public String getStatus() {
        return status;
    }
}

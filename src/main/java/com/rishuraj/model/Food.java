package com.rishuraj.model;

public class Food {
    private int food_id;
    private int restaurant_id;
    private String food_name;
    private String category;
    private double price;
    private String availabilty;

    public Food(int food_id , int restaurant_id , String food_name , String category , double price , String availabilty){
        this.food_id = food_id;
        this.restaurant_id = restaurant_id;
        this.food_name = food_name;
        this.category = category;
        this.price = price;
        this.availabilty = availabilty;
    }

    public int getFood_id() {
        return food_id;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public String getFood_name() {
        return food_name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public String getAvailabilty() {
        return availabilty;
    }
}

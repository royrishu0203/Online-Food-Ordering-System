package com.rishuraj.service;
import com.rishuraj.database.DatabaseConnection;
import com.rishuraj.model.Food;

import java.sql.*;

public class FoodService {
    public void registerFood(Food food){
        try{
            Connection con = DatabaseConnection.getConnection();
            System.out.println("Database Connected successfully");

            String sql = "INSERT INTO food_item(food_id, restaurant_id, food_name, category, price, availability) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1 , food.getFood_id());
            ps.setInt(2, food.getRestaurant_id());
            ps.setString(3 , food.getFood_name());
            ps.setString(5, food.getCategory());
            ps.setDouble(5 , food.getPrice());
            ps.setString(6, food.getAvailabilty());

            int rows = ps.executeUpdate();

            if(rows>0){
                System.out.println("Data inserted successfully");
            }else{
                System.out.println("Not Inserted");
            }
            con.close();
            ps.close();
        }catch(SQLException e ){
            System.out.println(e);
        }
    }

    public  void viewAllFood(){
        try{
            Connection con = DatabaseConnection.getConnection();
            System.out.println("Database Connected successfully");

            String sql = "SELECT * FROM food_items";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                System.out.println("Food ID : " + rs.getInt("food_id"));
                System.out.println("Restaurant ID : " + rs.getInt("restaurant_id"));
                System.out.println("Food Name : " + rs.getString("food_name"));
                System.out.println("Category : " + rs.getString("category"));
                System.out.println("Price : " + rs.getDouble("price"));
                System.out.println("Availability : " + rs.getString("availability"));
                System.out.println("--------------------------------");
            }
            con.close();
            ps.close();
            rs.close();
        }catch (SQLException e ){
            System.out.println(e);
        }
    }

    public void searchFood(int searchId){
        try {
            Connection con = DatabaseConnection.getConnection();
            System.out.println("Database Connected successfully");

            String sql = "SELECT * FROM food_items WHERE food_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1 , searchId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("Food ID : " + rs.getInt("food_id"));
                System.out.println("Restaurant ID : " + rs.getInt("restaurant_id"));
                System.out.println("Food Name : " + rs.getString("food_name"));
                System.out.println("Category : " + rs.getString("category"));
                System.out.println("Price : " + rs.getDouble("price"));
                System.out.println("Availability : " + rs.getString("availability"));
                System.out.println("--------------------------------");
            }
            con.close();
            ps.close();
            rs.close();
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public void updateFood(int updateId , double newPrice){
        try {
            Connection con = DatabaseConnection.getConnection();
            System.out.println("Database Connected successfully");

            String sql = "UPDATE food_item SET price  = ? WHERE food_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1,newPrice);
            ps.setInt(2 , updateId);
            int rows = ps.executeUpdate();

            if(rows>0){
                System.out.println("Data inserted successfully");
            }else{
                System.out.println("Not Inserted");
            }
            con.close();
            ps.close();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    public void deleteFood(int deleteId) {
        try {
            Connection con = DatabaseConnection.getConnection();
            System.out.println("Database Connected successfully");

            String sql5 = "DELETE FROM food WHERE food_id = ?";
            PreparedStatement ps = con.prepareStatement(sql5);

            ps.setInt(1, deleteId);

            int rowsDeleted = ps.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Restaurant Deleted Successfully");
            } else {
                System.out.println("Restaurant Not Found");
            }
            ps.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}

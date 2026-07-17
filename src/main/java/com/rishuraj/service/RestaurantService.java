package com.rishuraj.service;

import com.rishuraj.database.DatabaseConnection;
import com.rishuraj.model.Restaurant;

import java.sql.*;

public class RestaurantService {
    public void registerRestaurant(Restaurant restaurant) {
        try {
            Connection con = DatabaseConnection.getConnection();
            System.out.println("Database Connected successfully");

            String sql = "INSERT INTO restaurant(restaurant_id,restaurant_name,location, fssai_no,rating,opening_time,closing_time,status) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, restaurant.getRestaurant_id());
            ps.setString(2, restaurant.getRestaurant_name());
            ps.setString(3, restaurant.getLocation());
            ps.setLong(4, restaurant.getFssai_no());
            ps.setDouble(5, restaurant.getRating());
            ps.setString(6, restaurant.getOpening_time());
            ps.setString(7, restaurant.getClosing_time());
            ps.setString(8, restaurant.getStatus());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Inserted successfully");
            } else {
                System.out.println("Not Inserted");
            }
            ps.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void viewAllRestaurant() {
        try {
            Connection con = DatabaseConnection.getConnection();
            System.out.println("Database Connected successfully");

//                View all users;
            String sql2 = "SELECT * FROM restaurant ";
            PreparedStatement ps1 = con.prepareStatement(sql2);
            ResultSet rs = ps1.executeQuery();
            while (rs.next()) {
                System.out.println("Restaurant ID : " + rs.getInt("restaurant_id"));
                System.out.println("Restaurant Name : " + rs.getString("restaurant_name"));
                System.out.println("Location : " + rs.getString("location"));
                System.out.println("Rating : " + rs.getDouble("rating"));
                System.out.println("Opening Time : " + rs.getString("opening_time"));
                System.out.println("Closing Time : " + rs.getString("closing_time"));
                System.out.println("Status : " + rs.getString("status"));
                System.out.println("--------------------------------");
            }

            rs.close();
            ps1.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void searchRestaurant(int searchId) {
        try {
            Connection con = DatabaseConnection.getConnection();
            System.out.println("Database Connected successfully");

//                To search a Restaurant;
            String sql3 = "SELECT * FROM restaurant WHERE restaurant_id = ?";
            PreparedStatement ps3 = con.prepareStatement(sql3);
            ps3.setInt(1, searchId);

            ResultSet rs1 = ps3.executeQuery();

            while (rs1.next()) {
                System.out.println("Restaurant ID : " + rs1.getInt("restaurant_id"));
                System.out.println("Restaurant Name : " + rs1.getString("restaurant_name"));
                System.out.println("Location : " + rs1.getString("location"));
                System.out.println("Rating : " + rs1.getDouble("rating"));
                System.out.println("Opening Time : " + rs1.getString("opening_time"));
                System.out.println("Closing Time : " + rs1.getString("closing_time"));
                System.out.println("Status : " + rs1.getString("status"));
                System.out.println("--------------------------------");

            }
            rs1.close();
            ps3.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateRestaurant(int updateId, String newLocation) {
        try {
            Connection con = DatabaseConnection.getConnection();
            System.out.println("Database Connected successfully");

//                To update user;
            String sql4 = "UPDATE restaurant SET location = ? WHERE restaurant_id = ?";
            PreparedStatement ps4 = con.prepareStatement(sql4);

            ps4.setString(1, newLocation);
            ps4.setInt(2, updateId);

            int rowsUpdated = ps4.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Address Updated Successfully");
            } else {
                System.out.println("Restaurant Not Found");
            }
            ps4.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteRestaurant(int deleteId) {
        try {
            Connection con = DatabaseConnection.getConnection();
            System.out.println("Database Connected successfully");

            String sql5 = "DELETE FROM restaurant WHERE restaurant_id = ?";
            PreparedStatement ps5 = con.prepareStatement(sql5);

            ps5.setInt(1, deleteId);

            int rowsDeleted = ps5.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Restaurant Deleted Successfully");
            } else {
                System.out.println("Restaurant Not Found");
            }

            ps5.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
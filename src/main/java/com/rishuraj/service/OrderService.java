package com.rishuraj.service;

import com.rishuraj.database.DatabaseConnection;
import com.rishuraj.model.Order;

import java.sql.*;

public class OrderService {

    public void registerOrder(Order order) {
        try {
            Connection con = DatabaseConnection.getConnection();
            System.out.println("Database Connected successfully");

            String sql = "INSERT INTO orders(order_id,user_id,order_date,total_amount,order_status) VALUES (?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, order.getOrder_id());
            ps.setInt(2, order.getUser_id());
            ps.setString(3, order.getOrder_date());
            ps.setDouble(4, order.getTotal_amount());
            ps.setString(5, order.getOrder_status());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Order Added Successfully");
            } else {
                System.out.println("Order Not Added");
            }

            ps.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void viewAllOrders() {
        try {
            Connection con = DatabaseConnection.getConnection();
            System.out.println("Database Connected successfully");

            String sql = "SELECT * FROM orders";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("Order ID : " + rs.getInt("order_id"));
                System.out.println("User ID : " + rs.getInt("user_id"));
                System.out.println("Order Date : " + rs.getString("order_date"));
                System.out.println("Total Amount : " + rs.getDouble("total_amount"));
                System.out.println("Order Status : " + rs.getString("order_status"));
                System.out.println("--------------------------------");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void searchOrder(int searchId) {
        try {
            Connection con = DatabaseConnection.getConnection();
            System.out.println("Database Connected successfully");

            String sql = "SELECT * FROM orders WHERE order_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, searchId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("Order ID : " + rs.getInt("order_id"));
                System.out.println("User ID : " + rs.getInt("user_id"));
                System.out.println("Order Date : " + rs.getString("order_date"));
                System.out.println("Total Amount : " + rs.getDouble("total_amount"));
                System.out.println("Order Status : " + rs.getString("order_status"));

            } else {
                System.out.println("Order Not Found");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateOrder(int updateId, String newStatus) {
        try {
            Connection con = DatabaseConnection.getConnection();
            System.out.println("Database Connected successfully");

            String sql = "UPDATE orders SET order_status = ? WHERE order_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, newStatus);
            ps.setInt(2, updateId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Order Updated Successfully");
            } else {
                System.out.println("Order Not Found");
            }

            ps.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteOrder(int deleteId) {
        try {
            Connection con = DatabaseConnection.getConnection();
            System.out.println("Database Connected successfully");

            String sql = "DELETE FROM orders WHERE order_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, deleteId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Order Deleted Successfully");
            } else {
                System.out.println("Order Not Found");
            }

            ps.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
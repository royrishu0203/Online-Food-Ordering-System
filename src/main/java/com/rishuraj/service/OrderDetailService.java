package com.rishuraj.service;

import com.rishuraj.database.DatabaseConnection;
import com.rishuraj.model.OrderDetail;

import java.sql.*;

public class OrderDetailService {

    public void registerOrderDetail(OrderDetail orderDetail) {
        try {
            Connection con = DatabaseConnection.getConnection();

            String sql = "INSERT INTO order_details(order_detail_id,order_id,food_id,quantity) VALUES (?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, orderDetail.getOrder_detail_id());
            ps.setInt(2, orderDetail.getOrder_id());
            ps.setInt(3, orderDetail.getFood_id());
            ps.setInt(4, orderDetail.getQuantity());

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Order Detail Added Successfully");
            else
                System.out.println("Not Added");

            ps.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void viewAllOrderDetails() {
        try {
            Connection con = DatabaseConnection.getConnection();
            System.out.println("Database Connected successfully");

            String sql = "SELECT * FROM order_details";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("Order Detail ID : " + rs.getInt("order_detail_id"));
                System.out.println("Order ID : " + rs.getInt("order_id"));
                System.out.println("Food ID : " + rs.getInt("food_id"));
                System.out.println("Quantity : " + rs.getInt("quantity"));
                System.out.println("--------------------------------");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void searchOrderDetail(int searchId) {
        try {
            Connection con = DatabaseConnection.getConnection();
            System.out.println("Database Connected successfully");

            String sql = "SELECT * FROM order_details WHERE order_detail_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, searchId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("Order Detail ID : " + rs.getInt("order_detail_id"));
                System.out.println("Order ID : " + rs.getInt("order_id"));
                System.out.println("Food ID : " + rs.getInt("food_id"));
                System.out.println("Quantity : " + rs.getInt("quantity"));

            } else {
                System.out.println("Order Detail Not Found");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateOrderDetail(int updateId, int newQuantity) {
        try {
            Connection con = DatabaseConnection.getConnection();
            System.out.println("Database Connected successfully");

            String sql = "UPDATE order_details SET quantity = ? WHERE order_detail_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, newQuantity);
            ps.setInt(2, updateId);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Updated Successfully");
            else
                System.out.println("Order Detail Not Found");

            ps.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteOrderDetail(int deleteId) {
        try {
            Connection con = DatabaseConnection.getConnection();
            System.out.println("Database Connected successfully");

            String sql = "DELETE FROM order_details WHERE order_detail_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, deleteId);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Deleted Successfully");
            else
                System.out.println("Order Detail Not Found");

            ps.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
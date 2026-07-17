package com.rishuraj.service;
import com.rishuraj.database.DatabaseConnection;
import com.rishuraj.model.Payment;

import java.sql.*;

public class PaymentService {
    public void registerPayment(Payment payment){
        try {
            Connection con = DatabaseConnection.getConnection();
            System.out.println("Database Connected successfully");

            String sql = "INSERT INTO payments(payment_id , payment_method , order_id , amount) VALUES (? , ? ,? ,? )";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1 , payment.getPayment_id());
            ps.setString(2, payment.getPayment_method());
            ps.setInt(3 , payment.getOrder_id());
            ps.setDouble(4 , payment.getAmount());

            int rows = ps.executeUpdate();
            if(rows > 0){
                System.out.println("Successfully inserted");
            }else{
                System.out.println("Not Inserted");
            }
            con.close();
            ps.close();
        }catch (SQLException e ){
            System.out.println(e);
        }
    }
    public void viewAllPayments(){
        try{
            Connection con = DatabaseConnection.getConnection();
            System.out.println("Database Connected successfully");

            String sql = "SELECT * FROM payments";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                System.out.println("Enter payment_id : " + rs.getInt("payment_id"));
                System.out.println("Enter payment_method : " + rs.getString("payment_method"));
                System.out.println("Enter order_id : " + rs.getInt("order_id"));
                System.out.println("Enter amount : " + rs.getDouble("amount") );
            }
            con.close();
            ps.close();
            rs.close();

        }catch (SQLException e){
            System.out.println(e);
        }
    }
    public void searchPayments(int search_id){
        try{
            Connection con = DatabaseConnection.getConnection();
            System.out.println("Database Connected successfully");

            String sql = "SELECT * FROM  payments WHERE payment_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1 , search_id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                System.out.println("Enter payment_id : " + rs.getInt("payment_id"));
                System.out.println("Enter payment_method : " + rs.getString("payment_method"));
                System.out.println("Enter order_id : " + rs.getInt("order_id"));
                System.out.println("Enter amount : " + rs.getDouble("amount") );
            }
            con.close();
            ps.close();
            rs.close();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    public void updatePayment(int update_id , String newPaymentMethod){
        try {
            Connection con = DatabaseConnection.getConnection();
            System.out.println("Database Connected successfully");

            String sql = "UPDATE payments SET payment_method = ? WHERE payment_id = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1 ,newPaymentMethod);
            ps.setInt(2 , update_id);
            int rows = ps.executeUpdate();
            if(rows > 0){
                System.out.println("Successfully inserted");
            }else{
                System.out.println("Not Inserted");
            }
            con.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void deletePayment(int deleteId){
        try{
            Connection con = DatabaseConnection.getConnection();
            System.out.println("Database Connected successfully");

            String sql = "DELETE FROM payments WHERE payment_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1 , deleteId);
            int rows = ps.executeUpdate();
            if(rows > 0){
                System.out.println("Successfully inserted");
            }else{
                System.out.println("Not Inserted");
            }
            con.close();
            ps.close();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
}

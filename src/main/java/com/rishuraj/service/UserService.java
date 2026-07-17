package com.rishuraj.service;
import com.rishuraj.database.DatabaseConnection;
import com.rishuraj.model.User;

import java.sql.*;
public class UserService {
    public void registerUser(User user) {
        try {
            Connection con = DatabaseConnection.getConnection();
            System.out.println("Database Connected successfully");

//                Register user ;
            String sql = "INSERT INTO users(user_id, name , mob_no , address , status , state) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, user.getUser_id());
            ps.setString(2, user.getName());
            ps.setLong(3, user.getMob_no());
            ps.setString(4, user.getAddress());
            ps.setString(5, user.getStatus());
            ps.setString(6, user.getState());

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

    public void viewAllUsers() {
        try {
            Connection con = DatabaseConnection.getConnection();
            System.out.println("Database Connected successfully");

//                View all users;
            String sql2 = "SELECT * FROM users ";
            PreparedStatement ps1 = con.prepareStatement(sql2);
            ResultSet rs = ps1.executeQuery();
            while (rs.next()) {
                System.out.println("User ID : " + rs.getInt("user_id"));
                System.out.println("Name : " + rs.getString("name"));
                System.out.println("Mobile No : " + rs.getLong("mob_no"));
                System.out.println("Address : " + rs.getString("address"));
                System.out.println("Status : " + rs.getString("status"));
                System.out.println("State : " + rs.getString("state"));
                System.out.println("--------------------------------");
            }
            rs.close();
            ps1.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void searchUser(int searchId) {
        try {
            Connection con = DatabaseConnection.getConnection();
            System.out.println("Database Connected successfully");

//                To search a User;
            String sql3 = "SELECT * FROM users WHERE user_id = ?";
            PreparedStatement ps3 = con.prepareStatement(sql3);
            ps3.setInt(1, searchId);

            ResultSet rs1 = ps3.executeQuery();

            if (rs1.next()) {
                System.out.println("User ID : " + rs1.getInt("user_id"));
                System.out.println("Name : " + rs1.getString("name"));
                System.out.println("Mobile No : " + rs1.getLong("mob_no"));
                System.out.println("Address : " + rs1.getString("address"));
                System.out.println("Status : " + rs1.getString("status"));
                System.out.println("State : " + rs1.getString("state"));
                System.out.println("--------------------------------");
            } else {
                System.out.println("User Not Found");
            }
            rs1.close();
            ps3.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateUser(int updateId, String newAddress) {
        try {
            Connection con = DatabaseConnection.getConnection();
            System.out.println("Database Connected successfully");

//                To update user;
            String sql4 = "UPDATE users SET address = ? WHERE user_id = ?";
            PreparedStatement ps4 = con.prepareStatement(sql4);

            ps4.setString(1, newAddress);
            ps4.setInt(2, updateId);

            int rowsUpdated = ps4.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Address Updated Successfully");
            } else {
                System.out.println("User Not Found");
            }
            ps4.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteUser(int deleteId) {
        try {
            Connection con = DatabaseConnection.getConnection();
            System.out.println("Database Connected successfully");

//                To delete a user;
            String sql5 = "DELETE FROM users WHERE user_id = ?";
            PreparedStatement ps5 = con.prepareStatement(sql5);

            ps5.setInt(1, deleteId);

            int rowsDeleted = ps5.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("User Deleted Successfully");
            } else {
                System.out.println("User Not Found");
            }

            ps5.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
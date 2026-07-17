package com.rishuraj.database;
import java.sql.*;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/food_ordering";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "YOUR PASSWORD";

//    "If an SQL error happens here, I'm not handling it inside this method. I'll send (throw) it to whoever called this method."

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
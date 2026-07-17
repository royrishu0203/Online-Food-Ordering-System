package com.rishuraj.service;
import com.rishuraj.database.DatabaseConnection;

import java.sql.*;

public class PlaceOrderService{

    public void placeOrder( int user_id, int food_id, int quantity, String payment_method){

        try {

            Connection con = DatabaseConnection.getConnection();

            //               USER CHECK

            String userSql = "SELECT * FROM users WHERE user_id = ?";
            PreparedStatement psUser = con.prepareStatement(userSql);
            psUser.setInt(1, user_id);

            ResultSet rsUser = psUser.executeQuery();

            if (!rsUser.next()) {
                System.out.println("User Not Found");
                return;
            }


            //               FOOD CHECK

            String foodSql = "SELECT * FROM food_items WHERE food_id = ?";
            PreparedStatement psFood = con.prepareStatement(foodSql);
            psFood.setInt(1, food_id);

            ResultSet rsFood = psFood.executeQuery();

            if (!rsFood.next()) {
                System.out.println("Food Not Found");
                return;
            }


            String food_name = rsFood.getString("food_name");
            double price = rsFood.getDouble("price");

            double total_amount = price * quantity;

            String order_date = java.time.LocalDate.now().toString();   // This will automatically give the todays date
            String order_status = "Placed";

            //               INSERT INTO ORDERS


            String orderSql = "INSERT INTO orders(user_id, order_date, total_amount, order_status) VALUES (?,?,?,?)";
            PreparedStatement psOrder = con.prepareStatement(orderSql , Statement.RETURN_GENERATED_KEYS);

            psOrder.setInt(1, user_id);
            psOrder.setString(2, order_date);
            psOrder.setDouble(3, total_amount);
            psOrder.setString(4, order_status);

            psOrder.executeUpdate();
            ResultSet rs = psOrder.getGeneratedKeys();

            int order_id = 0;

            if (rs.next()) {
                order_id = rs.getInt(1);
            }


//                           INSERT INTO ORDER DETAILS

            String detailSql = "INSERT INTO order_details(order_id , food_id, quantity) VALUES (?,?,?)";

            PreparedStatement psDetail = con.prepareStatement(detailSql ,Statement.RETURN_GENERATED_KEYS );
            psDetail.setInt(1 ,order_id);
            psDetail.setInt(2, food_id);
            psDetail.setInt(3, quantity);

            psDetail.executeUpdate();


//                   INSERT INTO PAYMENTS


            String paymentSql = "INSERT INTO payments(payment_method, order_id, amount) VALUES (?,?,?)";

            PreparedStatement psPayment = con.prepareStatement(paymentSql);

            psPayment.setString(1, payment_method);
            psPayment.setInt(2, order_id);      // Generated order_id
            psPayment.setDouble(3, total_amount);

            psPayment.executeUpdate();


//                   SUCCESS MESSAGE

            System.out.println("\n======================================");
            System.out.println("     ORDER PLACED SUCCESSFULLY");
            System.out.println("======================================");
            System.out.println("Food           : " + food_name);
            System.out.println("Quantity       : " + quantity);
            System.out.println("Price          : ₹" + price);
            System.out.println("Total Amount   : ₹" + total_amount);
            System.out.println("Payment Method : " + payment_method);
            System.out.println("======================================");


//                  CLOSE

            rsUser.close();
            rsFood.close();

            psUser.close();
            psFood.close();
            psOrder.close();
            psDetail.close();
            psPayment.close();

            con.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
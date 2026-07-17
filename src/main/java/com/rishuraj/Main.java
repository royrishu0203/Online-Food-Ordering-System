package com.rishuraj;
import com.rishuraj.model.*;
import com.rishuraj.service.*;

import java.util.Scanner;
public class Main {

    static Scanner sc = new Scanner(System.in);

    static UserService userService = new UserService();
    static RestaurantService restaurantService = new RestaurantService();
    static FoodService foodService = new FoodService();
    static OrderService orderService = new OrderService();
    static OrderDetailService orderDetailService = new OrderDetailService();
    static PaymentService paymentService = new PaymentService();
    static PlaceOrderService placeOrderService = new PlaceOrderService();


    public static void userMenu() {

        while (true) {

            System.out.println("\n===== USER Management =====");
            System.out.println("1. Register User");
            System.out.println("2. View All Users");
            System.out.println("3. Search User");
            System.out.println("4. Update User");
            System.out.println("5. Delete User");
            System.out.println("6. Back");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter User ID: ");
                    int user_id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Mobile: ");
                    long mob_no = sc.nextLong();
                    sc.nextLine();

                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();

                    System.out.print("Enter Status: ");
                    String status = sc.nextLine();

                    System.out.print("Enter State: ");
                    String state = sc.nextLine();

                    User user = new User(user_id, name, mob_no, address, status, state);

                    userService.registerUser(user);
                    break;

                case 2:
                    userService.viewAllUsers();
                    break;

                case 3:
                    System.out.print("Enter User ID: ");
                    int searchId = sc.nextInt();

                    userService.searchUser(searchId);
                    break;

                case 4:
                    System.out.print("Enter User ID: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Address: ");
                    String newAddress = sc.nextLine();

                    userService.updateUser(updateId, newAddress);
                    break;

                case 5:
                    System.out.print("Enter User ID: ");
                    int deleteId = sc.nextInt();

                    userService.deleteUser(deleteId);
                    break;

                case 6:
                    System.out.println("Thank you");
                    return;

                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 6.");
            }
        }
    }

    public static void restaurantMenu() {

        while (true) {

            System.out.println("\n===== RESTAURANT Management =====");
            System.out.println("1. Register Restaurant");
            System.out.println("2. View All Restaurants");
            System.out.println("3. Search Restaurant");
            System.out.println("4. Update Restaurant");
            System.out.println("5. Delete Restaurant");
            System.out.println("6. Back");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Restaurant ID: ");
                    int restaurant_id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Restaurant Name: ");
                    String restaurant_name = sc.nextLine();

                    System.out.print("Enter Location: ");
                    String location = sc.nextLine();

                    System.out.print("Enter FSSAI No: ");
                    long fssai_no = sc.nextLong();
                    sc.nextLine();

                    System.out.print("Enter Rating: ");
                    double rating = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter Opening Time: ");
                    String opening_time = sc.nextLine();

                    System.out.print("Enter Closing Time: ");
                    String closing_time = sc.nextLine();

                    System.out.print("Enter Status: ");
                    String status = sc.nextLine();

                    Restaurant restaurant = new Restaurant(restaurant_id, restaurant_name, location, fssai_no, rating, opening_time, closing_time, status);

                    restaurantService.registerRestaurant(restaurant);
                    break;

                case 2:
                    restaurantService.viewAllRestaurant();
                    break;

                case 3:
                    System.out.print("Enter Restaurant ID: ");
                    int searchId = sc.nextInt();

                    restaurantService.searchRestaurant(searchId);
                    break;

                case 4:
                    System.out.print("Enter Restaurant ID: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Location: ");
                    String newLocation = sc.nextLine();

                    restaurantService.updateRestaurant(updateId, newLocation);
                    break;

                case 5:
                    System.out.print("Enter Restaurant ID: ");
                    int deleteId = sc.nextInt();

                    restaurantService.deleteRestaurant(deleteId);
                    break;

                case 6:
                    System.out.println("Thank you");
                    return;

                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 6.");
            }
        }
    }

    public static void foodMenu() {

        while (true) {

            System.out.println("\n===== FOOD Management =====");
            System.out.println("1. Add Food");
            System.out.println("2. View All Food");
            System.out.println("3. Search Food");
            System.out.println("4. Update Food");
            System.out.println("5. Delete Food");
            System.out.println("6. Back");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Food ID: ");
                    int food_id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Restaurant ID: ");
                    int restaurant_id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Food Name: ");
                    String food_name = sc.nextLine();

                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter Availability: ");
                    String availability = sc.nextLine();

                    Food food = new Food(food_id, restaurant_id, food_name, category, price, availability);

                    foodService.registerFood(food);
                    break;

                case 2:
                    foodService.viewAllFood();
                    break;

                case 3:
                    System.out.print("Enter Food ID: ");
                    int searchId = sc.nextInt();

                    foodService.searchFood(searchId);
                    break;

                case 4:
                    System.out.print("Enter Food ID: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Price: ");
                    double newPrice = sc.nextDouble();

                    foodService.updateFood(updateId, newPrice);
                    break;

                case 5:
                    System.out.print("Enter Food ID: ");
                    int deleteId = sc.nextInt();

                    foodService.deleteFood(deleteId);
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 6.");
            }
        }
    }
    public static void orderMenu() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("===== ORDER Management =====");
            System.out.println("1. Register Order");
            System.out.println("2. View All Orders");
            System.out.println("3. Search Order");
            System.out.println("4. Update Order");
            System.out.println("5. Delete Order");
            System.out.println("6. Back");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Order ID: ");
                    int order_id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter User ID: ");
                    int user_id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Order Date: ");
                    String order_date = sc.nextLine();

                    System.out.print("Enter Total Amount: ");
                    double total_amount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter Order Status: ");
                    String order_status = sc.nextLine();

                    Order order = new Order(order_id, user_id, order_date, total_amount, order_status);

                    orderService.registerOrder(order);
                    break;

                case 2:
                    orderService.viewAllOrders();
                    break;

                case 3:
                    System.out.print("Enter Order ID: ");
                    int searchId = sc.nextInt();
                    orderService.searchOrder(searchId);
                    break;

                case 4:
                    System.out.print("Enter Order ID: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Status: ");
                    String newStatus = sc.nextLine();

                    orderService.updateOrder(updateId, newStatus);
                    break;

                case 5:
                    System.out.print("Enter Order ID: ");
                    int deleteId = sc.nextInt();

                    orderService.deleteOrder(deleteId);
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 6.");
            }
        }
    }

    public static void orderDetailMenu() {
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("===== ORDER DETAIL Management =====");
            System.out.println("1. Register Order Detail");
            System.out.println("2. View All Order Details");
            System.out.println("3. Search Order Detail");
            System.out.println("4. Update Order Detail");
            System.out.println("5. Delete Order Detail");
            System.out.println("6. Back");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Order Detail ID: ");
                    int order_detail_id = sc.nextInt();

                    System.out.print("Enter Order ID: ");
                    int order_id = sc.nextInt();

                    System.out.print("Enter Food ID: ");
                    int food_id = sc.nextInt();

                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();

                    OrderDetail orderDetail = new OrderDetail(order_detail_id, order_id, food_id, quantity);

                    orderDetailService.registerOrderDetail(orderDetail);
                    break;

                case 2:
                    orderDetailService.viewAllOrderDetails();
                    break;

                case 3:
                    System.out.print("Enter Order Detail ID: ");
                    int searchId = sc.nextInt();

                    orderDetailService.searchOrderDetail(searchId);
                    break;

                case 4:
                    System.out.print("Enter Order Detail ID: ");
                    int updateId = sc.nextInt();

                    System.out.print("Enter New Quantity: ");
                    int newQuantity = sc.nextInt();

                    orderDetailService.updateOrderDetail(updateId, newQuantity);
                    break;

                case 5:
                    System.out.print("Enter Order Detail ID: ");
                    int deleteId = sc.nextInt();

                    orderDetailService.deleteOrderDetail(deleteId);
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 6.");
            }
        }
    }
    public static void paymentMenu() {
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("===== PAYMENT Management =====");
            System.out.println("1. Register Payment");
            System.out.println("2. View All Payments");
            System.out.println("3. Search Payment");
            System.out.println("4. Update Payment");
            System.out.println("5. Delete Payment");
            System.out.println("6. Back");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Payment ID: ");
                    int payment_id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Payment Method: ");
                    String payment_method = sc.nextLine();

                    System.out.print("Enter Order ID: ");
                    int order_id = sc.nextInt();

                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();

                    Payment payment = new Payment(payment_id, payment_method, order_id, amount);

                    paymentService.registerPayment(payment);
                    break;

                case 2:
                    paymentService.viewAllPayments();
                    break;

                case 3:
                    System.out.print("Enter Payment ID: ");
                    int searchId = sc.nextInt();

                    paymentService.searchPayments(searchId);
                    break;

                case 4:
                    System.out.print("Enter Payment ID: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Payment Method: ");
                    String newMethod = sc.nextLine();

                    paymentService.updatePayment(updateId, newMethod);
                    break;

                case 5:
                    System.out.print("Enter Payment ID: ");
                    int deleteId = sc.nextInt();

                    paymentService.deletePayment(deleteId);
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 6.");
            }
        }
    }
        public static void placeOrderMenu() {

            Scanner sc = new Scanner(System.in);

            System.out.println("========= PLACE ORDER =========");

            System.out.print("Enter User ID : ");
            int user_id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Food ID : ");
            int food_id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Quantity : ");
            int quantity = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Payment Method : ");
            String payment_method = sc.nextLine();

            placeOrderService.placeOrder(user_id, food_id, quantity, payment_method);
        }

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n========================================");
            System.out.println("       ONLINE FOOD ORDERING SYSTEM");
            System.out.println("          Developed by Rishuraj");
            System.out.println("========================================\n");
            System.out.println("1. User Management");
            System.out.println("2. Restaurant Management");
            System.out.println("3. Food Management");
            System.out.println("4. Order Management");
            System.out.println("5. Order Details Management");
            System.out.println("6. Payment Management");
            System.out.println("7. Place Order Menu");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    userMenu();
                    break;

                case 2:
                    restaurantMenu();
                    break;

                case 3:
                    foodMenu();
                    break;

                case 4:
                    orderMenu();
                    break;

                case 5:
                    orderDetailMenu();
                    break;

                case 6:
                    paymentMenu();
                    break;

                case 7:
                    placeOrderMenu();
                    break;

                case 8:
                    System.out.println("Thank You!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 8.");
            }
        }
    }
}
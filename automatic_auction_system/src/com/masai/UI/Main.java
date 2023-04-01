package com.masai.UI;

import java.util.Scanner;

import com.masai.DAO.DisputeDAO;
import com.masai.DAO.GSTDAO;
import com.masai.DAO.ItemDAO;
import com.masai.DAO.TransactionDAO;
import com.masai.DAO.UserDAO;
import com.masai.DTO.ItemDTO;
import com.masai.DTO.UserDTO;
import com.masai.Exception.DuplicateUsernameException;
import com.masai.Exception.InvalidDataEntryException;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;
import com.masai.DAO.DBUtils;

import java.lang.System;

public class Main {
    public static void main(String[] args) {
        // Load database credentials from properties file
//        Properties props = new Properties();
//        try {
//            props.load(new FileInputStream("src/database.properties"));
//        } catch (IOException e) {
//            System.out.println("Error loading database properties: " + e.getMessage());
//            return;
//        }
        

        // Initialize the UI object
        UserDAO userDAO = null;
		ItemDAO itemDAO = null;
		TransactionDAO transactionDAO = null;
		DisputeDAO disputeDAO = null;
		GSTDAO gstDAO = null;
		AuctionSystemUI ui = new AuctionSystemUI(null, userDAO, itemDAO, transactionDAO, disputeDAO, gstDAO);

        try (// Start the application
		Scanner scanner = new Scanner(System.in)) {
			while (true) {
			    // Display the main menu
			    ui.showAdminMenu();

			    // Get the user input
			    int choice = scanner.nextInt();
			    scanner.nextLine();

			    // Handle the user input
			    switch (choice) {
			        case 1:
			            ui.login();
			            break;
			        case 2:
			            ui.register();
			            break;
			        case 3:
			            ui.searchItems();
			            break;
			        case 4:
			            ui.viewTransactions();
			            break;
			        case 5:
			            ui.logout();
			            break;
			        case 6:
			            System.out.println("Exiting the application...");
			            return;
			        default:
			            System.out.println("Invalid choice. Please try again.");
			            break;
			    }
			}
        }		
    }
    
    
    
    public void showAdminMenu() {
        System.out.println("Welcome to the Auction System!");
        System.out.println("Please select an option:");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Search items");
        System.out.println("4. View transactions");
        System.out.println("5. Logout");
        System.out.println("6. Exit the application");
    }

    public void login() {
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Please enter your username:");
			String username = scanner.nextLine();

			System.out.println("Please enter your password:");
			String password = scanner.nextLine();

			if (username.equals("admin") && password.equals("admin")) {
			    // Successful login
			    System.out.println("Login successful. Welcome, admin!");
			} else {
			    // Invalid login
			    System.out.println("Invalid username or password. Please try again.");
			}
		}
    }
    

        
        public void register() throws DuplicateUsernameException {
            System.out.println("Enter your details:");

            // Prompt user for input
            System.out.print("Username: ");
            System.out.print("First Name: ");
            System.out.print("Last Name: ");
            System.out.print("Address: ");
            System.out.print("Mobile Number: ");
            System.out.print("Password: ");
            // Create new User object
            UserDAO user = new UserDAO() {
				
				@Override
				public void updateUser(UserDTO user) throws SQLException, InvalidDataEntryException {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public int login(String username, String password) {
					// TODO Auto-generated method stub
					return 0;
				}
				
				@Override
				public UserDTO getUserByUsername(String username) throws SQLException {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public UserDTO getUserById(int userId) throws SQLException {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public List<TransactionDAO> getTransactionsInRange(LocalDate startDate, LocalDate endDate) {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public List<UserDTO> getAllUsers() throws SQLException {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public List<TransactionDAO> getAllTransactions() {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public void deleteUser(int userId) throws SQLException {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public UserDTO authenticate(String username, String password) {
					// TODO Auto-generated method stub
					return null;
				}
			};

            try {
                // Call UserDAO to add new user to the database
                UserDAO.addUser(user);
                System.out.println("User registration successful.");
            } catch (SQLException e) {
                System.out.println("User registration failed. Error: " + e.getMessage());
            }
        }
        
        
        
        
        @SuppressWarnings("null")
		public void searchItems() throws SQLException {
            try (Scanner scanner = new Scanner(System.in)) {
				System.out.println("Enter your search criteria: ");
				System.out.println("1. Category");
				System.out.println("2. Sold status");
				System.out.println("3. Keyword");
				int choice = scanner.nextInt();
				scanner.nextLine();

				ItemDAO itemDAO = null;
				switch (choice) {
				    case 1:
				        System.out.println("Enter category (Clothing, Electronics, Grocery, Miscellaneous):");
				        String category = scanner.nextLine();
				        List<ItemDTO> itemsByCategory = itemDAO.getItemsByCategory(category);
				        if (itemsByCategory.isEmpty()) {
				            System.out.println("No items found for category " + category);
				        } else {
				            System.out.println("Items for category " + category + ":");
				            for (ItemDTO item : itemsByCategory) {
				                System.out.println(item);
				            }
				        }
				        break;
				    case 2:
				        System.out.println("Enter sold status (0 for unsold, 1 for sold):");
				        int soldStatus = scanner.nextInt();
				        List<ItemDAO> itemsBySoldStatus = itemDAO.getItemsBySoldStatus(soldStatus);
				        if (itemsBySoldStatus.isEmpty()) {
				            System.out.println("No items found for sold status " + soldStatus);
				        } else {
				            System.out.println("Items for sold status " + soldStatus + ":");
				            for (ItemDAO item : itemsBySoldStatus) {
				                System.out.println(item);
				            }
				        }
				        break;
				    case 3:
				        System.out.println("Enter keyword:");
				        String keyword = scanner.nextLine();
				        List<ItemDAO> itemsByKeyword = itemDAO.getItemsByKeyword(keyword);
				        if (itemsByKeyword.isEmpty()) {
				            System.out.println("No items found for keyword " + keyword);
				        } else {
				            System.out.println("Items for keyword " + keyword + ":");
				            for (ItemDAO item : itemsByKeyword) {
				                System.out.println(item);
				            }
				        }
				        break;
				    default:
				        System.out.println("Invalid choice. Please try again.");
				        break;
				}
			}
        }

        
        @SuppressWarnings("null")
		public void viewTransactions() throws SQLException {
            System.out.println("View Transactions:");
            System.out.println("1. All Transactions");
            System.out.println("2. Transactions for a date range");
            System.out.println("3. Transaction by transaction id");
            System.out.println("4. Back to main menu");

            Scanner scanner = null;
			int choice = scanner.nextInt();
            scanner.next();

            UserDAO transactionDAO = null;
			switch (choice) {
                case 1:
                    List<TransactionDAO> allTransactions = transactionDAO.getAllTransactions();
                    System.out.println("All Transactions:");
                    for (TransactionDAO transaction : allTransactions) {
                        System.out.println(transaction);
                    }
                    break;
                case 2:
                    System.out.println("Enter start date (yyyy-MM-dd):");
                    String startDateString = scanner.nextLine();
                    LocalDate startDate = LocalDate.parse(startDateString);
                    System.out.println("Enter end date (yyyy-MM-dd):");
                    String endDateString = scanner.nextLine();
                    LocalDate endDate = LocalDate.parse(endDateString);
                    List<TransactionDAO> transactionsInRange = transactionDAO.getTransactionsInRange(startDate, endDate);
                    System.out.println("Transactions for date range:");
                    for (TransactionDAO transaction : transactionsInRange) {
                        System.out.println(transaction);
                    }
                    break;
                case 3:
                    System.out.println("Enter transaction id:");
                    int transactionId = scanner.nextInt();
                    scanner.nextLine();
                    TransactionDAO transaction = (TransactionDAO) ((TransactionDAO) transactionDAO).getTransactionById(transactionId);
                    System.out.println("Transaction by id:");
                    System.out.println(transaction);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }


           
        public void logout() {
            System.out.println("Successfully logged out.");
        }
        
}


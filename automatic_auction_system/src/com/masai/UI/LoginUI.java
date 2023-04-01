package com.masai.UI;



import java.util.Scanner;

import com.masai.DAO.DisputeDAO;
import com.masai.DAO.GSTDAO;
import com.masai.DAO.ItemDAO;
import com.masai.DAO.TransactionDAO;
import com.masai.DAO.UserDAO;
import com.masai.DTO.UserDTO;

public class LoginUI {
    
    private static final String UserRole = null;
	private UserDAO userDAO;
    
    public LoginUI(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    
    public int show() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the online marketplace!");
        System.out.println("----------------------------------");
        
        while (true) {
            System.out.println("Please select an option:");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    login(scanner);
                    break;
                case 2:
                    register(scanner);
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    return choice;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
    
    UserDTO login(Scanner scanner) {
        System.out.println("Please enter your username:");
        String username = scanner.next();
        
        System.out.println("Please enter your password:");
        String password = scanner.next();
        
        UserDTO user = userDAO.authenticate(username, password);
		System.out.println("Welcome, " + user.getFullName() + "!");
		
		TransactionDAO transactionDAO = null;
		ItemDAO itemDAO = null;
		DisputeDAO disputeDAO = null;
		GSTDAO gstDAO = null;
		// Launch appropriate user interface based on user role
		if (user.getRole() == UserRole.stripLeading()) {
		    AdminUI adminUI = new AdminUI(userDAO, itemDAO, transactionDAO, disputeDAO, gstDAO);
		    adminUI.show();
		} else {
		    UserUI userUI = new UserUI(userDAO, itemDAO, transactionDAO, disputeDAO, gstDAO, user);
		    userUI.show();
		}
		return user;
    }
    
    private void register(Scanner scanner) {
        System.out.println("Please enter your full name:");
        String fullName = scanner.nextLine();
        
        System.out.println("Please enter your username:");
        String username = scanner.nextLine();
        
        System.out.println("Please enter your password:");
        String password = scanner.nextLine();
        
        System.out.println("Please enter your email:");
        String email = scanner.nextLine();
        
        System.out.println("Please enter your phone number:");
        String phoneNumber = scanner.nextLine();
        
        UserDTO user = new UserDTO(fullName, username, password, email, phoneNumber, UserRole.codePointCount(0, 0));
        
        UserDAO.addUser(user);
		System.out.println("User registered successfully!");
    }

	public String promptForUsername(Scanner scanner) {
		// TODO Auto-generated method stub
		return null;
	}

	public String promptForPassword(Scanner scanner) {
		// TODO Auto-generated method stub
		return null;
	}

	public String display(Scanner scanner) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	public void showErrorMessage(String string) {
		// TODO Auto-generated method stub
		
	}

	public void showSuccessMessage(String string) {
		// TODO Auto-generated method stub
		
	}

	public int getChoice() {
		// TODO Auto-generated method stub
		return 0;
	}
}



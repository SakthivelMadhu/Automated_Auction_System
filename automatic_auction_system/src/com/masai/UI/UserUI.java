package com.masai.UI;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.masai.DAO.DisputeDAO;
import com.masai.DAO.GSTDAO;
import com.masai.DAO.ItemDAO;
import com.masai.DAO.TransactionDAO;
import com.masai.DAO.UserDAO;
import com.masai.DAO.UserDAOImpl;
import com.masai.DTO.ItemDTO;
import com.masai.DTO.TransactionDTO;
import com.masai.DTO.UserDTO;
import com.masai.Exception.InvalidDataEntryException;

public class UserUI {
    
    private final UserDTO user;
    private final ItemDAO itemDAO;
    private final TransactionDAO transactionDAO;
    private final DisputeDAO scanner;
    
    public UserUI(UserDAO userDAO, ItemDAO itemDAO, TransactionDAO transactionDAO, DisputeDAO disputeDAO) {
        this.user = (UserDTO) userDAO;
        this.itemDAO = itemDAO;
        this.transactionDAO = transactionDAO;
        this.scanner = disputeDAO;
    }
    
    public UserUI(UserDAO userDAO, ItemDAO itemDAO2, TransactionDAO transactionDAO2, DisputeDAO disputeDAO,
			GSTDAO gstDAO, UserDTO user2) {
				this.user = null;
				this.itemDAO = null;
		// TODO Auto-generated constructor stub
				this.transactionDAO = null;
				this.scanner = null;
	}

	public void viewAvailableItems() {
        try {
            List<ItemDTO> items = itemDAO.getAvailableItems();
            System.out.println("Available Items:");
            for (ItemDTO item : items) {
                System.out.println(item);
            }
        } catch (SQLException e) {
            System.out.println("Error getting available items: " + e.getMessage());
        }
    }
    
    public void viewBoughtItems() {
        try {
            List<TransactionDTO> transactions = transactionDAO.getTransactionsByBuyerId(user.getUserId());
            System.out.println("Bought Items:");
            for (TransactionDTO transaction : transactions) {
                System.out.println(transaction.getItemId());
            }
        } catch (SQLException e) {
            System.out.println("Error getting bought items: " + e.getMessage());
        }
    }
    
    public void viewSoldItems() {
        try {
            List<TransactionDTO> transactions = transactionDAO.getTransactionsBySellerId(user.getUserId());
            System.out.println("Sold Items:");
            for (TransactionDTO transaction : transactions) {
                System.out.println(transaction.getItemId());
            }
        } catch (SQLException e) {
            System.out.println("Error getting sold items: " + e.getMessage());
        }
    }
    
    public void buyItem(ItemDTO item) throws InvalidDataEntryException {
        try {
            TransactionDTO transaction = new TransactionDTO(user.getUserId(), item.getSellerId(), item.getItemId(), 0, null, 0);
            transactionDAO.addTransaction(transaction);
            System.out.println("Item bought successfully.");
        } catch (SQLException e) {
            System.out.println("Error buying item: " + e.getMessage());
        }
    }
    
    public void sellItem(ItemDTO item) throws InvalidDataEntryException {
        item.setSellerId(user.getUserId());
		itemDAO.addItem(item);
		System.out.println("Item added for sale successfully.");
    }
    
    public void viewProfile() {
        System.out.println("User Profile:");
        System.out.println(user);
    }
    
    public void updateProfile() {
        System.out.println("Update User Profile:");
        System.out.print("Enter new username (press enter to skip): ");
        String username = scanner.nextLine();
        System.out.print("Enter new password (press enter to skip): ");
        String password = scanner.nextLine();
        System.out.print("Enter new full name (press enter to skip): ");
        String fullName = scanner.nextLine();
        try {
            if (!username.isEmpty()) {
                user.setUsername(username);
            }
            if (!password.isEmpty()) {
                user.setPassword(password);
            }
            if (!fullName.isEmpty()) {
                user.setFullName(fullName);
            }
            UserDAO userDAO = new UserDAOImpl(null) {
				
				@Override
				public UserDTO authenticate(String username, String password) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public List<TransactionDTO> getAllTransactions() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public int login(String username, String password) {
					// TODO Auto-generated method stub
					return 0;
				}
			};
            userDAO.updateUser(user);
            System.out.println("User profile updated successfully.");
        } catch (SQLException | InvalidDataEntryException e) {
            System.out.println("Error updating user profile: " + e.getMessage());
        }
    }

	public void show() {
		// TODO Auto-generated method stub
		
	}

	public UserDTO validateUserCredentials(String userUsername, String userPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	public void showUserMenu(Scanner scanner2, UserDTO user2) {
		// TODO Auto-generated method stub
		
	}

	public void displayMenu(Scanner scanner2, UserDAO userDAO, ItemDAO itemDAO2, TransactionDAO transactionDAO2,
			DisputeDAO disputeDAO, GSTDAO gstDAO, UserDTO user2) {
		// TODO Auto-generated method stub
		
	}

	public String register(Scanner scanner2, UserDAO userDAO) {
		return null;
		// TODO Auto-generated method stub
		
	}

	public void display() {
		// TODO Auto-generated method stub
		
	}

	public void login() {
		// TODO Auto-generated method stub
		
	}
}

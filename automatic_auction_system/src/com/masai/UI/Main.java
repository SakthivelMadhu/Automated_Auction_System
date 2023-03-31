package com.masai.UI;

import java.util.Scanner;

import com.masai.DAO.DisputeDAO;
import com.masai.DAO.GSTDAO;
import com.masai.DAO.ItemDAO;
import com.masai.DAO.TransactionDAO;
import com.masai.DAO.UserDAO;
import com.masai.DTO.DisputeDTO;
import com.masai.DTO.GSTDTO;
import com.masai.DTO.ItemDTO;
import com.masai.DTO.TransactionDTO;
import com.masai.DTO.UserDTO;
import com.masai.Exception.InvalidDataEntryException;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        // Load database credentials from properties file
        Properties props = new Properties();
        try {
            props.load(new FileInputStream("database.properties"));
        } catch (IOException e) {
            System.out.println("Error loading database properties: " + e.getMessage());
            return;
        }
        // Initialize the DAO objects
        UserDAO userDAO = new UserDAO() {
			
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
			public List<UserDTO> getAllUsers() throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<TransactionDTO> getAllTransactions() {
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
        ItemDAO itemDAO = new ItemDAO() {
			
			@Override
			public boolean updateItem(ItemDTO itemDTO) throws InvalidDataEntryException {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public List<ItemDTO> getItemsBySellerId(int sellerId) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<ItemDTO> getItemsByCategory(String category) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<ItemDTO> getItemsByBuyerId(int buyerId) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ItemDTO getItemById(int itemId) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<ItemDTO> getAvailableItems() throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<ItemDTO> getAllItems() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean deleteItem(int itemId) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean addItem(ItemDTO itemDTO) throws InvalidDataEntryException {
				// TODO Auto-generated method stub
				return false;
			}
		};
        TransactionDAO transactionDAO = new TransactionDAO() {
			
			@Override
			public void updateTransaction(TransactionDTO transaction) throws SQLException, InvalidDataEntryException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public List<TransactionDTO> getTransactionsBySellerId(int sellerId) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<TransactionDTO> getTransactionsByBuyerId(int buyerId) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public TransactionDTO getTransactionById(int transactionId) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void deleteTransaction(int transactionId) throws SQLException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void addTransaction(TransactionDTO transaction) throws SQLException, InvalidDataEntryException {
				// TODO Auto-generated method stub
				
			}
		};
        DisputeDAO disputeDAO = new DisputeDAO() {
			
			@Override
			public void updateDispute(DisputeDTO dispute) throws SQLException, InvalidDataEntryException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public String nextLine() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public DisputeDTO getDisputeById(int disputeId) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<DisputeDTO> getAllDisputes() throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void deleteDispute(int disputeId) throws SQLException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void addDispute(DisputeDTO dispute) throws SQLException {
				// TODO Auto-generated method stub
				
			}
		};
        GSTDAO gstDAO = new GSTDAO() {
			
			@Override
			public GSTDTO getGSTByCategory(String category) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<GSTDTO> getAllGST() throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void deleteGST(String category) throws SQLException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void addGST(GSTDTO gst) throws SQLException {
				// TODO Auto-generated method stub
				
			
//		(props)
			}
        };

        // Initialize the UI object
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
}


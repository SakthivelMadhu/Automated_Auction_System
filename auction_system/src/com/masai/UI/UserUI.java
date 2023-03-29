package com.masai.UI;

import java.util.Scanner;

import com.masai.DAO.ItemDAO;
import com.masai.DAO.TransactionDAO;
import com.masai.DTO.ItemDTO;
import com.masai.DTO.UserDTO;
import com.masai.Exception.AuctionException;
import com.masai.DTO.TransactionDTO;

public class UserUI {
    private UserDTO currentUser;
    private ItemDAO itemDAO;
    private TransactionDAO transactionDAO;

    public UserUI(UserDTO user, ItemDAO itemDAO, TransactionDAO transactionDAO) {
        this.currentUser = user;
        this.itemDAO = itemDAO;
        this.transactionDAO = transactionDAO;
    }

    public void displayOptions() throws AuctionException {
        try (Scanner scanner = new Scanner(System.in)) {
			int choice = 0;
			while (choice != 4) {
			    System.out.println("Please select an option:");
			    System.out.println("1. View items for sale");
			    System.out.println("2. View purchased items");
			    System.out.println("3. View sold items");
			    System.out.println("4. Exit");

			    try {
			        choice = Integer.parseInt(scanner.nextLine());
			    } catch (NumberFormatException e) {
			        System.out.println("Invalid input. Please enter a number.");
			        continue;
			    }

			    switch (choice) {
			        case 1:
			            viewItemsForSale();
			            break;
			        case 2:
			            viewPurchasedItems();
			            break;
			        case 3:
			            viewSoldItems();
			            break;
			        case 4:
			            System.out.println("Exiting...");
			            break;
			        default:
			            System.out.println("Invalid input. Please enter a number between 1 and 4.");
			            break;
			    }
			}
		}
    }

    public void viewItemsForSale() throws AuctionException {
        System.out.println("Items for sale:");
        for (ItemDTO item : itemDAO.getAllItems()) {
            if (item.getStatus() == ItemStatus.FOR_SALE && item.getSeller().charAt(0) != currentUser.getId()) {
                System.out.println(item);
            }
        }
    }

    public void viewPurchasedItems() {
        System.out.println("Purchased items:");
        for (TransactionDTO transaction : transactionDAO.getTransactionsByBuyer(currentUser.getId())) {
            System.out.println(transaction.getItem());
        }
    }

    public void viewSoldItems() {
        System.out.println("Sold items:");
        for (TransactionDTO transaction : transactionDAO.getTransactionsBySeller(currentUser.getId())) {
            System.out.println(transaction.getItem());
        }
    }
}



package com.masai.UI;

import java.util.Scanner;
import com.masai.DTO.ItemDTO;
import com.masai.DTO.TransactionDTO;
import com.masai.DTO.UserDTO;

public class AdminUI {
    private Scanner scanner;

    public AdminUI() {
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Welcome, Administrator!");
        System.out.println("1. View all users");
        System.out.println("2. View all items");
        System.out.println("3. View all transactions");
        System.out.println("4. View all refunded products");
        System.out.println("0. Exit");
    }

    public int getChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public void displayUsers(UserDTO[] users) {
        System.out.println("All Users:");
        for (UserDTO user : users) {
            System.out.println(user.getUsername() + " (" + user.getEmail() + ")");
        }
    }

    public void displayItems(ItemDTO[] items) {
        System.out.println("All Items:");
        for (ItemDTO item : items) {
            System.out.println(item.getName() + " (" + item.getCategory() + ") - $" + item.getPrice());
        }
    }

    public void displayTransactions(TransactionDTO[] transactions) {
        System.out.println("All Transactions:");
        for (TransactionDTO transaction : transactions) {
            System.out.println("Transaction #" + transaction.getId() + " - " + transaction.getDate() + " - $" + transaction.getAmount());
        }
    }

    public void displayRefundedProducts(ItemDTO[] items) {
        System.out.println("All Refunded Products:");
        for (ItemDTO item : items) {
            System.out.println(item.getName() + " (" + item.getCategory() + ") - $" + item.getPrice());
        }
    }
}


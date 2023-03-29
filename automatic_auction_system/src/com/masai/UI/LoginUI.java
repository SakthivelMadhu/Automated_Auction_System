package com.masai.UI;

import java.util.Scanner;

public class LoginUI {
    private Scanner scanner;

    public LoginUI() {
        scanner = new Scanner(System.in);
    }

    public String getUsername() {
        System.out.print("Enter username: ");
        return scanner.nextLine();
    }

    public String getPassword() {
        System.out.print("Enter password: ");
        return scanner.nextLine();
    }

    public void displayErrorMessage(String message) {
        System.out.println("Error: " + message);
    }
}


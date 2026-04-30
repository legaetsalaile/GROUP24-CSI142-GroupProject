package com.ub.csi142.util;

import java.util.Scanner;

public class InputHelper {
    private final Scanner scanner;

    public InputHelper() {
        this.scanner = new Scanner(System.in);
    }

    public int getInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("Please enter a valid number: ");
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    public double getDouble(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            scanner.next();
            System.out.print("Please enter a valid number: ");
        }
        double value = scanner.nextDouble();
        scanner.nextLine();
        return value;
    }

    public String getString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}

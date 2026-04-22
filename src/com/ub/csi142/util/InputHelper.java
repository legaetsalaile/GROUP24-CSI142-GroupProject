package com.ub.csi142.util;

import java.util.Scanner;

public class InputHelper{
<<<<<<< HEAD
private Scanner scanner;

public InputHelper(){
scanner = new Scanner(System.in);
}

public int getInt(String prompt){
    while(true){
        try{
            System.out.println(prompt);
            int value= Integer.parseInt(scanner .nextLine());
            return value;
        }
        catch(NumberFormatException e){
            System.out.println("Invalid input");
        }
    }
}
 public double getDouble(String prompt){
    while (true){
        try{
            System.out.print(prompt);
            double value = Double.parseDouble(scanner.nextLine());
            return value;
        }
        catch(NumberFormatException e){
            System.out.println("Invalid input");
        }
        }
    }
    public String getString(String prompt){
        while(true){
            System.out.print(prompt);
            String value = scanner.nextLine().trim();

            if (!value.isEmpty()){
                return value;
            }
            System.out.println("Input cannot be empty");
        }
        }
 
public void closeScanner(){
    scanner.close();
}
=======
private Scanner scanner= new Scanner(System.in);

public int getInt(String prompt){
    System.out.println(prompt);
    return scanner.nextInt();
>>>>>>> origin/main
}
    

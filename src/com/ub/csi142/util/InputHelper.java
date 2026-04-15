package com.ub.csi142.util;

public class InputHelper{
    private Scanner scanner= new Scanner(System.in);

public int getInt(String prompt){
    System.out.println(prompt);
    return scanner.nextInt();
}
    
}






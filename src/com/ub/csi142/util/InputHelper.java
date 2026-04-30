package com.ub.csi142.util;

import java.util.Scanner;

public class InputHelper {
   private final Scanner scanner;

   public InputHelper() {
      this.scanner = new Scanner(System.in);
   }

   public int getInt(String var1) {
      System.out.print(var1);

      while(!this.scanner.hasNextInt()) {
         this.scanner.next();
         System.out.print("Please enter a valid number: ");
      }

      int var2 = this.scanner.nextInt();
      this.scanner.nextLine();
      return var2;
   }

   public double getDouble(String var1) {
      System.out.print(var1);

      while(!this.scanner.hasNextDouble()) {
         this.scanner.next();
         System.out.print("Please enter a valid number: ");
      }

      double var2 = this.scanner.nextDouble();
      this.scanner.nextLine();
      return var2;
   }

   public String getString(String var1) {
      System.out.print(var1);
      return this.scanner.nextLine().trim();
   }

   public void closeScanner() {
      if (this.scanner != null) {
         this.scanner.close();
      }

   }
}

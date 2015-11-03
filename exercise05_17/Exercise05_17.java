
package exercise05_17;

import java.util.Scanner;

public class Exercise05_17 {
/* 
Display pyramid 
Write a program that prompts the user to enter an integer from 
1 to 15 and displays a pyramid
*/
    
    public static void main(String[] args) {
        //get input
        Scanner s = new Scanner(System.in);
        System.out.print("Enter an integer n from (1 to 15): ");
        int n = s.nextInt();
        
        //exception handling
        if (n > 15 || n < 1) {
            System.out.println("Invalid input");
            System.exit(1);
        }
        
        for (int i = 1; i <= n; i++){
            //add spaces in front
            for (int j = 1; j <= n-i; j++) {
                System.out.printf("  ");
            }
            //print numbers in front
            for (int j = i; j > 0; j--) {
                System.out.printf("%2d",j);     
            }
            //add numbers at end
            for (int j = 2; j <= i; j++) {
                System.out.printf("%2d",j);
            }
            
            System.out.println();
        }
    }
}

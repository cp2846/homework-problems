/*
(Palindrome integer) Write the methods with the following headers
Return the reversal of an integer, i.e., reverse(456) returns 654
public static int reverse(int number)
public static boolean isPalindrome(int number)
Use the reverse method to implement isPalindrome. 
A number is a palindrome if its reversal is the same as itself. 
Write a test program that prompts the 
user to enter an integer and reports whether the integer is a palindrome.
 */
package exercise06_03;

import java.util.Scanner;
public class Exercise06_03 {
    public static void main(String[] args) {
        
        System.out.println("Enter a number: ");
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        
        if (isPalindrome(num)) {
            System.out.println(num+" is a palindrome.");
        } else {
            System.out.println(num+" is not palindrome.");
        }
    }
    
    public static int reverse(int number){
        int output = 0;
        
        while (number >= 10) {
            output += number % 10;
            output *= 10;
            number /= 10;
        }
        output += number;
        
        return output;
    }
    
    public static boolean isPalindrome(int num) {
        return reverse(num) == num;
    }
    
}


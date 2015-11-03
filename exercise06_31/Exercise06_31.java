/*
Financial: credit card number validation
Credit card numbers follow certain patterns. 
A credit card number must have between 13 and 16 digits. 
It must start with:
 
4 for Visa cards

5 for Master cards
 
37 for American Express cards
 
6 for Discover cards

In 1954, Hans Luhn of IBM proposed an algorithm for validating credit card 
numbers. The algorithm is useful to determine whether a card number is entered 
correctly or whether a credit card is scanned correctly by a scanner. Credit card 
numbers are generated following this validity check, commonly known as the 
Luhn check or the Mod 10 check,which can be described as follows (
for illustration, consider the card number 4388576018402626):

1.  Double every second digit from right to left. If doubling of a digit results in a 
two-digit number, add up the two digits to get a single-digit number.

2. Now add all single-digit numbers from Step 1.

3. Add all digits in the odd places from right to left in the card number.

4. Sum the results from Step 2 and Step 3.

5.  If the result from Step 4 is divisible by 10, the card number is valid; otherwise, 
it is invalid. For example, the number 4388576018402626 is invalid, but the 
number 4388576018410707 is valid.

Write a program that prompts the user to enter a credit card number as a 
long integer. Display whether the number is valid or invalid.

 */
package exercise06_31;

import java.util.Scanner;

public class Exercise06_31 {

    public static void main (String[] args) {
        
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a cc number");
        long num = s.nextLong();
            
        if (isValid(num)) {
            System.out.println(num+" is valid.");
        } else {
            System.out.println(num+" is invalid.");
        }
    }
	
    public static boolean isValid (long number) {
          
        if (!prefixMatched(number, 4) && !prefixMatched(number, 37) && 
            !prefixMatched(number, 5) && !prefixMatched(number, 6)) {
            return false;
        }
        if (getSize(number) > 16 || getSize(number) < 13) {
            return false;
        }
        return ((sumOfOddPlace(number) + sumOfDoubleEvenPlace(number)) % 10 == 0);		
    }
	
    public static boolean prefixMatched(long number, int d) {
        //check first 1-2 digits of credit card
        while (number > d) {
            number /= 10;
        }
        return (number == d);
    }
	
    public static int sumOfDoubleEvenPlace(long num) {
        int sum = 0;
        while (num > 0) {
            num /= 10;
            int doubleLast = (int)(num % 10)*2;
            sum += getDigit(doubleLast);
            num /= 10;
        }
        return sum;
    }
        
    public static int getDigit(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    
    public static int sumOfOddPlace(long num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 100;
        }
        return sum;
    }
    //get number of digits in number
    public static int getSize(long num) {
        int size = 0;
        while (num > 0) {
            size += 1;
            num /= 10;
        }
        return size;
    }	
}

    


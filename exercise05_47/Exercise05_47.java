/*
(Business: check ISBN-13)
ISBN-13 is a new standard for indentifying books. It 
uses 13 digits. The last digit is a checksum, 
which is calculated from the other digits using the following formula:
10 - (d1 + 3d2 + d3 + 3d4 + d5 + 3d6 + d7 + 3d8 + d9 + 3d10 + d11 + 3d12) % 10
If the checksum is 10, replace it with 0. 
Your program should read the input as a string.
 */
package exercise05_47;

import java.util.Scanner;
public class Exercise05_47 {

    public static void main(String[] args) {
        //get first 9 digits of ISBN
        System.out.println("Enter first 12 digits of ISBN:");
        Scanner s = new Scanner(System.in);
        
        String number = s.nextLine();
        int sum = 0;
        //loop through each character in string
        for (int i = 0; i < number.length(); i++){
            char ch = number.charAt(i);
            int num = Character.getNumericValue(ch);
            //if at odd position, sum += num; otherwise sum += 3*num
            if (i % 2 == 0) {
                sum += num;
            } else {
                sum += 3*num;
            }
        }
        
        //calculate checksum
        int checksum = 10 - sum % 10;
        if (checksum == 10) {
            checksum = 0;
        }
        
        System.out.println(number+checksum);
    } 
}

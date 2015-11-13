
package exercise07_05;
/*
(Print distinct numbers) 
Write a program that reads in ten numbers and displays 
the number of distinct numbers and the distinct numbers separated by exactly one 
space (i.e., if a number appears multiple times, it is displayed only once). 
Here is the sample run of the program:
Enter ten numbers: 1 2 3 2 1 6 3 4 5 2
The number of distinct number is 6
The distinct numbers are: 1 2 3 6 4 5 
*/

import java.util.Scanner;
public class Exercise07_05 {

    public static void main(String[] args) {
        
        System.out.println("Input ten integers: ");
        Scanner s = new Scanner(System.in);
        int max_num = Integer.MIN_VALUE;
        int min_num = Integer.MAX_VALUE;
        int[] nums = new int[10];
        
        //populate the array with input integers
        for (int i = 0; i < 10; i++) {
            nums[i] = s.nextInt();
            max_num = Math.max(nums[i], max_num);
            min_num = Math.min(nums[i], min_num);
        }
        int count = 0;
        String output = "";
        int[] counter = new int[max_num - min_num + 1];
        for (int i = 0; i < nums.length; i++) {
            if (counter[nums[i] - min_num] == 0) {
                counter[nums[i] - min_num] += 1;
                count += 1;
                output += nums[i] + " ";
            }
        }
        System.out.println("The number of distinct numbers is " + count);
        System.out.println("The distinct numbers are: " + output);
        
    }
    
}

/*
(Emirp) An emirp
(prime spelled backward) is a nonpalindromic prime number 
whose reversal is also a prime. For example, 17 is a prime and 71 is a prime, so 17 
and 71 are emirps. Write a program that displays the first 100 emirps. Display 10 
numbers per line, separated by exactly one space, as follows:
13 17 31 37 71 73 79 97 107 113 
149 157 167 179 199 311 337 347 359 389
...
 */
package exercise06_27;

public class Exercise06_27 {

    public static void main(String[] args) {
        int count = 0;
        int i = 13; //lowest non-palindromic prime
        
        while (count < 100) {
            if (isPrime(i) && isBackwardsPrime(i) && isNotPalindrome(i)) {
                count++;
                System.out.print(i + " ");
                //print new line after 10 numbers
                if (count % 10 == 0) {
                    System.out.println();
                }
            }
            i++;
        }
    }
       
    
    public static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isBackwardsPrime(int num) {
        num = reverse(num);
        return isPrime(num);
    }
    
    public static boolean isNotPalindrome(int num) {
        return reverse(num) != num;
    }
    
    public static int reverse(int num) {
        int sum = 0;
        while (num >= 10) {
            sum += num % 10;
            sum *= 10;
            num /= 10;
        }
        sum += num;
        return sum;
    }
    
}
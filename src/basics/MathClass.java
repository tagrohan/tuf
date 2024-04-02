package basics;

public class MathClass {

    // we are going to use mod and divide here
    //mod gave last digit always, while divide gave remaining ex, for 123 % 10 = 3, / = 12(as digit after dot(12.3) not considered in int variable)
    public static void main(String[] args) {


    }

    //    1234 -> 4, 123 -> 3
    public static void countNumberOfDigits(int num) {
//        countNumberOfDigits(123);
        int count = 0;
        while (num > 0) {
            num /= 10;
            count += 1;
        }
        System.out.println(count);
    }

    // here if we mod we are getting last digit which we can print in reverse
    // but as we what about 12300, for this are going to use some math tricks as if we multiply mod number with 10 and then mod number can place that
    // cvalue in 10th position then 100 th based on it
    // ex 123 % 10 = 3, now 10 * 0 + 3 = 30,
    // 12 % 10 = 2, now 10 * 3 + 2 = 32, and so on became 321
    public static void reverseANum(int num) {
//        reverseANum(12300);
        int revNumber = 0;

        while (num > 0) {
            int mod = num % 10;
            num /= 10;

            revNumber = revNumber * 10 + mod;
        }
        System.out.println(revNumber);
    }
}

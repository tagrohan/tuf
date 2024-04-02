package basics;

public class MathClass {

    // we are going to use mod and divide here
    //mod gave last digit always, while divide gave remaining ex, for 123 % 10 = 3, / = 12(as digit after dot(12.3) not considered in int variable)
    public static void main(String[] args) {
        isPalindrome(121);

    }

    //    1234 -> 4, 123 -> 3
    public static void countNumberOfDigits(int num) {
//        countNumberOfDigits(123);
        int count = 0;
        while (num > 0) {
            num /= 10; //time complexity Olog(n) as we are dividing here, specifically Olog10(N)
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

    // number which looks same from both sides, ex 1221, 131,
    private static void isPalindrome(int num) {
//        isPalindrome(121);
        int revNumber = 0;
        int originalNum = num;

        while (num > 0) {
            int mod = num % 10;
            num /= 10;

            revNumber = revNumber * 10 + mod;
        }
        System.out.println(revNumber == originalNum);
    }
}
